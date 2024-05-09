-- programmers 131117
select fp.product_id as PRODUCT_ID, fp.product_name as PRODUCT_NAME, sum(fo.amount * fp.price) as TOTAL_SALES
from FOOD_ORDER fo
         join FOOD_PRODUCT fp
where fo.product_id = fp.product_id
  and date_format(fo.produce_date, '%Y-%m') = '2022-05'
group by fp.product_id
order by TOTAL_SALES desc, PRODUCT_ID;