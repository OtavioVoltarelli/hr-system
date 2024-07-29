package com.example.hr_system.controllers;

import com.example.hr_system.domain.Absence;
import com.example.hr_system.dtos.AbsenceDto;
import com.example.hr_system.services.AbsenceService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/absences")
public class AbsenceController {

    @Autowired
    AbsenceService absenceService;


    @Transactional
    @PostMapping
    public ResponseEntity<Absence> save(@RequestBody @Valid AbsenceDto absenceDto) {
        Absence absence = new Absence(absenceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(absenceService.save(absence));
    }

}
