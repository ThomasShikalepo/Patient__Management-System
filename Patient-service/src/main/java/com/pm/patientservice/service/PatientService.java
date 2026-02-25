package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientRespondDTO;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.exception.EmailAndPhoneNumberAlreadyExistsException;
import com.pm.patientservice.exception.PhoneNumberAlreadyExistsException;
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

//    get patient service
    public List<PatientRespondDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        List<PatientRespondDTO> patientRespondDTOS = patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();

        return  patientRespondDTOS;
    }

    public PatientRespondDTO createPatient(PatientRequestDTO patientRequestDTO) {
        boolean existsByEmail = patientRepository.existsByEmail(patientRequestDTO.getEmail());
        boolean existsByPhoneNumber = patientRepository.existsByPhoneNumber(patientRequestDTO.getPhoneNumber());

        if(existsByEmail && existsByPhoneNumber) {
            throw new EmailAndPhoneNumberAlreadyExistsException("Email and phone already exist");
        }
         else if(existsByEmail) {
            throw new EmailAlreadyExistsException("Email already exists");
        } else if (existsByPhoneNumber) {
            throw new PhoneNumberAlreadyExistsException("Phone number already exists");
        }

        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));

        return PatientMapper.toDTO(newPatient);
    }


}
