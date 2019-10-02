Select ename, sal,hiredate, next_sal from
(select ename, sal, hiredate, lead(sal) over (order by hiredate) next_sal
from emp
) x
where sal < next_sal;

# ename, sal, hiredate, next_sal
'SMITH', '800', '1980-12-17', '1600'
'WARD', '1250', '1981-02-22', '2975'
'MARTIN', '1250', '1981-09-28', '5000'
'JAMES', '950', '1981-12-03', '3000'
'MILLER', '1300', '1982-01-23', '3000'


select ename, sal, hiredate
from
(
	select ename, sal, hiredate, 
		(select min(hiredate) from emp b
		where b.hiredate > a.hiredate and b.sal > a.sal) as next_hire_more,
		(select min(hiredate) from emp b where b.hiredate > a.hiredate) as next_hire
	from emp a
) x
where next_hire_more = next_hire;
