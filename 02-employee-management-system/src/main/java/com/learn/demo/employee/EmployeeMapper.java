package com.learn.demo.employee;

import com.learn.demo.department.Department;
import com.learn.demo.employee.dto.EmployeeRequest;
import com.learn.demo.employee.dto.EmployeeResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeMapper {

    public EmployeeResponse toEmployeeResponse(
            @NonNull Employee employee
    ) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getSalary(),
                employee.isActive(),
                employee.getHireDate(),
                employee.getDepartment()
        );
    }

    public Employee toEmployee(@NonNull EmployeeRequest employeeRequest, @NonNull Department department) {
        return Employee.builder()
                .firstName(employeeRequest.firstName())
                .lastName(employeeRequest.lastName())
                .email(employeeRequest.email())
                .salary(employeeRequest.salary())
                .isActive(true)
                .department(department)
                .hireDate(LocalDate.now())
                .build();
    }
}
