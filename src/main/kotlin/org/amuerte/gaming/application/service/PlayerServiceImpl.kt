package org.amuerte.gaming.application.service

import org.amuerte.gaming.application.dto.PlayerDto
import org.amuerte.gaming.application.dto.PlayerInfoDto
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
        playerRepository.update(player.updateScore(score))
    }

    override fun findById(id: String): PlayerInfoDto {
        val foundPlayer = playerRepository.findById(id)
        val rank:Int = playerRepository.findRank(foundPlayer)
        return mapper(foundPlayer, rank)
    }

    override fun create(login: String, idBattle: String) {
        playerRepository.create(Player(
                id=UUID.randomUUID().toString(),
                idBattle = idBattle,
                login = login)
        )
    }

    override fun findAll(idBattle: String, sortAsc: Boolean): Iterable<PlayerDto> {
        return playerRepository.findAll(idBattle, sortAsc).map { mapper(it) };
    }

    private fun mapper(p: Player) = PlayerDto(p.id, p.login, p.score)
    private fun mapper(p: Player, rank:Int) = PlayerInfoDto(p.id, p.login, p.score,rank)
}