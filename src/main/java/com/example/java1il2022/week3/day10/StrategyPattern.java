package com.example.java1il2022.week3.day10;

/**
 *
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        int res = c.calculate(1, 0, new AddCalculatorStrategy());
        System.out.println(res);
    }
}

//+ , - , /, *, mod ...
//two number
class Calculator {
    /*
    public int add(int v1, int v2) {
        return v1 + v2;
    }
    //..
     */

//    public int calculate(int v1, int v2, char symbol) {
//        switch (symbol) {
//            case '+':
//                return v1 + v2;
//            case '-':
//                return v1 - v2;
//        }
//        return 0;
//    }
    public int calculate(int v1, int v2, CalculatorStrategy strategy) {
        return strategy.run(v1, v2);
    }

}
@FunctionalInterface
interface CalculatorStrategy {
    int run(int v1, int v2);
}

class AddCalculatorStrategy implements CalculatorStrategy {
    @Override
    public int run(int v1, int v2) {
        return v1 + v2;
    }
}


