package org.amuerte.gaming.domain

interface PlayerRepository {
    fun create(player: Player): Unit
    fun delete(idPlayer: String): Unit
    fun deleteAll(): Unit
    fun findAll(): List<Player>
    fun findById(id: String): Player?
    fun update(player: Player?)
}