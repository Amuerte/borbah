package org.amuerte.gaming.domain

import java.time.Instant

data class Player(
    val id: String,
    val login: String,
    val score: Int = 0,
    val creationDate: Instant = Instant.now(),
    val modificationDate: Instant = Instant.now()
) {
    fun updateScore(score: Int): Player {
        return copy(score = score)
    }
}



