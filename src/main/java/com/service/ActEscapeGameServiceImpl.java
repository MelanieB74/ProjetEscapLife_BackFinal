package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.ActEscapeGame;
import com.dao.IActEscapeGameDao;

@Service("serviceActEscapeGame")
public class ActEscapeGameServiceImpl implements IActEscapeGameService {
	
	// ===================== CONFIGURATION =====================
	@Autowired
	IActEscapeGameDao actEscapeGameDao;

	public ActEscapeGameServiceImpl(IActEscapeGameDao actEscapeGameDao) {
		super();
		this.actEscapeGameDao = actEscapeGameDao;
	}
	
	
	// ===================== METHODE CREATE =====================
	@Override
	public ActEscapeGame save(ActEscapeGame actEscapeGame) {
		return actEscapeGameDao.save(actEscapeGame);
	}
	
	
	// ===================== METHODE UPDATE =====================
	@Override
	public ActEscapeGame update(ActEscapeGame actEscapeGame) {
		return this.actEscapeGameDao.save(actEscapeGame);
	}
	
	
	// ===================== METHODE DELETE =====================
	@Override
	public void delete(ActEscapeGame actEscapeGame) {
		actEscapeGameDao.delete(actEscapeGame);
	}
	
	
	// ===================== METHODE FIND ALL =====================
	@Override
	public List<ActEscapeGame> findAll() {
		return actEscapeGameDao.findAll();
	}
	
	
	// ===================== METHODE FIND BY ID =====================
	@Override
	public ActEscapeGame findById(Integer id) {
		Optional<ActEscapeGame> actEscapeGame = actEscapeGameDao.findById(id);
		return (actEscapeGame == null ? null : actEscapeGame.orElse(null));
	}
	
	
	// ===================== METHODE FIND BY MISSION =====================
	@Override
	public ActEscapeGame findByMission(String mission) {
		return actEscapeGameDao.findByMission(mission);
	}

}
