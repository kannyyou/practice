/**
Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Note: All emails are in lowercase.

GRANT ALL PRIVILEGES ON database_name.* TO 'username'@'localhost';
*/


use quiz;
drop table if exists L182_person;
create table L182_person (
   id int(10),
   email varchar(255),
   PRIMARY KEY ( id )
);
GRANT ALL PRIVILEGES ON quiz.* TO 'root'@'localhost';

SELECT email FROM
(
  SELECT email, count(email) AS num
  FROM person
  GROUP BY email
) AS stat
WHERE stat.num > 1;

SELECT email
FROM person
GROUP BY email
HAVING count(email) > 1;
