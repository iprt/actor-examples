package org.iproute.actor.iot;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**
 * IotMain
 *
 * @author zhuzhenjie
 */
public class IotMain {
    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("iot-system");

        try {
            // Create top level supervisor
            ActorRef supervisor = system.actorOf(IotSupervisor.props(), "iot-supervisor");

            Thread.sleep(1000);
            System.out.println("Press ENTER to exit the system");
            System.in.read();
        } finally {
            system.terminate();
        }
    }
}
