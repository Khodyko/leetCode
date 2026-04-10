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


-- Изи. Очень простая задачка, нужно узнать какие из работников получают зарплату больше своих менеджеров.

-- https://leetcode.com/problems/employees-earning-more-than-their-managers/

SELECT a.name Employee
                    FROM  Employee a 
                    LEFT JOIN Employee b ON a.managerId=b.id
                    WHERE a.salary>b.salary



-- Надеюсь я когда-нибудь стану мастером оконных функций, а сейчас я решаю все подряд с помощью них.
-- И вот еще одна задачка. Ее лучше решать группировкой)) Но группировками никого не удивишь)

-- https://leetcode.com/problems/duplicate-emails/

SELECT DISTINCT Email from 
    (
        SELECT Email, COUNT(Email) OVER (PARTITION BY Email) AS c
        FROM Person p
    )
    WHERE c>=2



-- https://leetcode.com/problems/department-highest-salary/

-- Простое решение:
SELECT d.name as Department, e.name as Employee, e.salary as Salary
FROM Employee e JOIN Department d ON e.departmentId=d.id
WHERE e.salary=(SELECT MAX(salary) FROM Employee WHERE departmentId = e.departmentId);

-- Ну и наши любимые оконные функции (есть ощущение, что я начинаю понимать как это работает):

SELECT
      a.d as Department,
      a.e as Employee,
      a.s as Salary
FROM (
    SELECT dep.name as d, emp.name as e, emp.salary as s,
    DENSE_RANK() OVER (PARTITION BY emp.departmentId ORDER by emp.salary DESC)
    as rnk
    FROM Employee emp
    JOIN Department dep ON dep.id=emp.departmentId
) as a
WHERE a.rnk=1;
