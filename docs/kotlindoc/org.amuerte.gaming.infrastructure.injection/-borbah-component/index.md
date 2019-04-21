[borbah](../../index.md) / [org.amuerte.gaming.infrastructure.injection](../index.md) / [BorbahComponent](./index.md)

# BorbahComponent

`@Singleton @Component([RepositoryModule, ServiceModule, DynamoDbModule]) interface BorbahComponent`

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder` |

### Functions

| Name | Summary |
|---|---|
| [dynamoDbHealthCheck](dynamo-db-health-check.md) | `abstract fun dynamoDbHealthCheck(): `[`DynamoDbHealthCheck`](../../org.amuerte.gaming.infrastructure.healthcheck/-dynamo-db-health-check/index.md) |
| [playerResource](player-resource.md) | `abstract fun playerResource(): `[`PlayerResource`](../../org.amuerte.gaming.infrastructure/-player-resource/index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [DaggerBorbahComponent](../-dagger-borbah-component/index.md) | `class DaggerBorbahComponent : `[`BorbahComponent`](./index.md) |
