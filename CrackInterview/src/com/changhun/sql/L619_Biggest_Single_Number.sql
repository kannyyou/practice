/*
Table number contains many numbers in column num including duplicated ones.
Can you write a SQL query to find the biggest number, which only appears once.
+---+
|num|
+---+
| 8 |
| 8 |
| 3 |
| 3 |
| 1 |
| 4 |
| 5 |
| 6 | 
For the sample data above, your query should return the following result:
+---+
|num|
+---+
| 6 |
*/

Create table If Not Exists L619_number (num int);
GRANT ALL PRIVILEGES ON quiz.* TO 'root'@'localhost';
Truncate table L619_number;
insert into L619_number (num) values ('8');
insert into L619_number (num) values ('8');
insert into L619_number (num) values ('3');
insert into L619_number (num) values ('3');
insert into L619_number (num) values ('1');
insert into L619_number (num) values ('4');
insert into L619_number (num) values ('5');
insert into L619_number (num) values ('6');

SELECT max(s.num)

FROM (
SELECT num, count(*) as count
FROM L619_number
GROUP BY num
) s
WHERE s.count = 1;

SELECT
    MAX(num) AS num
FROM
(
	SELECT
        num
    FROM
        number
    GROUP BY num
	HAVING COUNT(num) = 1
) t;