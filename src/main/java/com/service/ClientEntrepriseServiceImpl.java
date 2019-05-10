package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.ClientEntreprise;
import com.dao.IClientEntrepriseDao;

@Service
public class ClientEntrepriseServiceImpl implements IClientEntrepriseService {
	
	// ===================== CONFIGURATION =====================
	@Autowired
	IClientEntrepriseDao clientEntrepriseDao;

	public ClientEntrepriseServiceImpl(IClientEntrepriseDao clientEntrepriseDao) {
		super();
		this.clientEntrepriseDao = clientEntrepriseDao;
	}
	
	
	// ===================== METHODE CREATE =====================
	@Override
	public ClientEntreprise save(ClientEntreprise clientEntreprise) {
		return clientEntrepriseDao.save(clientEntreprise);
	}

	
	// ===================== METHODE UPDATE =====================
	@Override
	public ClientEntreprise update(ClientEntreprise clientEntreprise) {
		return this.clientEntrepriseDao.save(clientEntreprise);
	}
	
	
	// ===================== METHODE DELETE =====================
	@Override
	public void delete(ClientEntreprise clientEntreprise) {
		clientEntrepriseDao.delete(clientEntreprise);
	}
	
	
	// ===================== METHODE FIND ALL =====================
	@Override
	public List<ClientEntreprise> findAll() {
		return clientEntrepriseDao.findAll();
	}
	
	
	// ===================== METHODE FIND BY ID =====================
	@Override
	public ClientEntreprise findById(Integer id) {
		Optional<ClientEntreprise> clientEntreprise = clientEntrepriseDao.findById(id);
		return (clientEntreprise == null ? null : clientEntreprise.orElse(null));
	}
	
	
	// ===================== METHODE FIND BY NOM =====================
	@Override
	public ClientEntreprise findByNom(String nom) {
		return clientEntrepriseDao.findByNom(nom);
	}

}
