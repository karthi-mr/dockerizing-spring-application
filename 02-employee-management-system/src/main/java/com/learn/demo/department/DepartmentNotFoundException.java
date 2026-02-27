package com.learn.demo.department;

import static java.lang.String.format;

public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException(Long id) {
        super(format("Department not found for id: %d", id));
    }
}
