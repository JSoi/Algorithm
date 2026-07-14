CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    set N=N-1; # set n to n-1 because offset is 0 based
    RETURN (
        select distinct salary from Employee
        order by salary desc
        LIMIT 1 OFFSET N
    );
END;

# based on dense rank
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN (
        # Write your MySQL query statement below.
        SELECT DISTINCT salary
        FROM (SELECT salary,
                     DENSE_RANK() OVER (ORDER BY salary DESC) as rnk
              FROM Employee) AS RankedSalaries
        WHERE rnk = N
    );
END