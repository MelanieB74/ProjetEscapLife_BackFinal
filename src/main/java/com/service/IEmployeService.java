package com.service;

import java.util.List;

import com.model.Employe;

public interface IEmployeService {

	public Employe save(Employe employe);

	public Employe update(Employe employe);

	public void delete(Employe employe);

	public List<Employe> findAll();

	public Employe findById(Integer id);

	public Employe findByNom(String nom);

}
