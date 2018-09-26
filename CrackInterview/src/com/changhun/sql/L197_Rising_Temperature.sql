/**

Given a Weather table, write a SQL query to find all dates' Ids with higher temperature 
compared to its previous (yesterday's) dates.

+---------+------------------+------------------+
| Id(INT) | RecordDate(DATE) | Temperature(INT) |
+---------+------------------+------------------+
|       1 |       2015-01-01 |               10 |
|       2 |       2015-01-02 |               25 |
|       3 |       2015-01-03 |               20 |
|       4 |       2015-01-04 |               30 |
+---------+------------------+------------------+
For example, return the following Ids for the above Weather table:

+----+
| Id |
+----+
|  2 |
|  4 |
+----+

 */

Create table If Not Exists L197_weather (Id int, RecordDate date, Temperature int);
GRANT ALL PRIVILEGES ON quiz.* TO 'root'@'localhost';
Truncate table L197_weather;
insert into L197_weather (Id, RecordDate, Temperature) values ('1', '2015-01-01', '10');
insert into L197_weather (Id, RecordDate, Temperature) values ('2', '2015-01-02', '25');
insert into L197_weather (Id, RecordDate, Temperature) values ('3', '2015-01-03', '20');
insert into L197_weather (Id, RecordDate, Temperature) values ('4', '2015-01-04', '30');

SELECT t.Id
FROM L197_weather t
JOIN L197_weather p
ON DATEDIFF(t.RecordDate, p.RecordDate) = 1
AND t.Temperature > p.Temperature;

SELECT t.ID 
FROM L197_weather t, L197_weather p 
WHERE t.Temperature > p.Temperature 
AND  DATEDIFF(t.RecordDate, p.RecordDate) = 1;
