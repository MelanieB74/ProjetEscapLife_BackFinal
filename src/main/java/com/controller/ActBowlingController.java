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

import com.model.ActBowling;
import com.service.ActBowlingServiceImpl;
import com.service.IActBowlingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/actBowling")
public class ActBowlingController {

	// ===================== CONFIGURATION =====================
	@Autowired
	IActBowlingService actBowlingService;

	public ActBowlingController(ActBowlingServiceImpl actBowlingServiceImpl) {
		actBowlingService = actBowlingServiceImpl;
	}

	
	// ===================== METHODE CREATE =====================
	@PostMapping(value = "/createAct")
	public ActBowling createActBowling(@RequestBody ActBowling actBowling) {
		return this.actBowlingService.save(actBowling);
	}

	
	// ===================== METHODE UPDATE =====================
	@PutMapping("/updateAct/{id}")
	public ActBowling updateActBowling(@RequestBody ActBowling actBowling) {
		return actBowlingService.update(actBowling);
	}

	
	// ===================== METHODE DELETE BY ID =====================
	@DeleteMapping("/deleteById/{id}")
	public void deleteActBowling(@PathVariable int id) {
		if (actBowlingService.findById(id) != null) {
			actBowlingService.delete(actBowlingService.findById(id));
		}
	}

	
	// ===================== METHODE DELETE BY NUMERO PISTE =====================
	@DeleteMapping("/deleteByPiste/{piste}")
	public void deleteActBowlingPiste(@PathVariable int piste) {
		if (actBowlingService.findByPiste(piste) != null) {
			actBowlingService.delete(actBowlingService.findByPiste(piste));
		}
	}

	
	// ===================== METHODE FIND ALL =====================
	@GetMapping(value = "/all")
	public List<ActBowling> getAllActBowlings() {
		return actBowlingService.findAll();
	}

	
	// ===================== METHODE FIND BY ID =====================
	@GetMapping("/getById/{id}")
	public ActBowling findActBowlingById(@PathVariable int id) {
		if (actBowlingService.findById(id) == null) {
			return null;
		} else {
			return actBowlingService.findById(id);
		}
	}

	
	// ===================== METHODE FIND BY NUMERO PISTE =====================
	@GetMapping("/getByPiste/{piste}")
	public ActBowling findActBowlingByNom(@PathVariable int piste) {
		if (actBowlingService.findByPiste(piste) == null) {
			return null;
		} else {
			return actBowlingService.findByPiste(piste);
		}
	}
	

}
