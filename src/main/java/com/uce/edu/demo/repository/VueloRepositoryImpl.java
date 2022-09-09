package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Vuelo;

@Transactional
@Repository
public class VueloRepositoryImpl implements IVueloRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(value = TxType.MANDATORY)
	@Override
	public void insertarVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vuelo);
	}
	
	@Override
	public List<Vuelo> buscarVueloNuevo(String origen, String destino, String fechaVuelo) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo> myQuery = this.entityManager.createQuery(
				"SELECT v FROM Vuelo v JOIN v.avion a WHERE v.origen= :datoOrigen AND v.destino= :datoDestino AND v.fechaVuelo= :datoFecha",
				Vuelo.class);

		myQuery.setParameter("datoOrigen", origen);
		myQuery.setParameter("datoDestino", destino);
		myQuery.setParameter("datoFecha", fechaVuelo);

		return myQuery.getResultList();
		
		
		

	}

	@Override
	public Vuelo buscarVuelo(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo> myQuery = this.entityManager
				.createQuery("SELECT v FROM Vuelo v WHERE v.numero = :datoNumero AND v.estado = :datoEstado ", Vuelo.class);

		myQuery.setParameter("datoNumero", numero);
		myQuery.setParameter("datoEstado", "DIS");

		return myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vuelo);
	}

}
