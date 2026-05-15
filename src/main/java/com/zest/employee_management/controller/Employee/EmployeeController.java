package com.zest.employee_management.controller.Employee;

import com.zest.employee_management.dto.ApiResponse;
import com.zest.employee_management.entity.Employee.Employee;
import com.zest.employee_management.service.Employee.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Employee>> addEmployee(
            @Valid @RequestBody Employee employee) {

        Employee savedEmployee =
                employeeService.addEmployee(employee);

        ApiResponse<Employee> response =
                ApiResponse.<Employee>builder()
                        .success(true)
                        .message("Employee added successfully")
                        .data(savedEmployee)
                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }
    @GetMapping
    public Page<Employee> getAllEmployees(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "5")
            int size,

            @RequestParam(defaultValue = "id")
            String sortBy
    ) {

        return employeeService.getAllEmployees(
                page,
                size,
                sortBy
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployeeById(
            @PathVariable Long id) {

        Employee employee =
                employeeService.getEmployeeById(id);

        ApiResponse<Employee> response =
                ApiResponse.<Employee>builder()
                        .success(true)
                        .message("Employee fetched successfully")
                        .data(employee)
                        .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);

        ApiResponse<String> response =
                ApiResponse.<String>builder()
                        .success(true)
                        .message("Employee deleted successfully")
                        .data(null)
                        .build();

        return ResponseEntity.ok(response);
    }


}
