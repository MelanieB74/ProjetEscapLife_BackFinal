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

import com.model.ClientEntreprise;
import com.service.ClientEntrepriseServiceImpl;
import com.service.IClientEntrepriseService;

@RestController
@CrossOrigin
@RequestMapping("/clientEntreprise")
public class ClientEntrepriseController {

	// ===================== CONFIGURATION =====================
	@Autowired
	IClientEntrepriseService clientEntService;

	public ClientEntrepriseController(ClientEntrepriseServiceImpl clientEntServiceImpl) {
		clientEntService = clientEntServiceImpl;
	}

	
	// ===================== METHODE CREATE =====================
	@PostMapping(value = "/createClient")
	public ClientEntreprise createClient(@RequestBody ClientEntreprise clientent) {
		return this.clientEntService.save(clientent);
	}

	
	// ===================== METHODE UPDATE =====================
	@PutMapping("/updateClient/{id}")
	public ClientEntreprise updateClient(@RequestBody ClientEntreprise clientent) {
		return clientEntService.update(clientent);
	}

	
	// ===================== METHODE DELETE BY ID =====================
	@DeleteMapping("/deleteById/{id}")
	public void deleteClient(@PathVariable int id) {
		if (clientEntService.findById(id) != null) {
			clientEntService.delete(clientEntService.findById(id));
		}
	}

	
	// ===================== METHODE DELETE BY NOM =====================
	@DeleteMapping("/deleteByNom/{nom}")
	public void deleteClient(@PathVariable String nom) {
		if (clientEntService.findByNom(nom) != null) {
			clientEntService.delete(clientEntService.findByNom(nom));
		}
	}

	
	// ===================== METHODE FIND ALL =====================
	@GetMapping(value = "/all")
	public List<ClientEntreprise> getAllClients() {
		return clientEntService.findAll();
	}

	
	// ===================== METHODE FIND BY ID =====================
	@GetMapping("/getById/{id}")
	public ClientEntreprise findClientById(@PathVariable int id) {
		if (clientEntService.findById(id) == null) {
			return null;
		} else {
			return clientEntService.findById(id);
		}
	}

	
	// ===================== METHODE FIND BY NOM =====================
	@GetMapping("/getByNom/{nom}")
	public ClientEntreprise findClientByNom(@PathVariable String nom) {
		if (clientEntService.findByNom(nom) == null) {
			return null;
		} else {
			return clientEntService.findByNom(nom);
		}
	}
	
}
