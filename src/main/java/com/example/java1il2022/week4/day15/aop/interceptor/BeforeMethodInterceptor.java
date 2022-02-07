package com.example.java1il2022.week4.day15.aop.interceptor;



import com.example.java1il2022.week4.day15.aop.MethodInterceptor;
import com.example.java1il2022.week4.day15.aop.MethodInvocation;

import java.lang.reflect.Method;

public class BeforeMethodInterceptor implements MethodInterceptor {
    private Object aspectInstance;
    private Method aspectMethod;

    public BeforeMethodInterceptor(Object aspectInstance, Method aspectMethod) {
        this.aspectInstance = aspectInstance;
        this.aspectMethod = aspectMethod;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Exception {
        aspectMethod.setAccessible(true);
        aspectMethod.invoke(aspectInstance);
        return methodInvocation.proceed();
    }
}
