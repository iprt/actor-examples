package org.iproute.actor.demo04;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**
 * ExceptionMain
 *
 * @author zhuzhenjie
 */
public class ExceptionMain {

    public static void main(String[] args) throws Exception {

        ActorSystem system = ActorSystem.create("test-system");

        ActorRef supervisingActor = system.actorOf(SupervisingActor.props(), "supervising-actor");
        supervisingActor.tell("failChild", ActorRef.noSender());

    }
}
