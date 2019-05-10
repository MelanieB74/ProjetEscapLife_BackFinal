package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Reservation;
import com.dao.IReservationDao;

@Service("serviceReservation")
public class ReservationServiceImpl implements IReservationService {
	
	// ===================== CONFIGURATION =====================
	@Autowired
	IReservationDao reservationDao;

	public ReservationServiceImpl(IReservationDao reservationDao) {
		super();
		this.reservationDao = reservationDao;
	}
	
	
	// ===================== METHODE CREATE =====================
	@Override
	public Reservation save(Reservation reservation) {
		return reservationDao.save(reservation);
	}
	
	
	// ===================== METHODE UPDATE =====================
	@Override
	public Reservation update(Reservation reservation) {
		return this.reservationDao.save(reservation);
	}
	
	
	// ===================== METHODE DELETE =====================
	@Override
	public void delete(Reservation reservation) {
		reservationDao.delete(reservation);
	}
	
	
	// ===================== METHODE FIND ALL =====================
	@Override
	public List<Reservation> findAll() {
		return reservationDao.findAll();
	}
	
	
	// ===================== METHODE FIND BY ID =====================
	@Override
	public Reservation findById(Integer id) {
		Optional<Reservation> reservation = reservationDao.findById(id);
		return (reservation == null ? null : reservation.orElse(null));
	}
	
	
	// ===================== METHODE FIND BY DATE =====================
	@Override
	public Reservation findByDate(String date) {
		return reservationDao.findByDate(date);
	}
	
	
//	// ===================== METHODE FIND BY HEURE =====================
//	@Override
//	public Reservation findByHeure(String date, String heure) {
//		return reservationDao.findByHeure(date, heure);
//	}

}
