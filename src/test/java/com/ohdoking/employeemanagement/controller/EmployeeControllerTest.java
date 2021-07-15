package com.ohdoking.employeemanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohdoking.employeemanagement.controller.EmployeeController;
import com.ohdoking.employeemanagement.model.Employee;
import com.ohdoking.employeemanagement.model.State;
import com.ohdoking.employeemanagement.model.StateRequest;
import com.ohdoking.employeemanagement.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("UT. EmployeeControllerTest.")
@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webapp;

    @MockBean
    private EmployeeService employeeService;

    private final ObjectMapper mapper = new ObjectMapper();



    @BeforeEach
    public void init() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.webapp)
                .build();
    }

    @DisplayName("GIVEN pass employee, WHEN call post /employee, THEN return 201")
    @Test
    public void givenPassEmployeeWhenCallPostEmployeeThenReturn201() throws Exception {

        Employee employee = new Employee();
        employee.setAge(10);
        employee.setContract(Map.of("key","value"));
        employee.setName("dokeun");
        employee.setUpdatedTime(null);
        employee.setCreatedTime(null);

        String jsonString = mapper.writeValueAsString(employee);

        given(employeeService.addEmployee(any(Employee.class))).willReturn(employee);

        mockMvc.perform(post("/employee")
                .content(jsonString)
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    @DisplayName("GIVEN pass id and state, WHEN call patch /employee/{id}/state, THEN return 202")
    @Test
    public void givenPassIdAndStateWhenCallPatchEmployeeIdStateThenReturn202() throws Exception {

        Employee employee = new Employee();

        StateRequest stateRequest = new StateRequest();
        stateRequest.setState(State.APPROVED.name());
        String jsonString = mapper.writeValueAsString(stateRequest);

        given(employeeService.updateState(eq("1"), anyString())).willReturn(employee);

        mockMvc.perform(patch("/employee/1/state")
                .content(jsonString)
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isAccepted());

    }

}
