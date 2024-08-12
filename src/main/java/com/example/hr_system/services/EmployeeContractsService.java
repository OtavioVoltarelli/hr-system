package com.example.hr_system.services;

import com.example.hr_system.domain.EmployeeContracts;
import com.example.hr_system.domain.Employee;
import com.example.hr_system.dtos.EmployeeContractsDto;
import com.example.hr_system.repositories.EmployeeContractsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeContractsService {

    @Autowired
    EmployeeContractsRepository employeeContractsRepository;

    @Autowired
    EmployeeService employeeService;

    @Transactional
    public EmployeeContracts save(EmployeeContracts employeeContracts) {
        return employeeContractsRepository.save(employeeContracts);
    }

    public List<EmployeeContracts> findAll() {
        return employeeContractsRepository.findAll();
    }

    public EmployeeContracts findById(Long id) {
        return employeeContractsRepository.findById(id).orElseThrow(() -> new RuntimeException("EmployeeContracts with Id " + id + " not found"));
    }

    @Transactional
    public EmployeeContracts update(Long id, EmployeeContractsDto employeeContractsDto) {
        EmployeeContracts employeeContracts = findById(id);
        Employee employee = employeeService.findById(employeeContractsDto.employeeId());
        employeeContracts.setEmployee(employee);
        employeeContracts.setPosition(employeeContractsDto.position());
        employeeContracts.setSalary(employeeContractsDto.salary());
        employeeContracts.setHireDate(employeeContractsDto.hireDate());
        employeeContracts.setTerminationDate(employeeContractsDto.terminationDate());
        return employeeContractsRepository.save(employeeContracts);
    }

}
