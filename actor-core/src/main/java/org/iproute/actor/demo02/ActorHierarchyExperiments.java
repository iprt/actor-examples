package org.iproute.actor.demo02;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**
 * ActorHierarchyExperiments
 *
 * @author zhuzhenjie
 */
public class ActorHierarchyExperiments {

    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("test-system");

        ActorRef firstRef = system.actorOf(PrintMyActorRefActor.props(), "first-actor");

        System.out.println("First: " + firstRef);

        firstRef.tell("printit", ActorRef.noSender());

        Thread.sleep(1000);
        System.out.println(">>> Press ENTER to exit <<<");

        try {
            System.in.read();
        } finally {
            system.terminate();
        }
    }
}

/*
https://github.com/guobinhit/akka-guide/blob/master/articles/getting-started-guide/tutorial_1.md
 */
