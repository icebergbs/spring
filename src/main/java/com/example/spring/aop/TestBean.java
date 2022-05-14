package com.example.spring.aop;

/**
 * 用于拦截的Bean
 */
public class TestBean {

    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test() {
        System.out.println("aop test bean");
    }
}
