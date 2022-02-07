package com.example.java1il2022.week4.day15.aop;

public interface MethodInterceptor {
    Object invoke(MethodInvocation methodInvocation) throws Exception;
}
