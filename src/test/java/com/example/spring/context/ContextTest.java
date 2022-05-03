package com.example.spring.context;

import com.example.spring.beans.MyTestBean1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;

import java.util.Date;

public class ContextTest {


    @Test
    public void testMyBean() {
        ApplicationContext ap = new ClassPathXmlApplicationContext("spring.xml");

    }

    /**
     * Converter 以及 ConversionService提供的便利功能
     */
    @Test
    public void testStringToPhoneNumberConvert() {
       // ApplicationContext ap = new ClassPathXmlApplicationContext("spring.xml");
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new String2DateConverter());
        String dateStr = "2022-01-01 12:21:01";
        Date date = conversionService.convert(dateStr, Date.class);
        System.out.println("test Convert: " + date.toString());
    }
}
