package com.zest.employee_management.entity.Employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Employee name is required")
    @Column(nullable = false)
    private String name;

    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Department is required")
    private String department;

    @NotBlank(message="Designation is required")
    private String designation;

    @NotNull(message = "Salary is required")
    private String salary;

    @NotNull(message = "Date of Joining is required")
    private LocalDate dateOfJoining;
}
