package org.amuerte.gaming.infrastructure.injection

import dagger.Module
import dagger.Provides
import org.amuerte.gaming.DbConfiguration
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI
import javax.inject.Singleton

@Module
class DynamoDbModule constructor(val configuration: DbConfiguration) {

    @Provides
    @Singleton
    fun dynamoDbClient(): DynamoDbClient {
        return DynamoDbClient.builder()
                .region(Region.of(configuration.region))
                .endpointOverride(URI.create(configuration.endpoint))
                .build();
    }
}