package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Client;
import com.dao.IClientDao;

@Service("serviceClient")
public class ClientServiceImpl implements IClientService {
	
	// ===================== CONFIGURATION =====================
	@Autowired
	IClientDao clientDao;

	public ClientServiceImpl(IClientDao clientDao) {
		super();
		this.clientDao = clientDao;
	}
	
	
	// ===================== METHODE CREATE =====================
	@Override
	public Client save(Client client) {
		return clientDao.save(client);
	}
	
	
	// ===================== METHODE UPDATE =====================
	@Override
	public Client update(Client client) {
		return this.clientDao.save(client);
	}
	
	
	// ===================== METHODE DELETE =====================
	@Override
	public void delete(Client client) {
		clientDao.delete(client);
	}
	
	
	// ===================== METHODE FIND ALL =====================
	@Override
	public List<Client> findAll() {
		return clientDao.findAll();
	}
	
	
	// ===================== METHODE FIND BY ID =====================
	@Override
	public Client findById(Integer id) {
		Optional<Client> client = clientDao.findById(id);
		return (client == null ? null : client.orElse(null));
	}
	
	
	// ===================== METHODE FIND BY NOM =====================
	@Override
	public Client findByNom(String nom) {
		return clientDao.findByNom(nom);
	}

}
