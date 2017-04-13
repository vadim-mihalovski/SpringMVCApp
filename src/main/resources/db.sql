CREATE DATABASE IF NOT  EXISTS `spring_mvc_app` CHARACTER SET utf8 COLLATE utf8_general_ci;
USE spring_mvc_app;
CREATE TABLE EMPLOYEE(
    id INT NOT NULL auto_increment,
    name VARCHAR(50) NOT NULL,
    joining_date DATE NOT NULL,
    salary DOUBLE NOT NULL,
    ssn VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);