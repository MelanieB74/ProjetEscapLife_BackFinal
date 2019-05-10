package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.ActBowling;
import com.dao.IActBowlingDao;

@Service("serviceActBowling")
public class ActBowlingServiceImpl implements IActBowlingService {
	
	// ===================== CONFIGURATION =====================
	@Autowired
	IActBowlingDao actBowlingDao;

	public ActBowlingServiceImpl(IActBowlingDao actBowlingDao) {
		super();
		this.actBowlingDao = actBowlingDao;
	}
	
	
	// ===================== METHODE CREATE =====================
	@Override
	public ActBowling save(ActBowling actBowling) {
		return actBowlingDao.save(actBowling);
	}
	
	
	// ===================== METHODE UPDATE =====================
	@Override
	public ActBowling update(ActBowling actBowling) {
		return this.actBowlingDao.save(actBowling);
	}
	
	
	// ===================== METHODE DELETE =====================
	@Override
	public void delete(ActBowling actBowling) {
		actBowlingDao.delete(actBowling);
	}
	
	
	// ===================== METHODE FIND ALL =====================
	@Override
	public List<ActBowling> findAll() {
		return actBowlingDao.findAll();
	}
	
	
	// ===================== METHODE FIND BY ID =====================
	@Override
	public ActBowling findById(Integer id) {
		Optional<ActBowling> actBowling = actBowlingDao.findById(id);
		return (actBowling == null ? null : actBowling.orElse(null));
	}
	
	
	// ===================== METHODE FIND BY NUMERO PISTE =====================
	@Override
	public ActBowling findByPiste(int piste) {
		return actBowlingDao.findByPiste(piste);
	}

}
