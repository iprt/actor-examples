package org.iproute.actor.typed.actor;

import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

/**
 * DynamicBehaviorActor
 *
 * @author zhuzhenjie
 */
public class DynamicBehaviorActor extends AbstractBehavior<String> {

    public static Behavior<String> create() {
        // Initial behavior
        return Behaviors.setup(DynamicBehaviorActor::new);
    }

    private DynamicBehaviorActor(ActorContext<String> context) {
        super(context);
    }

    @Override
    public Receive<String> createReceive() {
        return newReceiveBuilder().onMessageEquals("change", this::onChange).build();
    }

    private Behavior<String> onChange() {
        // Change behavior after receiving "change" message
        return Behaviors.receive(String.class).onMessageEquals("hello", () -> {
            System.out.println("Hello");
            return this;
        }).build();
    }

    public static void main(String[] args) {
        ActorSystem<String> system = ActorSystem.create(
                DynamicBehaviorActor.create(), "DynamicBehaviorActor"
        );

        system.tell("change");
        system.tell("hello");
    }
}