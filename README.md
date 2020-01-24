# 3Diligent_Application
Toy code used for application to 3Diligent.  

Provides a REST API to a database of students and correlated information with the following queries:
- `/api/students/{name}` - GETs a student's (by name) guardians and courses taken
- `/api/{course}/{grade}` - GETs all students who got a specific grade in a specific course
- `/api/grades/{course}` - GETs the grade distribution of a specific course  

## File Structure
```
3Diligent_Application
 |   README.md      // this file
 |   pom.xml        // dependencies and such
 |   ... 
 |---src
     |--main
        |-- java
            |--com.example.demo
               |--domain
                  |--model              // contains postgres table models 
                     |--Courses.java
                     |--Guardians.java
                     |--RelationshipsId.java
                     |-- ...
                  |--services           // business / join logic
                     |--Services.java
               |--repository            // interfaces to interact w/ db
                  |--StudentsRepo.java
                  |--GuardiansRepo.java
                  |-- ...
               |--webapi.controller     // route mappings
                  |--StudentsController.java
               |--DemoApplication.java  // Initial springboot launcher
        |-- resources
            |--application.properties
            |--schema.sql       // sql to create db
            |--import.sql       // sql to load basic data into db
            | ...
     |--test        // ought to mirror main, but unit tests aren't written yet
     |-- ...
 |
 |---target         // contains compiled .class files
     |-- ...
```

## Setup / Details
- Update `src/main/resources/application.properties` fields for your postgres setup:
    - spring.datasource.url      
    - spring.datasource.username
    - spring.datasource.password
- Runs server on `localhost:8080`, but this can also be modified in `src/main/resources/application.properties`

## TODO: 
- Unit testing
- Modify routes for GET requests to use query string parameters rather than paths
- Modify database names to be singular (eg Students -> Student)
