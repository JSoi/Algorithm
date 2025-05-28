-- binary-search-tree-1
SELECT N,
       CASE WHEN P IS NULL THEN 'Root' WHEN N IN (SELECT DISTINCT P FROM bst) THEN 'Inner' ELSE 'Leaf' END AS NodeType
FROM bst
ORDER BY N;