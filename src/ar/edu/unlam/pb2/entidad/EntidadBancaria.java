package ar.edu.unlam.pb2.entidad;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import ar.edu.unlam.pb2.interfaces.Denunciable;
import ar.edu.unlam.pb2.transacciones.Transaccion;
import ar.edu.unlam.pb2.varios.Cliente;

public class EntidadBancaria {

	private String nombreEntidad;
	private Set<Cliente> conjuntoClientes;
	private Set<Transaccion> conjuntoTransacciones;
	private Set<Denunciable> conjuntoDenunciables;

	public EntidadBancaria(String nombreEntidad) {
		this.nombreEntidad = nombreEntidad;
		this.conjuntoClientes = new HashSet<>();
		this.conjuntoDenunciables = new HashSet<>();
		this.conjuntoTransacciones = new LinkedHashSet<>();
	}

	public Set<Cliente> getConjuntoClientes() {
		return conjuntoClientes;
	}

	public Set<Transaccion> getConjuntoTransacciones() {
		return conjuntoTransacciones;
	}

	public Set<Denunciable> getConjuntoDenunciables() {
		return conjuntoDenunciables;
	}

}
