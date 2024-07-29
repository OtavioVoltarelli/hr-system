package com.example.hr_system.dtos;

import com.example.hr_system.domain.Employee;

import java.time.LocalDate;

public record AbsenceDto(LocalDate startDate, LocalDate endDate, String reason, Employee employee) {

}
