SELECT avg(sal)
from emp
where sal not in 
((select min(sal) from emp),(select max(sal) from emp));


