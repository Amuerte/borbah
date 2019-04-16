package org.amuerte.gaming.application.service

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.mockk.*
import org.amuerte.gaming.domain.Player
import org.amuerte.gaming.domain.PlayerRepository
import java.util.*

class PlayerServiceImplTest:StringSpec() {

    val playerRepository = mockk<PlayerRepository>()
    val playerService = PlayerServiceImpl(playerRepository)

    init {
        "Should create player" {
            //given
            val playerSlot = CapturingSlot<Player>()
            every { playerRepository.create(capture(playerSlot)) } just Runs
            //when
            playerService.create(login = "testUser", idBattle = "KingOfFighters Tournament")
            //then
            verify(exactly = 1) { playerRepository.create(allAny()) }
            UUID.fromString(playerSlot.captured.id).toString() shouldBe playerSlot.captured.id
            playerSlot.captured.login shouldBe "testUser"
            playerSlot.captured.idBattle shouldBe "KingOfFighters Tournament"
            playerSlot.captured.score shouldBe 0
        }

        "Should failed creating player with empty login" {
            //given
            every { playerRepository.create(any()) } just Runs
            //when
            playerService.create(login = "", idBattle = "")
            //then
        }

        "Should call deleteAll players on repository" {
            //when
            every { playerRepository.deleteAll() } just Runs
            playerService.deleteAll()
            //then
            verify(exactly = 1) { playerRepository.deleteAll() }
        }

        "Should update player" {
            //when
            val playerSlot = CapturingSlot<Player>()
            every { playerRepository.update(capture(playerSlot)) } just Runs
            every { playerRepository.findById(any()) } returns
                    Player(id=UUID.randomUUID().toString(), login = "testLogin", score = 25, idBattle = "Beastz")
            //given
            playerService.updateScore(UUID.randomUUID().toString(), 10)
            //then
            verify(exactly = 1) { playerRepository.update(any()) }
            playerSlot.captured.score shouldBe 10
        }
    }

}