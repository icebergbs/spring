package com.example.spring.beans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import sun.awt.X11.XMapEvent;
import sun.awt.motif.X11CNS11643;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("deprecation")
class MyTestBeanTest {

    @Test
    public void testSimpleLoad() {
        //2.2 功能分析
        /**
         * 1. 读取配置文件.xml
         * 2. 根据.xml中的配置找到对应的类的配置. 并实例化
         * 3. 调用实例化后的实例
         *
         * 实现上面功能, beans.jar(core是必须的)
         *
         *
         */

        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
        assertEquals("testStr", bean.getTestStr());

        /**
         * 2.4 Spring 的结构组成
         *  2.4.1 beans包的层级结构
         *  2.4.2 核心类介绍
         *      1. DefaultListableBeanFactor
         *         XmlBeanFactory继承字DefaultListableBeanFactory, DBF是整个bean加载的核心部分,是Spring注册及加载bean的默认实现
         *         XBF与DBF不同地方在于, XBF自定义实现了XML读取器XmlBeanDefinitionReader
         * 容器加载相关类:
             AliasRegistry: 定义对alias的简单增删改等操作
             SimpleAliasRegistry: 主要使用map 作为 alias 的缓存, 并对接口 AliasRegistry进行实现
             SingletonBeanRegistry: 定义对单例的注册及获取
             BeanFactory: 定义获取bean 及 bean 的各种属性
             DefaultSingletonBeanRegistry: 对接口SingletonBeanRegistry各函数的实现
             HierarchicalBeanFactory: 继承BeanFactory, 也就是在BeanFacoty定义的功能的基础上增加了对parentFactory的支持
             BeanDefinitionRegistry: 定义对BeanDefinition 的各种增删改查操作
             FactoryBeanRegistrySupport: 在 DefaultSingletonBeanRegistry 的基层上增加了对 FactoryBean的特殊处理功能
             ConfigurableBeanFacoty: 提供配置 Factory 的各种方法
             ListableBeanFactory: 根据各种条件获取 bean 的配置清单
             AbstractBeanFactory: 综合 FactoryBeanRegistrySupport 和 ConfigurableBeanFactory 的功能
             AutowireCapableBeanFactory: 提供创建 bean, 自动注入, 初始化以及 应用 bean 的后处理器
             AbstractAutowireCapableBeanFactory: 综合 AbstractBeanFactory 并对接口 AutowireCapableBeanFactory实现
             ConfigurableListableBeanFactory: BeanFactory 配置清单, 指定忽略类型及接口等
             DefaultListableBeanFactory: 综合上面所以功能, 主要是对 bean 注册后的处理


         */
    }

    @Test
    public void testCircleByConstructor() throws Throwable {
        try {
            BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring.xml"));
            MyTestBean bean = (MyTestBean) bf.getBean("testC");
        }catch (Exception e) {
            //因为要在创建 testC时抛出
            Throwable el = e.getCause().getCause().getCause();

            throw el;
        }

    }
}