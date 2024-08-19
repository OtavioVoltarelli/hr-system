package com.example.hr_system.domain;

import com.example.hr_system.dtos.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

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
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(name = "birth_date",nullable = false)
    private LocalDate birthDate;
    @Column(name = "contract_number", nullable = false)
    private String contactNumber;
    @Column(nullable = false)
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    List<Absence> absences;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee")
    List<EmployeeContracts> contracts;

    public Employee(EmployeeDto employeeDto) {
        this.name = employeeDto.name();
        this.cpf = employeeDto.cpf();
        this.birthDate = employeeDto.birthDate();
        this.contactNumber = employeeDto.contactNumber();
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

    public @NotBlank String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(@NotBlank String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public List<EmployeeContracts> getContracts() {
        return contracts;
    }
}
