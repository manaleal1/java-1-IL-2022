package com.example.java1il2022.week4.day16;


/**
 *  what will happen if you click url
 *  1. www.xx.com <- DNS -> IP
 *  2. browser cache IP(TTL)
 *  3. send http request
 *          Application Layer
 *          Presentation Layer : ssl/tls
 *          Session Layer    : socket
 *          Transport Layer  : TCP(3-ways handshake, 4 ways disconnection) / UDP
 *          Network Layer    : IP (ip packet: ip header + tcp header + data)
 *          Data Link Layer  : Ethernet
 *          Physical Layer   : cable
 *
 *    [1][10100][seq_id]
 *0    p1  ->  p2  0 hi, want to build connection
 *1    p1  <-  p2  ok
 *     p1  ->  p2  sure thanks
 *
 *     p1  -> p2  i want to stop
 *     p1  <- p2  just wait
 *     p1  <- p2  finished
 *     p1  -> p2  get it
 *
 *      p1
 *      p2    <-->    NAT(public ip pool)
 *                         source ip + source port  <-> destination ip + destination port
 *   *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *   Http
 *      1. www.xx.com/abcdefg/name
 *      2. http method
 *          get     : retrieve resource
 *          delete  : delete resource
 *          put     : update whole resource -> Tom - Jerry /
 *          patch   : update partial resource
 *          post    : create resource
 *
 *          idempotent
 *      3. status code
 *            200.. : success
 *            400.. : client side error
 *            500.. : server side error
 *      4. header
 *            content-type : json / xml / raw text
 *            accept :
 *      5. tcp
 *
 *     *     *     *     *     *     *     *     *     *     *     *
 *
 *     send request to tomcat (blocking IO server)
 *waiting queue -  tomcat container(ThreadPool) - T1 - connection1 url1 / http method / request content / header -> Servlet1
 *                                              - T2 - connection2 url2 / ..    -> Servlet2
 *
 *     Spring MVC (old flow)
 *          DispatcherServlet("/*") -> handler mapping -> Controller (return String + model and view)
 *                 |
 *             view resolver
 *
 *
 *     Spring MVC (new flow)
 *    <->  DispatcherServlet("/*") -> handler mapping -> Controller (return Object + @ResponseBody)
 *                 |
 *         http message converter (Jackson / JaxB)
 *  ************
 *   Json
 *      {
 *          "name" : [{}, {}],
 *          "pwd"  : "xx",
 *          "stu"  : {
 *              "name" : "st_name",
 *              "age"  : 15
 *          }
 *      }
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *     session(key-value) vs cookie
 *  session_id
 *
 *      session:
 *          p1 -> server
 *  (cookie)  p1 <- session_id
 *          p1 -> request header(cookie data_(session_id)) -> server
 *
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   scaling :
 *      vertical scaling : hardware level
 *      horizontal scaling :
 *
 *                                 node1[tomcat1(university-app)]
 *   users -> load-balancer   ->   node2[tomcat2(university-app)]
 *                                 node3[tomcat3(university-app)]
 *
 *            master - slave
 *            leader - follower
 *            primary - secondary
 *
 */
