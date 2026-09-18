-- https://leetcode.com/problems/sales-person
select name
from SalesPerson
where sales_id not in(
    select sales_id
    from Orders
             join Company on Company.com_id = Orders.com_id
    where Company.name = 'RED'
);