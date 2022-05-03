package com.example.spring.beans;


import com.example.spring.beans.aware.TestAware;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestAwareTest {

    @Test
    public void testMyBean() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        TestAware bean = (TestAware) bf.getBean("testAware");
        bean.testAware();


    }
}
