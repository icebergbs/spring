package com.example.spring.beans;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class Replacer1 implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("replace method run");
        return method.invoke(obj.getClass().newInstance(), args);
    }
}
