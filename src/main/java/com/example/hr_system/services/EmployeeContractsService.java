package com.example.hr_system.services;

import com.example.hr_system.domain.Department;
import com.example.hr_system.domain.EmployeeContracts;
import com.example.hr_system.domain.Employee;
import com.example.hr_system.dtos.EmployeeContractsDto;
import com.example.hr_system.dtos.TerminationContractDto;
import com.example.hr_system.exceptions.NoActiveContractException;
import com.example.hr_system.exceptions.ObjectNotFoundException;
import com.example.hr_system.repositories.EmployeeContractsRepository;
import com.example.hr_system.repositories.EmployeeRepository;
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

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeContracts save(EmployeeContracts employeeContracts) {
        boolean hasActiveContract = employeeService.hasActiveContract(employeeContracts.getEmployee().getId());
        return employeeContractsRepository.save(employeeContracts);
    }

    public List<EmployeeContracts> findAll() {
        return employeeContractsRepository.findAll();
    }

    public EmployeeContracts findById(Long id) {
        return employeeContractsRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Employee contract with Id " + id + " not found"));
    }

    @Transactional
    public EmployeeContracts update(Long id, EmployeeContractsDto employeeContractsDto) {
        EmployeeContracts employeeContracts = findById(id);
        Employee employee = employeeService.findById(employeeContractsDto.employeeId());
        employeeContracts.setEmployee(employee);
        employeeContracts.setPosition(employeeContractsDto.position());
        employeeContracts.setSalary(employeeContractsDto.salary());
        employeeContracts.setHireDate(employeeContractsDto.hireDate());
        return employeeContractsRepository.save(employeeContracts);
    }

    @Transactional
    public EmployeeContracts disable(Long employeeId, TerminationContractDto terminationContractDto) {
        Employee employee = employeeService.findById(employeeId);
        EmployeeContracts activeContract = employee.getContracts().stream()
                .filter(contract -> contract.getTerminationDate() == null)
                .findFirst()
                .orElseThrow(NoActiveContractException::new);
        activeContract.setTerminationDate(terminationContractDto.terminationDate());
        return employeeContractsRepository.save(activeContract);
    }

    @Transactional
    public void delete(Long id) {
        EmployeeContracts employeeContracts = findById(id);
        employeeContractsRepository.delete(employeeContracts);
    }
}
