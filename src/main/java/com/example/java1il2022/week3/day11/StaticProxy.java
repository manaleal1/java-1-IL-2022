package com.example.java1il2022.week3.day11;

class EmpService {
    public void report() {
        System.out.println("this is report");
    }

    public int getSalary() {
        System.out.println("get salary function");
        return 0;
    }
}
//"IS-A"
class EmpLogService {
    public void report() {
        //..
        System.out.println("this is report");
        //..
    }

    public int getSalary() {
        //..
        System.out.println("get salary function");
        //..
        return 0;
    }
}
//"HAS-A"
class EmpServiceProxy {
    private final EmpService es;

    public EmpServiceProxy(EmpService es) {
        this.es = es;
    }

    public void report() {
        //
        es.report();
        //
    }

    public int getSalary() {
        //..
        int res = es.getSalary();
        //..
        return res;
    }
}
/**
 *  "this is before"
 *  "this is report"
 *  "this is after"
 *
 *  "this is before"
 *  "get salary function"
 *  "this is after"
 *
 */