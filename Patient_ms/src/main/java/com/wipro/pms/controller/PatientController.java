package com.wipro.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.pms.dto.PatientDTO;
import com.wipro.pms.entity.Patient;
import com.wipro.pms.service.IPatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	@Autowired
	IPatientService service;
	
	@GetMapping("/getPatient/{pid}")
	public    Patient   getPatientByid(@PathVariable int pid) {
		return service.getByPid(pid);
	}
	
	@PostMapping("/addPatient")
	public  Patient  addPatient(@RequestBody PatientDTO pt) {
		return service.addPatient(pt);
		
	}
}
