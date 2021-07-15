package com.ohdoking.employeemanagement.service;

import com.ohdoking.employeemanagement.controller.EmployeeController;
import com.ohdoking.employeemanagement.exception.EmployeeManagementException;
import com.ohdoking.employeemanagement.model.Employee;
import com.ohdoking.employeemanagement.model.State;
import com.ohdoking.employeemanagement.model.StateRequest;
import com.ohdoking.employeemanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@DisplayName("UT. EmployeeServiceTest.")
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService target;

    @Mock
    private EmployeeRepository employeeRepository;

    @DisplayName("GIVEN Employee type argument, WHEN execute addEmployee, THEN call save method")
    @Test
    void givenEmployeeTypeArgumentWhenExecuteAddEmployeeThenCallSaveMethod() {
        //given
        Employee employee = new Employee();

        given(employeeRepository.save(any(Employee.class))).willReturn(employee);

        //when
        target.addEmployee(employee);

        //then
        then(employeeRepository).should().save(any(Employee.class));
    }

    @DisplayName("GIVEN pass existed employee id and State type, WHEN execute updateState, THEN call save method")
    @Test
    void givenPassExistedEmployeeIdAndStateWhenExecuteUpdateStateThenCallSaveMethod() {
        //given
        Employee employee = new Employee();

        given(employeeRepository.save(any(Employee.class))).willReturn(employee);
        given(employeeRepository.findById(eq("1"))).willReturn(Optional.of(employee));

        //when
        target.updateState("1", State.APPROVED.name());

        //then
        then(employeeRepository).should().findById(anyString());
        then(employeeRepository).should().save(any(Employee.class));
    }

    @DisplayName("GIVEN pass non existed employee id and State type, WHEN execute updateState, THEN call save method")
    @Test
    void givenPassNonExistedEmployeeIdAndStateWhenExecuteUpdateStateThenCallSaveMethod() {
        //given
        Employee employee = new Employee();

        given(employeeRepository.findById(eq("1"))).willReturn(Optional.empty());

        //when
        assertThrows(EmployeeManagementException.class, () -> target.updateState("1", State.APPROVED.name()));

        //then
        then(employeeRepository).should().findById(anyString());
        then(employeeRepository).should(times(0)).save(any(Employee.class));
    }
}
