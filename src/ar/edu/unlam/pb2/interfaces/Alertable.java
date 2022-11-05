package ar.edu.unlam.pb2.interfaces;

import ar.edu.unlam.pb2.dispositivos.Dispositivo;
import ar.edu.unlam.pb2.entidad.EntidadBancaria;
import ar.edu.unlam.pb2.varios.Cliente;

public interface Alertable {
	
	public void marcarComoCasoSospechoso();
	
	void confirmarSiFueFraude(Boolean fueFraude, Cliente cliente, Dispositivo movil, EntidadBancaria entidad);
	
}
