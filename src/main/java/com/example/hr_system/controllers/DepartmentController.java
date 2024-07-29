package com.example.hr_system.controllers;

import com.example.hr_system.domain.Department;
import com.example.hr_system.dtos.DepartmentDto;
import com.example.hr_system.services.DepartmentService;
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
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @Transactional
    @PostMapping
    public ResponseEntity<Department> save(@RequestBody @Valid DepartmentDto departmentDto) {
        Department department = new Department(departmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(department));
    }

}
