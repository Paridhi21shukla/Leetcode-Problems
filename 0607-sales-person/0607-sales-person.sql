# Write your MySQL query statement below
select sp.name
from salesperson sp
where not exists (
    select 1 
    from orders o
    join company c
    on o.com_id=c.com_id
 where o.sales_id=sp.sales_id
 and c.name='red'
);