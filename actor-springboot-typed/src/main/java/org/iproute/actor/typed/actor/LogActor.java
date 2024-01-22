package org.iproute.actor.typed.actor;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

/**
 * LogActor
 *
 * @author zhuzhenjie
 */
public class LogActor extends AbstractBehavior<String> {

    public LogActor(ActorContext<String> context) {
        super(context);
    }

    public static Behavior<String> create() {
        return Behaviors.setup(LogActor::new);
    }

    @Override
    public Receive<String> createReceive() {
        return newReceiveBuilder()
                .onMessage(String.class, this::onLog)
                .build();
    }

    private Behavior<String> onLog(String msg) {
        System.out.println("log ===> " + msg);
        return this;
    }

}
