package org.iproute.actor.object.controller;

import akka.actor.ActorRef;
import lombok.AllArgsConstructor;
import org.iproute.actor.object.actor.IotMsg;
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
