[borbah](../../index.md) / [org.amuerte.gaming.application.service](../index.md) / [PlayerServiceImpl](./index.md)

# PlayerServiceImpl

`class PlayerServiceImpl : `[`PlayerService`](../-player-service/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PlayerServiceImpl(playerRepository: `[`PlayerRepository`](../../org.amuerte.gaming.domain/-player-repository/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [playerRepository](player-repository.md) | `val playerRepository: `[`PlayerRepository`](../../org.amuerte.gaming.domain/-player-repository/index.md) |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(login: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, idBattle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Create a player with login [login](../-player-service/create.md#org.amuerte.gaming.application.service.PlayerService$create(kotlin.String, kotlin.String)/login) for the battle [idBattle](../-player-service/create.md#org.amuerte.gaming.application.service.PlayerService$create(kotlin.String, kotlin.String)/idBattle) |
| [deleteAll](delete-all.md) | `fun deleteAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Delete all players for all battles |
| [findAll](find-all.md) | `fun findAll(idBattle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sortAsc: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`PlayerDto`](../../org.amuerte.gaming.application.dto/-player-dto/index.md)`>`<br>Return a list containing all the players for the battle [idBattle](../-player-service/find-all.md#org.amuerte.gaming.application.service.PlayerService$findAll(kotlin.String, kotlin.Boolean)/idBattle). |
| [findById](find-by-id.md) | `fun findById(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`PlayerInfoDto`](../../org.amuerte.gaming.application.dto/-player-info-dto/index.md)<br>Return a player identified by [id](../-player-service/find-by-id.md#org.amuerte.gaming.application.service.PlayerService$findById(kotlin.String)/id) |
| [updateScore](update-score.md) | `fun updateScore(idPlayer: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, score: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Update the score of the player identified by [id](#) with the given score [score](../-player-service/update-score.md#org.amuerte.gaming.application.service.PlayerService$updateScore(kotlin.String, kotlin.Int)/score) |
