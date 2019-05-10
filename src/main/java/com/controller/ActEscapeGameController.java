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

import com.model.ActEscapeGame;
import com.service.ActEscapeGameServiceImpl;
import com.service.IActEscapeGameService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/actEscapeGame")
public class ActEscapeGameController {

	// ===================== CONFIGURATION =====================
	@Autowired
	IActEscapeGameService actEscapeGameService;

	public ActEscapeGameController(ActEscapeGameServiceImpl actEscapeGameServiceImpl) {
		actEscapeGameService = actEscapeGameServiceImpl;
	}

	
	// ===================== METHODE CREATE =====================
	@PostMapping(value = "/createAct")
	public ActEscapeGame createActEscapeGame(@RequestBody ActEscapeGame actEscapeGame) {
		return this.actEscapeGameService.save(actEscapeGame);
	}

	
	// ===================== METHODE UPDATE =====================
	@PutMapping("/updateAct/{id}")
	public ActEscapeGame updateActEscapeGame(@RequestBody ActEscapeGame actEscapeGame) {
		return actEscapeGameService.update(actEscapeGame);
	}

	
	// ===================== METHODE DELETE BY ID =====================
	@DeleteMapping("/deleteById/{id}")
	public void deleteActEscapeGame(@PathVariable int id) {
		if (actEscapeGameService.findById(id) != null) {
			actEscapeGameService.delete(actEscapeGameService.findById(id));
		}
	}

	
	// ===================== METHODE DELETE BY MISSION =====================
	@DeleteMapping("/deleteByMission/{mission}")
	public void deleteActEscapeGame(@PathVariable String mission) {
		if (actEscapeGameService.findByMission(mission) != null) {
			actEscapeGameService.delete(actEscapeGameService.findByMission(mission));
		}
	}

	
	// ===================== METHODE FIND ALL =====================
	@GetMapping(value = "/all")
	public List<ActEscapeGame> getAllActEscapeGames() {
		return actEscapeGameService.findAll();
	}

	
	// ===================== METHODE FIND BY ID =====================
	@GetMapping("/getById/{id}")
	public ActEscapeGame findActEscapeGameById(@PathVariable int id) {
		if (actEscapeGameService.findById(id) == null) {
			return null;
		} else {
			return actEscapeGameService.findById(id);
		}
	}

	
	// ===================== METHODE FIND BY MISSION =====================
	@GetMapping("/getByMission/{mission}")
	public ActEscapeGame findActEscapeGameByNom(@PathVariable String mission) {
		if (actEscapeGameService.findByMission(mission) == null) {
			return null;
		} else {
			return actEscapeGameService.findByMission(mission);
		}
	}
	

}
