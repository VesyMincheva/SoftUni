create database minions;
use minions;

-- 1:
CREATE TABLE minions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    age INT
);

CREATE TABLE towns (
    town_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

-- 2:
alter table minions
add column town_id int;

alter table minions
add constraint fk_minions_towns
foreign key minions(town_id)
references towns(id);

-- 3: 
insert into towns (`id`, `name`) 
values (1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');

insert into minions (`id`, `name`, `age`, `town_id`)
values (1, 'Kevin', 22, 1),
(2, 'Bob', 15, 3),
(3, 'Steward', null, 2);

-- 4:
truncate table minions;

-- 5:
drop table minions;
drop table towns;


-- 6:
CREATE TABLE people (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL,
    picture BLOB,
    height DOUBLE(5 , 2 ),
    weight DOUBLE(5 , 2 ),
    gender VARCHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

insert into people (id, `name`, height, weight, gender, birthdate)
values (1, 'Atanaska', 1.67, 67, 'f', '1968-04-28'),
(2, 'Ventsi', 1.80, 90, 'm', '1966-01-19'),
(3, 'Irina', 1.67, 67, 'f', '2001-08-01'),
(4, 'Katerina', 1.60, 65, 'f', '1990-11-24'),
(5, 'Runi', 0.5, 25, 'm', '2015-03-18');

-- 7: 
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    `password` VARCHAR(26) NOT NULL,
    profile_picture BLOB,
    last_login_time DATE,
    is_deleted BOOLEAN
);

INSERT INTO users (username, `password`, is_deleted)
VALUES ('kasei', '123456', true),
('rooney', '123456', false),
('taivo', '11111', true),
('katu6ka', '09876', true),
('maison', '345344', true);

-- 8:
ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY users (id, username);

-- 9:
alter table users
change column last_login_time 
last_login_time  datetime default now();

-- 10:
alter table users
drop primary key,
add constraint pk_users
primary key users(id),
change column username
username varchar (25) unique;

-- 11:

create database movies;
use movies;
CREATE TABLE directors (
    id INT PRIMARY KEY,
    director_name VARCHAR(50) NOT NULL,
    notes TEXT
);

insert into directors (id, director_name)
values (1, 'Spielberg'),
(2, 'Cameron'),
(3, 'Allen'),
(4, 'Coppola'),
(5, 'Tarantino');

CREATE TABLE genres (
    id INT PRIMARY KEY,
    genre_name VARCHAR(20) NOT NULL,
    notes TEXT
);

insert into genres (id, genre_name)
values (1, 'Drama'),
(2, 'Comedy'),
(3, 'Triller'),
(4, 'Dramedy'),
(5, 'Sci-fi');

CREATE TABLE categories (
    id INT PRIMARY KEY,
    category_name VARCHAR(20) NOT NULL,
    notes TEXT
);

insert into categories (id, category_name)
values (1, 'First'),
(2, 'Second'),
(3, 'Third'),
(4, 'Forth'),
(5, 'Fifth');

CREATE TABLE movies (
    id INT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    director_id INT NOT NULL,
    copyright_year YEAR,
    length DOUBLE (10, 2),
    genre_id INT NOT NULL,
    category_id INT NOT NULL,
    rating DOUBLE(5 , 2 ),
    notes TEXT
);

insert into movies (id, title, director_id, genre_id, category_id)
values (1, 'Inglourious Basterds', 5, 4, 5),
(2, 'Titanic', 2, 1, 1),
(3, 'Vicky Cristina Barcelona', 3, 2, 4),
(4, 'The Godfather', 4, 3, 1),
(5, 'Catch Me If You Can', 1, 1, 2);

-- 12:
create database car_rental;
use car_rental;

create table categories (
id int primary key auto_increment, 
category varchar(30) not null, 
daily_rate double (5, 2), 
weekly_rate double (5, 2), 
monthly_rate double (5, 2), 
weekend_rate double (5, 2)
);

insert into categories (category)
values ('sport'),
('family'),
('luxury');

create table cars (
id int primary key, 
plate_number int not null, 
make varchar (30), 
model varchar (30), 
car_year year, 
category_id int not null, 
doors int, 
picture blob, 
car_condition varchar (50), 
available boolean
);

insert into cars (id, plate_number, category_id)
values (1, 1234, 3),
(2, 6666, 2),
(3, 7654, 1);

create table employees (
id int primary key, 
first_name varchar(30) not null, 
last_name varchar(30) not null, 
title varchar(30), 
notes text
);

insert into employees (id, first_name, last_name)
values (1, 'Petar', 'Petrov'),
(2, 'Georgi', 'Georgiev'),
(3, 'Dimitar', 'Dinitrov');

create table customers(
id int primary key, 
driver_licence_number int not null, 
full_name varchar (50) not null, 
address varchar (50), 
city varchar (20), 
zip_code varchar (20), 
notes text
);

insert into customers (id, driver_licence_number, full_name)
values (1, 123456789, 'Petar Petrov'),
(2, 987654321, 'Georgi Georgiev'),
(3, 999999999, 'Dimitar Dimitrov');

create table rental_orders(
id int primary key, 
employee_id int not null, 
customer_id int not null, 
car_id int not null, 
car_condition varchar (50), 
tank_level double (12, 2), 
kilometrage_start double (12, 2), 
kilometrage_end double (12, 2), 
total_kilometrage double (12, 2), 
start_date date, 
end_date date, 
total_days int, 
rate_applied double (5, 2), 
tax_rate double (5, 2), 
order_status varchar (20), 
notes text
);

insert into rental_orders (id, employee_id, customer_id, car_id)
values (1, 1, 1, 1),
(2, 2, 2, 2),
(3, 3, 3, 3);

-- 13:
create database soft_uni;
use soft_uni;
drop table towns;

create table towns (
id int primary key auto_increment,
`name` varchar(20) not null
);

create table addresses (
id int primary key auto_increment,
address_text varchar(20),
town_id int not null
);

create table departments (
id int primary key auto_increment,
`name` varchar(20) not null
);
drop table employees;

create table employees (
id int primary key auto_increment, 
first_name varchar (30) not null, 
middle_name varchar (30) not null, 
last_name varchar (30) not null, 
job_title varchar (30) not null, 
department_id int not null, 
hire_date date not null, 
salary double (10, 2) not null, 
address_id int,
CONSTRAINT fk_employees_departments 
    FOREIGN KEY `employees`(`department_id`) 
    REFERENCES `departments`(`id`),
    CONSTRAINT fk_employees_addresses 
    FOREIGN KEY `employees`(`address_id`)
    REFERENCES `addresses`(`id`)
);

insert into towns (`name`)
values ('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

insert into departments (`name`)
values ('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

insert into employees (`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`,`salary`)
VALUES
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);

-- 14:
SELECT * FROM towns;
SELECT * FROM departments;
SELECT * FROM employees;

-- 15:
SELECT * FROM towns	
ORDER BY `name`;
SELECT * FROM departments
ORDER BY `name`;
SELECT * FROM employees
ORDER BY salary DESC;

-- 16:
SELECT `name` FROM towns	
ORDER BY `name`;
SELECT `name` FROM departments
ORDER BY `name`;
SELECT first_name, last_name, job_title, salary
FROM employees
ORDER BY salary DESC;

-- 17:
update employees
set salary = salary * 1.1;
select salary from employees;






