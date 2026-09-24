# Student Management System – Spring MVC (CRUD Application)

This is a Student Management System built using Java, Spring MVC, Hibernate/JPA, and Thymeleaf.  
The application performs full CRUD operations such as adding, viewing, updating, and deleting student records.

## Features
- Add new student details
- View list of all students
- Update existing student information
- Delete student records
- Uses MVC architecture
- Responsive UI using Bootstrap
- Database integration using Hibernate/JPA

## Tech Stack
Backend: Java, Spring MVC, Spring Core  
Frontend: HTML, CSS, Bootstrap, Thymeleaf  
Database: MySQL / PostgreSQL  
ORM: Hibernate / JPA  
Build Tool: Maven  
IDE: VS Code / STS / IntelliJ  /Eclipse Enterprise Editon

## Project Structure
Student_Management_System  
 ├── src/main/java  
 │   ├── controller/  
 │   ├── service/  
 │   ├── repository/  
 │   └── model/  
 ├── src/main/resources  
 │   └── application.properties  
 ├── src/main/webapp  
 │   └── WEB-INF/views/  
 ├── pom.xml  
 └── README.md  

## How to Run the Project

1. Clone the repository:
   git clone https://github.com/your-username/Student_Management_System.git

2. Configure the database in application.properties:
   spring.datasource.url=jdbc:postgresql://localhost:3306/studentdb  
   spring.datasource.username=postgres 
   spring.datasource.password=root  
   spring.jpa.hibernate.ddl-auto=update  
   spring.jpa.show-sql=true  

3. Run the project in VS Code, STS, or IntelliJ using your Tomcat server.

4. Open the application in a web browser:
   http://localhost:8080/students

## Purpose of the Project
This project demonstrates:
- Spring MVC Architecture
- CRUD operations
- Controller, Service, Repository layers
- Form handling with Thymeleaf
- Database operations using Hibernate/JPA
- Full-stack Java development

## Future Enhancements
- User authentication (Spring Security)
- Pagination and sorting
- Search functionality
- Improved UI design
- Additional student fields

## Author
Shubham Kapare
