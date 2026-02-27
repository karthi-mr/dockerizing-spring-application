package com.learn.demo.employee;

import com.learn.demo.department.Department;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = true, name = "email")
    private String email;

    @Column(nullable = false, name = "salary")
    private BigDecimal salary;

    @Column(nullable = false, name = "is_active")
    private boolean isActive;

    @Column(nullable = false, name = "hire_date")
    private LocalDate hireDate;

    @Column(nullable = false, updatable = false, name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(insertable = false, name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
