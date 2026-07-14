-- https://leetcode.com/problems/tree-node/
WITH RECURSIVE CTE AS (SELECT ID, P_ID

                       FROM TREE
                       WHERE P_ID IS NULL
                       UNION ALL
                       SELECT T.ID, T.P_ID
                       FROM TREE T,
                            CTE
                       WHERE T.P_ID = CTE.ID)
SELECT CTE.ID,
       CASE
           WHEN CTE.P_ID IS NULL THEN 'Root'
           WHEN T.ID IS NULL THEN 'Leaf'
           ELSE 'Inner'
           END AS `type`
FROM CTE
         LEFT JOIN TREE T ON T.P_ID = CTE.ID
GROUP BY CTE.ID;

-- compact version
SELECT ID,
       CASE
           WHEN P_ID IS NULL THEN 'Root'
           WHEN ID IN (SELECT DISTINCT P_ID FROM TREE WHERE P_ID IS NOT NULL) THEN 'Inner'
           ELSE 'Leaf'
           END AS TYPE
FROM TREE