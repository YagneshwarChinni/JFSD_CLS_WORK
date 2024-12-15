package com.klef.jfsd.springboot.service;

import java.util.List;
import com.klef.jfsd.springboot.model.Doctor;

public interface DoctorService 
{
    
     public String doctorRegistration(Doctor d);
     public String doctorlogin(String email,String pwd);
}
