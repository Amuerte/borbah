package org.amuerte.gaming.infrastructure.repository

import org.amuerte.gaming.domain.Player
import org.amuerte.gaming.domain.PlayerRepository
import javax.inject.Inject

class SimplePlayerRepositoryImpl @Inject constructor() : PlayerRepository {

    val players: MutableMap<String, Player> = mutableMapOf()

    override fun deleteAll() {
        players.clear()
    }

    override fun findById(id: String): Player? {
        return players[id]
    }

    override fun update(player: Player?) {
        players.replace(player!!.id, player)
    }

    override fun findAll(): List<Player> {
        return players.values.toList()
    }

    override fun create(player: Player) {
        players[player.id] = player
    }

    override fun delete(idPlayer: String) {
        players.remove(idPlayer)
    }
}