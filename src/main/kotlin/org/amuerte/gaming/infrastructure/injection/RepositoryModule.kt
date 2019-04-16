package org.amuerte.gaming.infrastructure.injection

import dagger.Binds
import dagger.Module
import org.amuerte.gaming.domain.PlayerRepository
import org.amuerte.gaming.infrastructure.repository.SimplePlayerRepositoryImpl

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindPlayerRepository(repository: SimplePlayerRepositoryImpl): PlayerRepository
}