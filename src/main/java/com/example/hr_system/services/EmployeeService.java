package com.example.hr_system.services;

import com.example.hr_system.domain.Department;
import com.example.hr_system.domain.Employee;
import com.example.hr_system.dtos.EmployeeDto;
import com.example.hr_system.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentService departmentService;

    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee with Id " + id + " not found"));
    }

    @Transactional
    public Employee update(Long id, EmployeeDto employeeDto) {
        Employee employee = findById(id);
        Department department = departmentService.findById(employeeDto.departmentId());
        employee.setDepartment(department);
        employee.setCpf(employeeDto.cpf());
        employee.setName(employeeDto.name());
        employee.setPosition(employeeDto.position());
        employee.setHireDate(employeeDto.hireDate());
        employee.setTerminationDate(employeeDto.terminationDate());
        return employeeRepository.save(employee);
    }

}
