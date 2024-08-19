package com.example.hr_system.services;

import com.example.hr_system.domain.Department;
import com.example.hr_system.domain.Employee;
import com.example.hr_system.domain.EmployeeContracts;
import com.example.hr_system.dtos.EmployeeDto;
import com.example.hr_system.dtos.TerminationContractDto;
import com.example.hr_system.exceptions.ObjectNotFoundException;
import com.example.hr_system.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
        return employeeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Employee with Id " + id + " not found"));
    }

    @Transactional
    public Employee update(Long id, EmployeeDto employeeDto) {
        Employee employee = findById(id);
        Department department = departmentService.findById(employeeDto.departmentId());
        employee.setDepartment(department);
        employee.setCpf(employeeDto.cpf());
        employee.setName(employeeDto.name());
        employee.setContactNumber(employeeDto.contactNumber());
        employee.setBirthDate(employeeDto.birthDate());
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee disable(Long id, TerminationContractDto terminationContractDto) {
        Employee employee = findById(id);
        employee.setActive(false);
//        employeeContractsService.disable(id, terminationContractDto);
        return employeeRepository.save(employee);
    }

    public boolean hasActiveContract (Long id) {
        Employee employee = findById(id);
        Optional<EmployeeContracts> optionalActiveContract = employee.getContracts().stream()
                .filter(contract -> contract.getTerminationDate() == null)
                .findFirst();
        if (optionalActiveContract.isPresent()) {
            throw new RuntimeException("This employee already has an active contract");
        }
        return false;
    }

    @Transactional
    public void delete(Long id) {
        Employee employee = findById(id);
        employeeRepository.delete(employee);
    }
}
