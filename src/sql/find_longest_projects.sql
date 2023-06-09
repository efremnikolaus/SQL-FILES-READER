SELECT * FROM project WHERE DATEDIFF(MONTH, START_DATE, FINISH_DATE) = (
    SELECT MAX(DATEDIFF(MONTH, START_DATE, FINISH_DATE))
    FROM project
    );