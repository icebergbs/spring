package com.example.spring.event;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventTest {

    @Test
    public void testMyBean() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestEvent event = new TestEvent("hello", "msg");
        context.publishEvent(event);
    }
    /**
     * 观察者模式
     *
     * ApplictionEventMulticaster初始化:
     *  用户没有自定义事件广播器,使用用户
     *  用户没有自定义事件广播器,使用默认的 ApplicationEventMulticaster
     *
     * 广播器:
     *  存放监听器并在合适的时候调用监听器
     *  默认广播器实现 SimpleApplicationEventMulticaster
     */

}
