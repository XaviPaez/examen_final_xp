package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICompraPasajeRepository;
import com.uce.edu.demo.repository.IVueloRepository;
import com.uce.edu.demo.repository.modelo.CompraPasaje;
import com.uce.edu.demo.repository.modelo.Vuelo;

@Service
public class CompraPasajeServiceImpl implements ICompraPasajeService {
	@Autowired
	private ICompraPasajeRepository iCompraPasajeRepository;

	@Autowired
	private IVueloRepository iVueloRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void compraPasaje(Vuelo vuelo, Integer asientosComprados, String numeroTarjeta) {
		// TODO Auto-generated method stub

		List<CompraPasaje> compraPasajes = new ArrayList<CompraPasaje>();

		CompraPasaje comprar = new CompraPasaje();
		comprar.setEstado("DIS");
		comprar.setNumero("123");
		comprar.setFechaCompra(LocalDateTime.now());
		comprar.setNumeroTarjeta(numeroTarjeta);
		comprar.setVuelo(vuelo);

		if (asientosComprados < vuelo.getAsientosDisponibles()) {
			vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles() - asientosComprados);
			comprar.setCantidadAsientosComprados(asientosComprados);

		} else {

			comprar.setCantidadAsientosComprados(vuelo.getAsientosDisponibles());
			vuelo.setAsientosDisponibles(0);
			vuelo.setEstado("ND");
		}

		compraPasajes.add(comprar);
		this.iCompraPasajeRepository.insertarCompra(comprar);

		this.iVueloRepository.actualizar(vuelo);

	}

}
