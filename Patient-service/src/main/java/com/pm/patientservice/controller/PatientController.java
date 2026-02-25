package com.pm.patientservice.controller;


import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientRespondDTO;
import com.pm.patientservice.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientRespondDTO>> getPatients() {
        List<PatientRespondDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }


//    create new patient
    @PostMapping
    public ResponseEntity<PatientRespondDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO){
        PatientRespondDTO patientRespondDTO = patientService.createPatient(patientRequestDTO);


        return ResponseEntity.ok().body(patientRespondDTO);
    }

    @PutMapping("/{patient_Id}")
    public ResponseEntity<PatientRespondDTO> updatePatient(@PathVariable UUID patient_Id, @RequestBody PatientRequestDTO patientRequestDTO) {

        PatientRespondDTO patientRespondDTO = patientService.updatePatient(patient_Id, patientRequestDTO);
        return ResponseEntity.ok().body(patientRespondDTO);
    }
}
