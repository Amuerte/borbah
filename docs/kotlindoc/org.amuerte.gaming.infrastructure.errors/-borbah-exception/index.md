[borbah](../../index.md) / [org.amuerte.gaming.infrastructure.errors](../index.md) / [BorbahException](./index.md)

# BorbahException

`abstract class BorbahException : `[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BorbahException(code: `[`ErrorCodeEnum`](../-error-code-enum/index.md)`, msg: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [code](code.md) | `val code: `[`ErrorCodeEnum`](../-error-code-enum/index.md) |
| [msg](msg.md) | `val msg: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [BusinessException](../-business-exception/index.md) | `class BusinessException : `[`BorbahException`](./index.md) |
| [TechnicalException](../-technical-exception/index.md) | `class TechnicalException : `[`BorbahException`](./index.md) |
