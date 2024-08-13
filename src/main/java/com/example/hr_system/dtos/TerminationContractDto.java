package com.example.hr_system.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TerminationContractDto(@NotNull LocalDate terminationDate) {
}
