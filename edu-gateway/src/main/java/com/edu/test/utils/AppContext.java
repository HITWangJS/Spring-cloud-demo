package com.edu.test.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

public class AppContext implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        if (AppContext.applicationContext == null) {
            AppContext.applicationContext = arg0;
        }
    }

    // 获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    // 通过name获取 Bean.
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    // 通过class获取Bean.
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    // 通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
    
    // 发布事件
    public static void publishEvent(ApplicationEvent event) {
        applicationContext.publishEvent(event);
    }
}
