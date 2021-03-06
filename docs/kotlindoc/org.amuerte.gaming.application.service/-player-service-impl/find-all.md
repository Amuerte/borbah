[borbah](../../index.md) / [org.amuerte.gaming.application.service](../index.md) / [PlayerServiceImpl](index.md) / [findAll](./find-all.md)

# findAll

`fun findAll(idBattle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sortAsc: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`PlayerDto`](../../org.amuerte.gaming.application.dto/-player-dto/index.md)`>`

Overrides [PlayerService.findAll](../-player-service/find-all.md)

Return a list containing all the players for the battle [idBattle](../-player-service/find-all.md#org.amuerte.gaming.application.service.PlayerService$findAll(kotlin.String, kotlin.Boolean)/idBattle).

### Parameters

`idBattle` -

`sortAsc` - should the players be sorted by their score in ascending order

**Return**
A list of players sorted by their score

