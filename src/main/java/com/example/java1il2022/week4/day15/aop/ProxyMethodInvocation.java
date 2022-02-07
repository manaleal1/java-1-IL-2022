package com.example.java1il2022.week4.day15.aop;

import java.lang.reflect.Method;
import java.util.List;

public class ProxyMethodInvocation implements MethodInvocation{

    private List<MethodInterceptor> methodInterceptorList;
    private Object realInstance;
    private Method method;
    private Object[] args;
    private int idx;

    public ProxyMethodInvocation(List<MethodInterceptor> methodInterceptorList, Object realInstance, Method method, Object[] args) {
        this.methodInterceptorList = methodInterceptorList;
        this.realInstance = realInstance;
        this.method = method;
        this.args = args;
    }

    @Override
    public Object proceed() throws Exception {
        if(idx < methodInterceptorList.size()) {
            MethodInterceptor mi = methodInterceptorList.get(idx);
            idx++;
            return mi.invoke(this);
        } else {
            return method.invoke(realInstance, args);
        }
    }
}
