package com.example.spring.beans;

public class Teacher implements User{
    @Override
    public void showMe() {
        System.out.println("I am a Teacher");
    }
}
