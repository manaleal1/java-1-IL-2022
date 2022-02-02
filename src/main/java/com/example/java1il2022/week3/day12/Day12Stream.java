package com.example.java1il2022.week3.day12;


import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *  what is Functional interface?
 *  example of functional interface?
 *      1. Runnable
 *      2. Callable
 *      3. Comparator
 *
 *      4. Function  one input + one output
 *      5. Consumer  one input + no  output
 *      6. Supplier  no  input + one output
 *      7. Predicate one input + boolean output
 *  when do we use comparator ? or comparable
 *
 *  what is Stream API
 *      - Functional programming
 *          list.func1(x -> x * 2).func2(x -> x > 3)...
 *      - intermediate(stateful / stateless) vs terminate operation
 *  Stream API vs for loop
 *
 */
public class Day12Stream {
    public static void main(String[] args) throws Exception{
//        A a = () -> System.out.println(6);
//        Runnable r = () -> System.out.println("this is runnable");
//        Callable c = () -> get();
//        List<Integer> list = new ArrayList<>();
//        list.sort((x1, x2) -> x1.compareTo(x2));
        streamTest();
    }
//    private static int get() {
//        return 5;
//    }

    public static void streamTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 4, 4, 3);
        List<Integer> streamList = list.stream()
                .map(x -> x * 2)
                .filter(x -> x > 3)
//                .collect(Collectors.toList());
                .collect(
                        ArrayList::new,
                        List::add,
                        (l1, l2) -> l1.addAll(l2)
                );
//        System.out.println(list);
//        System.out.println(streamList);
//        System.out.println(list == streamList);
//        list.stream().forEach(x -> System.out.println(x));

        //count the frequency
        Map<Integer, Integer> counter = new HashMap<>();
        for(int v: list) {
            counter.put(v, counter.getOrDefault(v, 0) + 1);
        }
        System.out.println(counter);
        Map<Integer, Integer> res = list.stream().collect(
                () -> new HashMap<>(),
                (map, v) -> map.put(v, map.getOrDefault(v, 0) + 1),
                (m1, m2) -> m1.putAll(m2)
        );
        System.out.println(res);

        //sum all elements
        int sum = list.stream().reduce(0, (v1, v2) -> v1 + v2);
        System.out.println(sum);

        //sort collection

        List<Integer> streamList2 = list.stream()
                .map(x -> x * 2)
                .filter(x -> x > 3)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(streamList2);
    }
}

@FunctionalInterface
interface A {
    void print();
}
