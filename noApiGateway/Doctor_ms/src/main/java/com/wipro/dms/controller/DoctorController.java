package com.wipro.dms.controller;

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

import com.wipro.dms.dto.DoctorDTO;
import com.wipro.dms.entity.Doctor;
import com.wipro.dms.service.IDoctorService;


@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	@Autowired
	IDoctorService service;
	
	@PostMapping("/bookDoctor")
	public  Doctor  addDoctor(@RequestBody DoctorDTO doc) {
		return service.addDoctor(doc);
		
	}
	
	@GetMapping("/getDoctor/{did}")
	public    Doctor   getDoctorByid(@PathVariable int did) {
		return service.getByDoctorid(did);
	}
}
