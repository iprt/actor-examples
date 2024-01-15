package org.iproute.actor.springboot.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.UntypedAbstractActor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static org.iproute.actor.springboot.akka.SpringExtension.SpringExtProvider;

/**
 * BasicActor
 *
 * @author zhuzhenjie
 */
@Component("BasicActor")
@Scope("prototype")
@Slf4j
@AllArgsConstructor
public class BasicActor extends UntypedAbstractActor {

    private final ActorSystem system;

    @Override
    public void preStart() throws Exception {

        log.info("BasicActor is {}", getSelf().path());

    }


    @Override
    public void onReceive(Object message) throws Throwable {
        log.info("do nothing , just for dispatching!");

        UUID uuid = UUID.randomUUID();

        ActorRef mysqlRef = getContext().actorOf(
                SpringExtProvider.get(system).props("MysqlActor"),
                "MysqlActor" + uuid
        );

        ActorRef redisRef = getContext().actorOf(
                SpringExtProvider.get(system).props("RedisActor"),
                "RedisActor" + uuid
        );

        mysqlRef.tell(message, ActorRef.noSender());
        redisRef.tell(message, ActorRef.noSender());

        // getContext().stop(self());
    }

}
