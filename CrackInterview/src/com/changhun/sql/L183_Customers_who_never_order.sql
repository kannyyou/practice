/*
 *
Suppose that a website contains two tables, the Customers table and the Orders table. 
Write a SQL query to find all customers who never order anything.

Table: Customers.
+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+


Table: Orders.
+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
Using the above tables as example, return the following:

+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+

  
 */

use quiz;
Create table If Not Exists L183_customers (id int, name varchar(255));
Create table If Not Exists L183_orders (id int, customerid int);
GRANT ALL PRIVILEGES ON quiz.* TO 'root'@'localhost';
Truncate table L183_customers;
insert into L183_customers (id, name) values ('1', 'Joe');
insert into L183_customers (id, name) values ('2', 'Henry');
insert into L183_customers (id, name) values ('3', 'Sam');
insert into L183_customers (id, name) values ('4', 'Max');
Truncate table L183_orders;
insert into L183_orders (id, customerid) values ('1', 3);
insert into L183_orders (id, customerid) values ('2', 1);



SELECT name 
FROM customers as 'Customers'
WHERE customers.id NOT IN (
	SELECT customer_id
	FROM orders
);

SELECT L183_customers.name as 'Customers'
FROM L183_customers 
WHERE L183_customers.id NOT IN (
	SELECT customerid
	FROM L183_orders
);
