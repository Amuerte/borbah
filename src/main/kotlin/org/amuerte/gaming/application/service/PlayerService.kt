package org.amuerte.gaming.application.service

import org.amuerte.gaming.application.dto.PlayerDto
import org.amuerte.gaming.application.dto.PlayerInfoDto

/**
 * Main service to manage players during the tournament/battle/combat
 */
interface PlayerService {

    /**
     * Create a player with login [login] for the battle [idBattle]
     *
     * @param login
     * @param idBattle
     */
    fun create(login: String, idBattle: String): Unit

    /**
     * Delete all players for all battles
     */
    fun deleteAll(): Unit

    /**
     * Return a list containing all the players for the battle [idBattle].
     *
     * @param idBattle
     * @param sortAsc should the players be sorted by their score in ascending order
     *
     * @return A list of players sorted by their score
     */
    fun findAll(idBattle: String, sortAsc: Boolean): Iterable<PlayerDto>

    /**
     * Return a player identified by [id]
     *
     * @param id player's id
     */
    fun findById(id: String): PlayerInfoDto

    /**
     * Update the score of the player identified by [id] with the given score [score]
     *
     * @param idPlayer
     * @param score
     */
    fun updateScore(idPlayer: String, score: Int)
}