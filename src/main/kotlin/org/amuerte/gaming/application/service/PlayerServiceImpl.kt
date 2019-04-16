package org.amuerte.gaming.application.service

import org.amuerte.gaming.application.dto.PlayerDto
import org.amuerte.gaming.domain.Player
import org.amuerte.gaming.domain.PlayerRepository
import java.util.*
import javax.inject.Inject

class PlayerServiceImpl @Inject constructor(val playerRepository: PlayerRepository) : PlayerService {
    override fun deleteAll() {
        playerRepository.deleteAll()
    }
    override fun updateScore(idPlayer: String, score: Int) {
        val player = playerRepository.findById(idPlayer)
        playerRepository.update(player!!.updateScore(score))
    }

    override fun findById(id: String): PlayerDto? {
        val foundPlayer = playerRepository.findById(id)
        return mapper(foundPlayer)
    }

    override fun create(login: String) {
        playerRepository.create(Player(UUID.randomUUID().toString(), login = login))
    }

    override fun delete(idPlayer: String) {
        playerRepository.delete(idPlayer)
    }

    override fun findAll(): Iterable<PlayerDto> {
        return playerRepository.findAll().map { mapper(it) };
    }

    private fun mapper(p: Player?) = PlayerDto(p!!.id, p.login, p.score)
}