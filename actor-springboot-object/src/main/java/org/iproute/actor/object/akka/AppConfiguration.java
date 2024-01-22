package org.iproute.actor.object.akka;

import akka.actor.ActorSystem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * AppConfiguration
 *
 * @author zhuzhenjie
 */
@Configuration
@Slf4j
public class AppConfiguration {

    // the application context is needed to initialize the Akka Spring Extension
    @Resource
    private ApplicationContext applicationContext;

    /**
     * Actor system singleton for this application.
     */
    @Bean
    public ActorSystem actorSystem() {
        ActorSystem system = ActorSystem.create("AkkaJavaSpring");
        // initialize the application context in the Akka Spring Extension
        SpringExtension.SpringExtProvider.get(system).initialize(applicationContext);
        log.info("create ActorSystem AkkaJavaSpring");
        return system;
    }
}
