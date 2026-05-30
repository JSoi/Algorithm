-- https://leetcode.com/problems/managers-with-at-least-5-direct-reports
select e2.name
from Employee e1
         join Employee e2
where e1.managerId = e2.id
group by e1.managerId
having count(e1.managerId) >= 5;