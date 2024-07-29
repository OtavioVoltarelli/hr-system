package com.example.hr_system.repositories;

import com.example.hr_system.domain.Absence;
import com.example.hr_system.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
}
