package org.iproute.actor.springboot.akka;

import org.springframework.stereotype.Component;

/**
 * CountingService
 *
 * @author zhuzhenjie
 */
@Component
public class CountingService {
    /**
     * Increment the given number by one.
     */
    public int increment(int count) {
        return count + 1;
    }
}
