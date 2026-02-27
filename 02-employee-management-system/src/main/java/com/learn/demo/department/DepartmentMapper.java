package com.learn.demo.department;

import com.learn.demo.department.dto.DepartmentRequest;
import com.learn.demo.department.dto.DepartmentResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public DepartmentResponse toDepartmentResponse(
            @NonNull Department department
    ) {
        return new DepartmentResponse(
                department.getId(),
                department.getName()
        );
    }

    public Department toDepartment(@NonNull DepartmentRequest departmentRequest) {
        return Department.builder()
                .name(departmentRequest.name())
                .build();
    }
}
