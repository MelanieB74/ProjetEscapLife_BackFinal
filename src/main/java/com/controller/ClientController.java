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

import com.model.Client;
import com.service.ClientServiceImpl;
import com.service.IClientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/client")
public class ClientController {

	// ===================== CONFIGURATION =====================
	@Autowired
	IClientService clientService;

	public ClientController(ClientServiceImpl clientServiceImpl) {
		clientService = clientServiceImpl;
	}

	
	// ===================== METHODE CREATE =====================
	@PostMapping(value = "/createClient")
	public Client createClient(@RequestBody Client client) {
		return this.clientService.save(client);
	}

	
	// ===================== METHODE UPDATE =====================
	@PutMapping("/updateClient/{id}")
	public Client updateClient(@RequestBody Client client) {
		return clientService.update(client);
	}

	
	// ===================== METHODE DELETE BY ID =====================
	@DeleteMapping("/deleteById/{id}")
	public void deleteClient(@PathVariable int id) {
		if (clientService.findById(id) != null) {
			clientService.delete(clientService.findById(id));
		}
	}

	
	// ===================== METHODE DELETE BY NOM =====================
	@DeleteMapping("/deleteByNom/{nom}")
	public void deleteClient(@PathVariable String nom) {
		if (clientService.findByNom(nom) != null) {
			clientService.delete(clientService.findByNom(nom));
		}
	}

	
	// ===================== METHODE FIND ALL =====================
	@GetMapping(value = "/all")
	public List<Client> getAllClients() {
		return clientService.findAll();
	}

	
	// ===================== METHODE FIND BY ID =====================
	@GetMapping("/getById/{id}")
	public Client findClientById(@PathVariable int id) {
		if (clientService.findById(id) == null) {
			return null;
		} else {
			return clientService.findById(id);
		}
	}

	
	// ===================== METHODE FIND BY NOM =====================
	@GetMapping("/getByNom/{nom}")
	public Client findClientByNom(@PathVariable String nom) {
		if (clientService.findByNom(nom) == null) {
			return null;
		} else {
			return clientService.findByNom(nom);
		}
	}
	
}