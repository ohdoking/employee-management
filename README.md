# Employee management Application

Employee management Application is for managing state of user.

## Features
- Instrument-Price retrieval via REST endpoint

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
