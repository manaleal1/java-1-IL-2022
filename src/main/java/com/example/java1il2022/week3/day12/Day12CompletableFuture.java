package com.example.java1il2022.week3.day12;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Day12CompletableFuture {
    public static void main(String[] args) {

    }
}

/**
 *      Thread life cycle
 *          new Thread -> runnable     <-           notify()
 *                          |                                   |
 *       sleep    <->    running   ->  wait(release lock) ->  waiting list
 *
 *     synchronized(obj1) -> obj1 waiting list
 *     synchronized(obj2) -> obj2 waiting list
 *     Synchronized => wait / notify
 *      *     *     *     *     *     *     *     *     *     *     *     *
 *      ReentrantLock (AbstractQueuedSynchronizer = CAS + volatile)
 *          2 mode -> fair / unfair
 *      lock() -> fair lock -> check blocked queue is empty ?
 *            -> unfair lock -> try to get lock
 *     unlock() -> get head node from queue
 *
 *
 *     ReentrantLock lock = new ReentrantLock();
 *     Condition waitingList1 = lock.newCondition();
 *     Condition waitingList2 = lock.newCondition();
 *      *     *     *     *     *     *     *     *     *     *     *     *
 *  same lock / monitor => multiple waiting list
 *
 *  producer                        consumer
 *  producer    BlockingQueue       consumer
 *  producer                        consumer
 *
 *  BlockingQueue => ReentrantLock + volatile
 *
 *
 *  homework
 *      1. create employee class(name / age)
 *         create employee list, sort emp list by name(descending), age(ascending), return a new list
 *      2. given list of integer, use stream to split list into List<List> (idx 0: odd list, idx 1: even list)
 *         in one line
 *      3. give array of chars, combine them into string by using stream api
 *
 */

