package com.example.hr_system.controllers;

import com.example.hr_system.domain.Employee;
import com.example.hr_system.dtos.EmployeeDto;
import com.example.hr_system.services.EmployeeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @Transactional
    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody @Valid EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
    }

}
