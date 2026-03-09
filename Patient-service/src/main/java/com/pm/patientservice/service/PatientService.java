package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientRespondDTO;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.exception.EmailAndPhoneNumberAlreadyExistsException;
import com.pm.patientservice.exception.PatientNotFoundException;
import com.pm.patientservice.exception.PhoneNumberAlreadyExistsException;
import com.pm.patientservice.grpc.BillingServiceGrpcClient;
import com.pm.patientservice.kafka.KafkaProducer;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final BillingServiceGrpcClient billingServiceGrpcClient;
    private final KafkaProducer kafkaProducer;


    public PatientService(PatientRepository patientRepository, BillingServiceGrpcClient billingServiceGrpcClient, KafkaProducer kafkaProducer) {
        this.patientRepository = patientRepository;
        this.billingServiceGrpcClient = billingServiceGrpcClient;
        this.kafkaProducer = kafkaProducer;
    }

    //    get patient service
    public List<PatientRespondDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        List<PatientRespondDTO> patientRespondDTOS = patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();

        return patientRespondDTOS;
    }

    public PatientRespondDTO createPatient(PatientRequestDTO patientRequestDTO) {
        boolean existsByEmail = patientRepository.existsByEmail(patientRequestDTO.getEmail());
        boolean existsByPhoneNumber = patientRepository.existsByPhoneNumber(patientRequestDTO.getPhoneNumber());

        if (existsByEmail && existsByPhoneNumber) {
            throw new EmailAndPhoneNumberAlreadyExistsException("Email and phone already exist: " + patientRequestDTO.getEmail() + " And " + patientRequestDTO.getPhoneNumber());
        } else if (existsByEmail) {
            throw new EmailAlreadyExistsException("Email already exists: " + patientRequestDTO.getEmail());
        } else if (existsByPhoneNumber) {
            throw new PhoneNumberAlreadyExistsException("Phone number already exists: " + patientRequestDTO.getPhoneNumber());
        }

        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));

        kafkaProducer.sendEvent(newPatient);

        billingServiceGrpcClient.createBillingAccount(newPatient.getPatientId().toString(), newPatient.getFirstname(),
                newPatient.getLastname(),newPatient.getEmail());


        return PatientMapper.toDTO(newPatient);
    }

    public PatientRespondDTO updatePatient(UUID patient_Id, @NonNull PatientRequestDTO patientRequestDTO) {

        Patient patient = patientRepository.findById(patient_Id).orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + patient_Id));

        if (patientRequestDTO.getEmail() != null && !patientRequestDTO.getEmail().equalsIgnoreCase(patient.getEmail())) {
            if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
                throw new EmailAlreadyExistsException("Email already exists" + patientRequestDTO.getEmail());
            }
            patient.setEmail(patientRequestDTO.getEmail());
        }

        if (patientRequestDTO.getPhoneNumber() != null && !patientRequestDTO.getPhoneNumber().equals(patient.getPhoneNumber())) {
            if (patientRepository.existsByPhoneNumber(patientRequestDTO.getPhoneNumber())) {
                throw new PhoneNumberAlreadyExistsException("Phone number already exists" + patientRequestDTO.getPhoneNumber());
            }
            patient.setPhoneNumber(patientRequestDTO.getPhoneNumber());
        }

        patient.setFirstname(patientRequestDTO.getFirstname());
        patient.setLastname(patientRequestDTO.getLastname());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setPhoneNumber(patientRequestDTO.getPhoneNumber());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setGender(patientRequestDTO.getGender());
        patient.setBloodType(patientRequestDTO.getBloodType());
        patient.setEmergencyContactName(patientRequestDTO.getEmergencyContactName());
        patient.setEmergencyContactPhone(patientRequestDTO.getEmergencyContactPhone());
        patient.setInsured(patientRequestDTO.getInsured());
        patient.setInsuranceProvider(patientRequestDTO.getInsuranceProvider());
        patient.setMedicalHistory(patientRequestDTO.getMedicalHistory());
        patient.setLastVisitDate(LocalDateTime.parse(patientRequestDTO.getLastVisitDate()));
        patient.setStatus(patientRequestDTO.getStatus());

        Patient updatePatient = patientRepository.save(patient);

        return PatientMapper.toDTO(updatePatient);
    }

    public void deletePatient(UUID patient_Id) {
       if(!patientRepository.existsById(patient_Id)) {
           throw new PatientNotFoundException("Patient not found with ID: " + patient_Id);
       }
       patientRepository.deleteById(patient_Id);
    }
}
