package org.iproute.actor.typed.actor;

import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.Behaviors;

/**
 * Main
 *
 * @author zhuzhenjie
 */
public class Main {
    public static void main(String[] args) {
        final Behavior<Void> behavior = Behaviors.setup(context -> Behaviors.empty());
        final ActorSystem<Void> system = ActorSystem.create(behavior, "actorSystemName");
    }
}
