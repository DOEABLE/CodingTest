-- 코드를 작성해주세요
with recursive tmp as (
    select id, parent_id, 1 as generation
    from ecoli_data
    where parent_id is null
    union all
    select s.id, s.parent_id, tmp.generation + 1
    from tmp join ecoli_data s
    on tmp.id = s.parent_id
)
SELECT count(*) count, generation
FROM tmp
WHERE ID NOT IN (
    SELECT DISTINCT PARENT_ID
    FROM ECOLI_DATA
    WHERE PARENT_ID != 0
)
GROUP BY generation
ORDER BY 2;