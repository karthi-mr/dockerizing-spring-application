package com.learn.demo.employee.dto;

import com.learn.demo.department.Department;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeResponse(

        Long id,

        String firstName,

        String lastName,

        String email,

        BigDecimal salary,

        boolean isActive,

        LocalDate hireDate,

        Department department
) {
}
