[borbah](../../index.md) / [org.amuerte.gaming.infrastructure.repository](../index.md) / [DynamoDbPlayerRepositoryImpl](./index.md)

# DynamoDbPlayerRepositoryImpl

`class DynamoDbPlayerRepositoryImpl : `[`PlayerRepository`](../../org.amuerte.gaming.domain/-player-repository/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DynamoDbPlayerRepositoryImpl(dynamoDbClient: DynamoDbClient)` |

### Properties

| Name | Summary |
|---|---|
| [dynamoDbClient](dynamo-db-client.md) | `var dynamoDbClient: DynamoDbClient` |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(player: `[`Player`](../../org.amuerte.gaming.domain/-player/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [createTable](create-table.md) | `fun createTable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deleteAll](delete-all.md) | `fun deleteAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deleteTable](delete-table.md) | `fun deleteTable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [findAll](find-all.md) | `fun findAll(idBattle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sortAsc: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Player`](../../org.amuerte.gaming.domain/-player/index.md)`>` |
| [findById](find-by-id.md) | `fun findById(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Player`](../../org.amuerte.gaming.domain/-player/index.md) |
| [findRank](find-rank.md) | `fun findRank(player: `[`Player`](../../org.amuerte.gaming.domain/-player/index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [update](update.md) | `fun update(newPlayer: `[`Player`](../../org.amuerte.gaming.domain/-player/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [LOG](-l-o-g.md) | `val LOG: Logger` |
| [SCORE_GSINDEX_NAME](-s-c-o-r-e_-g-s-i-n-d-e-x_-n-a-m-e.md) | `val SCORE_GSINDEX_NAME: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [TABLE_PLAYERS](-t-a-b-l-e_-p-l-a-y-e-r-s.md) | `val TABLE_PLAYERS: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
