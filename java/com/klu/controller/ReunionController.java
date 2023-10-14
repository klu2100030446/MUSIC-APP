package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.entity.Reunion;
import com.klu.model.ReunionDeleteData;
import com.klu.model.ReunionManager;
import com.klu.model.ReunionReadData;
import com.klu.model.ReunionUpdate;

@RestController
@RequestMapping("/reunionlab")
public class ReunionController {
	@Autowired
	ReunionManager rm;
	@Autowired
	ReunionUpdate ru;
	@Autowired
	ReunionDeleteData rd;
	@Autowired
	ReunionReadData rr;
	@PostMapping("/register")
	public String register(@RequestBody Reunion r1) {
		return rm.registration(r1);	
	}
	@PutMapping("/update/{id}/{amount}")
	public String updatestatus(@PathVariable("id") long id,@PathVariable("amount") int amount) {
		return ru.updatepaymentStatus(id, amount);
		
	}
	@DeleteMapping("/delete/{id}")
	public String cancelRegistration(@PathVariable("id") long id) {
		return rd.deleteData(id);
		
	}
	@GetMapping("/read")
	public String read() {
		return rr.readData().toString();
		
	}
	

}
