package com.example.hr_system.services;

import com.example.hr_system.domain.Absence;
import com.example.hr_system.domain.Department;
import com.example.hr_system.repositories.AbsenceRepository;
import com.example.hr_system.repositories.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AbsenceService {

    @Autowired
    AbsenceRepository absenceRepository;

    @Transactional
    public Absence save(Absence absence) {
        return absenceRepository.save(absence);
    }

    public List<Absence> findAll() {
        return absenceRepository.findAll();
    }

    public Optional<Absence> findById(Long id) {
        return absenceRepository.findById(id);
    }

}
