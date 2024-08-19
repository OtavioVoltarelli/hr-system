package com.example.hr_system.services;

import com.example.hr_system.domain.Absence;
import com.example.hr_system.domain.Department;
import com.example.hr_system.domain.Employee;
import com.example.hr_system.dtos.AbsenceDto;
import com.example.hr_system.exceptions.InvalidDateException;
import com.example.hr_system.exceptions.ObjectNotFoundException;
import com.example.hr_system.repositories.AbsenceRepository;
import com.example.hr_system.repositories.DepartmentRepository;
import com.example.hr_system.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AbsenceService {

    @Autowired
    AbsenceRepository absenceRepository;

    @Autowired
    EmployeeService employeeService;

    @Transactional
    public Absence save(Absence absence) {
        if (!absence.getStartDate().isBefore(absence.getEndDate())) throw new InvalidDateException("Start date must be before end date.");
        return absenceRepository.save(absence);
    }

    public List<Absence> findAll() {
        return absenceRepository.findAll();
    }

    public Absence findById(Long id) {
        return absenceRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Absence with Id " + id + " not found"));
    }

    @Transactional
    public Absence update(Long id, AbsenceDto absenceDto) {
        Absence absence = findById(id);
        Employee employee = employeeService.findById(absenceDto.employeeId());
        absence.setEmployee(employee);
        absence.setStartDate(absenceDto.startDate());
        absence.setEndDate(absenceDto.endDate());
        absence.setReason(absenceDto.reason());
        return absenceRepository.save(absence);
    }

    @Transactional
    public void delete(Long id){
        Absence absence = findById(id);
        absenceRepository.delete(absence);
    }

}
