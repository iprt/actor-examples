package org.iproute.actor.typed.controller;

import org.iproute.actor.typed.config.AppCtxUtils;
import org.iproute.actor.typed.service.MailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author zhuzhenjie
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/mail")
    public String mail() {
        MailService mailService = AppCtxUtils.getBean(MailService.class);
        mailService.send("hello world");
        return "true";
    }

}
