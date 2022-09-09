package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Cliente;

@Transactional
@Repository
public class ClienteRepositoryImpl implements IClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(value = TxType.MANDATORY)
	@Override
	public void insertarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

}
