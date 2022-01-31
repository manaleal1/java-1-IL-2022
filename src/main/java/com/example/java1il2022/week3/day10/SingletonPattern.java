package com.example.java1il2022.week3.day10;

import java.io.Serializable;

/**
 *  what is singleton?
 *  why do use singleton?
 *  how do create singleton?
 *
 * Class.forName()
 * Singleton.getObj()
 * new Singleton()
 */

//eager loading
public class SingletonPattern {
    private Object data = new Object();
    private static final SingletonPattern obj = new SingletonPattern();

    private SingletonPattern() {
    }

    public static SingletonPattern getObj() {
        return obj;
    }
}

//lazy loading
//obj -> get memory location ->  run constructor -> ?
class SingletonImpl2 {
    private Object data = new Object();
    private volatile static SingletonImpl2 obj;

    private SingletonImpl2() {

    }

    public static SingletonImpl2 getObj() {
        if(obj == null) {
            synchronized (SingletonImpl2.class) {
                if(obj == null) {
                    obj = new SingletonImpl2();
                }
            }
        }
        return obj;
    }
}

//Enum
enum Car {
    Benz, BMW;
}

class EnumTest {
    public static void main(String[] args) {
        System.out.println(Car.BMW == Car.BMW);
    }
}
