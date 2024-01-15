# actor examples

## reference

```text
https://github.com/guobinhit/akka-guide/blob/master/articles/getting-started-guide/tutorial_1.md
```

## `AbstractBehavior` vs `AbstractActor`

AbstractActor 和 AbstractBehavior 是Akka框架中的两个重要类，它们在创建Actor系统时扮演了不同的角色。

AbstractActor是Akka早期版本的Actor系统模型的一部分。这个类提供了一种方式来创建并管理Actor系统的状态，但是必须注意，使用这种方式创建的Actor在同一时间只能处理一个消息，这大大降低了并发处理能力。

还有一个重要的注意事项是AbstractActor不是线程安全的，这意味着你不能在没有适当同步机制的情况下从多个线程修改Actor的状态。这种情况往往会导致数据的破坏和并发错误。

另一方面，AbstractBehavior是新的Akka Typed API的一部分，它提供了一个更先进，更安全的方式来创建和管理Actors。

使用AbstractBehavior，你能够创建的Actor在相同的时间可以并行处理多个消息，这提高了系统的效率和性能。

另外，AbstractBehavior还提供了更强的类型安全性，这意味着在编译时就能发现更多的错误，从而避免了在运行时发生不可预期的错误。

总的来说，如果在创建新的Actor系统，或者重构旧的Actor系统，一般建议使用AbstractBehavior，因为它提供了更强的安全性和并发处理能力。如果你在处理遗留系统或者必须使用旧API的情况下，AbstractActor仍然是一个可行的选择。