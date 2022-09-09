package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVueloRepository;
import com.uce.edu.demo.repository.modelo.Vuelo;

@Service
public class VueloServiceImpl implements IVueloService {

	@Autowired
	private IVueloRepository iVueloRepository;
	
	@Transactional(value = TxType.REQUIRES_NEW)
	@Override
	public void insertarVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.iVueloRepository.insertarVuelo(vuelo);
	}

	@Override
	public Vuelo buscarVueloNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iVueloRepository.buscarVuelo(numero);
	}

	@Override
	public List<Vuelo> buscarVueloNuevo(String origen, String destino, String fecha) {
		// TODO Auto-generated method stub
		return this.iVueloRepository.buscarVueloNuevo(origen, destino, fecha);
	}

}
