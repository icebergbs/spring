package com.example.spring.context;

import com.example.spring.beans.MyTestBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class PropertyConfigurerTest {

    @Test
    public void testMyBean() {
        ConfigurableListableBeanFactory ap = new XmlBeanFactory(new ClassPathResource("BeanFactory.xml"));
        BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) ap.getBean("bfpp");
        bfpp.postProcessBeanFactory(ap);
        System.out.println(ap.getBean("simpleBean"));

    }

    /**
     * BeanFactory中没有实现后处理器的自动注册; 使用时如果没有手动注册是不能使用的
     * ApplicationContext中却添加了自动注册功能
     *      : 这个特性就是在 registerBeanPostProcessors()方法中完成的
     */
    @Test
    public void testBeanFactory() {
        BeanFactory ap = new XmlBeanFactory(new ClassPathResource("BeanFactory.xml"));
        System.out.println(ap.getBean("simpleBean"));
    }

    @Test
    public void testApplicationContext() {
        //在获取每个bean的时候打印 "===="
        ApplicationContext ap = new ClassPathXmlApplicationContext("BeanFactory.xml");
        System.out.println(ap.getBean("simpleBean"));

    }
}
