package com.example.java1il2022.week5.day21;

/**
 *  RDBMS
SINGLE-LEADER
 *      client (write)
 *        /
 *     DB1(L) ->  DB2(F) -> DB3(F)

 *        client (read)
 *        /
 *     DB1(L) ->  DB2(F) -> DB3(F)
 *
 *              client (read)
 *                 \        \
 *     DB1(L) ->  DB2(F) -> DB3(F)
 *
 *      master - slave
 *      leader - follower
 *      primary - secondary
MULTI-LEADER
 *     DB1(L) - DB2(L) - DB3(L)
 *      |       |           |
 *      F        F           F
LEADER-LESS
 *      DB1 - DB2 - DB3
 *
 *
DATA-SHARDING
 *      RDBMS
 *          read
 *          DB1(L) ->  DB2(F) - DB3(F) - DB4(F)
 *          write
 *            id % 3 = db-location
 *            hash(id) % 3 = db-location
 *          DB1-a       DB1-b       DB1-c   +  DB1-d
 *         |    |           ...
 *        F-a   F-b
 *              problems:
 *                  1. add a new instance : id % 3 => id % 4
 *                  2. select query - range
 *                          id % db-count
 *                          hash(id) % db-count
 *                  3. transaction (ACID)
 *                          insert into DB1-a - fail
 *                          insert into DB1-b - success
 *      MongoDB(CP)
 *          ->         mongos(gateway)    --     mongos(config)
 *                    /         \       \
 *             Sharding1        2         3
 *             Primary Node     ..
 *          Secondary Nodes     ..
 *     Cassandra(AP)
 *          LSM(Log -> append -> file + sequential IO)
 *
 *                           large   file
 *                   /          \           \
 *              file1           file2           file3
 *
 *          in each Node
 *              write -> mem-table  -> full ->  immutable file SSTable
 *                  |
 *             redo log
 *              read -> blooming filter ->
 *
 *           Cassandra cluster -> consistent hashing
 *                      0  - 1000
 *                       Node(0)
 *                                  N-X(15)
 *        N5(700)                   N2(30)
 *
 *                                  N3(100)
 *
 *                       N4(500)
 *          replica factor = 3
 *          read consistency  = 2
 *          write consistency = 2
 *          read consistency + write consistency > replica factor
 *
 *
 *  redis cache
 *  message queue(kafka / SQS)
 *
 *
 */