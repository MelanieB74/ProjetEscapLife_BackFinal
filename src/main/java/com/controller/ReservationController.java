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

import com.model.Reservation;
import com.service.ReservationServiceImpl;
import com.service.IReservationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reservation")
public class ReservationController {

	// ===================== CONFIGURATION =====================
	@Autowired
	IReservationService reservationService;

	public ReservationController(ReservationServiceImpl reservationServiceImpl) {
		reservationService = reservationServiceImpl;
	}

	
	// ===================== METHODE CREATE =====================
	@PostMapping(value = "/createReserv")
	public Reservation createReservation(@RequestBody Reservation reservation) {
		return this.reservationService.save(reservation);
	}

	
	// ===================== METHODE UPDATE =====================
	@PutMapping("/updateReserv/{id}")
	public Reservation updateReservation(@RequestBody Reservation reservation) {
		return reservationService.update(reservation);
	}

	
	// ===================== METHODE DELETE BY ID =====================
	@DeleteMapping("/deleteById/{id}")
	public void deleteReservation(@PathVariable int id) {
		if (reservationService.findById(id) != null) {
			reservationService.delete(reservationService.findById(id));
		}
	}

	
	// ===================== METHODE DELETE BY DATE =====================
	@DeleteMapping("/deleteByDate/{date}")
	public void deleteReservation(@PathVariable String date) {
		if (reservationService.findByDate(date) != null) {
			reservationService.delete(reservationService.findByDate(date));
		}
	}
	
	
	// ===================== METHODE DELETE BY HEURE =====================
//	@DeleteMapping("/deleteByHeure/{heure}")
//	public void deleteReservationHeure(@PathVariable String date, String heure) {
//		if (reservationService.findByHeure(date, heure) != null) {
//			reservationService.delete(reservationService.findByHeure(date, heure));
//		}
//	}

	
	// ===================== METHODE FIND ALL =====================
	@GetMapping(value = "/all")
	public List<Reservation> getAllReservations() {
		return reservationService.findAll();
	}

	
	// ===================== METHODE FIND BY ID =====================
	@GetMapping("/getById/{id}")
	public Reservation findReservationById(@PathVariable int id) {
		if (reservationService.findById(id) == null) {
			return null;
		} else {
			Reservation res = reservationService.findById(id);
			System.out.println(res.getActivite());
			return reservationService.findById(id);
		}
	}

	
	// ===================== METHODE FIND BY DATE =====================
		@GetMapping("/getByDate/{date}")
		public Reservation findReservationByDate(@PathVariable String date) {
			if (reservationService.findByDate(date) == null) {
				return null;
			} else {
				return reservationService.findByDate(date);
			}
		}
	
	
	// ===================== METHODE FIND BY HEURE =====================
//	@GetMapping("/getByHeure/{heure}")
//	public Reservation findReservationByHeure(@RequestBody Reservation Reservation, @PathVariable String date, String heure) {
//		if (reservationService.findByHeure(date, heure) == null) {
//			return null;
//		} else {
//			return reservationService.findByHeure(date, heure);
//		}
//	}
	

}
