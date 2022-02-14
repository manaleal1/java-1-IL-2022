package com.example.java1il2022.week5.day19;

/**
 *                         client
 *                           |
 *                        Load balancer
 *               /           \           \                   \
 *  Node1(server1)   Node2(server2)   Node3(server3)    Node4(server4)
 *
 *
 *  monolithic
 *      1. team work
 *      2. scalability : horizontal / vertical scaling
 *
 *  microservice
 *      pros:
 *          1. scalability
 *          2. message queue (kafka / sqs / sns)
 *              client
 *              ||
 *          producer (server) ->  message queue (server)  -> consumer (server)
 *          3. deployment / team
 *          4. fail tolerance with circuit breaker (Hystrix)
 *             service1 -> service2(shutdown)
 *               |--------------|
 *          ...
 *      cons:
 *          1. complexity
 *          2. may have bad performance
 *          3. service boundary
 *          ...
 *  what do we need when we design microservice :
 *          1. gateway (log / validation / rate limiter)
 *             request1 -> gateway -> request2(header:co-relation id) -> service1 -> request3(header:co-relation id) -> service2
 *             how to generate global unique id - co-relation id?
 *                  1. UUID
 *                  2. db1 (1 - 3 - 5 - ..)
 *                     db2 (2 - 4 - 6 - ..)
 *                  3. timestamp + machine id + process id  +  000000
 *                     timestamp + machine id + process id  +  111111
 *
 *              how to create rate limiter
 *                  1. token bucket
 *                       drop 1 token per sec into bucket
 *
 *                          bucket[1000 token]        ->   request take token
 *
 *          2. circuit breaker (fail tolerance)
 *          3. service discovery + client side load balancing  (spring cloud eureka + spring cloud ribbon)
 *              service1                                     service2
 *              service1 -> http request /service2/uri ->    service2
 *              service1                                     service2
 *
 *                                \          /
 *                              discovery service / service registration
 *                                      key - value
 *                                 service2 : {ip1, ip2, ip3}
 *          4. centralized config service (spring cloud config)
 *          5. create centralized security service (spring cloud security)
 *          6. data storage / cache (CAP / BASE, nosql / rdbms / file storage)
 *          7. message queue (Asynchronous flow)
 *          ...
 *
 *   Tuesday:
 *      Spring cloud
 *   Wednesday:
 *      Database
 *   Thursday:
 *      Message Queue
 *   Friday:
 *      code review
 */
