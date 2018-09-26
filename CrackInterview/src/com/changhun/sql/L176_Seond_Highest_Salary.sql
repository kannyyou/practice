/*
 * 
Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the query should return 200 as the second highest salary. 
If there is no second highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+

 */

Create table If Not Exists L176_Employee (Id int, Salary int);
GRANT ALL PRIVILEGES ON quiz.* TO 'root'@'localhost';
Truncate table L176_Employee;
insert into L176_Employee (Id, Salary) values ('1', '100');
insert into L176_Employee (Id, Salary) values ('2', '200');
insert into L176_Employee (Id, Salary) values ('3', '300');

SELECT
    (SELECT DISTINCT
            Salary
        FROM
            L176_Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary
;

WITH rank_salary AS (
SELECT 
    salary,
    RANK()  OVER (
    ORDER BY salary
    ) as my_rank
FROM L176_Employee
)
SELECT *
FROM rank_salary
WHERE my_rank = 2;