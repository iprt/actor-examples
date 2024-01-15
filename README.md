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

## akka actor springboot

https://github.com/typesafehub/activator-akka-java-spring

## actor 编排

编排Akka Actor通常需要考虑消息传递和Actor间的交互模式。以下是一些可能的策略：

**使用Ask模式**

这是一种请求-响应模式，在这种模式中，发送器Actor向接收器Actor发送一个消息并等待响应。这可以通过ask方法实现，它返回一个Future对象表示响应。这种模式有助于组织Actor的交互，但需要注意的是，因为它会阻塞Actor直到响应返回，所以可能会减慢整体性能。

**使用Tell模式**

这是一种基于事件的方式，Actor通过发送消息给其他Actor来通知它们事件发生。这种模式可以更好地扩展，因为Actor不需要等待响应，可以立即处理下一个消息。这也是推荐的用法，因为它最大程度地利用了Akka的并发性能。

**使用Actor层次结构**

可以通过创建父子Actor来表示复杂的流程和工作流。父Actor可以决定如何管理和监视其子Actor，例如，如果一个子Actor失败，父Actor可以决定重新启动它，或者停止所有子Actor。

**使用Router**

Akka提供了Router来实现Actor的负载均衡。你可以使用各种路由策略（如轮询，随机，广播等）来分发消息。

**使用Akka Streams**

对于更复杂的消息流，可以使用Akka Streams，这是一个用于处理流式数据的库，它提供了一种声明式方式来定义Actor之间的数据流。

**使用Akka Typed**

Akka 2.6中引入了Akka Typed，它提供了一种更加类型安全的方式来处理Actor间的互动。

