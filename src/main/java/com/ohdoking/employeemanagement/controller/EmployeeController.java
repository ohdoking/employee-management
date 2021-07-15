package com.ohdoking.employeemanagement.controller;

import com.ohdoking.employeemanagement.model.Employee;
import com.ohdoking.employeemanagement.model.State;
import com.ohdoking.employeemanagement.model.StateRequest;
import com.ohdoking.employeemanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public @ResponseBody Employee addEmployee(@RequestBody Employee employee){
        log.info("addEmployee");
        return employeeService.addEmployee(employee);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PatchMapping("/{id}/state")
    public @ResponseBody Employee updateState(@PathVariable("id") String id, @RequestBody StateRequest stateRequest){
        log.info("updateState for employee, employee_id: %s", id);
        return employeeService.updateState(id, stateRequest.getState());
    }

}
