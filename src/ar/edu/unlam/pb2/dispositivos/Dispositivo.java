package ar.edu.unlam.pb2.dispositivos;

import java.util.Objects;

import ar.edu.unlam.pb2.interfaces.Denunciable;

public class Dispositivo implements Denunciable{
	private String so;
	private String ip;
	private String localidad;
	
	public Dispositivo(String sO, String ip, String localidad) {
		this.so = sO;
		this.ip = ip;
		this.localidad = localidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dispositivo other = (Dispositivo) obj;
		return Objects.equals(ip, other.ip);
	}

	
}
