
package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    

    Patient findByEmail(String email);
}
