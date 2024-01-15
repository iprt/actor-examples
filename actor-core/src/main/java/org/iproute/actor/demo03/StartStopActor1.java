package org.iproute.actor.demo03;

import akka.actor.AbstractActor;
import akka.actor.Props;

/**
 * StartStopActor1
 *
 * @author zhuzhenjie
 */
public class StartStopActor1 extends AbstractActor {

    /*
    props 是一个附加于 Actor 之上的配置类
    Props 实例是不可变的,并且在 Actor 系统间是可序列化的
    包含了创建 Actor 实例所需要的所有关联信息
     */
    static Props props() {
        return Props.create(StartStopActor1.class, StartStopActor1::new);
    }

    @Override
    public void preStart() {
        System.out.println("first started");
        getContext().actorOf(StartStopActor2.props(), "second");
    }


    @Override
    public void postStop() {
        System.out.println("first stopped");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("stop", s -> {
                    getContext().stop(getSelf());
                })
                .build();
    }
}
