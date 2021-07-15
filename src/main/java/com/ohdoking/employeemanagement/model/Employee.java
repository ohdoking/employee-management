package com.ohdoking.employeemanagement.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document
@Getter
@Setter
public class Employee {
    @Id
    private String id;
    private String name;
    private Map<String, String> contract;
    private int age;
    private State state = State.ADDED;
    private LocalDateTime createdTime = LocalDateTime.now();
    private LocalDateTime updatedTime = LocalDateTime.now();

}
