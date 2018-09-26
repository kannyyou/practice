/*
There is a table courses with columns: student and class

Please list out all classes which have more than or equal to 5 students.

For example, the table:

+---------+------------+
| student | class      |
+---------+------------+
| A       | Math       |
| B       | English    |
| C       | Math       |
| D       | Biology    |
| E       | Math       |
| F       | Computer   |
| G       | Math       |
| H       | Math       |
| I       | Math       |
+---------+------------+
Should output:

+---------+
| class   |
+---------+
| Math    |
+---------+
 */

Create table If Not Exists L596_courses (student varchar(255), class varchar(255));
GRANT ALL PRIVILEGES ON quiz.* TO 'root'@'localhost';
Truncate table L596_courses;
insert into L596_courses (student, class) values ('A', 'Math');
insert into L596_courses (student, class) values ('B', 'English');
insert into L596_courses (student, class) values ('C', 'Math');
insert into L596_courses (student, class) values ('D', 'Biology');
insert into L596_courses (student, class) values ('E', 'Math');
insert into L596_courses (student, class) values ('F', 'Computer');
insert into L596_courses (student, class) values ('G', 'Math');
insert into L596_courses (student, class) values ('H', 'Math');
insert into L596_courses (student, class) values ('I', 'Math');

SELECT class
FROM
(
	SELECT class, count(student)
	FROM L596_courses
	GROUP BY class
	HAVING count(distinct student) > 5
) t;

SELECT
    class
FROM
    (SELECT
        class, COUNT(DISTINCT student) AS num
    FROM
		L596_courses
    GROUP BY class) AS temp_table
WHERE
    num >= 5
;