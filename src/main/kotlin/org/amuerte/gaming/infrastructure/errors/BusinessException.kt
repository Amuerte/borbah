package org.amuerte.gaming.infrastructure.errors

class BusinessException(code: ErrorCodeEnum, msg: String): BorbahException(code, msg) {
}