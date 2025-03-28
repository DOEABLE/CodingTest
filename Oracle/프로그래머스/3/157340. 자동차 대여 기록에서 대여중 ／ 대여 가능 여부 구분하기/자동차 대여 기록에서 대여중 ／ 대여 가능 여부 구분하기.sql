-- 코드를 입력하세요
SELECT CAR_ID,
    MAX(CASE WHEN '2022-10-16' BETWEEN TO_CHAR(START_DATE, 'YYYY-MM-DD') AND TO_CHAR(END_DATE, 'YYYY-MM-DD')
       THEN '대여중' ELSE '대여 가능' END
) AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY 1 DESC;