package ar.edu.unlam.pb2.interfaces;

import java.util.Set;

import ar.edu.unlam.pb2.dispositivos.Dispositivo;
import ar.edu.unlam.pb2.entidad.EntidadBancaria;
import ar.edu.unlam.pb2.excepciones.FraudeException;
import ar.edu.unlam.pb2.transacciones.Transaccion;
import ar.edu.unlam.pb2.varios.Cliente;

public interface Rechazable {

	void monitorear(Cliente cliente, Dispositivo dispositivo,EntidadBancaria entidad, Double monto) throws FraudeException;

	void monitorear(Cliente queTransfiereDinero, Cliente queRecibeDinero, Dispositivo deQuienTransfiere,
			Dispositivo deQuienRecibe, EntidadBancaria entidad, Double montoATransferir) throws FraudeException;
	
}
