package org.amuerte.gaming.infrastructure.errors

import javax.ws.rs.core.Response

/**
 * Enum class for error code.
 * T prefix stands for Technical
 * B prefix stands for Business
 */
enum class ErrorCodeEnum {
    T_CONNECTION_ERROR,
    T_DB_ACTION_ERROR,
    B_DATA_ALREADY_EXIST,
    B_NOT_FOUND;

    fun response(): Response.ResponseBuilder {
        val builder = when (this) {
            B_DATA_ALREADY_EXIST -> Response.status(Response.Status.CONFLICT)
            B_NOT_FOUND -> Response.status(Response.Status.NOT_FOUND)
            T_DB_ACTION_ERROR -> Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            T_CONNECTION_ERROR -> Response.status(Response.Status.SERVICE_UNAVAILABLE)
        }
        return builder
    }
}