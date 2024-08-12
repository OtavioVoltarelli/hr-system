package com.example.hr_system.dtos;

import com.example.hr_system.domain.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EmployeeDto(@NotBlank String name,
                          @NotBlank String cpf,
                          @NotBlank String position,
                          @NotBlank String contactNumber,
                          @NotNull LocalDate birthDate,
                          @NotNull Long departmentId) {

}
