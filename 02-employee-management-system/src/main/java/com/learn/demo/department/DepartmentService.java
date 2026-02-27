package com.learn.demo.department;

import com.learn.demo.department.dto.DepartmentRequest;
import com.learn.demo.department.dto.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @NonNull
    public List<DepartmentResponse> findAll() {
        List<Department> departments = this.departmentRepository.findAll();
        return departments.stream()
                .map(this.departmentMapper::toDepartmentResponse)
                .toList();
    }

    @NonNull
    public DepartmentResponse findById(@NonNull Long id) {
        return this.departmentRepository.findById(id)
                .map(this.departmentMapper::toDepartmentResponse)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    @NonNull
    public DepartmentResponse create(@NonNull DepartmentRequest request) {
        Department department = this.departmentMapper.toDepartment(request);
        var savedDepartment = this.departmentRepository.save(department);
        return this.departmentMapper.toDepartmentResponse(savedDepartment);
    }

    @NonNull
    public DepartmentResponse update(@NonNull Long id, @NonNull DepartmentRequest request) {
        Department department = this.departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
        department.setName(request.name());
        var savedDepartment = this.departmentRepository.save(department);
        return this.departmentMapper.toDepartmentResponse(savedDepartment);
    }

    public void delete(@NonNull Long id) {
        this.departmentRepository.deleteById(id);
    }
}