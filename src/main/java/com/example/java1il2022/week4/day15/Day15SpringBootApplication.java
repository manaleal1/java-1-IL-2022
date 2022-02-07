package com.example.java1il2022.week4.day15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.swing.*;

@SpringBootApplication
public class Day15SpringBootApplication {

    private static Day15Interface c1;
    private static Day15Interface c2;

    @Autowired
    public Day15SpringBootApplication(@Qualifier("day15Component1") Day15Interface c1, @Qualifier("day15Component2")Day15Interface c2) {
        Day15SpringBootApplication.c1 = c1;
        Day15SpringBootApplication.c2 = c2;
    }

    public static void main(String[] args) {
        SpringApplication.run(Day15SpringBootApplication.class, args);
        System.out.println(c1);
        System.out.println(c2);
    }
}
@Repository
interface Day15Interface {}
@Repository
//@Scope("prototype")
class Day15Component1 implements Day15Interface{
}

@Repository
//@Scope("prototype")
class Day15Component2 implements Day15Interface{
}


/**
 *  Spring: IOC / AOP
 *
 *  IOC : concept : IOC container to manage bean lifecycle
 *  Dependency Injection : implementation
 *      1. application context (IOC container)
 *      2. @Autowired
 *      3. @Component / @Controller(SpringMVC - rest api) / @Repository(dao layer / repository layer) / @Service(business layer) / @Bean
 *      4. bean scope : singleton(default) / prototype / session / global session / request
 *      5. field / constructor(eager) / setter(lazy) injection
 *      6. byName / byType injection
 *
 *
 *  AOP : Aspect: @Before / @After / @Around / @AfterReturn / @AfterThrow
 *        PointCut: location
 *
 *        log start time before every method
 *        log end time after every method
 *
 * homework:
 *     option 1. try AOP class from spring boot aop framework with IOC
 *               use AspectJ => @Before / @After / @Around  + point cutting to print
 *     option 2. try to impl @Around based on my AOP implementation
 *
 * Tues:
 *     network / Spring MVC / server
 * Wed + Thur:
 *     restful api
 * Friday:
 *     security + spring security
 *
 */
