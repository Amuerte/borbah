package org.amuerte.gaming.infrastructure.repository

import org.amuerte.gaming.DbConfiguration
import org.amuerte.gaming.domain.Player
import org.amuerte.gaming.domain.PlayerRepository
import org.amuerte.gaming.infrastructure.errors.BusinessException
import org.amuerte.gaming.infrastructure.errors.ErrorCodeEnum
import org.amuerte.gaming.infrastructure.errors.TechnicalException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import software.amazon.awssdk.awscore.exception.AwsServiceException
import software.amazon.awssdk.core.exception.SdkException
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.*
import java.time.Instant
import java.util.*
import javax.inject.Inject
import kotlin.collections.HashMap


class DynamoDbPlayerRepositoryImpl @Inject constructor(var dynamoDbClient: DynamoDbClient, val dbConfig: DbConfiguration) : PlayerRepository {

    companion object {
        val TABLE_PLAYERS: String = "players"
        val SCORE_GSINDEX_NAME = "scoreIndex"
        val LOG: Logger = LoggerFactory.getLogger(DynamoDbPlayerRepositoryImpl::class.java)
    }

    override fun deleteAll() {
        deleteTable()
        createTable()
    }

    override fun findById(id: String): Player {
        val queryRequest = QueryRequest.builder()
                .tableName(TABLE_PLAYERS)
                .keyConditionExpression("id = :valeurId")
                .expressionAttributeValues(Collections.singletonMap(
                        ":valeurId",
                        AttributeValue.builder().s(id).build()
                ))
                .build()

        return handleRequest {
            val response = dynamoDbClient.query(queryRequest)
            if (response.items().isEmpty()) {
                throw BusinessException(ErrorCodeEnum.B_NOT_FOUND, "No player with key $id")
            }

            response.items()
                    .map { mapper(it) }
                    .toList()[0]
        }
    }

    override fun update(newPlayer: Player) {
        val now = Instant.now().toEpochMilli()

        val updateAttributPlayer = HashMap<String, AttributeValueUpdate>()
        updateAttributPlayer["score"] = AttributeValueUpdate.builder()
                .value(AttributeValue.builder().n(newPlayer.score.toString()).build())
                .action(AttributeAction.PUT)
                .build()

        updateAttributPlayer["modificationDate"] = AttributeValueUpdate.builder()
                .value(AttributeValue.builder().n(now.toString()).build())
                .action(AttributeAction.PUT)
                .build()

        val keyMap = HashMap<String, AttributeValue>()
        keyMap["id"] = AttributeValue.builder().s(newPlayer.id).build()
        val updateItemRequest = UpdateItemRequest.builder()
                .tableName(TABLE_PLAYERS)
                .key(keyMap)
                .attributeUpdates(updateAttributPlayer)
                .build()

        return handleRequest {
            dynamoDbClient.updateItem(updateItemRequest)
        }
    }

    override fun create(player: Player) {
        val now = Instant.now().toEpochMilli()
        val newPlayerItem = HashMap<String, AttributeValue>()
        newPlayerItem["id"] = AttributeValue.builder().s(UUID.randomUUID().toString()).build()
        newPlayerItem["idBattle"] = AttributeValue.builder().s(player.idBattle).build()
        newPlayerItem["login"] = AttributeValue.builder().s(player.login).build()
        newPlayerItem["score"] = AttributeValue.builder().n(player.score.toString()).build()
        newPlayerItem["creationDate"] = AttributeValue.builder().n(now.toString()).build()
        newPlayerItem["modificationDate"] = AttributeValue.builder().n(now.toString()).build()

        val putItemRequest = PutItemRequest.builder()
                .tableName(TABLE_PLAYERS)
                .item(newPlayerItem)
                .build()

        return handleRequest {
            try {
                dynamoDbClient.putItem(putItemRequest)
            } catch (e: ConditionalCheckFailedException) {
                LOG.error("Player {} already exists", player.login, e)
                throw BusinessException(ErrorCodeEnum.B_DATA_ALREADY_EXIST, "Player already exists")
            }
        }
    }

    override fun findAll(idBattle: String, sortAsc: Boolean): List<Player> {
        val queryRequest = QueryRequest.builder()
                .tableName(TABLE_PLAYERS)
                .indexName(SCORE_GSINDEX_NAME)
                .keyConditionExpression("idBattle = :idBattle")
                .expressionAttributeValues(Collections.singletonMap(
                        ":idBattle",
                        AttributeValue.builder().s(idBattle).build()
                ))
                .scanIndexForward(sortAsc)
                .select(Select.ALL_ATTRIBUTES)
                .limit(dbConfig.pagesize)

        return handleRequest {
            dynamoDbClient.query(queryRequest.build())
                    .items()
                    .map { mapper(it) }
                    .toList()
        }
    }

    override fun findRank(player: Player): Int {
        val attributesValue = HashMap<String, AttributeValue>()
        attributesValue[":idBattle"] = AttributeValue.builder().s(player.idBattle).build()
        attributesValue[":score"] = AttributeValue.builder().n(player.score.toString()).build()

        val queryRequest = QueryRequest.builder()
                .tableName(TABLE_PLAYERS)
                .indexName(SCORE_GSINDEX_NAME)
                .keyConditionExpression("idBattle = :idBattle AND score >= :score")
                .expressionAttributeValues(attributesValue)
                .select(Select.COUNT)
                .build()

        return handleRequest {
            dynamoDbClient.query(queryRequest).count()
        }
    }

    fun createTable() {
        val gsScoreIndex = GlobalSecondaryIndex.builder()
                .indexName(SCORE_GSINDEX_NAME)
                .keySchema(
                        KeySchemaElement.builder().attributeName("idBattle").keyType(KeyType.HASH).build(),
                        KeySchemaElement.builder().attributeName("score").keyType(KeyType.RANGE).build()
                )
                .projection(Projection.builder().projectionType(ProjectionType.ALL).build())
                .provisionedThroughput(ProvisionedThroughput.builder()
                        .readCapacityUnits(5)
                        .writeCapacityUnits(5)
                        .build()
                )
                .build()

        val request = CreateTableRequest.builder()
                .attributeDefinitions(
                        AttributeDefinition.builder().attributeName("id").attributeType(ScalarAttributeType.S).build(),
                        AttributeDefinition.builder().attributeName("idBattle").attributeType(ScalarAttributeType.S).build(),
                        AttributeDefinition.builder().attributeName("score").attributeType(ScalarAttributeType.N).build()
                )
                .keySchema(
                        KeySchemaElement.builder().attributeName("id").keyType(KeyType.HASH).build()
                )
                .globalSecondaryIndexes(gsScoreIndex)
                .provisionedThroughput(ProvisionedThroughput.builder()
                        .readCapacityUnits(10)
                        .writeCapacityUnits(10)
                        .build())
                .tableName(TABLE_PLAYERS)
                .build();

        return handleRequest {
            val response = dynamoDbClient.createTable(request);
            LOG.debug("Table {} created and in status {}", TABLE_PLAYERS, response.tableDescription().tableStatusAsString())
        }
    }

    fun deleteTable() {
        val deleteRequest = DeleteTableRequest.builder()
                .tableName(TABLE_PLAYERS)
                .build();

        return handleRequest {
            try {
                dynamoDbClient.deleteTable(deleteRequest);
            } catch (e: ResourceNotFoundException) {
                //noop
                LOG.debug("Cant delete table player as it was not created")
            }
        }
    }

    private fun <T> handleRequest(doRequest: () -> T): T {
        try {
            return doRequest()
        } catch (e: AwsServiceException) {
            LOG.error("DynamoDb Processing Error", e)
            throw TechnicalException(ErrorCodeEnum.T_DB_ACTION_ERROR, "DynamoDb processing Error")
        } catch (e: SdkException) {
            LOG.error("DynamoDb Connection Error", e)
            throw TechnicalException(ErrorCodeEnum.T_CONNECTION_ERROR, "DynamoDb Connection Error")
        }
    }

    private fun mapper(item: Map<String, AttributeValue>): Player {
        return Player(
                id = item["id"]!!.s(),
                login = item["login"]!!.s(),
                idBattle = item["idBattle"]!!.s(),
                score = item["score"]!!.n().toInt()
                //Instant.parse(item["creationDate"]!!.s()),
                //Instant.parse(item["modificationDate"]!!.s())
        )
    }
}