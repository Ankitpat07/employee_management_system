package com.zest.employee_management.service.impl;

import com.zest.employee_management.entity.Employee.Employee;
import com.zest.employee_management.exception.ResourceNotFoundException;
import com.zest.employee_management.repository.Employee.EmployeeRepository;
import com.zest.employee_management.service.Employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee){
        return  employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> getAllEmployees(
            int page,
            int size,
            String sortBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy).ascending()
        );

        return employeeRepository.findAll(pageable);
    }
    @Override
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id : " + id
                        ));
    }
    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id : " + id
                        ));
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setDateOfJoining(employee.getDateOfJoining());

        return employeeRepository.save(existingEmployee);
    }
    @Override
    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id : " + id
                        ));

        employeeRepository.delete(employee);
    }

}
