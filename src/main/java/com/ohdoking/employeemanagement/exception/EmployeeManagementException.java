package com.ohdoking.employeemanagement.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeManagementException extends RuntimeException{
    public EmployeeManagementException(String message){
        log.error(message);
    }
}