package com.example.java1il2022.week4.day15.aop.interceptor;

import com.example.java1il2022.week4.day15.aop.MethodInterceptor;
import com.example.java1il2022.week4.day15.aop.MethodInvocation;


import java.lang.reflect.Method;

public class AfterMethodInterceptor implements MethodInterceptor {
    private Object aspectInstance;
    private Method aspectMethod;

    public AfterMethodInterceptor(Object aspectInstance, Method aspectMethod) {
        this.aspectInstance = aspectInstance;
        this.aspectMethod = aspectMethod;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Exception {
        aspectMethod.setAccessible(true);
        Object res;
        try {
            res = methodInvocation.proceed();
        } finally {
            aspectMethod.invoke(aspectInstance);
        }
        return res;
    }
}
