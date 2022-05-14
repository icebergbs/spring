package com.example.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 创建 Advisor
 */
@Aspect
public class AspectJTest {

    @Pointcut("execution(* *.test(..))")
    public void test(){

    }

    @Before("test()")
    public void beforeTest() {
        System.out.println("before Test");
    }


    @After("test()")
    public void afterTest() {
        System.out.println("after Test");
    }

    @Around("test()")
    public Object arountTest(ProceedingJoinPoint p) {
        System.out.println("before 1");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after 1");
        return o;
    }


}
