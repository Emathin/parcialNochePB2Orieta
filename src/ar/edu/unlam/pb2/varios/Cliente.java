package ar.edu.unlam.pb2.varios;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import ar.edu.unlam.pb2.dispositivos.Dispositivo;
import ar.edu.unlam.pb2.interfaces.Denunciable;

public class Cliente implements Denunciable {
	private String nombreCliente;
	private String cuit;
	private Set<Dispositivo> conjuntoDispositivos;
	private Double fondos;

	public Cliente(String nombreCliente, String cuit) {
		this.nombreCliente = nombreCliente;
		this.cuit = cuit;
		this.conjuntoDispositivos = new HashSet<>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cuit, other.cuit);
	}

	public Double getFondos() {
		return fondos;
	}

	public Set<Dispositivo> getConjuntoDispositivos() {
		return conjuntoDispositivos;
	}

	public void agregarDispositivo(Dispositivo dispositivo) {
		this.conjuntoDispositivos.add(dispositivo);
	}
	
	public Dispositivo buscarDispositivo(Dispositivo dispositivoRecibido) {
		for (Dispositivo dispositivo : conjuntoDispositivos) {
			if(dispositivo.equals(dispositivoRecibido))
				return dispositivo;
		}
		return null;
	}

}
