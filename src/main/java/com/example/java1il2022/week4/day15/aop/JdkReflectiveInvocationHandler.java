package com.example.java1il2022.week4.day15.aop;

import com.example.java1il2022.week4.day15.aop.annotation.*;
import com.example.java1il2022.week4.day15.aop.interceptor.*;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JdkReflectiveInvocationHandler implements InvocationHandler {
    private Object realInstance;
    private Object aspectInstance;

    public JdkReflectiveInvocationHandler(Object realInstance, Object aspectInstance) {
        this.realInstance = realInstance;
        this.aspectInstance = aspectInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> clazz = aspectInstance.getClass();
        List<MethodInterceptor> methodInterceptorList = new ArrayList<>();
        for(Method aspectMethod: clazz.getDeclaredMethods()) {
            for(Annotation annotation: aspectMethod.getDeclaredAnnotations()) {
                if(annotation.annotationType() == After.class) {
                    methodInterceptorList.add(new AfterMethodInterceptor(aspectInstance, aspectMethod));
                } else if(annotation.annotationType() == AfterReturn.class) {
                    methodInterceptorList.add(new AfterReturnInterceptor(aspectInstance, aspectMethod));
                } else if(annotation.annotationType() == AfterThrow.class) {
                    methodInterceptorList.add(new AfterThrowInterceptor(aspectInstance, aspectMethod));
                } else if(annotation.annotationType() == Before.class) {
                    methodInterceptorList.add(new BeforeMethodInterceptor(aspectInstance, aspectMethod));
                }
            }
        }
        ProxyMethodInvocation proxyMethodInvocation = new ProxyMethodInvocation(
                methodInterceptorList,
                realInstance,
                method,
                args
        );

        return proxyMethodInvocation.proceed();
    }
}
