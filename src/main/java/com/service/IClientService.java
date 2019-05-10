package com.service;

import java.util.List;

import com.model.Client;

public interface IClientService {

	public Client save(Client client);

	public Client update(Client client);

	public void delete(Client client);

	public List<Client> findAll();

	public Client findById(Integer id);

	public Client findByNom(String nom);

}
