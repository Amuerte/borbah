package org.amuerte.gaming.application.service

import org.amuerte.gaming.application.dto.PlayerDto

interface PlayerService {
    fun create(login: String): Unit
    fun delete(idPlayer: String): Unit
    fun deleteAll(): Unit
    fun findAll(): Iterable<PlayerDto>
    fun findById(id: String): PlayerDto?
    fun updateScore(idPlayer: String, score: Int)
}