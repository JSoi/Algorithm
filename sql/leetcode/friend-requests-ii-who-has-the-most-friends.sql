-- https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends
SELECT ID AS `id`, COUNT(*) AS `num`
FROM ((SELECT REQUESTER_ID AS ID
       FROM REQUESTACCEPTED)
      UNION ALL
      (SELECT ACCEPTER_ID AS ID
       FROM REQUESTACCEPTED)) AS T
GROUP BY ID
ORDER BY COUNT(*) DESC
LIMIT 1;
;