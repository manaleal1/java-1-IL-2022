package com.example.java1il2022.week3.day13;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFutureTest {
    private static final ExecutorService pool = Executors.newCachedThreadPool();
    public static void main(String[] args) throws Exception {
//        List<Integer> list = Arrays.asList(1, 2, 3 , 4);
//        list.parallelStream()
//                .map(x -> {
//                    System.out.println(Thread.currentThread());
//                    return x * 2;
//                })
//                .collect(Collectors.toList());
        System.out.println(cfTest1());
    }

    //sum(1, 10, 2) , sum(2, 10, 2)
    public static int futureTest1() throws Exception {
        Future<Integer> f1 = pool.submit(() -> {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread() + "f1 sleep ready");
            return sum(1, 10, 2);
        });
        System.out.println(Thread.currentThread() + " after f1 , before f2");
        Future<Integer> f2 = pool.submit(() -> sum(2, 10, 2));
        return f1.get() + f2.get();
    }

    public static int cfTest1() {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return sum(1, 10, 2);
        }, pool);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> sum(2, 10, 2), pool);
        CompletableFuture<Integer>[] futures = new CompletableFuture[]{f1, f2};
        CompletableFuture<Integer> finalFuture =  CompletableFuture.allOf(futures)
                .thenApply(Void -> {
                    int res = 0;
                    for(CompletableFuture<Integer> f: futures) {
                        res += f.join();
                    }
                    System.out.println(Thread.currentThread() + "/" + res);
                    return res;
                })
                .thenApply(preRes -> preRes * 2)
                .thenApply(x -> {
                    System.out.println(x);
                    return x;
                });
//                .orTimeout(1, TimeUnit.SECONDS);
//        f1.cancel(true);
//        f2.cancel(true);
        System.out.println("this is main thread");
        if(!finalFuture.isDone()) {
            finalFuture.completeExceptionally(new RuntimeException("xx"));
        }
        return finalFuture.join();
    }


    public static int cfTest2() {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> sum(1, 10, 2), pool);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> sum(2, 10, 2), pool);
        return f1.join() + f2.join();
    }

    public static int sum(int from, int to, int interval) {
        int res = 0;
        while(from <= to) {
            res += from;
            from += interval;
        }
        return res;
    }
}

/**
 *  homework
 *      1. write cfTest1() on white board
 *      2. read documents / topics related to hibernate
 *          a. relation mapping @OneToMany / @ManyToMany / @OneToOne / @ManyToOne
 *          b. connection pool concept
 *          c. object mapping
 *          d. lazy loading vs eager loading
 *          e. hibernate cache
 *          f. hibernate query language
 *          g. sql injection
 *      3. sql ->  find nth highest salary from employee table
 */
