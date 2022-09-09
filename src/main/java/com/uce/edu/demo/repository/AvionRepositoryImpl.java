package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Avion;

@Repository
@Transactional
public class AvionRepositoryImpl implements IAvionRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(value = TxType.MANDATORY)
	@Override
	public void insertarAvion(Avion avion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(avion);
	}
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Avion buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Avion.class, id);
	}

}
