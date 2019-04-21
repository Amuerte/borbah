package org.amuerte.gaming.domain

interface PlayerRepository {
    fun create(player: Player): Unit
    fun deleteAll(): Unit
    fun findAll(idBattle: String, sortAsc: Boolean, fromId: String?): List<Player>
    fun findById(id: String): Player
    fun findRank(player: Player): Int
    fun update(newPlayer: Player)
}