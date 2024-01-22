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
@Component("MysqlActor")
@Scope("prototype")
@Slf4j
public class MysqlActor extends UntypedAbstractActor {
    @Override
    public void preStart() throws Exception {
        log.info("MysqlActor is {}", getSelf().path());
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof IotMsg) {
            log.info("save to mysql ==> {}", message);
        } else {
            unhandled(message);
        }

        getContext().stop(self());
    }

}
