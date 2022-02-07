package com.example.java1il2022.week4.day15.aop.interceptor;

import com.example.java1il2022.week4.day15.aop.MethodInterceptor;
import com.example.java1il2022.week4.day15.aop.MethodInvocation;


import java.lang.reflect.Method;

public class AfterThrowInterceptor implements MethodInterceptor {
    private Object aspectInstance;
    private Method aspectMethod;

    public AfterThrowInterceptor(Object aspectInstance, Method aspectMethod) {
        this.aspectInstance = aspectInstance;
        this.aspectMethod = aspectMethod;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Exception {
        try {
            return methodInvocation.proceed();
        } catch (Exception ex) {
            aspectMethod.setAccessible(true);
            aspectMethod.invoke(aspectInstance);
            throw ex;
        }
    }
}
