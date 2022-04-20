package com.example.spring.beans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import static org.junit.jupiter.api.Assertions.*;


class MyTestBean1Test {

    @Test
    public void testMyBean() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        MyTestBean1 bean = (MyTestBean1) bf.getBean("myTestBean1");
        bean.getUserBean().showMe();
        bean.changedMethod();
        bean.changedMethod1();
    }
}