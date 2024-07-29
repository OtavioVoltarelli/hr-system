package com.example.hr_system.dtos;

import jakarta.validation.constraints.NotBlank;

public record DepartmentDto(@NotBlank String name) {

}
