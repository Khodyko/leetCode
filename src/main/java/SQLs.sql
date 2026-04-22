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



-- https://leetcode.com/problems/customers-who-never-order/submissions/1975748541/

-- Очень простая задачка:

Select c.name as Customers 
FROM Customers c 
WHERE c.id NOT in (SELECT customerId FROM Orders )



-- Я прикинул, что прошлая задачка слишком легкая. Я написал эту. Эта уже уровня хард.
-- Я по-тихоньку становлюсь хорош в оконных функциях.
-- https://leetcode.com/problems/department-top-three-salaries/


SELECT a.d as Department, a.e AS Employee, a.s AS Salary 
FROM (
    SELECT dep.name as d, emp.name as e, emp.salary as s, 
        DENSE_RANK() OVER (PARTITION BY dep.name ORDER BY emp.salary DESC) AS rnk
    FROM Employee emp
    JOIN Department dep 
    ON emp.departmentId=dep.id   
) as a
WHERE rnk<4
    FROM Employee emp
    JOIN Department dep ON dep.id=emp.departmentId
) as a
WHERE a.rnk=1;



-- Сегодняшняя порция литкода.  Оконные функции всё еще продолжаются.
-- https://leetcode.com/problems/game-play-analysis-i/


-- Write your PostgreSQL query statement below
SELECT a.player_id, a.event_date AS first_login
FROM (
    SELECT player_id, event_date, 
    DENSE_RANK() OVER (partition by player_id ORDER by event_date) rnk
    FROM Activity
) as a
where a.rnk=1



-- Достойная задачка на оконные функции.
-- https://leetcode.com/problems/game-play-analysis-iv/


SELECT ROUND(COUNT(DISTINCT a.player_id)::numeric/(SELECT COUNT(DISTINCT player_id) FROM Activity),2) AS fraction FROM
(
    SELECT player_id, device_id, event_date, 
        MIN(event_date) OVER (partition by player_id) AS first_day
        FROM Activity
) as a
WHERE event_date=(first_day  + INTERVAL '1' DAY)




-- Прошла буквально неделя и оконные функции уже совсем не кажутся сложными.
-- https://leetcode.com/problems/managers-with-at-least-5-direct-reports/


-- Write your PostgreSQL query statement below
SELECT a.name FROM (
    SELECT e.managerId, e2.name, ROW_NUMBER() OVER (partition by e.managerId) rnk
    FROM Employee e JOIN Employee e2
    ON e.managerId=e2.id
) a
WHERE rnk=5





-- сегодня ничем не примечательная простоая задачка на join
-- https://leetcode.com/problems/employee-bonus/

-- Write your PostgreSQL query statement below
SELECT name, bonus FROM Employee e
LEFT JOIN Bonus b ON 
e.empId=b.empId
WHERE
bonus IS NULL OR
bonus<1000



-- https://leetcode.com/problems/find-customer-referee

SELECT name
FROM Customer
WHERE referee_id IS NULL OR referee_id != 2;

-- или используя COALESCE (кто знает как это читается?)))

SELECT name
FROM Customer
WHERE COALESCE(referee_id,0) != 2;




-- Сегодня была достаточно интересная задача.
-- Я получил удовольствие. Однозначно лайк.

-- https://leetcode.com/problems/investments-in-2016/


-- Write your PostgreSQL query statement below
SELECT ROUND(SUM(r.tiv_2016)::numeric,2) as tiv_2016 FROM 
(
    SELECT tiv_2016, 
    COUNT(tiv_2015) over (partition by tiv_2015) as ct,
    COUNT(CONCAT(lat,',', lon)) over (partition by CONCAT(lat,',', lon)) as cll
    FROM Insurance
) as r
where ct>1 AND cll=1


-- Сегодняшняя небольшая задачка sql

-- https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/

-- Write your PostgreSQL query statement below
SELECT customer_number FROM
(
    SELECT customer_number,
    COUNT(customer_number) OVER (partition by customer_number) as c
    FROM Orders
) 
ORDER BY c desc
LIMIT 1


-- Сегодня слишком простая задача
-- https://leetcode.com/problems/big-countries/


-- Write your PostgreSQL query statement below
SELECT name, population, area FROM World
WHERE area>=3000000 OR population>=25000000




-- Задачка на HAVING
-- https://leetcode.com/problems/classes-with-at-least-5-students/


-- Write your PostgreSQL query statement below
SELECT class FROM Courses
GROUP BY class
HAVING COUNT(student)>=5





-- Вот сегодняшняя задачка по бд
-- https://leetcode.com/problems/human-traffic-of-stadium/



-- Write your PostgreSQL query statement below
SELECT id, visit_date, people FROM
(
    SELECT id, visit_date, people, 
     LAG(people,1) OVER (ORDER BY id)  AS prev1,
        LAG(people,2) OVER (ORDER BY id)  AS prev2,
        LEAD(people,1) OVER (ORDER BY id) AS next1,
        LEAD(people,2) OVER (ORDER BY id) AS next2
    FROM Stadium
) as s
WHERE   (people >= 100 AND prev1 >= 100 AND prev2 >= 100)
 OR (people >= 100 AND prev1 >= 100 AND next1 >= 100)
 OR (people >= 100 AND next1 >= 100 AND next2 >= 100)
