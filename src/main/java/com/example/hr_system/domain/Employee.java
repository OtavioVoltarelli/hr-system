package com.example.hr_system.domain;

import com.example.hr_system.dtos.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    @NotBlank
    private String position;
    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;
    @Column(name = "termination_date")
    private LocalDate terminationDate;
    @Column(nullable = false)
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    List<Absence> absences;


    public Employee(EmployeeDto employeeDto) {
        this.name = employeeDto.name();
        this.cpf = employeeDto.cpf();
        this.position = employeeDto.position();
        this.hireDate = employeeDto.hireDate();
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank String getPosition() {
        return position;
    }

    public void setPosition(@NotBlank String position) {
        this.position = position;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Absence> getAbsences() {
        return absences;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
