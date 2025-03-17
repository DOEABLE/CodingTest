-- 코드를 작성해주세요
SELECT ROUND(AVG(IFNULL(LENGTH,10)),2)AS AVERAGE_LENGTH
FROM FISH_INFO
;

             -- IFNULL(COLUMN명, 나타낼조건)
             -- 평균 AVG(나타낼 COLUMN)
             -- ROUND(COLUMN, 나타낼 자릿수)
             
             