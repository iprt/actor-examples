package org.iproute.actor.typed.actor;

import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import akka.actor.typed.javadsl.TimerScheduler;
import lombok.SneakyThrows;

import java.time.Duration;

/**
 * TimerActor
 *
 * @author zhuzhenjie
 */
public class TimerActor extends AbstractBehavior<String> {

    private static final String TIMER_KEY = "PeriodicTimerKey";

    public static Behavior<String> create() {
        return Behaviors.setup(
                context -> Behaviors.withTimers(
                        timers -> new TimerActor(context, timers)));
    }

    private TimerActor(ActorContext<String> context, TimerScheduler<String> timers) {
        super(context);
        timers.startTimerAtFixedRate(TIMER_KEY, "Tick", Duration.ofSeconds(1));
    }

    @Override
    public Receive<String> createReceive() {
        return newReceiveBuilder()
                .onMessageEquals("Tick", this::onTick)
                .onMessageEquals("Stop", this::onStop)
                .build();
    }


    private Behavior<String> onTick() {
        getContext().getLog().info("Tick");
        return this;
    }

    private Behavior<String> onStop() {
        getContext().getLog().info("Stop");

        return Behaviors.stopped();
    }

    @SneakyThrows
    public static void main(String[] args) {
        ActorSystem<String> system = ActorSystem.create(TimerActor.create(), "TimerActor");


        system.tell("Tick");

        Thread.sleep(5000);

        system.tell("Stop");
    }
}