[borbah](../../index.md) / [org.amuerte.gaming.infrastructure](../index.md) / [PlayerResource](./index.md)

# PlayerResource

`@Path("/v1/players") @Produces(["application/json"]) class PlayerResource`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PlayerResource(playerService: `[`PlayerService`](../../org.amuerte.gaming.application.service/-player-service/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [playerService](player-service.md) | `val playerService: `[`PlayerService`](../../org.amuerte.gaming.application.service/-player-service/index.md) |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(idBattle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, login: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Response` |
| [deleteAll](delete-all.md) | `fun deleteAll(): Response` |
| [findAll](find-all.md) | `fun findAll(idBattle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sortAscParam: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`?): Response` |
| [findPlayer](find-player.md) | `fun findPlayer(idPlayer: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Response` |
| [update](update.md) | `fun update(idPlayer: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, score: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Response` |
