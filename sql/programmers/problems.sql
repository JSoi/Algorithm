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

-- 157339
SELECT
    car.CAR_ID,
    car.CAR_TYPE,
    TRUNCATE(
            car.DAILY_FEE * 30 * (100 - IFNULL(dp.DISCOUNT_RATE, 0)) / 100,
            0) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS car
         LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS hist
                   ON hist.CAR_ID = car.CAR_ID
                       AND hist.START_DATE <= '2022-11-30'
                       AND hist.END_DATE >= '2022-11-01'
         JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS dp
              ON dp.CAR_TYPE = car.CAR_TYPE
                  AND dp.DURATION_TYPE = '30일 이상'
WHERE hist.CAR_ID IS NULL
  AND car.CAR_TYPE IN ('세단','SUV')
  AND TRUNCATE(
              car.DAILY_FEE * 30 * (100 - IFNULL(dp.DISCOUNT_RATE,0)) / 100,
              0) <= 2000000
GROUP BY car.CAR_ID
ORDER BY FEE DESC, car.CAR_ID DESC;