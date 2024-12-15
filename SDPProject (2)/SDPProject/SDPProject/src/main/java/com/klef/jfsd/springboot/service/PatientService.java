
package com.klef.jfsd.springboot.service;

import java.util.List;
import com.klef.jfsd.springboot.model.Patient;

public interface PatientService {
    String patientRegistration(Patient patient);
    
    public String patientlogin(String email,String pwd);
}

