-- https://leetcode.com/problems/classes-with-at-least-5-students
select class
from Courses
group by class
having count(*) >= 5;