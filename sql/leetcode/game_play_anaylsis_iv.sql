SELECT ROUND(
               COUNT(DISTINCT ACTIVITY.PLAYER_ID) /
               (SELECT COUNT(DISTINCT AC.PLAYER_ID) FROM ACTIVITY AC),
               2
       ) AS `fraction`
FROM ACTIVITY
WHERE ACTIVITY.PLAYER_ID IN (SELECT A1.PLAYER_ID
                             FROM ACTIVITY A1
                                      JOIN (SELECT PLAYER_ID, MIN(EVENT_DATE) FIRST_DATE
                                            FROM ACTIVITY A2
                                            GROUP BY A2.PLAYER_ID) A2 ON A1.PLAYER_ID = A2.PLAYER_ID
                             WHERE A2.FIRST_DATE = DATE_SUB(A1.EVENT_DATE, INTERVAL 1 DAY));