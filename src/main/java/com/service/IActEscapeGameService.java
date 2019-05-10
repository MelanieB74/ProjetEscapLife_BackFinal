package com.service;

import java.util.List;

import com.model.ActEscapeGame;

public interface IActEscapeGameService {

	public ActEscapeGame save(ActEscapeGame actEscapeGame);
    
    public ActEscapeGame update(ActEscapeGame actEscapeGame);
    
    public void delete(ActEscapeGame actEscapeGame);
    
    public List<ActEscapeGame> findAll();
    
    public ActEscapeGame findById(Integer id);

	public ActEscapeGame findByMission(String mission);
    
	
}
