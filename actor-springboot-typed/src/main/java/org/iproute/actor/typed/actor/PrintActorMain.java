package org.iproute.actor.typed.actor;

import akka.actor.typed.ActorSystem;

/**
 * PrintActorMain
 *
 * @author zhuzhenjie
 */
public class PrintActorMain {
    public static void main(String[] args) {

        ActorSystem<String> system = ActorSystem.create(
                PrintActor.create(), "printActorSystem"
        );

        system.tell("print");

    }
}
