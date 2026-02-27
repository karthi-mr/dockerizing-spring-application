package com.learn.demo.employee;

import com.learn.demo.employee.dto.EmployeeRequest;
import com.learn.demo.employee.dto.EmployeeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EmployeeResponse>> findAll() {
        return ResponseEntity
                .ok(this.employeeService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EmployeeResponse> findById(@PathVariable Long id) {
        return ResponseEntity
                .ok(this.employeeService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EmployeeResponse> create(@RequestBody @Valid EmployeeRequest request) {
        return ResponseEntity
                .ok(this.employeeService.create(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EmployeeResponse> update(
            @PathVariable Long id,
            @RequestBody @Valid EmployeeRequest request
    ) {
        return ResponseEntity
                .ok(this.employeeService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
