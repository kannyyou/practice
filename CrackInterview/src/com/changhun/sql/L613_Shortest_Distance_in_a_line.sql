/**
Table point holds the x coordinate of some points on x-axis in a plane, which are all integers.
Write a query to find the shortest distance between two points in these points.
| x   |
|-----|
| -1  |
| 0   |
| 2   |

The shortest distance is '1' obviously, which is from point '-1' to '0'. So the output is as below:
| shortest|
|---------|
| 1       |

Note: Every point is unique, which means there is no duplicates in table point.
Follow-up: What if all these points have an id and are arranged from the left most to the right most of x axis?


 */

SELECT p1.x, p2.x, ABS(p1.x - p2.x) AS distance
FROM
	point p1
JOIN
	point p2 ON p1.x != p2.x;
	
SELECT MIN(ABS(p1.x - p2.x)) AS shortest
FROM
	point p1
JOIN
	point p2 ON p1.x != p2.x;
	
SELECT MIN(P1.x - P2.x) AS shortest 
FROM point P1 
JOIN 
	point P2 ON P1.id = P2.id + 1 
WHERE P1.id > 1;
