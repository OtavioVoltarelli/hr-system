package com.example.hr_system.dtos;

import com.example.hr_system.domain.Department;

import java.time.LocalDate;

public record EmployeeDto(String name, String cpf, String position, LocalDate hireDate, Department department) {

}
