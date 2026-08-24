# https://leetcode.com/problems/trips-and-users
SELECT T.REQUEST_AT AS `Day`,
       ROUND(
               SUM(STATUS != 'completed') / COUNT(*),
               2
       )            AS `Cancellation Rate`
FROM TRIPS T
         JOIN USERS C
              ON T.CLIENT_ID = C.USERS_ID AND C.BANNED = 'No'
         JOIN USERS D
              ON T.DRIVER_ID = D.USERS_ID AND D.BANNED = 'No'
WHERE T.REQUEST_AT BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY T.REQUEST_AT;