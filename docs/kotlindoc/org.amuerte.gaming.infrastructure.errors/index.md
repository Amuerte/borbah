[borbah](../index.md) / [org.amuerte.gaming.infrastructure.errors](./index.md)

## Package org.amuerte.gaming.infrastructure.errors

### Types

| Name | Summary |
|---|---|
| [ErrorCodeEnum](-error-code-enum/index.md) | `enum class ErrorCodeEnum`<br>Enum class for error code. T prefix stands for Technical B prefix stands for Business |

### Exceptions

| Name | Summary |
|---|---|
| [BorbahException](-borbah-exception/index.md) | `abstract class BorbahException : `[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html) |
| [BusinessException](-business-exception/index.md) | `class BusinessException : `[`BorbahException`](-borbah-exception/index.md) |
| [TechnicalException](-technical-exception/index.md) | `class TechnicalException : `[`BorbahException`](-borbah-exception/index.md) |
