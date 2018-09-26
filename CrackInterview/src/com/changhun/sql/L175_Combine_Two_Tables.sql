/*
 * Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId is the primary key column for this table.
Table: Address

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId is the primary key column for this table.
 

Write a SQL query for a report that provides the following information for each person in the Person table, 
regardless if there is an address for each of those people:

FirstName, LastName, City, State


 */


INSERT INTO new person_address  
SELECT p.first_name, p.last_name, a.city, a.state
FROM person p
LEFT JOIN address a
ON p.person_id = a.person_id;

