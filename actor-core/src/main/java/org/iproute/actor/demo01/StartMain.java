package org.iproute.actor.demo01;

import akka.actor.typed.ActorSystem;

/**
 * StartMain
 *
 * @author zhuzhenjie
 */
public class StartMain {
    public static void main(String[] args) {
        final ActorSystem<HelloWorldMain.SayHello> system =
                ActorSystem.create(HelloWorldMain.create(), "hello");

        system.tell(new HelloWorldMain.SayHello("World"));
        system.tell(new HelloWorldMain.SayHello("Akka"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
        system.terminate();
    }
}
