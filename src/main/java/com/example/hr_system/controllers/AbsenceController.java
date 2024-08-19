package com.example.hr_system.controllers;

import com.example.hr_system.domain.Absence;
import com.example.hr_system.domain.Employee;
import com.example.hr_system.dtos.AbsenceDto;
import com.example.hr_system.services.AbsenceService;
import com.example.hr_system.services.EmployeeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/absences")
public class AbsenceController {

    @Autowired
    AbsenceService absenceService;

    @Autowired
    EmployeeService employeeService;


    @Transactional
    @PostMapping
    public ResponseEntity<Absence> save(@RequestBody @Valid AbsenceDto absenceDto) {
        Employee employee = employeeService.findById(absenceDto.employeeId());
        Absence absence = new Absence(absenceDto);
        absence.setEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(absenceService.save(absence));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Absence> findById(@PathVariable Long id) {
        Absence absence = absenceService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(absence);
    }

    @GetMapping
    public ResponseEntity<List<Absence>> findAll() {
        List<Absence> absences = absenceService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(absences);
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public ResponseEntity<Absence> update(@PathVariable Long id, @RequestBody @Valid AbsenceDto absenceDto) {
        Absence absence = absenceService.update(id, absenceDto);
        return ResponseEntity.status(HttpStatus.OK).body(absence);
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        absenceService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
