package org.amuerte.gaming.infrastructure.injection

import dagger.Component
import org.amuerte.gaming.infrastructure.PlayerResource
import org.amuerte.gaming.infrastructure.healthcheck.DynamoDbHealthCheck
import javax.inject.Singleton


@Singleton
@Component(modules = [
    RepositoryModule::class,
    ServiceModule::class,
    DynamoDbModule::class
])
interface BorbahComponent {

    fun playerResource(): PlayerResource

    fun dynamoDbHealthCheck(): DynamoDbHealthCheck

    @Component.Builder
    interface Builder {
        fun dynamoDbModule(dynamoDbModule: DynamoDbModule): Builder

        fun build(): BorbahComponent
    }
}