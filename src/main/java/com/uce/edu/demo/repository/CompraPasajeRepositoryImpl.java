package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CompraPasaje;

@Transactional
@Repository
public class CompraPasajeRepositoryImpl implements ICompraPasajeRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarCompra(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		this.entityManager.persist(compraPasaje);
	}

}
