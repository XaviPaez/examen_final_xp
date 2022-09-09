package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface IVueloRepository {

	public void insertarVuelo(Vuelo vuelo);

	public void actualizar(Vuelo vuelo);
	
	public List<Vuelo> buscarVueloNuevo(String origen, String destino, String fechaVuelo);
	
	public Vuelo buscarVuelo(String numero);
	

	

	
}
