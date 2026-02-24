package com.pm.patientservice.dto;

import jakarta.validation.constraints.*;



public class PatientRequestDTO {

    @NotBlank(message = "Firstname is required")
    @Size(max = 100, message = "Firstname cannot exceed 100 characters")
    private String firstname;

    @NotBlank(message = "Lastname is required")
    @Size(max = 100, message = "Lastname cannot exceed 100 characters")
    private String lastname;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be a valid email address")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9+]+$", message = "Phone number must contain only digits and '+'")
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    @Size(max = 255, message = "Address cannot exceed 255 characters")
    private String address;

    @NotBlank(message = "Date of birth is required")
    private String dateOfBirth;

    @NotBlank(message = "Registered date is required")
    private String registeredDate;

    @Size(max = 50, message = "Gender cannot exceed 50 characters")
    private String gender;

    @Size(max = 10, message = "Blood type cannot exceed 10 characters")
    @Pattern(
            regexp = "^(A|B|AB|O)[+-]$",
            message = "Blood type must be A+, A-, B+, B-, AB+, AB-, O+, or O-"
    )
    private String bloodType;

    @Size(max = 255, message = "Emergency contact name cannot exceed 255 characters")
    private String emergencyContactName;

    @Size(max = 20, message = "Emergency contact phone cannot exceed 20 characters")
    @Pattern(
            regexp = "^[0-9+]*$",
            message = "Emergency contact phone must contain only digits and '+'"
    )
    private String emergencyContactPhone;

    @NotNull(message = "Insured status must be specified (true or false)")
    private Boolean insured;

    @Size(max = 255, message = "Insurance provider cannot exceed 255 characters")
    private String insuranceProvider;

    @Size(max = 2000, message = "Medical history cannot exceed 2000 characters")
    private String medicalHistory;

    private String lastVisitDate;

    @Size(max = 50, message = "Status cannot exceed 50 characters")
    private String status;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public Boolean getInsured() {
        return insured;
    }

    public void setInsured(Boolean insured) {
        this.insured = insured;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(String lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
