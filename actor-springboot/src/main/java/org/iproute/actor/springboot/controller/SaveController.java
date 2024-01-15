package org.iproute.actor.springboot.controller;

import akka.actor.ActorRef;
import lombok.AllArgsConstructor;
import org.iproute.actor.springboot.actor.IotMsg;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * SaveController
 *
 * @author zhuzhenjie
 */
@RestController
@AllArgsConstructor
public class SaveController {

    private final ActorRef basicRef;

    @PostMapping("/save")
    public String saveMsg(@RequestBody IotMsg msg) {
        basicRef.tell(msg, ActorRef.noSender());
        return "true";
    }

}
