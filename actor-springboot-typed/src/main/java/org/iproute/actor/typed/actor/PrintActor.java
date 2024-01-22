package org.iproute.actor.typed.actor;

import akka.actor.typed.ActorRef;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import lombok.SneakyThrows;

/**
 * PrintActor
 *
 * @author zhuzhenjie
 */
public class PrintActor extends AbstractBehavior<String> {

    private final ActorRef<String> logRef;

    public PrintActor(ActorContext<String> context) {
        super(context);
        logRef = context.spawn(LogActor.create(), "log");
    }

    public static Behavior<String> create() {
        return Behaviors.setup(PrintActor::new);
    }

    @Override
    public Receive<String> createReceive() {
        return newReceiveBuilder()
                .onMessageEquals("print", this::onPrint)
                .build();
    }

    private Behavior<String> onPrint() {
        System.out.println("【【【Print command received】】】");

        logRef.tell("hello world");
        return this;
    }

    @SneakyThrows
    public static void main(String[] args) {

        ActorSystem<String> system = ActorSystem.create(
                PrintActor.create(), "printActorSystem"
        );

        system.printTree();

        system.tell("print");

        Thread.sleep(2000);

        system.terminate();

    }
}
