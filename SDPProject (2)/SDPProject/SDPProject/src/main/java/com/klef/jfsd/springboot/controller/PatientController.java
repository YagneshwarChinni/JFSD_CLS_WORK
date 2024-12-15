package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Patient;
import com.klef.jfsd.springboot.service.PatientService;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("patientreg")
    public ModelAndView patientreg() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("patientregistration");
        return mv;
    }

    @GetMapping("patientlogin")
    public ModelAndView patientlogin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("patientlogin");
        return mv;
    }

    @PostMapping("patientregistration")
    @ResponseBody
    public String patientRegistration(@RequestBody Patient p) {
        return patientService.patientRegistration(p);
    }

    @PostMapping("patientlogin")
    @ResponseBody
    public String patientLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
        String patient = patientService.patientlogin(email, password);
        if (patient != null) {
            return "Login successful!";
        } else {
            return "Invalid email or password.";
        }
    }

    @GetMapping("about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("about");
        return mv;
    }

    @GetMapping("services")
    public ModelAndView services() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("services");
        return mv;
    }
    
    @GetMapping("contactus")
    public ModelAndView contactus() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("contactus");
        return mv;
    }
   

}
