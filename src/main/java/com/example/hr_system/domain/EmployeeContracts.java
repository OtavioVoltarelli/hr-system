package com.example.hr_system.domain;

import com.example.hr_system.dtos.EmployeeContractsDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "employee_contracts")
public class EmployeeContracts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String position;
    @Column(nullable = false)
    private Long salary;
    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;
    @Column(name = "termination_date")
    private LocalDate terminationDate;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonBackReference
    private Employee employee;


    public EmployeeContracts(EmployeeContractsDto employeeContractsDto) {
        this.position = employeeContractsDto.position();
        this.salary = employeeContractsDto.salary();
        this.hireDate = employeeContractsDto.hireDate();
        this.terminationDate = null;
    }

    public EmployeeContracts() {
    }

    public @NotBlank String getPosition() {
        return position;
    }

    public void setPosition(@NotBlank String position) {
        this.position = position;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
