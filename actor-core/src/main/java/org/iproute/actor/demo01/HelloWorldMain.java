package org.iproute.actor.demo01;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

/**
 * HelloWorldMain
 *
 * @author zhuzhenjie
 */
public class HelloWorldMain extends AbstractBehavior<HelloWorldMain.SayHello> {

    public static class SayHello {
        public final String name;

        public SayHello(String name) {
            this.name = name;
        }
    }

    // #hello-world-main-setup
    public static Behavior<SayHello> create() {
        return Behaviors.setup(HelloWorldMain::new);
    }

    private final ActorRef<HelloWorld.Greet> greeter;

    private HelloWorldMain(ActorContext<SayHello> context) {
        super(context);
        greeter = context.spawn(HelloWorld.create(), "greeter");
    }

    @Override
    public Receive<SayHello> createReceive() {
        return newReceiveBuilder().onMessage(SayHello.class, this::onStart).build();
    }

    private Behavior<SayHello> onStart(SayHello command) {
        ActorRef<HelloWorld.Greeted> replyTo =
                getContext().spawn(HelloWorldBot.create(3), command.name);
        greeter.tell(new HelloWorld.Greet(command.name, replyTo));
        return this;
    }


}
