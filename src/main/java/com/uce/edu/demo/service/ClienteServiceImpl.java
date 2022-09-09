package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Transactional(value = TxType.REQUIRES_NEW)
	@Override
	public void insertarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepository.insertarCliente(cliente);
	}

}
