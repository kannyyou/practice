/* 
 * 
 * 
Several friends at a cinema ticket office would like to reserve consecutive available seats.
Can you help to query all the consecutive available seats order by the seat_id using the following cinema table?
| seat_id | free |
|---------|------|
| 1       | 1    |
| 2       | 0    |
| 3       | 1    |
| 4       | 1    |
| 5       | 1    |
Your query should return the following result for the sample case above.
| seat_id |
|---------|
| 3       |
| 4       |
| 5       |
Note:
The seat_id is an auto increment int, and free is bool ('1' means free, and '0' means occupied.).
Consecutive available seats are more than 2(inclusive) seats consecutively available.


 */


SELECT cur.seat_id, cur.free, prev.seat_id, prev.free 
FROM cinema cur
JOIN cinema pre;

SELECT cur.seat_id, cur.free, prev.seat_id, prev.free 
FROM cinema cur
JOIN cinema pre;
ON ABS(cur.seat_id - prev.seat_id) = 1
and a.free = 1 and b.free = 1;

SELECT DISTNCT cur.seat_id 
FROM cinema cur
JOIN cinema pre;
ON ABS(cur.seat_id - prev.seat_id) = 1
and a.free = 1 and b.free = 1
ORDER BY cur.seat_id;


SELECT C1.seat_id 
FROM cinema C1  
WHERE 
C1.free=1 
AND
(
    C1.seat_id+1 in (SELECT seat_id FROM cinema WHERE free=1) 
    OR
    C1.seat_id-1 in (SELECT seat_id FROM cinema WHERE free=1) 
) 
ORDER BY C1.seat_id;


