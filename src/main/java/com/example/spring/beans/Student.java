package com.example.spring.beans;

public class Student implements User{
    @Override
    public void showMe() {
        System.out.println("I am a Sutdent");
    }
}
