package com.example.hr_system.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TerminationEmployeeDto(@NotNull LocalDate terminationDate) {
}
