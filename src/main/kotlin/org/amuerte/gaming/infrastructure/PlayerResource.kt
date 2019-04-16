package org.amuerte.gaming.infrastructure

import org.amuerte.gaming.application.service.PlayerService
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/v1/players")
@Produces(MediaType.APPLICATION_JSON)
class PlayerResource @Inject constructor(val playerService: PlayerService) {

    @POST
    @Path("/{login}")
    fun create(@PathParam("login") _login:String):Response {
        playerService.create(_login)
        return Response.ok().build()
    }

    @PUT
    @Path("/{idPlayer}")
    fun update(@PathParam("idPlayer") idPlayer: String, @QueryParam("score") score: Int): Response {
        playerService.updateScore(idPlayer, score)
        return Response.ok().build()
    }

    @DELETE
    @Path("/{idPlayer}")
    fun delete(@PathParam("idPlayer") idPlayer:String):Response {
        playerService.delete(idPlayer)
        return Response.ok().build()
    }

    @GET
    @Path("/")
    fun findAll():Response {
        return Response.ok(playerService.findAll()).build()
    }

    @DELETE
    @Path("/")
    fun deleteAll(): Response {
        playerService.deleteAll()
        return Response.ok().build()
    }

    @GET
    @Path("/{idPlayer}")
    fun findPlayer(@PathParam("idPlayer") idPlayer: String): Response {
        return Response.ok(playerService.findById(idPlayer)).build()
    }
}