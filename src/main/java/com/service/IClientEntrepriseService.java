package com.service;

import java.util.List;

import com.model.ClientEntreprise;

public interface IClientEntrepriseService {

	public ClientEntreprise save(ClientEntreprise clientEntreprise);

	public ClientEntreprise update(ClientEntreprise clientEntreprise);

	public void delete(ClientEntreprise clientEntreprise);

	public List<ClientEntreprise> findAll();

	public ClientEntreprise findById(Integer id);

	public ClientEntreprise findByNom(String nom);

}
