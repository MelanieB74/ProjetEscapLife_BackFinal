package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Employe;
import com.model.Utilisateur;
import com.dao.IEmployeDao;

@Service("serviceEmploye")
public class EmployeServiceImpl implements IEmployeService {
	
	// ===================== CONFIGURATION =====================
	@Autowired
	IEmployeDao employeDao;

	public EmployeServiceImpl(IEmployeDao employeDao) {
		super();
		this.employeDao = employeDao;
	}
	
	
	// ===================== METHODE CREATE =====================
	@Override
	public Employe save(Employe employe) {
//		Utilisateur ut = employe.getUtilisateur();
//		employe.setUtilisateur(ut);
		return employeDao.save(employe);
	}
	
	
	// ===================== METHODE UPDATE =====================
	@Override
	public Employe update(Employe employe) {
		return this.employeDao.save(employe);
	}
	
	
	// ===================== METHODE DELETE =====================
	@Override
	public void delete(Employe employe) {
		employeDao.delete(employe);
	}
	
	
	// ===================== METHODE FIND ALL =====================
	@Override
	public List<Employe> findAll() {
		return employeDao.findAll();
	}
	
	
	// ===================== METHODE FIND BY ID =====================
	@Override
	public Employe findById(Integer id) {
		Optional<Employe> employe = employeDao.findById(id);
		return (employe == null ? null : employe.orElse(null));
	}
	
	
	// ===================== METHODE FIND BY NOM =====================
	@Override
	public Employe findByNom(String nom) {
		return employeDao.findByNom(nom);
	}

}
