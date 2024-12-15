package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Doctor;
import com.klef.jfsd.springboot.repository.DoctorRepository;

import jakarta.transaction.Transactional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public String doctorRegistration(Doctor d) {
        doctorRepository.save(d);
        return "Registered";
    }

    @Override
    public String doctorlogin(String email, String pwd) {
        Doctor d = doctorRepository.doctorlogin(email, pwd);
        if (d != null)
            return "Doctor Logged in";
        return "Doctor login fail";
    }
}
