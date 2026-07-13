SELECT (SELECT DISTINCT salary
        FROM (SELECT salary,
                     DENSE_RANK() OVER (ORDER BY salary DESC) as rnk
              FROM Employee) AS RankedSalaries
        WHERE rnk = 2) AS SecondHighestSalary;


select(select distinct salary
       from employee
       order by salary desc
       limit 1 offset 1) as secondHighestSalary;