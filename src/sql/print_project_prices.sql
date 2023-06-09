SELECT p.ID AS PROJECT_ID, p.NAME AS PROJECT_NAME,
       SUM(w.SALARY * DATEDIFF(MONTH, p.START_DATE, p.FINISH_DATE)) AS PROJECT_COST FROM project p
                                                                                             INNER JOIN project_worker pw ON p.ID = pw.PROJECT_ID
                                                                                             INNER JOIN worker w ON pw.WORKER_ID = w.ID
GROUP BY p.ID, p.NAME
ORDER BY PROJECT_COST DESC;