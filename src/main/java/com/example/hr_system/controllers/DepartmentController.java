package com.example.hr_system.controllers;

import com.example.hr_system.domain.Department;
import com.example.hr_system.dtos.DepartmentDto;
import com.example.hr_system.services.DepartmentService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        Department department = departmentService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(department);
    }

    @GetMapping
    public ResponseEntity<List<Department>> findAll() {
        List<Department> departments = departmentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(departments);
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody @Valid DepartmentDto departmentDto) {
        Department department = departmentService.findById(id);
        department.setName(departmentDto.name());
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.save(department));
    }

}
