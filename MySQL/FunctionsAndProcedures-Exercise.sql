SET GLOBAL log_bin_trust_function_creators = 1;
SET SQL_SAFE_UPDATES = 0;

-- 1:
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000 ()
	BEGIN
    	SELECT
			first_name,
			last_name
		FROM employees
		WHERE salary > 35000
		ORDER BY first_name, last_name, employee_id;
	END $$
DELIMITER ;;

-- 2:
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above (salary_above DECIMAL(15,4))
	BEGIN
    	SELECT
			first_name,
			last_name
		FROM employees
		WHERE salary >= salary_above
		ORDER BY first_name, last_name, employee_id;
	END $$
DELIMITER ;;

-- 3:
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with (start_text VARCHAR(30))
	BEGIN
    	SELECT `name` AS town_name FROM towns
		WHERE `name` LIKE CONCAT(start_text, '%')
		ORDER BY `name`;
	END $$
DELIMITER ;;

-- 4:
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town (town_name VARCHAR(50))
	BEGIN
    	SELECT
		e.first_name,
		e.last_name
		FROM employees AS e
		JOIN addresses AS a ON e.address_id = a.address_id
		JOIN towns AS t ON t.town_id = a.town_id
		WHERE t.name = town_name
		ORDER BY e.first_name, e.last_name, e.employee_id;
	END $$
DELIMITER ;;

-- 5:
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level (salary DECIMAL(19,4))
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
		DECLARE result VARCHAR(20);
        SET result :=(
			CASE
			WHEN salary < 30000 THEN 'Low'
			WHEN salary BETWEEN 30000 AND 50000 THEN 'Average'
			WHEN salary > 50000 THEN 'High'
		END);
    	RETURN result;
END $$
DELIMITER ;;

-- 6:
-- 7:
-- 8:
-- 9:
-- 10:
-- 11:
-- 12:
-- 13:
-- 14:
-- 15: