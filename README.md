# Task 2: Database Connectivity using Java JDBC

## 🎯 Objective
Build a Java application that connects to a MySQL database and retrieves data using JDBC.

## 📋 Task Requirements
- Write Java code using JDBC to connect to a database
- Retrieve and display data from a table

## 🛠️ Technologies Used
- Java 17
- JDBC
- MySQL 8.0
- Maven
- MySQL Connector/J

## 📁 Project Structure
Task2-DatabaseProject-Java/
├── src/
│ └── config/DataBaseConfig.java
│ └── doa/StudentDoa.java
│ └── entity/Student.java
│ └── main/Main.java
├── pom.xml
└── README.md


## 🚀 Quick Start

### Prerequisites
- Java 17+
- MySQL 8.0+
- Maven 3.6+

### Step 1: Database Setup
```sql
CREATE DATABASE student_management;
USE student_management;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    age INT,
    course VARCHAR(100)
);

INSERT INTO students (name, email, age, course) VALUES
('John Doe', 'john.doe@example.com', 22, 'Computer Science'),
('Jane Smith', 'jane.smith@example.com', 21, 'Electrical Engineering'),
('Bob Johnson', 'bob.johnson@example.com', 23, 'Mechanical Engineering');
