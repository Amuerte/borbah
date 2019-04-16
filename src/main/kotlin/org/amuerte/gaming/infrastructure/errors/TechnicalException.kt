package org.amuerte.gaming.infrastructure.errors

class TechnicalException(code: ErrorCodeEnum, msg: String): BorbahException(code, msg) {
}