package com.example.java1il2022.week3.day11.ioc;

import com.example.java1il2022.week3.day11.ioc.annotation.MyAutowired;
import com.example.java1il2022.week3.day11.ioc.annotation.MyComponent;

public class IOCTest {
    public static void main(String[] args) throws Exception {
        MyContainer container = new MyContainer();
        container.start();
        Object obj = container.getObj(IOCEmployee.class);
        System.out.println(obj);
    }
}

@MyComponent
class IOCEmployee {
    @MyAutowired
    private IOCStudent iocStudent;

    public void print() {
        System.out.println(iocStudent);
    }

    @Override
    public String toString() {
        return "IOCEmployee{" +
                "iocStudent=" + iocStudent +
                '}';
    }
}

@MyComponent
class IOCStudent {
    @Override
    public String toString() {
        return "IOCStudent{}";
    }
}