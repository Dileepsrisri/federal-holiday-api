# Federal Holiday API

## Overview

Federal Holiday API is a RESTful Spring Boot application that allows users to manage federal holidays for different countries.

The application supports:
1).Adding federal holidays
2).Updating existing holidays
3).Listing all holidays
4).Fetching holidays by country
5).Uploading holidays through CSV file
6)Deleting holidays

Currently supported countries:
- USA
- CANADA

# Technology Stack

- Java 17
- Spring Boot 3.5.4
- Spring Web
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- Swagger OpenAPI
- JUnit 5
- Mockito
- JaCoCo


# Project Structure


src
 ├── main
 │    └── java
 │         └── com.cgi.federalholidayapi
 │              ├── controller
 │              ├── service
 │              ├── repository
 │              ├── entity
 │              ├── dto
 │              ├── exception
 │              └── config
 │
 └── test
      └── java
           └── com.cgi.federalholidayapi
                ├── controller
                └── service


---

# How to Run the Application

## Prerequisites

Install:

- Java 17
- Maven

Verify Java: java -version
Verify Maven: mvn -version

## Build Application
Run: mvn clean install

## Start Application
Run:mvn spring-boot:run

Application will start on: http://localhost:8080


# Database Details

The application uses H2 database for local development.

Database URL: jdbc:h2:mem:holidaydb
H2 Console: http://localhost:8080/h2-console
JDBC URL:jdbc:h2:mem:holidaydb
Username:SA
Password:


# Swagger Documentation

Swagger UI is available at: http://localhost:8080/swagger-ui/index.html


Available APIs:

| Method | Endpoint | Description |
|---|---|---|
| POST | /api/holidays | Add a holiday |
| GET | /api/holidays | Get all holidays |
| GET | /api/holidays/country/{country} | Get holidays by country |
| PUT | /api/holidays/{id} | Update holiday |
| DELETE | /api/holidays/{id} | Delete holiday |
| POST | /api/holidays/upload | Upload CSV file |


---

# API Details

## Add Holiday
Endpoint:POST /api/holidays

Sample Request:

json
{
  "country": "USA",
  "name": "Independence Day",
  "date": "2026-07-04"
}


## Get All Holidays
Endpoint: GET /api/holidays

## Get Holidays By Country
Endpoint: GET /api/holidays/country/{country}
Example: GET /api/holidays/country/USA


## Update Holiday
Endpoint: PUT /api/holidays/{id}
Example: PUT /api/holidays/1


## Delete Holiday
Endpoint: DELETE /api/holidays/{id}
Example: DELETE /api/holidays/1


## Upload Holidays Using CSV
Endpoint:POST /api/holidays/upload
Request type:multipart/form-data
Parameter:file
CSV format:
csv
country,name,date
USA,Independence Day,2026-07-04
CANADA,Canada Day,2026-07-01


# Validation Rules
- Country is mandatory.
- Holiday name is mandatory.
- Holiday date is mandatory.
- Date format should be:dd-MM-yyyy


# Exception Handling

The application implements global exception handling for:

- Holiday not found
- Invalid file upload
- Validation errors
- Invalid input data


---

# Testing
Testing framework:
- JUnit 5
- Mockito
- MockMvc

Run tests:mvn clean test


# Code Coverage

JaCoCo is configured for test coverage reporting.
Generate report:mvn jacoco:report
Coverage report location:target/site/jacoco/index.html
Current test coverage:91%

# Assumptions

- Supported countries are limited to USA and CANADA as mentioned in the requirement.
- Country values are implemented using Enum so new countries can be added easily.
- CSV upload supports the defined format only.
- CSV date format is dd-MM-yyyy.
- H2 database is used for local development and testing.
- Delete API was added to support complete CRUD operations.
- File upload validates empty files and invalid data formats.
- Swagger documentation is provided for API consumers.


---

# Future Enhancements

Possible improvements:
- Replace H2 with PostgreSQL/MySQL database.
- Add Docker support.
- Add authentication and authorization using Spring Security.
- Add pagination for holiday listing.
- Add audit logging.


---

# Author
Pasupuleti Dileep Kumar