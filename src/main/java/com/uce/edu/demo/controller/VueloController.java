package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.service.IVueloService;

@Controller
@RequestMapping("/vuelos")
public class VueloController {

	@Autowired
	private IVueloService iVueloService;

	@GetMapping("/nuevaBusquedaVuelo")
	public String buscarVuelos(Vuelo vuelo) {

		return "vistaNuevaBusquedaVuelo";

	}

	@GetMapping("/buscarVuelos")
	public String buscarVuelosDisponibles(Model modelo, Vuelo vuelo) {

		List<Vuelo> vuelos = this.iVueloService.buscarVueloNuevo(vuelo.getOrigen(), vuelo.getDestino(),
				vuelo.getFechaVuelo());
		modelo.addAttribute("vuelos", vuelos);

		return "vistaVuelosDisponibles";

	}

	@GetMapping("/buscarVuelosReserva")
	public String reservaVuelo(Vuelo vuelo) {

		return "vistaVuelo";

	}

	@GetMapping("/reservarVuelo")
	public String ingresarReserva(Vuelo vuelo, Model modelo) {

		Vuelo vuelo1 = this.iVueloService.buscarVueloNumero(vuelo.getNumero());

		modelo.addAttribute("vuelo1", vuelo1);

		return "vistaReservaVuelo";

	}

}
