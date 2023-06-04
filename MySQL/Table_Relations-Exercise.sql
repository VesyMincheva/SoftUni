CREATE DATABASE test;
USE test;

-- 1:
CREATE TABLE people (
person_id INT UNIQUE AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
salary DECIMAL(19,2),
passport_id INT UNIQUE NOT NULL
);

CREATE TABLE passports (
passport_id INT PRIMARY KEY,
passport_number VARCHAR (12) NOT NULL UNIQUE
);

ALTER TABLE people
ADD CONSTRAINT pk_people
PRIMARY KEY (person_id);

ALTER TABLE people
ADD CONSTRAINT fk_people_passports
FOREIGN KEY (passport_id)
REFERENCES passports (passport_id);

INSERT INTO passports (passport_id, passport_number)
VALUES (101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');

INSERT INTO people (first_name, salary, passport_id)
VALUES ('Roberto', 43300.00, 102),
('Tom', 56100.00, 103),
('Yana', 60200.00, 101);

-- 2:
CREATE TABLE manufacturers(
manufacturer_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
established_on DATE
);

CREATE TABLE models(
model_id INT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL,
manufacturer_id INT NOT NULL
);

ALTER TABLE models
ADD CONSTRAINT fk_models_manufacturers
FOREIGN KEY (manufacturer_id)
REFERENCES manufacturers(manufacturer_id);

INSERT INTO manufacturers (`name`, established_on)
VALUES ('BMW', '1916-03-01'),
('Tesla', '2003-01-01'),
('Lada', '1966-05-01');

INSERT INTO models (model_id, `name`, manufacturer_id)
VALUES (101, 'X1', 1),
(102, 'i6', 1),
(103, 'Model S', 2),
(104, 'Model X', 2),
(105, 'Model 3', 2),
(106, 'Nova', 3);

-- 3:
CREATE TABLE students(
student_id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (50) NOT NULL
);

CREATE TABLE exams(
exam_id INT PRIMARY KEY,
`name` VARCHAR(50)
);


CREATE TABLE students_exams(
student_id INT NOT NULL,
exam_id INT NOT NULL
);

ALTER TABLE students_exams
ADD CONSTRAINT pk_studets_exams
PRIMARY KEY (student_id, exam_id);

ALTER TABLE students_exams
ADD CONSTRAINT fk_students_exams_students
FOREIGN KEY (student_id)
REFERENCES students(student_id),
ADD CONSTRAINT fk_students_exams_exams
FOREIGN KEY (exam_id)
REFERENCES exams(exam_id);

INSERT INTO students (`name`)
VALUES ('Mila'),
('Toni'),
('Ron');

INSERT INTO exams (exam_id, `name`)
VALUES (101, 'Spring MVC'),
(102, 'Neo4j'),
(103, 'Oracle 11g');

INSERT INTO students_exams (student_id, exam_id)
VALUES (1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);

-- 4:
CREATE TABLE teachers (
	teacher_id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    manager_id INT UNSIGNED DEFAULT NULL
);

ALTER TABLE teachers AUTO_INCREMENT = 101;

INSERT INTO teachers (`name`, manager_id)
VALUES ('John', null),
('Maya', 106),
('Silvia', 106),
('Ted', 105),
('Mark', 101),
('Greta', 101);

ALTER TABLE teachers
ADD CONSTRAINT pk_teachers 
	PRIMARY KEY (teacher_id),
ADD CONSTRAINT fk_teacher_manager_id
	FOREIGN KEY (manager_id)
	REFERENCES teachers(teacher_id);

-- 5:
CREATE DATABASE online_store;
USE online_store;

CREATE TABLE item_types(
item_type_id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE cities(
city_id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE customers (
customer_id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
birthday DATE,
city_id INT(11),
CONSTRAINT fk_customers_cities
FOREIGN KEY (city_id)
REFERENCES cities(city_id)
);

CREATE TABLE orders(
order_id INT(11) PRIMARY KEY AUTO_INCREMENT,
customer_id INT(11),
CONSTRAINT fk_orders_customers
FOREIGN KEY (customer_id)
REFERENCES customers(customer_id)
);

CREATE TABLE items(
item_id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
item_type_id INT(11),
CONSTRAINT fk_items_item_types
FOREIGN KEY (item_type_id)
REFERENCES item_types(item_type_id)
);

CREATE TABLE order_items(
order_id INT(11),
item_id INT(11),
CONSTRAINT pk_order_items
PRIMARY KEY (order_id, item_id),
CONSTRAINT fk_order_items_orders
FOREIGN KEY (order_id)
REFERENCES orders(order_id),
CONSTRAINT fk_oreder_items_items
FOREIGN KEY (item_id)
REFERENCES items(item_id)
);

-- 6:
CREATE DATABASE university;
USE university;

CREATE TABLE subjects(
subject_id INT(11) PRIMARY KEY AUTO_INCREMENT,
subject_name VARCHAR(50)
);

CREATE TABLE majors(
major_id INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);

CREATE TABLE students (
student_id INT(11) PRIMARY KEY AUTO_INCREMENT,
student_number VARCHAR(12),
student_name VARCHAR(50),
major_id INT(11),
CONSTRAINT fk_students_majors
FOREIGN KEY (major_id)
REFERENCES majors(major_id)
);

CREATE TABLE payments (
payment_id INT(11) PRIMARY KEY AUTO_INCREMENT,
payment_date DATE,
payment_amount DECIMAL(8,2),
student_id INT(11),
CONSTRAINT fk_payments_students
FOREIGN KEY (student_id)
REFERENCES students(student_id)
);

CREATE TABLE agenda (
student_id INT(11) NOT NULL,
subject_id INT(11) NOT NULL,
CONSTRAINT pk_agenda
PRIMARY KEY (student_id, subject_id),
CONSTRAINT fk_agenda_students
FOREIGN KEY (student_id)
REFERENCES students(student_id),
CONSTRAINT fk_agenda_subjects
FOREIGN KEY (subject_id)
REFERENCES subjects(subject_id)
);

-- 9:
USE geography;

SELECT mountain_range,
peak_name,
elevation AS `peak_elevation`
FROM mountains AS m
 JOIN peaks AS p ON m.id = p.mountain_id
WHERE mountain_range = 'Rila'
ORDER BY `peak_elevation` DESC;