package org.amuerte.gaming.infrastructure.healthcheck

import com.codahale.metrics.health.HealthCheck
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest
import javax.inject.Inject

class DynamoDbHealthCheck @Inject constructor(val dynamoDbClient: DynamoDbClient) : HealthCheck() {

    override fun check(): Result {
        try {
            val listTablesRequest = ListTablesRequest.builder().limit(1).build()
            dynamoDbClient.listTables(listTablesRequest)
        } catch (e: Exception) {
            return Result.unhealthy(e.message)
        }

        return Result.healthy()
    }
}