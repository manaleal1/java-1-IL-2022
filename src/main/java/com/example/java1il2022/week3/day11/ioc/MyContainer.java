package com.example.java1il2022.week3.day11.ioc;

import com.example.java1il2022.week3.day11.ioc.annotation.MyAutowired;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  1.scan
 *  2.load instance into factory / map
 *  3.@MyAutowired
 *    inject instance from factory / map
 */
public class MyContainer {
    private final Map<String, Object> objFactory = new HashMap<>();

    private List<Class> scan() {
        return Arrays.asList(IOCStudent.class, IOCEmployee.class);
    }

    public void start() throws Exception{
        List<Class> classes = scan();
        for(Class clazz: classes) {
            String name = clazz.getSimpleName();
            Object obj = clazz.getDeclaredConstructor().newInstance();
            objFactory.put(name, obj);
        }
        System.out.println(objFactory);
        for(Class clazz: classes) {
            Object obj = objFactory.get(clazz.getSimpleName());
            for(Field f: clazz.getDeclaredFields()) {
                f.setAccessible(true);
                Class fieldClazz = f.getType();
                for(Annotation annotation: f.getDeclaredAnnotations()) {
                    if(annotation.annotationType() == MyAutowired.class) {
                        f.set(obj, objFactory.get(fieldClazz.getSimpleName()));
                    }
                }
            }
        }
    }

    public Object getObj(Class clazz) {
        return objFactory.get(clazz.getSimpleName());
    }
}
