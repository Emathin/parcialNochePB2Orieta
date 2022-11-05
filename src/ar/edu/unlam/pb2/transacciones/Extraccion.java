package ar.edu.unlam.pb2.transacciones;

import java.util.Set;

import ar.edu.unlam.pb2.dispositivos.Dispositivo;
import ar.edu.unlam.pb2.entidad.EntidadBancaria;
import ar.edu.unlam.pb2.excepciones.FraudeException;
import ar.edu.unlam.pb2.interfaces.Denunciable;
import ar.edu.unlam.pb2.interfaces.Rechazable;
import ar.edu.unlam.pb2.varios.Cliente;

public class Extraccion extends Monetaria implements Rechazable {

	private Boolean bloqueada;
	private Boolean sospechoso;
	private Boolean fueFraude;

	public Extraccion(Cliente cliente, EntidadBancaria entidad, Double monto)
			throws FraudeException {
		this.bloqueada = false;
		this.sospechoso = false;
		this.fueFraude = false;

	}

	@Override
	public void monitorear(Cliente cliente, Dispositivo dispositivo, EntidadBancaria entidad, Double monto)
			throws FraudeException {

		Integer score = 0;

		if (entidad.getConjuntoDenunciables().contains(cliente)) {
			score += 80;
			// 1. Si el CUIT del cliente de la transacción formó parte de un fraude se suma
			// 80 puntos al SCORE.
		}

		if (entidad.getConjuntoDenunciables().contains(dispositivo)) {
			score += 80;
			// 2. Si la dirección IP o IMEI del dispositivo estuvo involucrado en un evento
			// de FRAUDE, se suma 80 puntos al SCORE.
		}

		if (ultimaTransaccion(entidad.getConjuntoTransacciones()) instanceof CambioDeContraseña) {
			score += 80;
			// 3. Si el cliente hizo un cambio de contraseña inmediatamente antes (última
			// operación realizada) a realizar una transacción RECHAZABLE, suma 20 puntos al
			// SCORE.
		}

		if (cliente.getFondos() == monto) {
			score += 40;
			// 4. Si el monto de la TRANSFERENCIA coincide con el total de fondos del
			// cliente (su saldo quedaría en 0) suma 40 puntos al SCORE.
		}

		if (!cliente.getConjuntoDispositivos().contains(dispositivo)) {
			score += 20;
			// 5. Si el cliente está operando desde un dispositivo que nunca utilizó
			// previamente, suma 20 puntos al SCORE.
		}

		if (score > 80) {
			this.bloqueada = true;
			this.fueFraude = true;
			throw new FraudeException();
		} else if (60 <= score && score <= 79) {
			marcarComoCasoSospechoso();
		}

	}

	private Transaccion ultimaTransaccion(Set<Transaccion> conjuntoTransacciones) {
		Transaccion[] array = new Transaccion[conjuntoTransacciones.size()];
		array = conjuntoTransacciones.toArray(array);
		int last = array.length;
		if (last == 0) {
			return null;
		}
		return array[last];

	}

	@Override
	public void marcarComoCasoSospechoso() {
		this.sospechoso = true;
	}

	@Override
	public void confirmarSiFueFraude(Boolean fueFraude, Cliente cliente, Dispositivo movil, EntidadBancaria entidad) {
		if (fueFraude == true) {
			entidad.getConjuntoDenunciables().add(cliente);
			entidad.getConjuntoDenunciables().add(movil);
		}

	}

	@Override
	public void monitorear(Cliente queTransfiereDinero, Cliente queRecibeDinero, Dispositivo deQuienTransfiere,
			Dispositivo deQuienRecibe, EntidadBancaria entidad, Double montoATransferir) throws FraudeException {
		// TODO Auto-generated method stub
		
	}

}
