package org.amuerte.gaming.infrastructure.injection

import dagger.Binds
import dagger.Module
import org.amuerte.gaming.domain.PlayerRepository
import org.amuerte.gaming.infrastructure.repository.DynamoDbPlayerRepositoryImpl
import javax.inject.Singleton


@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPlayerRepository(repository: DynamoDbPlayerRepositoryImpl): PlayerRepository
}