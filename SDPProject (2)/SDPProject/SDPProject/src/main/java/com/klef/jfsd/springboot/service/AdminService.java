package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Doctor;

public interface AdminService 
{

 public Admin checkadminlogin(String uname,String pwd);
 public List<Doctor> viewdoctors();
 

}