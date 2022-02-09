package com.example.java1il2022.week4.day17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day17RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(Day17RestApplication.class, args);
    }
}

/**
 *  Rest Api
 *      1. stateless
 *      2. http : method / status code / header / request body / response body
 *      3. xml / json
 *      4. /employee   get
 *         /employee   post
 *         /employee/{id}  get
 *         /employee/{id}  delete
 *         /employee/{id}  put
 *         /employee?firstname=xxx
 */


/**
 *  Question/story: develop api for university(student + teacher)
 *    1. ask interviewer / QA / BA / Manager
 *          can 1 student have multiple teachers ?
 *          can 1 teacher have multiple students ?
 *          are they many to many >?
 *          student table contains ? ?
 *              unique / duplicate name, email, student_id?
 *          teacher table contains ? ?
 *          retrieve all students ?
 *          retrieve stu by id?
 *          create stu ? -> include teacher info ?
 *          exception -> error message
 *    2. retrieve all students endpoint
 *       retrieve stu by id
 *       stu m - m teacher
 *    3. design tables / model
 *       stu(id(pk), name)
 *       stu_teacher(id(pk), s_id(fk), t_id(fk))
 *       teacher(id(pk), name)
 *    4. design rest api
 *        url: /students
 *        request parameter: name
 *        http method: get
 *        header : accept: json
 *        status code:
 *              200 success
 *              400 bad request
 *              500 internal server error
 *        response body:
 *              normal response
 *              {
 *                  timestamp: xx,
 *                  data: [
 *                      {
 *                          id: 1,
 *                          name: "xx"
 *                      },
 *                      {stu2..},
 *                      {stu3..}
 *                  ]
 *              }
 *              exception response
 *              {
 *                  timestamp: xx,
 *                  message: "xx"
 *              }
 *       retrieve student by id
 *          url: /students/{id}
 *          http method: get
 *          status:
 *              200 success
 *              400 bad request
 *              404 resource not found
 *              500 internal server error
 *          response body
 *              {
 *                  ..
 *                  data: {
 *                      id: xx,
 *                      "name": "xx
 *                  }
 *              }
 *       create student
 *          url: /students
 *          http method:  post
 *          status:
 *              201 created
 *          request body
 *              {
 *                  name: "xx"
 *              }
 *          response body
 *              {
 *                  id: xx
 *              }
 *    5. write interface + abstract class + class + entity
 *       OOD + //TODO
 *    6. create unit test
 *    7. write implementation
 *    8. run your test ..
 *
 *
 *
 *   homework:
 *      create rest api for previous orm project
 *      1. write Readme
 *      2. many - many
 *        endpoint to create student
 *        endpoint to create teacher
 *        endpoint to register student with teacher
 *        endpoint to update student
 *        endpoint to get students(consider pagination)
 *      3. exception handling
 *      4. log
 *  deadline before Friday Morning
 *  Thursday topic: security
 *  Friday topic: what is good rest api?
 */

