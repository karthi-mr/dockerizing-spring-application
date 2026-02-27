package com.learn.demo.employee;

import static java.lang.String.format;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super(format("Employee not found for id: %d", id));
    }
}
