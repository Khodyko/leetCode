--https://leetcode.com/problems/rank-scores/
SELECT s.score,
           DENSE_RANK() OVER (ORDER BY s.score DESC) AS rank
    FROM Scores s;

-- Продолжаю постигать оконные функции
-- LAG позволяет увидеть прошлые значения,
-- LEAD позволяет увидеть значения впереди
-- https://leetcode.com/problems/consecutive-numbers/


SELECT DISTINCT num AS ConsecutiveNums
FROM (
    SELECT
        num,
        LAG(num, 1) OVER (ORDER BY id) AS prev_num,
        LEAD(num, 1) OVER (ORDER BY id) AS next_num
    FROM logs
) sub
WHERE num = prev_num AND num = next_num;
