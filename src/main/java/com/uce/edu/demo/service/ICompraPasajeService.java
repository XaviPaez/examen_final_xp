package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface ICompraPasajeService {
	public void compraPasaje(Vuelo vuelo, Integer asientosComprados, String numeroTarjeta);
}
