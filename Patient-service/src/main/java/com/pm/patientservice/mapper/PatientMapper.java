package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientRespondDTO;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PatientMapper {
public static PatientRespondDTO toDTO(Patient patient) {
    PatientRespondDTO patientDTO = new PatientRespondDTO();
    patientDTO.setPatient_id(patient.getPatientId().toString());
    patientDTO.setFirstname(patient.getFirstname());
    patientDTO.setLastname(patient.getLastname());
    patientDTO.setEmail(patient.getEmail());
    patientDTO.setPhone_number(patient.getPhoneNumber());
    patientDTO.setAddress(patient.getAddress());
    patientDTO.setDate_of_birth(patient.getDateOfBirth().toString());
    patientDTO.setGender(patient.getGender());
    patientDTO.setBlood_type(patient.getBloodType());
    patientDTO.setEmergency_contact_name(patient.getEmergencyContactName());
    patientDTO.setEmergency_contact_phone(patient.getEmergencyContactPhone());
    patientDTO.setInsured(patient.getInsured().toString());
    patientDTO.setInsurance_provider(patient.getInsuranceProvider());
    patientDTO.setMedical_history(patient.getMedicalHistory());
    patientDTO.setLast_visit_date(patient.getLastVisitDate().toString());
    patientDTO.setStatus(patient.getStatus());

    return patientDTO;
}

public static Patient toModel(PatientRequestDTO patientRequestDTO) {
    Patient patient = new Patient();

    patient.setFirstname(patientRequestDTO.getFirstname());
    patient.setLastname(patientRequestDTO.getLastname());
    patient.setEmail(patientRequestDTO.getEmail());
    patient.setPhoneNumber(patientRequestDTO.getPhoneNumber());
    patient.setAddress(patientRequestDTO.getAddress());
    patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth() ));
    patient.setGender(patientRequestDTO.getGender());
    patient.setBloodType(patientRequestDTO.getBloodType());
    patient.setEmergencyContactName(patientRequestDTO.getEmergencyContactName());
    patient.setEmergencyContactPhone(patientRequestDTO.getEmergencyContactPhone());
    patient.setInsured(patientRequestDTO.getInsured());
    patient.setInsuranceProvider(patientRequestDTO.getInsuranceProvider());
    patient.setMedicalHistory(patientRequestDTO.getMedicalHistory());
    patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
    patient.setLastVisitDate(LocalDateTime.parse(patientRequestDTO.getLastVisitDate()));
    patient.setStatus(patientRequestDTO.getStatus());

    return patient;
}
}
