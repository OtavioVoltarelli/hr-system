package com.example.hr_system.repositories;

import com.example.hr_system.domain.Department;
import com.example.hr_system.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
