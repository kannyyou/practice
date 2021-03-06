SELECT deptno, sal, sum(sal) over() as total,
sum(sal) over (partition by deptno) dept_total
from emp
order by 1,2

# deptno, sal, total, dept_total
'10', '1300', '29025', '8750'
'10', '2450', '29025', '8750'
'10', '5000', '29025', '8750'
'20', '800', '29025', '10875'
'20', '1100', '29025', '10875'
'20', '2975', '29025', '10875'
'20', '3000', '29025', '10875'
'20', '3000', '29025', '10875'
'30', '950', '29025', '9400'
'30', '1250', '29025', '9400'
'30', '1250', '29025', '9400'
'30', '1500', '29025', '9400'
'30', '1600', '29025', '9400'
'30', '2850', '29025', '9400'
