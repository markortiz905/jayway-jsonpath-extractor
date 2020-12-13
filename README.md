# Mongo DB API
Develop a API to manage customers using MongoDB

## Technology Stack
- Spring Boot 
- Gradle
- MongoDB
- Java 8
- Log4j2

## Compatible IDE
- Netbeans
    - Install Gradle Plugin for Netbeans.
- Intellij
- Eclipse

## Package Anatomy

### com.system.customer.controllers.*
Use this to integrate with your front-end, 
these controllers use spring-web to expose endpoints to clients.

### com.system.customer.entities.*
In this package you will see Business Entities like Product and Brand. 
These entities are mapped directly into mondodb using spring-data-mongodb.

### com.system.customer.repositories.*
In this package you will see classes that talks to database, 
they handle low level orchestration of communication to database.

### com.system.customer.services.*
In this package you will see classes that deals with business flows, 
this is the place to orchestrate business flows. This classes
talks to its corresponding repository to fetch data from db. 

## Project Configuration
You may check on application.properties file for the default application config.
You may add environment specific config if needed e.g. application-prod.properties

## MongoDB Configuration
You can use Compass to inspect changes in the mongodb
 - URI: mongodb+srv://<user>>:<pass>@cluster0.dd8bu.mongodb.net/kbdev?retryWrites=true&w=majority
 - Request system owner for user and pass
 
## In case app did not stop force it
 - sudo lsof -i :8080
 - kill -9 PID

## Sample Requests

 - New Customer POST http://localhost:8080/api/customer/create/firstName/Rechel%20Girl/lastName/Ortiz/dob/2019-06-22%2000:00:00/email/ortizmark905@gmail.com/gender/Female/address/One%20Oasis%20Condominium/city/Pasig%20City
 - Find Customer by firstName GET http://localhost:8080/api/customer/search/firstName/Mark

## Authors
- Mark Anthony Ortiz - ortizmark905@gmail.com
