package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.ActLaserGame;
import com.dao.IActLaserGameDao;

@Service("serviceActLaserGame")
public class ActLaserGameServiceImpl implements IActLaserGameService {
	
	// ===================== CONFIGURATION =====================
	@Autowired
	IActLaserGameDao actLaserGameDao;

	public ActLaserGameServiceImpl(IActLaserGameDao actLaserGameDao) {
		super();
		this.actLaserGameDao = actLaserGameDao;
	}
	
	
	// ===================== METHODE CREATE =====================
	@Override
	public ActLaserGame save(ActLaserGame actLaserGame) {
		return actLaserGameDao.save(actLaserGame);
	}
	
	
	// ===================== METHODE UPDATE =====================
	@Override
	public ActLaserGame update(ActLaserGame actLaserGame) {
		return this.actLaserGameDao.save(actLaserGame);
	}
	
	
	// ===================== METHODE DELETE =====================
	@Override
	public void delete(ActLaserGame actLaserGame) {
		actLaserGameDao.delete(actLaserGame);
	}
	
	
	// ===================== METHODE FIND ALL =====================
	@Override
	public List<ActLaserGame> findAll() {
		return actLaserGameDao.findAll();
	}
	
	
	// ===================== METHODE FIND BY ID =====================
	@Override
	public ActLaserGame findById(Integer id) {
		Optional<ActLaserGame> actLaserGame = actLaserGameDao.findById(id);
		return (actLaserGame == null ? null : actLaserGame.orElse(null));
	}
	
	
	// ===================== METHODE FIND BY THEME =====================
	@Override
	public ActLaserGame findByTheme(String theme) {
		return actLaserGameDao.findByTheme(theme);
	}

}
