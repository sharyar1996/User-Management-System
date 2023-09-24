
create database userManagement;
USE userManagement;

CREATE table users(
    id INT auto_increment  ,
    name varchar(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    
    PRIMARY KEY (id)
);

DROP TABLE users;

INSERT INTO users(id,name,email,country) 
VALUES
(1,"taha","@outlook.com","pakistan"),
(2,"sharyar","@facebook.com","pakistan"),
(3,"umer","@gmail.com","pakistan"),
(4,"irfan","@outlook.com","pakistan");

UPDATE users 
SET name="muheet",email="muheet@farigh.com",country="india"
WHERE id=4;

SELECT EXISTS (SELECT * FROM users WHERE id=5);
SELECT * FROM users;