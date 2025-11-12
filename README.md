# 🎓 Student Database Retrieval System

## 📘 Overview
This project is a **Java console-based application** developed to retrieve student details from a **MySQL database**.  
It uses **JDBC (Java Database Connectivity)** and follows the **DAO (Data Access Object) pattern** for modular and clean database access.  
The application allows users to view all students, search by ID, and filter students by course.

---

## 🧩 Features
- 🔍 Retrieve all student records from the database  
- 🆔 Find student details by **Student ID**  
- 🎓 Retrieve students enrolled in a **specific course**  
- ⚙️ Test and verify database connection  
- 📋 Display results in a formatted table layout  
- 🧱 Organized into modular Java packages (`config`, `doa`, `entity`, `main`)

---

## 🏗️ Project Structure

## 📂 Task2 Project Structure

```bash
Task2/
├── config/
│   └── DatabaseConfig.java          # Contains DB connection setup and SQL queries
│
├── dao/
│   └── StudentDao.java              # Handles all database retrieval operations
│
├── entity/
│   └── Student.java                 # Represents the Student entity (POJO)
│
├── main/
│   └── Main.java                    # Entry point with console-based menu
│
└── README.md                        # Project documentation
```


---

## 🗃️ Database Configuration

**Database Name:** `student_db`  
**Table Name:** `students`

| Column Name | Data Type | Description |
|--------------|------------|-------------|
| id | INT (Primary Key) | Unique student ID |
| name | VARCHAR(50) | Student name |
| email | VARCHAR(50) | Student email address |
| age | INT | Student age |
| course | VARCHAR(50) | Student course name |

### Example SQL to create the database:
```sql
CREATE DATABASE student_db;
USE student_db;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50),
    age INT,
    course VARCHAR(50)
);

INSERT INTO students (name, email, age, course) VALUES
('John Doe', 'john.doe@example.com', 22, 'Computer Science'),
('Jane Smith', 'jane.smith@example.com', 21, 'Electrical Engineering'),
('Bob Johnson', 'bob.johnson@example.com', 23, 'Mechanical Engineering'),
('Alice Brown', 'alice.brown@example.com', 20, 'Computer Science'),
('Charlie Wilson', 'charlie.wilson@example.com', 24, 'Data Science');

```


Student Database Retrieval System
====================================

 RETRIEVAL MENU
 1. View All Students
 2. Find Student by ID
 3. Find Students by Course
 4. Exit
 Choose an option (1-4): 1

### 📋 ALL STUDENTS  
Retrieved **5 students** from database.

| ID | Name           | Email                      | Age | Course                    |
|----|----------------|-----------------------------|-----|----------------------------|
| 1  | John Doe       | john.doe@example.com        | 22  | Computer Science           |
| 2  | Jane Smith     | jane.smith@example.com      | 21  | Electrical Engineering     |
| 3  | Bob Johnson    | bob.johnson@example.com     | 23  | Mechanical Engineering     |
| 4  | Alice Brown    | alice.brown@example.com     | 20  | Computer Science           |
| 5  | Charlie Wilson | charlie.wilson@example.com  | 24  | Data Science               |


## 🛠️ Technologies Used

☕ Java (JDK 17 or higher)

🗄️ MySQL Database

🔗 JDBC (Java Database Connectivity)

🧰 Eclipse

## 🚀 Future Enhancements

Add CRUD operations (Insert, Update, Delete)

Implement a GUI using JavaFX or Swing

Integrate Spring Boot for better scalability

Add exception logging and unit testing

## ✨ Author

Akash Shetty
📧 akash.shetty.ec@gmail.com

