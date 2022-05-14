package com.example.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class TestBeanTest {

    @Test
    public void testAop() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
        TestBean bean = (TestBean) ac.getBean("test");
        bean.test();
    }

}