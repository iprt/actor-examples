package org.iproute.actor.object.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.UntypedAbstractActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * An actor that can count using an injected CountingService.
 *
 * @note The scope here is prototype since we want to create a new actor
 * instance for use of this bean.
 */
@Component("CountingActor")
@Scope("prototype")
public class CountingActor extends UntypedAbstractActor {


    public static class Count {
    }

    public static class Get {
    }

    // the service that will be automatically injected
    final CountingService countingService;
    final ActorSystem system;

    @Autowired
    public CountingActor(CountingService countingService,
                         ActorSystem system) {
        this.countingService = countingService;
        this.system = system;
    }

    private int count = 0;

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Count) {
            count = countingService.increment(count);

            ActorRef demoActor = getContext().actorOf(
                    SpringExtension.SpringExtProvider.get(system).props("DemoActor"),
                    "demo" + count
            );

            demoActor.tell(new DemoActor.DemoMsg("count is " + count), ActorRef.noSender());

        } else if (message instanceof Get) {
            getSender().tell(count, getSelf());
        } else {
            unhandled(message);
        }
    }
}
