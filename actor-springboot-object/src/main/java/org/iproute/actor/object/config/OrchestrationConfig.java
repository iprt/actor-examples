package org.iproute.actor.object.config;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import lombok.extern.slf4j.Slf4j;
import org.iproute.actor.object.akka.SpringExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Orchestration
 *
 * @author zhuzhenjie
 */
@Configuration
@Slf4j
public class OrchestrationConfig {

    @Resource
    private ActorSystem system;

    @Bean
    public ActorRef basicRef() {
        ActorRef actorRef = system.actorOf(
                SpringExtension.SpringExtProvider.get(system).props("BasicActor"),
                "BasicActor"
        );
        log.info("init basicRef {}", actorRef.path().toString());
        return actorRef;
    }
}
