-- 273709
select sum(price) as `TOTAL_PRICE`
from item_info
where rarity = 'LEGEND';

-- 131115
select *
from FOOD_PRODUCT
where PRICE = (select max(price) from FOOD_PRODUCT);

-- 298515
select concat(max(length), "cm")  as `MAX_LENGTH` from fish_info;

-- 131697
SELECT max(PRICE) as `MAX_PRICE` from PRODUCT;

