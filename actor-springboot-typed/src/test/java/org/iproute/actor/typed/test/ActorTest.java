package org.iproute.actor.typed.test;

import akka.actor.testkit.typed.javadsl.BehaviorTestKit;
import org.iproute.actor.typed.actor.PrintActor;
import org.junit.jupiter.api.Test;

/**
 * ActorTest
 * <p>
 * <a href="https://doc.akka.io/docs/akka/current/typed/testing.html">https://doc.akka.io/docs/akka/current/typed/testing.html</a>
 *
 * @author zhuzhenjie
 */
public class ActorTest {

    @Test
    public void testPrintActor() {

        BehaviorTestKit<String> probe =
                BehaviorTestKit.create(PrintActor.create(), "PrintActor");


        probe.run("print");
    }

}
