package org.iproute.actor.typed.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * AtxUtils
 *
 * @author zhuzhenjie
 */
@Component
public class AppCtxUtils implements ApplicationContextAware {

    private static ApplicationContext atx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        atx = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return atx.getBean(clazz);
    }

}
