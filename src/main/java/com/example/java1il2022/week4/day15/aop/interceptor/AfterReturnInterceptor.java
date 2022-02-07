package com.example.java1il2022.week4.day15.aop.interceptor;

import com.example.java1il2022.week4.day15.aop.MethodInterceptor;
import com.example.java1il2022.week4.day15.aop.MethodInvocation;


import java.lang.reflect.Method;

public class AfterReturnInterceptor implements MethodInterceptor {
    private Object aspectInstance;
    private Method aspectMethod;

    public AfterReturnInterceptor(Object aspectInstance, Method aspectMethod) {
        this.aspectInstance = aspectInstance;
        this.aspectMethod = aspectMethod;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Exception {
        Object res = methodInvocation.proceed();
        aspectMethod.setAccessible(true);
        aspectMethod.invoke(aspectInstance);
        return res;
    }
}
