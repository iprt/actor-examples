package org.iproute.actor.typed.actor;

import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * ExtendActor
 *
 * @author zhuzhenjie
 */
public class ExtendActor extends AbstractBehavior<ExtendActor.BaseMsg> {

    public interface BaseMsg {
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @Data
    public static class LogMsg implements BaseMsg {
        private Date date;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @Data
    private static class ExceptionMsg implements BaseMsg {
        private RuntimeException exception;
    }

    public ExtendActor(ActorContext<BaseMsg> context) {
        super(context);
    }

    public static Behavior<BaseMsg> create() {
        return Behaviors.setup(ExtendActor::new);
    }

    @Override
    public Receive<BaseMsg> createReceive() {
        return newReceiveBuilder()
                .onMessage(LogMsg.class, this::onLogMsg)
                .onMessage(ExceptionMsg.class, this::onExceptionMsg)
                .build();
    }

    private Behavior<BaseMsg> onLogMsg(LogMsg msg) {
        System.out.println("log = " + msg);
        return this;
    }

    private Behavior<BaseMsg> onExceptionMsg(ExceptionMsg msg) {
        System.out.println("exceptionMsg = " + msg);
        return this;
    }

    public static void main(String[] args) {
        ActorSystem<BaseMsg> system = ActorSystem.create(
                ExtendActor.create(), "ExtendActor"
        );

        system.tell(LogMsg.builder().date(new Date()).build());
        system.tell(ExceptionMsg.builder().exception(new RuntimeException("test")).build());

    }
}
