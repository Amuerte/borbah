package org.amuerte.gaming

import io.dropwizard.Application
import io.dropwizard.setup.Environment
import org.amuerte.gaming.infrastructure.injection.DaggerBorbahComponent
import org.amuerte.gaming.infrastructure.injection.DynamoDbModule

class BorbahApplication : Application<BorbahConfiguration>() {

    override fun run(configuration: BorbahConfiguration, environment: Environment) {

        // Dagger graph object initialisation
        val component = DaggerBorbahComponent.builder()
                .dynamoDbModule(DynamoDbModule(configuration.database))
                .build()

        // Resources registration
        environment.jersey().register(component.playerResource())

        //HealthCheck Registration
        environment.healthChecks().register("dynamoDb", component.dynamoDbHealthCheck())
    }
}