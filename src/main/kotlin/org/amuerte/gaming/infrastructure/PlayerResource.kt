package org.amuerte.gaming.infrastructure

import org.amuerte.gaming.application.service.PlayerService
import org.amuerte.gaming.infrastructure.errors.BorbahException
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/v1/players")
@Produces(MediaType.APPLICATION_JSON)
class PlayerResource @Inject constructor(val playerService: PlayerService) {

    @POST
    @Path("/")
    fun create(@QueryParam("battle") idBattle: String, @QueryParam("login") login: String): Response {
        return handleResponse { playerService.create(login, idBattle) }
    }

    @PUT
    @Path("/{idPlayer}")
    fun update(@PathParam("idPlayer") idPlayer: String, @QueryParam("score") score: Int): Response {
        return handleResponse { playerService.updateScore(idPlayer, score) }
    }

    @GET
    @Path("/")
    fun findAll(@QueryParam("battle") idBattle: String, @QueryParam("sortAsc") sortAscParam: Boolean?,
                @QueryParam("from") from: String ?): Response {
        val sortAsc: Boolean = sortAscParam ?: false
        return handleResponse { playerService.findAll(idBattle, sortAsc, from) }
    }

    @DELETE
    @Path("/")
    fun deleteAll(): Response {
        return handleResponse { playerService.deleteAll() }
    }

    @GET
    @Path("/{idPlayer}")
    fun findPlayer(@PathParam("idPlayer") idPlayer: String): Response {
        return handleResponse { playerService.findById(idPlayer) }
    }

    private fun <T> handleResponse(call: () -> T): Response {
        try {
            val callResponse:T = call()
            var response:Response.ResponseBuilder

            if(callResponse == Unit) {
                response = Response.noContent()
            }else {
                response = Response.ok(callResponse)
            }

            return response.build()
        } catch (e: BorbahException) {
            return e.code.response()
                    .entity(e.msg)
                    .build()
        }
    }
}