package com.service;

import java.util.List;

import com.model.Reservation;

public interface IReservationService {

	public Reservation save(Reservation Reservation);
    
    public Reservation update(Reservation Reservation);
    
    public void delete(Reservation Reservation);
    
    public List<Reservation> findAll();
    
    public Reservation findById(Integer id);

	public Reservation findByDate(String date);
	
//	public Reservation findByHeure(String date, String heure);
    
	
}
