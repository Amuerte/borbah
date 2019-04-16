package org.amuerte.gaming.infrastructure.injection

import dagger.Binds
import dagger.Module
import org.amuerte.gaming.application.service.PlayerService
import org.amuerte.gaming.application.service.PlayerServiceImpl
import javax.inject.Singleton

@Module
abstract class ServiceModule {

    @Binds
    @Singleton
    abstract fun bindPlayerService(playerService: PlayerServiceImpl): PlayerService
}