package com.example.hr_system.controllers;

import com.example.hr_system.domain.EmployeeContracts;
import com.example.hr_system.domain.Employee;
import com.example.hr_system.dtos.EmployeeContractsDto;
import com.example.hr_system.dtos.TerminationContractDto;
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
@RequestMapping("/employeeContracts")
public class EmployeeContractsController {

    @Autowired
    EmployeeContractsService employeeContractsService;

    @Autowired
    EmployeeService employeeService;


    @Transactional
    @PostMapping
    public ResponseEntity<EmployeeContracts> save(@RequestBody @Valid EmployeeContractsDto employeeContractsDto) {
        Employee employee = employeeService.findById(employeeContractsDto.employeeId());
        EmployeeContracts employeeContracts = new EmployeeContracts(employeeContractsDto);
        employeeContracts.setEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeContractsService.save(employeeContracts));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeContracts> findById(@PathVariable Long id) {
        EmployeeContracts employeeContracts = employeeContractsService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeContracts);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeContracts>> findAll() {
        List<EmployeeContracts> employeeContracts = employeeContractsService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(employeeContracts);
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeContracts> update(@PathVariable Long id, @RequestBody @Valid EmployeeContractsDto employeeContractsDto) {
        EmployeeContracts employeeContracts = employeeContractsService.update(id, employeeContractsDto);
        return ResponseEntity.status(HttpStatus.OK).body(employeeContracts);
    }

    @Transactional
    @PutMapping(value = "/disable/{id}")
    public ResponseEntity<EmployeeContracts> disable(@PathVariable Long id, @RequestBody @Valid TerminationContractDto terminationContractDto) {
        EmployeeContracts employeeContracts = employeeContractsService.disable(id, terminationContractDto);
        return ResponseEntity.status(HttpStatus.OK).body(employeeContracts);
    }
}
