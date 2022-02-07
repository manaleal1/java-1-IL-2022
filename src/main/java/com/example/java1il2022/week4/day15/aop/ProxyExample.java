package com.example.java1il2022.week4.day15.aop;


import com.example.java1il2022.week4.day15.aop.annotation.*;

import java.lang.reflect.Proxy;

public class ProxyExample {
    public static void main(String[] args) throws Exception{
        Calculator c1 = new CalculatorImpl1();
        Calculator proxy = (Calculator) Proxy.newProxyInstance(
                c1.getClass().getClassLoader(),
                new Class[]{Calculator.class},
                new JdkReflectiveInvocationHandler(c1, new CalculatorAspect())
        );
        proxy.sum(1, 2);
    }
}
interface Calculator {
    int sum(int x, int y);
}

class CalculatorImpl1 implements Calculator {
    @Override
    public int sum(int x, int y) {
        System.out.println("res = " + (x + y));
//        throw new RuntimeException();
        return x + y;
    }
}

class CalculatorAspect {

    @AfterThrow
    public void exceptionThrow() {
        System.out.println("this is after throw exception");
    }
    @After
    public void afterLogic1() {
        System.out.println("this is after -- number 1");
    }

    @After
    public void afterLogic2() {
        System.out.println("this is after -- number 2");
    }


    @AfterReturn
    public void afterReturnMethod() {
        System.out.println("this is after return");
    }

    @Before
    public void beforeLogic1() {
        System.out.println("this is before -- number 1");
    }

    @Before
    public void beforeLogic2() {
        System.out.println("this is before -- number 2");
    }


}