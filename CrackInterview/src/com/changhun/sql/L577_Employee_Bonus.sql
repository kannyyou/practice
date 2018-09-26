/*
Select all employee's name and bonus whose bonus is < 1000.

Table:Employee

+-------+--------+-----------+--------+
| empId |  name  | supervisor| salary |
+-------+--------+-----------+--------+
|   1   | John   |  3        | 1000   |
|   2   | Dan    |  3        | 2000   |
|   3   | Brad   |  null     | 4000   |
|   4   | Thomas |  3        | 4000   |
+-------+--------+-----------+--------+
empId is the primary key column for this table.
Table: Bonus

+-------+-------+
| empId | bonus |
+-------+-------+
| 2     | 500   |
| 4     | 2000  |
+-------+-------+
empId is the primary key column for this table.
Example ouput:

+-------+-------+
| name  | bonus |
+-------+-------+
| John  | null  |
| Dan   | 500   |
| Brad  | null  |
+-------+-------+

  
 */
 
use quiz;
drop table if exists L577_employee;
create table L577_employee (
   emp_id int(10),
   name varchar(255),
   supervisor int(10),
   salary int(10),
   PRIMARY KEY ( emp_id )
);

drop table if exists L577_bonus;
create table L577_bonus (
   emp_id int(10),
   bonus int(10),
   PRIMARY KEY ( emp_id )
);


SELECT e.name, b.bonus
FROM employee e
LEFT JOIN bonus b
ON e.emp_id = b.emp_id
WHERE b.bonus < 1000 OR b.bonus IS NULL;

SELECT e.name, b.bonus
FROM employee e
LEFT JOIN bonus b
ON e.empId = b.empId
WHERE ifnull(b.bonus, 0) < 1000;

/**
 */
SELECT
    e.name, b.bonus
FROM
    L577_Employee e
        LEFT JOIN
    L577_Bonus b ON e.emp_id = b.emp_id
;