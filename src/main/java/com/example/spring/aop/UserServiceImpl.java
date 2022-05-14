package com.example.spring.aop;

import com.example.spring.beans.User;

/**
 * 业务接口实现
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("--------------add-------------------");
    }
}
