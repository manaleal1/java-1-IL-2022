package com.example.java1il2022.week3.day14;

/**
 *   stu one - many class
 *   stu (id(pk), name)
 *   class (id(pk), name, stu_id(fk))
 *
 *   stu many - many class
 *   stu one - many stu_class many - one class
 *   stu (id(pk))
 *   stu_class (id(pk), stu_id(fk), class_id(fk))
 *   class (id(pk))
 *
 *   why not jdbc / why orm
 *      1. object mapping
 *      2. hql / jpql
 *      3. criteria query
 *      4. connection pool
 *      5. lazy loading and eager loading
 *      6. cache 1st level session / 2nd level session factory
 *
 *
 *   hibernate -> session + session factory
 *             -> entitymanager + entitymanagerfactory
 *
 *
 */







/*
--2nd highest salary

-- select max(e1.salary)
-- from hr.employees e1
-- where e1.salary < (select max(e2.salary) from hr.employees e2)

-- select *
-- from (select e1.*, dense_rank() over (order by salary desc) as rank
-- from hr.employees e1)
-- where rank = 2

-- 2nd highest salary : 1 salary > res
-- 3rd highest salary : 2 salary > res
-- 4th highest salary : 3 salary > res
-- Nth highest salary : N - 1 salary > res

-- select e1.*
-- from hr.employees e1
-- where 3 - 1 = (select count(distinct(e2.salary)) from hr.employees e2 where e2.salary > e1.salary)


--Q: how to improve query performance
-- execution plan

Non-clustered index (B+ tree index, bitmap index)
B+Tree
                [10]
              /     \
            [2]     [10, 50]

                [10]
              /     \
         [2, 5]     [10, 50]

                 [10, 25]
              /      \      \
         [2, 5]     [10]   [25, 50]

                       [10]
                    /        \
                 [2]        [10, 25]
               /   \        /       \
            [1] <-> [2, 5]<-> [10]<-> [25, 50]
           rowid
             |
             ----------> Table



                        [10]
                    /        \
                 [2]        [10, 25]
               /   \        /       \
            [1] <-> [2, 5]<-> [10]<-> [25, 50]
           rowid  rowid
            Tom    Jerry
            28     30
            IL     IL


-- stu table(id, name, hidden column(row_id, tx_id, rollback_pointer))

table access
    1. full table scan
    2. index access path
        index unique scan
        index range scan
        index full scan
        index fast full scan
join
    1. nested loop join
        for() {
            for() {

            }
        }
    2. hash join
    3. merge join
-- explain plan for
-- select employee_id, first_name from hr.employees e;
        -- select * from table(DBMS_XPLAN.display(null))

        explain plan for
        select employee_id, d.department_name from hr.employees e join hr.departments d on e.department_id = d.department_id;
        select * from table(DBMS_XPLAN.display(null))

*/
/**
 *  1. build relation between hibernate (entitymanager) and database table
 *  2. create many to many relation in database
 *  3. use 1 - m + m - 1 in hibernate
 *  4. write jpql to select data / select data by id / join data
 *  5. write jpql to remove data
 *
 *  don't use : spring data jpa
 *              many to many annotation
 *              hibernate auto creation
 */
