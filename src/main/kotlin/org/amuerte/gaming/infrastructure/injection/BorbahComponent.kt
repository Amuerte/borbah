package org.amuerte.gaming.infrastructure.injection

import dagger.BindsInstance
import dagger.Component
import org.amuerte.gaming.DbConfiguration
import org.amuerte.gaming.infrastructure.PlayerResource
import javax.inject.Singleton


@Singleton
@Component(modules = [
    RepositoryModule::class,
    ServiceModule::class,
    DynamoDbModule::class
])
interface BorbahComponent {

    fun playerResource(): PlayerResource

    @Component.Builder
    interface Builder {
        fun dynamoDbModule(dynamoDbModule: DynamoDbModule): Builder

        fun build(): BorbahComponent
    }
}