package org.amuerte.gaming.infrastructure.injection

import dagger.Component
import org.amuerte.gaming.infrastructure.PlayerResource
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class, ServiceModule::class])
interface BorbahComponent {
    fun playerResource(): PlayerResource
}