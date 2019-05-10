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

import com.model.ActLaserGame;
import com.service.ActLaserGameServiceImpl;
import com.service.IActLaserGameService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/actLaserGame")
public class ActLaserGameController {

	// ===================== CONFIGURATION =====================
	@Autowired
	IActLaserGameService actLaserGameService;

	public ActLaserGameController(ActLaserGameServiceImpl actLaserGameServiceImpl) {
		actLaserGameService = actLaserGameServiceImpl;
	}

	
	// ===================== METHODE CREATE =====================
	@PostMapping(value = "/createAct")
	public ActLaserGame createActLaserGame(@RequestBody ActLaserGame actLaserGame) {
		return this.actLaserGameService.save(actLaserGame);
	}

	
	// ===================== METHODE UPDATE =====================
	@PutMapping("/updateAct/{id}")
	public ActLaserGame updateActLaserGame(@RequestBody ActLaserGame actLaserGame) {
		return actLaserGameService.update(actLaserGame);
	}

	
	// ===================== METHODE DELETE BY ID =====================
	@DeleteMapping("/deleteById/{id}")
	public void deleteActLaserGame(@PathVariable int id) {
		if (actLaserGameService.findById(id) != null) {
			actLaserGameService.delete(actLaserGameService.findById(id));
		}
	}

	
	// ===================== METHODE DELETE BY THEME =====================
	@DeleteMapping("/deleteByTheme/{theme}")
	public void deleteActLaserGame(@PathVariable String theme) {
		if (actLaserGameService.findByTheme(theme) != null) {
			actLaserGameService.delete(actLaserGameService.findByTheme(theme));
		}
	}

	
	// ===================== METHODE FIND ALL =====================
	@GetMapping(value = "/all")
	public List<ActLaserGame> getAllActLaserGames() {
		return actLaserGameService.findAll();
	}

	
	// ===================== METHODE FIND BY ID =====================
	@GetMapping("/getById/{id}")
	public ActLaserGame findActLaserGameById(@PathVariable int id) {
		if (actLaserGameService.findById(id) == null) {
			return null;
		} else {
			return actLaserGameService.findById(id);
		}
	}

	
	// ===================== METHODE FIND BY THEME =====================
	@GetMapping("/getByTheme/{theme}")
	public ActLaserGame findActLaserGameByNom(@PathVariable String theme) {
		if (actLaserGameService.findByTheme(theme) == null) {
			return null;
		} else {
			return actLaserGameService.findByTheme(theme);
		}
	}
	

}
