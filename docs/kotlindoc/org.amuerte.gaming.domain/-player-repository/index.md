[borbah](../../index.md) / [org.amuerte.gaming.domain](../index.md) / [PlayerRepository](./index.md)

# PlayerRepository

`interface PlayerRepository`

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `abstract fun create(player: `[`Player`](../-player/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deleteAll](delete-all.md) | `abstract fun deleteAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [findAll](find-all.md) | `abstract fun findAll(idBattle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sortAsc: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Player`](../-player/index.md)`>` |
| [findById](find-by-id.md) | `abstract fun findById(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Player`](../-player/index.md) |
| [findRank](find-rank.md) | `abstract fun findRank(player: `[`Player`](../-player/index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [update](update.md) | `abstract fun update(newPlayer: `[`Player`](../-player/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [DynamoDbPlayerRepositoryImpl](../../org.amuerte.gaming.infrastructure.repository/-dynamo-db-player-repository-impl/index.md) | `class DynamoDbPlayerRepositoryImpl : `[`PlayerRepository`](./index.md) |
