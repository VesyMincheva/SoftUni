create database universities_db;
use universities_db;

-- 1:
create table countries (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` varchar(40) NOT NULL UNIQUE
);

create table cities (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` varchar(40) NOT NULL UNIQUE,
population INT,
country_id INT NOT NULL,
CONSTRAINT fk_cities_countries
FOREIGN KEY (country_id)
REFERENCES countries(id)
);

create table universities(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` varchar(60) NOT NULL UNIQUE,
address varchar(80) NOT NULL UNIQUE,
tuition_fee decimal(19,2) NOT NULL,
number_of_staff INT,
city_id INT,
CONSTRAINT fk_universities_cities
FOREIGN KEY (city_id)
REFERENCES cities(id)
);

create table students(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name varchar(40) NOT NULL,
last_name varchar(40) NOT NULL,
age INT,
phone varchar(20) NOT NULL UNIQUE,
email varchar(255) NOT NULL UNIQUE,
is_graduated TINYINT(1) NOT NULL,
city_id INT,
CONSTRAINT fk_students_cities
FOREIGN KEY (city_id)
REFERENCES cities(id)
);

create table courses(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` varchar(40) NOT NULL UNIQUE,
duration_hours decimal(19,2),
start_date DATE,
teacher_name varchar(60) NOT NULL UNIQUE,
`description` text,
university_id INT,
CONSTRAINT fk_courses_universities
FOREIGN KEY (university_id)
REFERENCES universities(id)
);

create table students_courses(
grade decimal(19,2) NOT NULL,
student_id INT,
course_id INT,
CONSTRAINT fk_sc_students
FOREIGN KEY (student_id)
REFERENCES students(id),
CONSTRAINT fk_sc_courses
FOREIGN KEY (course_id)
REFERENCES courses(id)
);

-- 2:
insert into courses (`name`, `duration_hours`, `start_date`, `teacher_name`, `description`, `university_id`)
select 
concat(teacher_name, ' ', 'course'),
length(`name`)/10 as duration_hours,
adddate(start_date, INTERVAL 5 DAY) as start_date,
reverse(teacher_name),
concat('Course ', teacher_name, reverse(`description`)) as `description`,
day(start_date)
from courses
where id <= 5;

-- 3:
update universities 
set tuition_fee = tuition_fee + 300
where id >= 5 AND id <= 12;

-- 4:
delete from universities
where number_of_staff is null;

-- 5:
select 
id,	
name,	
population,	
country_id
from cities
order by population DESC;

-- 6:
select
first_name,
last_name,
age,
phone ,
email
from students
where age >= 21
order by first_name DESC, email ASC, id ASC
limit 10;

-- 7:
select
concat (first_name, ' ', last_name) as `full_name`,
substring(email, 2, 10) as `username`,
reverse(phone) as `password` 
from students as s
left join students_courses as sc on sc.student_id = s.id
where sc.student_id is null
order by `password` desc;

-- 8:
select
count(u.name) as `students_count`,
u.name as `university_name`
from universities as u
join courses as c on c.university_id = u.id
join students_courses as sc on sc.course_id = c.id
group by u.name
having `students_count` >= 8
order by `students_count` desc, `university_name` desc;

-- 9:
select
u.name as university_name,
c.name as city_name,
u.address,
(CASE
        WHEN u.tuition_fee < 800 THEN 'cheap'
        WHEN u.tuition_fee >= 800 AND u.tuition_fee < 1200 THEN 'normal'
        WHEN u.tuition_fee >= 1200 AND u.tuition_fee < 2500 THEN 'high'
        ELSE 'expensive'
    END) as price_rank,
u.tuition_fee
from universities as u
join cities as c on c.id = u.city_id
order by u.tuition_fee;

-- 10:
CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60)) 
RETURNS decimal(19, 2)
return(
	select
	avg(grade)
	from courses as c
	join students_courses as sc on c.id = sc.course_id
    join students as s on s.id = sc.student_id
    where c.name = course_name AND s.is_graduated = 1
	group by sc.course_id);
    
SELECT c.name, udf_average_alumni_grade_by_course_name('Quantum Physics') as average_alumni_grade FROM courses c 
WHERE c.name = 'Quantum Physics';

-- 11:
DELIMITER $$
CREATE PROCEDURE udp_graduate_all_students_by_year (year_started INT)
BEGIN
    	update
        students as s 
        join students_courses as sc on s.id = sc.student_id
		join courses as c on sc.course_id = c.id
        set s.is_graduated = 1
		where year(c.start_date) >= year_started;
END$$

CALL udp_graduate_all_students_by_year(2017); 