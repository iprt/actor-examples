package org.iproute.actor.springboot.config;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

import static org.iproute.actor.springboot.akka.SpringExtension.SpringExtProvider;

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
                SpringExtProvider.get(system).props("BasicActor"),
                "BasicActor"
        );
        log.info("init basicRef {}", actorRef.path().toString());
        return actorRef;
    }
}
