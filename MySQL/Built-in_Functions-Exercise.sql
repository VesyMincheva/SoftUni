use soft_uni;
-- 1:
SELECT first_name, last_name
FROM employees
WHERE first_name LIKE 'Sa%'
ORDER BY employee_id;

-- 2:
SELECT first_name, last_name
FROM employees
WHERE last_name LIKE '%ei%'
ORDER BY employee_id;

-- 3:
SELECT first_name
FROM employees
WHERE department_id IN (3, 10) AND year(hire_date) BETWEEN 1995 AND 2005
ORDER BY employee_id;

-- 4:
SELECT first_name, last_name
FROM employees
WHERE job_title NOT LIKE '%engineer%'
ORDER BY employee_id;

-- 5:
SELECT `name`
FROM towns
WHERE length(`name`) = 5 OR length(`name`) = 6
ORDER BY `name`;

-- 6:
SELECT town_id, `name`
FROM towns
WHERE lower(left(`name`, 1)) IN ('m', 'k', 'b', 'e')
ORDER BY `name`;

-- 7:
SELECT town_id, `name`
FROM towns
WHERE lower(left(`name`, 1)) NOT IN ('r', 'b', 'd')
ORDER BY `name`;

-- 8:
CREATE VIEW v_employees_hired_after_2000 AS
SELECT first_name, last_name 
FROM employees
WHERE year(hire_date) > 2000;

-- 9:
SELECT first_name, last_name
FROM employees
WHERE length(last_name) = 5;


use geography;

-- 10:
SELECT country_name, iso_code 
FROM countries
WHERE country_name LIKE '%a%a%a%'
ORDER BY iso_code;

use geography;

-- 11:
SELECT 
    peak_name,
    river_name,
    LOWER(CONCAT(LEFT(p.peak_name, LENGTH(p.peak_name) - 1), r.river_name)) as mix
FROM
    peaks as p,
    rivers as r
WHERE
	LEFT(r.river_name, 1) = RIGHT(p.peak_name, 1)
ORDER BY mix;


use diablo;
-- 12:
SELECT 
    `name`, DATE_FORMAT(`start`, '%Y-%m-%d') as `start`
FROM
    games
WHERE YEAR(`start`) = 2011 OR YEAR (`start`) = 2012
ORDER BY `start`, `name`
LIMIT 50;

-- 13:
SELECT 
user_name,
REGEXP_REPLACE(`email`,'.*@', '' ) as `email provider`
FROM users
ORDER BY `email provider`, user_name;

-- 14:
SELECT user_name, ip_address 
FROM users
WHERE ip_address LIKE '___.1%.%.___'
ORDER BY user_name;

-- 15:
SELECT 
`name`,
CASE
WHEN hour(`start`) BETWEEN 0 AND 11 THEN 'Morning'
WHEN hour(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
WHEN hour(`start`) BETWEEN 18 AND 24 THEN 'Evening'
END as `Part of the Day`,
CASE 
WHEN duration BETWEEN 0 AND 3 THEN 'Extra Short'
WHEN duration BETWEEN 4 AND 6 THEN 'Short'
WHEN duration BETWEEN 6 AND 10 THEN 'Long'
ELSE 'Extra Long'
END as `Duration`
FROM games;


use orders;
-- 16:
SELECT product_name,
order_date,
DATE_ADD(order_date, INTERVAL 3 DAY) as  pay_due,
DATE_ADD(order_date, INTERVAL 1 MONTH)as deliver_due
FROM orders;