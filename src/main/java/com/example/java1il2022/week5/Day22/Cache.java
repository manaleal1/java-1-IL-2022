package com.example.java1il2022.week5.Day22;


/**
 *  local cache vs global cache
 *
 *  local cache
 *      N1(map1)   N2(map2)   N3(map3)
 *  global cache
 *      N1          N2          N3
 *           \      |        /
 *          redis cache cluster
 *       leader1(1 - 10k)    leader2(10k - 20k)
 *      /       \               ..
 *    Follower1 Follower2
 *
 *  cache pattern
 *    read through / write through
 *      server - cache - db
 *    cache aside
 *      server - cache
 *         |
 *        db
 *      1. read data :
 *          a. read cache
 *          b. read db + save data into cache
 *      2. write / update data :
 *          a. remove data from cache
 *
 *
 *  your Rest api is slow ?
 *      1. locate issue
 *      2. database query ? code performance
 *      3. local cache
 *
 *
 *
 *  Message Queue
 *      1.Asynchronous
 *         producer -  queue  - consumer
 *         server      server   server
 *      2.queue model
 *         producer             consumer1
 *         producer -   queue - consumer2
 *         producer             consumer3
 *      3.publisher - subscriber
 *                    - sub
 *        pub - queue - sub
 *                    - sub
 *      4.kafka / SQS / rabbit, active mq
 *
 *
 *       producer   -    broker1(server)     -     consumer
 *                      |         |
 *                   broker2  -- broker3
 *
 *      broker1:
 *          Topic1
 *              partition1(leader)                 consumer group1
 *              partition2(follower)                 consumer1 (partition1)
 *      broker2:                                     consumer2 (partition2)
 *          Topic1                                 consumer group2
 *              partition1(follower)                 consumer3 (partition2)
 *              partition2(leader)                   consumer4 (partition1)
 *
 *
 *   Issues
 *      producer
 *          1. send msg to kafka
 *          2. commit kafka transaction
 *          --shutdown
 *          3. save data into db
 *          4. commit transaction
 *
 *          1. save data into db
 *          2. commit transaction
 *          --shutdown
 *          3. send msg to kafka
 *          4. commit kafka transaction
 *     CDC + outbox
 *          1. save msg to outbox table in db
 *          2. save data in db
 *          3. commit db
 *
 *          service1
 *              |
 *             db    --  producer(CDC)  -- queue  -- consumer(idempotent)
 *
 *
 *   Global Transaction(Saga pattern)
 *
 *    user  -> service1 -> queue -> service2 -> queue -> service3
 *   `                  <- queue <- rollback
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */