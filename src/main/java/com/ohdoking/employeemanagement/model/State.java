package com.ohdoking.employeemanagement.model;

import com.ohdoking.employeemanagement.exception.EmployeeManagementException;

import java.util.Objects;

public enum State {
    ADDED, IN_CHECK, APPROVED, ACTIVE;

    public static State of(String value) {
        try {
            return State.valueOf(Objects.requireNonNullElse(value, ""));
        } catch (IllegalArgumentException e) {
            throw new EmployeeManagementException(String.format("state doesn't exists, state : %s.", value));
        }
    }

}
