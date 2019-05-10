package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employe;
import com.service.EmployeServiceImpl;
import com.service.IEmployeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employe")
public class EmployeController {

	// ===================== CONFIGURATION =====================
	@Autowired
	IEmployeService employeService;

	public EmployeController(EmployeServiceImpl employeServiceImpl) {
		employeService = employeServiceImpl;
	}

	
	// ===================== METHODE CREATE =====================
	@PostMapping(value = "/createEmploye")
	public Employe createEmploye(@RequestBody Employe employe) {
		return this.employeService.save(employe);
	}

	
	// ===================== METHODE UPDATE =====================
	@PutMapping("/updateEmploye/{id}")
	public Employe updateEmploye(@RequestBody Employe employe) {
		return employeService.update(employe);
	}

	
	// ===================== METHODE DELETE BY ID =====================
	@DeleteMapping("/deleteById/{id}")
	public void deleteEmployeById(@PathVariable int id) {
		if (employeService.findById(id) != null) {
			employeService.delete(employeService.findById(id));
		}
	}

	
	// ===================== METHODE DELETE BY NOM =====================
	@DeleteMapping("/deleteByNom/{nom}")
	public void deleteEmployeByNom(@PathVariable String nom) {
		if (employeService.findByNom(nom) != null) {
			employeService.delete(employeService.findByNom(nom));
		}
	}

	
	// ===================== METHODE FIND ALL =====================
	@GetMapping(value = "/all")
	public List<Employe> getAllEmployes() {
		return employeService.findAll();
	}

	
	// ===================== METHODE FIND BY ID =====================
	@GetMapping("/getById/{id}")
	public Employe findEmployeById(@PathVariable int id) {
		if (employeService.findById(id) == null) {
			return null;
		} else {
			return employeService.findById(id);
		}
	}

	
	// ===================== METHODE FIND BY NOM =====================
	@GetMapping("/getByNom/{nom}")
	public Employe findEmployeByNom(@PathVariable String nom) {
		if (employeService.findByNom(nom) == null) {
			return null;
		} else {
			return employeService.findByNom(nom);
		}
	}
	
}
