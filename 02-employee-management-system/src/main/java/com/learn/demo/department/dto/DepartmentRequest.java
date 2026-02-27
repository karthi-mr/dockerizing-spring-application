package com.learn.demo.department.dto;

import jakarta.validation.constraints.NotBlank;

public record DepartmentRequest(

        @NotBlank(message = "Department name should not be blank")
        String name
) {
}
