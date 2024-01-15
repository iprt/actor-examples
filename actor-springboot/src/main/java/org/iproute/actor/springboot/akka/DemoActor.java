package org.iproute.actor.springboot.akka;

import akka.actor.UntypedAbstractActor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * DemoActor
 *
 * @author zhuzhenjie
 */
@Component("DemoActor")
@Scope("prototype")
@Slf4j
public class DemoActor extends UntypedAbstractActor {

    public static class DemoMsg {
        final String content;

        public DemoMsg(String content) {
            this.content = content;
        }
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof DemoMsg) {
            log.info("DemoActor receive msg :{}", ((DemoMsg) message).content);
        } else {
            unhandled(message);
        }
    }

}
