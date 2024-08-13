package com.example.hr_system.controllers;

import com.example.hr_system.domain.Department;
import com.example.hr_system.domain.Employee;
import com.example.hr_system.dtos.EmployeeDto;
import com.example.hr_system.dtos.TerminationContractDto;
import com.example.hr_system.services.DepartmentService;
import com.example.hr_system.services.EmployeeContractsService;
import com.example.hr_system.services.EmployeeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeContractsService employeeContractsService;

    @Autowired
    DepartmentService departmentService;


    @Transactional
    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody @Valid EmployeeDto employeeDto) {
        Department department = departmentService.findById(employeeDto.departmentId());
        Employee employee = new Employee(employeeDto);
        employee.setDepartment(department);
        employee.setActive(true);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody @Valid EmployeeDto employeeDto) {
        Employee employee = employeeService.update(id, employeeDto);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @Transactional
    @PutMapping(value = "/disable/{id}")
    public ResponseEntity<Employee> disable(@PathVariable Long id, @RequestBody @Valid TerminationContractDto terminationContractDto) {
        Employee employee = employeeService.disable(id, terminationContractDto);
        employeeContractsService.disable(id, terminationContractDto);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }
}
