package com.pm.patientservice.controller;


import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientRespondDTO;
import com.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patient", description = "API for managing Patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get All patients")
    public ResponseEntity<List<PatientRespondDTO>> getPatients() {
        List<PatientRespondDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }


    //    create new patient
    @PostMapping
    @Operation(summary = "Create a new patient")
    public ResponseEntity<PatientRespondDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientRespondDTO patientRespondDTO = patientService.createPatient(patientRequestDTO);


        return ResponseEntity.ok().body(patientRespondDTO);
    }

    @PutMapping("/{patient_Id}")
    @Operation(summary = "Updates a patient")
    public ResponseEntity<PatientRespondDTO> updatePatient(@PathVariable UUID patient_Id, @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO) {

        PatientRespondDTO patientRespondDTO = patientService.updatePatient(patient_Id, patientRequestDTO);
        return ResponseEntity.ok().body(patientRespondDTO);
    }

    @DeleteMapping("/{patient_id}")
    @Operation(summary = "Delete a patient")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID patient_id) {

        patientService.deletePatient(patient_id);
        return ResponseEntity.noContent().build();
    }
}
