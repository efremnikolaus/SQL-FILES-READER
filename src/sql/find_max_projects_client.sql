SELECT c.* FROM client c
                    INNER JOIN project p ON c.ID = p.CLIENT_ID
GROUP BY c.ID
HAVING COUNT(*) = (
    SELECT COUNT(*)
    FROM project
    GROUP BY CLIENT_ID
    ORDER BY COUNT(*) DESC
    LIMIT 1
    );