package com.example.java1il2022.week3.day11;

/**
 * java 8
 *      1. functional interface
 *      2. lambda expression + method reference
 *      3. stream api
 *      4. default method
 *      5. optional class
 *      6. Completable Future
 *
 *      7. hashmap -> RedBlackTree with LinkedList
 *      8. permanent -> meta space(native heap)
 *
 * Heap
 *      young gen   [eden ] [s0] [s1]   minor gc / full gc
 *      old gen     [               ]   major gc / full gc
 *     permanent gen[               ]   full gc
 *
 *     GC root
 *     STW = stop the world
 *     new instance()
 *     CMS
 *      1. initial mark STW
 *      2. concurrent mark
 *      3. final mark / final check STW
 *      4. concurrent remove
 *
 *    out of memory issue
 *      1. restart jvm
 *      2. increase young gen size
 *      3. change reference strong reference / soft reference /weak / phantom
 *      4. heap dump
 *      5. memory leak
 *              connection -> not closed
 *              static map -> data not cleaned up / not removed
 *
 */