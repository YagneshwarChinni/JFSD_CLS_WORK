package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Doctor;
import com.klef.jfsd.springboot.service.DoctorService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Home page
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    // Doctor Login page
    @GetMapping("doctorlogin")
    public ModelAndView doctorlogin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("doctorlogin");
        return mv;
    }

    // Handling Doctor Login POST request
    @PostMapping("doctorlogin")
    @ResponseBody
    public String doctorlogin(@RequestParam("email") String email, @RequestParam("pwd") String pwd) {
        System.out.println(doctorService.doctorlogin(email, pwd));
        return doctorService.doctorlogin(email, pwd);
    }

    // Show Register Doctor form (GET request)
    @GetMapping("/registerdoctor")
    public String showRegistrationForm() {
        return "registerdoctor"; // This will show the registration form
    }

    // Handling Doctor Registration POST request
    @PostMapping("/registerdoctor")
    public String registerDoctor(Doctor doctor, HttpServletRequest request) {
        String result = doctorService.doctorRegistration(doctor);
        if (result.equals("Registered")) {
            return "redirect:/doctorlogin"; // Redirect to login page after successful registration
        }
        return "doctorlogin"; // In case of failure, show the login page again
    }
}
