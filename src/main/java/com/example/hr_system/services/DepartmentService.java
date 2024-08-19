package com.example.hr_system.services;

import com.example.hr_system.domain.Absence;
import com.example.hr_system.domain.Department;
import com.example.hr_system.exceptions.ObjectNotFoundException;
import com.example.hr_system.repositories.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;


    @Transactional
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Department with Id " + id + " not found"));
    }

    @Transactional
    public Department disable(Long id) {
        Department department = findById(id);
        department.setActive(false);
        return departmentRepository.save(department);
    }

    @Transactional
    public void delete(Long id) {
        Department department = findById(id);
        departmentRepository.delete(department);
    }
}
