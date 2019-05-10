package com.service;

import java.util.List;

import com.model.ActBowling;

public interface IActBowlingService {

	public ActBowling save(ActBowling actBowling);
    
    public ActBowling update(ActBowling actBowling);
    
    public void delete(ActBowling actBowling);
    
    public List<ActBowling> findAll();
    
    public ActBowling findById(Integer id);

	public ActBowling findByPiste(int piste);
    
	
}
