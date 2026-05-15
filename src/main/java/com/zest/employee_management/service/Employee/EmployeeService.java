package com.zest.employee_management.service.Employee;

import com.zest.employee_management.entity.Employee.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Page<Employee> getAllEmployees(
            int page,
            int size,
            String sortBy
    );

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
}
