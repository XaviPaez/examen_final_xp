package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface IVueloService {

	public void insertarVuelo(Vuelo vuelo);
	
	public Vuelo buscarVueloNumero(String numero);
	
	public List<Vuelo> buscarVueloNuevo(String origen, String destino, String fecha);

}
