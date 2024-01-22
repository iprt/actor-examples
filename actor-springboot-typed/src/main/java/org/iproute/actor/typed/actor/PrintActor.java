package org.iproute.actor.typed.actor;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

/**
 * PrintActor
 *
 * @author zhuzhenjie
 */
public class PrintActor extends AbstractBehavior<String> {
    public PrintActor(ActorContext<String> context) {
        super(context);
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
        return this;
    }
}
