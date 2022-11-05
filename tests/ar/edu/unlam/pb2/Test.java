package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Set;

import ar.edu.unlam.pb2.dispositivos.Dispositivo;
import ar.edu.unlam.pb2.dispositivos.Movil;
import ar.edu.unlam.pb2.dispositivos.PC;
import ar.edu.unlam.pb2.entidad.EntidadBancaria;
import ar.edu.unlam.pb2.excepciones.FraudeException;
import ar.edu.unlam.pb2.interfaces.Denunciable;
import ar.edu.unlam.pb2.transacciones.Extraccion;
import ar.edu.unlam.pb2.transacciones.PagoQR;
import ar.edu.unlam.pb2.transacciones.Transaccion;
import ar.edu.unlam.pb2.transacciones.Transferencia;
import ar.edu.unlam.pb2.varios.Cliente;
import ar.edu.unlam.pb2.varios.TipoRegistro;

public class Test {

	@org.junit.Test
	public void queSePuedaCrearUnCliente() {

		Cliente cliente1 = new Cliente("Raul", "23441583249");

	}

	@org.junit.Test
	public void queSePuedaCrearUnDispositivo() {
		Dispositivo pc = new PC("Windows", "192.168.10.25", "San Justo");
		Dispositivo movil = new Movil("Android", "192.168.10.58", "Merlo", 159357, TipoRegistro.huella);
	}

	@org.junit.Test()
	public void queSePuedaMonitorearUnaExtraccion() throws FraudeException {
		Cliente cliente1 = new Cliente("Ernesto", "23441583249");
		Dispositivo movil1 = new Movil("Android", "192.168.10.58", "Merlo", 159357, TipoRegistro.huella);
		EntidadBancaria entidad1 = new EntidadBancaria("El ciudad");
		cliente1.agregarDispositivo(movil1);

		Extraccion extraccion = new Extraccion(cliente1, entidad1, 5000.00);
		extraccion.monitorear(cliente1, movil1, entidad1, 5000.00);

	}

	@org.junit.Test
	public void queSePuedaMonitorearUnaTransferencia() throws FraudeException {
		Cliente cliente1 = new Cliente("Ernesto", "23441583249");
		Cliente cliente2 = new Cliente("Roberto", "15468412346");

		Dispositivo movil1 = new Movil("Android", "192.168.10.58", "Merlo", 159357, TipoRegistro.huella);
		Dispositivo pc1 = new PC("Android", "192.168.10.58", "Merlo");

		EntidadBancaria entidad1 = new EntidadBancaria("El ciudad");
		
		cliente1.agregarDispositivo(movil1);
		cliente2.agregarDispositivo(pc1);

		Transferencia transferencia = new Transferencia(cliente1, cliente2, entidad1, 5000.00);
		transferencia.monitorear(cliente1, cliente2,movil1,pc1, entidad1, 5000.00);

	}

	@org.junit.Test
	public void queSePuedaMonitorearUnPagoConQR() throws FraudeException {
		
		Cliente cliente1 = new Cliente("Ernesto", "23441583249");
		Cliente cliente2 = new Cliente("Roberto", "15468412346");
		
		Dispositivo movil1 = new Movil("Android", "192.168.10.58", "Merlo", 159357, TipoRegistro.huella);
		Dispositivo pc1 = new PC("Android", "192.168.10.58", "Merlo");
		
		EntidadBancaria entidad1 = new EntidadBancaria("El ciudad");
		
		cliente1.agregarDispositivo(movil1);
		cliente2.agregarDispositivo(pc1);
		
		PagoQR pagoQr=new PagoQR(cliente1, cliente2, entidad1, 3000.00);
		pagoQr.monitorear(cliente1, cliente2, movil1, pc1, entidad1, 3000.00);
		
	}
}
