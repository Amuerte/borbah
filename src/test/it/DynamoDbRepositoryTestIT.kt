import io.kotlintest.extensions.system.withSystemProperties
import org.amuerte.gaming.infrastructure.repository.DynamoDbPlayerRepositoryImpl
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.*
import java.net.URI

class DynamoDbRepositoryTestIT {

    val dynamoDbClient = DynamoDbClient.builder()
            .region(Region.of("eu-west-1"))
            .endpointOverride(URI.create("http://localhost:4569"))
            .build();

    fun initDb() {
        val request = CreateTableRequest.builder()
                .attributeDefinitions(
                        AttributeDefinition.builder().attributeName("id").attributeType(ScalarAttributeType.S).build(),
                        AttributeDefinition.builder().attributeName("score").attributeType(ScalarAttributeType.N).build()
                )
                .keySchema(
                        KeySchemaElement.builder().attributeName("id").keyType(KeyType.HASH).build(),
                        KeySchemaElement.builder().attributeName("score").keyType(KeyType.RANGE).build()
                )
                .provisionedThroughput(ProvisionedThroughput.builder()
                        .readCapacityUnits(10)
                        .writeCapacityUnits(10)
                        .build())
                .tableName(DynamoDbPlayerRepositoryImpl.TABLE_PLAYERS)
                .build();

        try {
            val response = dynamoDbClient.createTable(request);
            println(response.tableDescription().tableName());
        } catch (e: DynamoDbException) {
            println(e.message);
        }
    }

    fun dropDb() {
        val request = DeleteTableRequest.builder()
                .tableName(DynamoDbPlayerRepositoryImpl.TABLE_PLAYERS)
                .build();
        try {
            val response = dynamoDbClient.deleteTable(request);
            println(response.tableDescription().tableName());
        } catch (e: DynamoDbException) {
            println(e.message);
        }
    }
}

fun main() {
    withSystemProperties(
            mapOf("aws.accessKeyId" to "keyId", "aws.secretAccessKey" to "secret"),
            {DynamoDbRepositoryTestIT().initDb()}
    )
}