Select 
sal, RANK() over (order by x.cnt desc) as rnk
from (
select sal, count(1) as cnt
from emp
where deptno = 20
group by sal
) x


# sal, rnk
'3000', '1'
'2975', '2'
'1100', '2'
'800', '2'


