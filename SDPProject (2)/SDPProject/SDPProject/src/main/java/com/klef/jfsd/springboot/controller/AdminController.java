package com.klef.jfsd.springboot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Doctor;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.DoctorService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DoctorService doctorService;
	
	
	
	@GetMapping("adminhome")
	public ModelAndView adminhome() 
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminhome");
		return mv;
	}
	@GetMapping("adminlogin")
	public ModelAndView adminlogin() 
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminlogin");
		
		
		
		return mv;
	}
	
	@PostMapping("checkadminlogin")
	@ResponseBody
	public String checkadminlogin(@RequestParam String suname,@RequestParam String apwd)
	{
		
		Admin admin = adminService.checkadminlogin(suname, apwd);
		if(admin!=null)
			return "Logged in successfully";
		return "Login Failed";
	}
	
	@PostMapping("doctorregistration")
	@ResponseBody
	public String doctorregistration(@RequestBody Doctor d)
	{
		return doctorService.doctorRegistration(d);
	}
	
	@GetMapping("viewdoctors")
	@ResponseBody
	public List<Doctor> viewdoctors()
	{
		return adminService.viewdoctors();
	}
	
	
	

	
	
	

}
