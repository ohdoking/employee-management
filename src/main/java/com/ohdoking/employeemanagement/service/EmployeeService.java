package com.ohdoking.employeemanagement.service;

import com.ohdoking.employeemanagement.exception.EmployeeManagementException;
import com.ohdoking.employeemanagement.model.Employee;
import com.ohdoking.employeemanagement.model.State;
import com.ohdoking.employeemanagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateState(String id, String state) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            employee.setState(State.of(state));
            employee.setUpdatedTime(LocalDateTime.now());
            return employeeRepository.save(employee);
        }
        throw new EmployeeManagementException(String.format("employee_id doesn't exists, employee_id : %s.", id));
    }
}
