package org.amuerte.gaming

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration

class BorbahConfiguration(@JsonProperty("database") val database: DbConfiguration) : Configuration() {

}

class DbConfiguration(@JsonProperty("region") val region: String,
                      @JsonProperty("endpoint") val endpoint: String
)