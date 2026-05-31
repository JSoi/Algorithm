select Employee.name as `name`, Bonus.bonus as `bonus`
from Employee
         left join Bonus
                   on Employee.empId = Bonus.empId
where ifnull(Bonus, 0) <= 1000;