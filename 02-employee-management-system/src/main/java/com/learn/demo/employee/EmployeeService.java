package com.learn.demo.employee;

import com.learn.demo.department.DepartmentNotFoundException;
import com.learn.demo.department.DepartmentRepository;
import com.learn.demo.employee.dto.EmployeeRequest;
import com.learn.demo.employee.dto.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentRepository departmentRepository;

    @NonNull
    public List<EmployeeResponse> findAll() {
        List<Employee> employees = this.employeeRepository.findAll();
        return employees.stream()
                .map(this.employeeMapper::toEmployeeResponse)
                .toList();
    }

    @NonNull
    public EmployeeResponse findById(@NonNull Long id) {
        return this.employeeRepository.findById(id)
                .map(this.employeeMapper::toEmployeeResponse)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    @NonNull
    public EmployeeResponse create(@NonNull EmployeeRequest request) {
        var department = this.departmentRepository.findById(request.departmentId())
                .orElseThrow(() -> new DepartmentNotFoundException(request.departmentId()));
        Employee employee = this.employeeMapper.toEmployee(request, department);
        var savedEmployee = this.employeeRepository.save(employee);
        return this.employeeMapper.toEmployeeResponse(savedEmployee);
    }

    @NonNull
    public EmployeeResponse update(@NonNull Long id, @NonNull EmployeeRequest request) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        var department = this.departmentRepository.findById(request.departmentId())
                .orElseThrow(() -> new DepartmentNotFoundException(request.departmentId()));
        employee.setFirstName(request.firstName());
        employee.setLastName(request.lastName());
        employee.setEmail(request.email());
        employee.setDepartment(department);

        var savedDepartment = this.employeeRepository.save(employee);
        return this.employeeMapper.toEmployeeResponse(savedDepartment);
    }

    public void delete(@NonNull Long id) {
        this.employeeRepository.deleteById(id);
    }
}