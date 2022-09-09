package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IAvionRepository;
import com.uce.edu.demo.repository.modelo.Avion;

@Service
public class AvionServiceImpl implements IAvionService{

	@Autowired
	private IAvionRepository avionRepository;
	
	@Transactional(value = TxType.REQUIRES_NEW)
	@Override
	public void insertarAvion(Avion avion) {
		// TODO Auto-generated method stub
		this.avionRepository.insertarAvion(avion);
	}

}
