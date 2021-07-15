# Employee management Application

Employee management Application is for creating and update state of employee.

## Features
- Post and patch employee via REST endpoint

## Software/Frameworks/Libs used for Employee management Application
* Java
* Spring/Spring-boot
* MongoDB
* Gradle
* Docker/Docker-Compose

## Getting started

### how to run Employee management project

#### 1. build Employee management Application

To run Quote Application, we need to build docker images.

##### 1.1. run gradle build
```
    gradle clean build
```

##### 1.2. build docker image
```
    docker build -t work_motion/employment_management .
```

#### 2. run Quote Application

When you run docker compose file, the Employee management application and rest of services which is necessary for Employee management service starts running.

##### 2.1. execute docker-compose
```
    cd local
    docker-compose up
```
## API documentation

The detail REST Endpoint description is in [swagger document](http://localhost:8080/employment-management/swagger-ui.html)
# employee-management

## Test

### how to test with rest api

#### 1. test with curl

##### create employee
```
    curl --location --request POST 'http://localhost:8080/employment-management/employee' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "name" : "dokeun",
        "age" : 30,
        "contract" : {
            "id" : "sample_id",
            "name": "contract"
        }
    }'
```

##### update employee state

```
    curl --location --request PATCH 'http://localhost:8080/employment-management/employee/60f0be2562d0ff4845480fc0/state' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "state" : "APPROVED"
    }'
```

#### 2. run unit test

This project has implemented unit test.
To run unit test, you can execute below command.
```
    gradle clean test 
```


