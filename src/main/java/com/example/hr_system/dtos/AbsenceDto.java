package com.example.hr_system.dtos;

import com.example.hr_system.domain.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AbsenceDto(@NotNull Long employeeId,
                         @NotNull LocalDate startDate,
                         @NotNull LocalDate endDate,
                         @NotBlank String reason) {

}
