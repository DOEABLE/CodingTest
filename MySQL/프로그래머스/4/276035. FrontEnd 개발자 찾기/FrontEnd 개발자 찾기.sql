SELECT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS D
WHERE SKILL_CODE &(
    SELECT SUM(CODE)
    FROM SKILLCODES
    WHERE CATEGORY='Front End'
    GROUP BY CATEGORY)
ORDER BY D.ID