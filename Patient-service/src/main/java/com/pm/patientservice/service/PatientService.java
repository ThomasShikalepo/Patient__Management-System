package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRespondDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientRespondDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        List<PatientRespondDTO> patientRespondDTOS = patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();

        return  patientRespondDTOS;
    }
}
