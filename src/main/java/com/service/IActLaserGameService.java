package com.service;

import java.util.List;

import com.model.ActLaserGame;

public interface IActLaserGameService {

	public ActLaserGame save(ActLaserGame actLaserGame);
    
    public ActLaserGame update(ActLaserGame actLaserGame);
    
    public void delete(ActLaserGame actLaserGame);
    
    public List<ActLaserGame> findAll();
    
    public ActLaserGame findById(Integer id);

	public ActLaserGame findByTheme(String theme);
    
	
}
