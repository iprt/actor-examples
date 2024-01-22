package org.iproute.actor.typed.actor;

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

/**
 * JdbcActor
 *
 * @author zhuzhenjie
 */
public class JdbcActor extends AbstractBehavior<JdbcActor.JdbcMsg> {


    public JdbcActor(ActorContext<JdbcMsg> context) {
        super(context);
    }

    public static Behavior<JdbcMsg> create() {
        return Behaviors.setup(JdbcActor::new);
    }


    @Override
    public Receive<JdbcMsg> createReceive() {
        return newReceiveBuilder()
                .onMessage(JdbcMsg.class, this::onReceive)
                .build();
    }

    public Behavior<JdbcMsg> onReceive(JdbcMsg msg) {
        getContext().getLog().info("jdbc msg is {}", msg);
        return this;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @Data
    public static class JdbcMsg {
        private String host;
        private int port;
        private String username;
        private String password;
    }
}
