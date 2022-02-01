package com.example.java1il2022.week3.day11;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Day11Reflection {
    public static void main(String[] args) throws Exception {
        Day11ReflectionEmpService es = new Day11ReflectionEmpService();
        Class<?> clazz = es.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field f: fields) {
            System.out.println(f);
            f.setAccessible(true);
            f.setInt(es, 10);
        }
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        for(Annotation annotation: annotations) {
            System.out.println(annotation);
        }
        es.print();
    }
}

//@MyComponent
class Day11ReflectionEmpService {
    private int a = 0;

    private Day11ReflectionStuService ss;

    public void print() {
        System.out.println(a);
    }
}

class Day11ReflectionStuService {

}


