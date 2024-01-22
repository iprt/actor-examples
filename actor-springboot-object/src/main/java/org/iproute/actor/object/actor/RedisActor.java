package org.iproute.actor.object.actor;

import akka.actor.UntypedAbstractActor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * HiActor
 *
 * @author zhuzhenjie
 */
@Component("RedisActor")
@Scope("prototype")
@Slf4j
public class RedisActor extends UntypedAbstractActor {
    @Override
    public void preStart() throws Exception {
        log.info("RedisActor is {}", getSelf().path());
    }

    @Override
    public void onReceive(Object message) throws Throwable {

        if (message instanceof IotMsg) {
            log.info("save to redis ==> {}", message);
        } else {
            unhandled(message);
        }
        getContext().stop(self());

    }
}
