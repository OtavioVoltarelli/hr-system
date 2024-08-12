package com.example.hr_system.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EmployeeContractsDto(@NotBlank String position,
                                   @NotNull Long salary,
                                   @NotNull LocalDate hireDate,
                                   @NotNull LocalDate terminationDate,
                                   @NotNull Long employeeId){
}
