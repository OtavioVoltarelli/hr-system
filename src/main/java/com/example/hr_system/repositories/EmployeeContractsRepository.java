package com.example.hr_system.repositories;

import com.example.hr_system.domain.EmployeeContracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeContractsRepository extends JpaRepository<EmployeeContracts, Long> {
}
