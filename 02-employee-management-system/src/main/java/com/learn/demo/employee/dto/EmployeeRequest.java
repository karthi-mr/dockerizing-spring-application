package com.learn.demo.employee.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record EmployeeRequest(

        @NotBlank(message = "FirstName should not be blank")
        String firstName,

        @NotBlank(message = "LastName should not be blank")
        String lastName,

        @NotBlank(message = "Email should not be blank")
        @Email(message = "Invalid email")
        String email,

        @Positive(message = "Salary should be positive value")
        BigDecimal salary,

        Long departmentId
) {
}
