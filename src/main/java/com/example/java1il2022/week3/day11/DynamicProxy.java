package com.example.java1il2022.week3.day11;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        Day11EmpService proxy = (Day11EmpService) Proxy.newProxyInstance(
                DynamicProxy.class.getClassLoader(),
                new Class[]{Day11EmpService.class},
                new Day11InvocationHandler(new Day11EmpServiceImpl1())
        );
        System.out.println(proxy.getSalary());
    }
}
class Day11InvocationHandler implements InvocationHandler {
    private final Day11EmpService es;

    public Day11InvocationHandler(Day11EmpService es) {
        this.es = es;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object res = method.invoke(es, args);
        System.out.println("after");
        return res;
    }
}

interface Day11EmpService {
    void report();
    int getSalary();
}

class Day11EmpServiceImpl1 implements Day11EmpService {
    @Override
    public void report() {
        System.out.println("report");
    }

    @Override
    public int getSalary() {
        System.out.println("salary");
        return 0;
    }
}


