package com.learn.demo.department;

import com.learn.demo.department.dto.DepartmentRequest;
import com.learn.demo.department.dto.DepartmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<DepartmentResponse>> findAll() {
        return ResponseEntity
                .ok(this.departmentService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DepartmentResponse> findById(@PathVariable Long id) {
        return ResponseEntity
                .ok(this.departmentService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DepartmentResponse> create(@RequestBody @Valid DepartmentRequest request) {
        return ResponseEntity
                .ok(this.departmentService.create(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DepartmentResponse> update(
            @PathVariable Long id,
            @RequestBody @Valid DepartmentRequest request
    ) {
        return ResponseEntity
                .ok(this.departmentService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.departmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
