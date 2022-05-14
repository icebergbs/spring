package com.example.spring.aop;

/**
 * Jdk 代理使用实例:
 *   创建业务接口
 */
public interface UserService {

    /**
     * 目标方法
     */
    public abstract void add();
}
