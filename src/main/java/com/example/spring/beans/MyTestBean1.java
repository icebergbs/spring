package com.example.spring.beans;

public abstract class MyTestBean1 {

    //用于测试lookup-method
    public abstract User getUserBean();

    //用于测试replace-method
    public void changedMethod() {
        System.out.println("Origin method in MyTestBean run");
    }
    //用于测试replace-method
    public void changedMethod1() {
        System.out.println("Origin method in MyTestBean run");
    }

}
