# HR System

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

This project is an API built using **Java, Java Spring, JPA/Hibernate, PostgresSQL as the database, and Spring Security and JWT for authentication control.**

The API was developed as part of my portfolio. It is a system for human resources management.

## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)
- [Database](#database)
- [Contributing](#contributing)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/OtavioVoltarelli/hr-system
```

2. Install dependencies with Maven

3. Install [PostgresSQL](https://www.postgresql.org/)

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080


## API Endpoints
The API provides the following endpoints:

**AUTHENTICATION**
```markdown
POST /auth/login - Login into the App
POST /auth/register - Register a new user into the App (ADMIN access required)
```
**API DEPARTMENTS**
```markdown
POST /departments - Register a new department.
GET /departments - Retrieve a list of all departments.
GET /departments/{id} - Retrieve the department by its id.
PUT /departments/{id} - Change the department by its id.
PUT /departments/disable/{id} - Disable the department by its id.
DELETE /departments/{id} - Delete the department by its id. (ADMIN access required)
```
**BODY**
```json
{
  "name:": " "
}
```
**API EMPLOYEES**
```markdown
POST /employees - Register a new employee.
GET /employees - Retrieve a list of all employees.
GET /employees/{id} - Retrieve the employee by its id.
PUT /employees/{id} - Change the employee by its id.
PUT /employees/disable/{id} - Disable the employee by its id.
DELETE /employees/{id} - Delete the employee by its id. (ADMIN access required)
```
**BODY**
```json
{
  "name": " ",
  "cpf": " ",
  "contactNumber": " ",
  "birthDate": "yyyy-MM-dd",
  "departmentId": 1
}
```
**API EMPLOYEE CONTRACTS**
```markdown
POST /employeeContracts - Register a new contract.
GET /employeeContracts - Retrieve a list of all contracts.
GET /employeeContracts/{id} - Retrieve the contract by its id.
PUT /employeeContracts/{id} - Change the contract by its id.
PUT /employeeContracts/disable/{id} - Disable the contract by its id.
DELETE /employeeContracts/{id} - Delete the contract by its id. (ADMIN access required)
```
**BODY**
```json
{
  "position": " ",
  "salary": 1000,
  "hireDate": "yyyy-MM-dd",
  "employeeId": 1
}
```
**API ABSENCES**
```markdown
POST /absences - Register a new absence.
GET /absences - Retrieve a list of all absences.
GET /absences/{id} - Retrieve the absence by its id.
PUT /absences/{id} - Change the absence by its id.
PUT /absences/disable/{id} - Disable the absence by its id.
DELETE /absences/{id} - Delete the absence by its id. (ADMIN access required)
```


## Authentication
The API uses Spring Security for authentication control. The following roles are available:
```
USER -> Standard user role for logged-in users.
ADMIN -> Admin role for managing partners (registering new partners).
```
To access protected endpoints as an ADMIN user, provide the appropriate authentication credentials in the request header.

## Database
The project utilizes [PostgresSQL](https://www.postgresql.org/) as the database.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.

When contributing to this project, please follow the existing code style, [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), and submit your changes in a separate branch.



