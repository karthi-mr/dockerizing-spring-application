package com.learn.demo.department;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.demo.employee.Employee;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employees;

}
