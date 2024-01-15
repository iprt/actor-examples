package org.iproute.actor.demo03;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**
 * LifeCycleMain
 *
 * @author zhuzhenjie
 */
public class LifeCycleMain {
    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("test-system");

        ActorRef first = system.actorOf(StartStopActor1.props(), "first");

        first.tell("stop", ActorRef.noSender());

        Thread.sleep(1000);
        System.out.println(">>> Press ENTER to exit <<<");

        try {
            System.in.read();
        } finally {
            system.terminate();
        }

    }
}
