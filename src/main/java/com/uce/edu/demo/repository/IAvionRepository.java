package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Avion;

public interface IAvionRepository {

	public void insertarAvion(Avion avion);
	public Avion buscarPorId(Integer id);
}
