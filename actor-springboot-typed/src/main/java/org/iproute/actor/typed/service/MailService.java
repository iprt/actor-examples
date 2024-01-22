package org.iproute.actor.typed.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Mail
 *
 * @author zhuzhenjie
 */
@Component
@Slf4j
public class MailService {

    public void send(String msg) {
        log.info("mail send {}", msg);
    }

}
