package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Patient;
import com.klef.jfsd.springboot.repository.PatientRepository;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public String patientRegistration(Patient patient) {
        try {
            // Check if email already exists
            if (patientRepository.findByEmail(patient.getEmail()) != null) {
                return "Error: Email already exists!";
            }
            // Save patient to the database
            patientRepository.save(patient);
            return "Patient registered successfully!";
        } catch (DataIntegrityViolationException e) {
            return "Error: Data integrity violation - " + e.getMessage();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public String patientlogin(String email, String password) {
        Patient patient = patientRepository.findByEmail(email);
        if (patient != null && patient.getPassword().equals(password)) {
            return "Login successful!";
        } else {
            return "Invalid email or password.";
        }
    }
}
