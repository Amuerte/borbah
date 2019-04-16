package org.amuerte.gaming.infrastructure.errors

abstract class BorbahException (val code: ErrorCodeEnum, val msg: String): Exception(msg) {

}