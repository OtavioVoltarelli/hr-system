package com.example.hr_system.dtos;

import com.example.hr_system.domain.user.UserRole;

public record RegisterDto(String login,
                          String password,
                          UserRole role) {
}
