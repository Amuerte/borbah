[borbah](../../index.md) / [org.amuerte.gaming.domain](../index.md) / [Player](./index.md)

# Player

`data class Player`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Player(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, idBattle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, login: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, score: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, creationDate: Instant = Instant.now(), modificationDate: Instant = Instant.now())` |

### Properties

| Name | Summary |
|---|---|
| [creationDate](creation-date.md) | `val creationDate: Instant` |
| [id](id.md) | `val id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [idBattle](id-battle.md) | `val idBattle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [login](login.md) | `val login: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [modificationDate](modification-date.md) | `val modificationDate: Instant` |
| [score](score.md) | `val score: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [updateScore](update-score.md) | `fun updateScore(score: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Player`](./index.md) |
