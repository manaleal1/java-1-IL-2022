package com.example.java1il2022.week3.day10;

/**
 *
 *      cloneable => clone();
 *
 *      1. shallow copy
 *          emp1 {
 *              name = "Tom"
 *              Address address
 *          }
 *
 *          emp2 {
 *  *           name = "Tom"
 *  *           Address address
 *  *       }
 *      2. deep copy
 */
class PrototypePattern {
    public static void main(String[] args) throws Exception{
        Object obj = new Object();
        Employee emp = new Employee();
        Employee emp2 = (Employee) emp.clone();
        System.out.println(emp == emp2);
        System.out.println(emp.data == emp2.data);
    }
}
class Employee implements Cloneable{
    public Object data = new Object();

    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();
    }
}

//immutable
final class ImmutableExample {
    private final Object obj;

    public ImmutableExample(Object obj) {
        //create copy
        this.obj = obj;
    }

    public Object getObj() {
        //return copy
        return obj;
    }
}