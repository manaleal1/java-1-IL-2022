package com.example.java1il2022.week3.day10;

/**
 *  why do we use factory?
 *
 */
public class Factory {
    public static StuService getStuService() {
        return new StuServiceImpl1();
    }
}

interface StuService{}
class StuServiceImpl1 implements StuService{}
class StuServiceImpl2 implements StuService{}

//1000 places -> Factory.getStuService();