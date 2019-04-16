package org.amuerte.gaming

import io.dropwizard.Application
import io.dropwizard.setup.Environment
import org.amuerte.gaming.infrastructure.injection.DaggerBorbahComponent

class BorbahApplication : Application<BorbahConfiguration>() {

    override fun run(configuration: BorbahConfiguration, environment: Environment) {
        println("Running ${configuration.appName}!")

        val component = DaggerBorbahComponent.builder().build()
        environment.jersey().register(component.playerResource())
    }
}