package com.klef.jfsd.springboot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import com.klef.jfsd.springboot.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer>
{
	
	@Query("SELECT d FROM Doctor d WHERE d.email = ?1 AND d.password = ?2")
    public Doctor doctorlogin(String email,String pwd);
}
