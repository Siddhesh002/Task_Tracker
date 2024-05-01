# Team Tasks Tracker Application

An application for managing tasks across multiple teams, this application has 3 types of accounts:

1. Employee

Can view assigned `tasks` by their `Manager`, could request `task completion` and modify `latest note` of the assigned tasks

2. Manager

Responsible for `creating/modifying and assigning tasks` to their respective Employees, Could `accept` or `reject` task completion request created by the Employee

3. Admin

Has Administrative privileges, could `CRUD` users accounts and modify their `roles`

# Technologies

1. Frontend - Thymeleaf, Bootstrap
2. Backend - Spring (Spring Boot, Spring Security, Spring Web MVC, Spring Data JPA), Hibernate
3. Database - MySQL
4. Deployment - Docker

## Features

1. Admin could create multiple users 
2. Managers could create and assign tasks to their respective employees
3. Each Manager has its seperated view of employees and their assigned tasks
4. Employees could request completion of their tasks

## Local Setup

1. Clone this repository
```
git clone
```
2. cd to project folder
```
cd tracker
```
3. Make sure you have docker installed and running
```
docker --version
```
4. Build and run the application
```
docker-compose up --build
```
4. Application will be available on following url
```
http://localhost:8080
```
5. You could log in to any default accounts
``` 
Username: employee1, employee2, manager or admin
Password: test123
```

## Enjoy!


