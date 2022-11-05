package ar.edu.unlam.pb2.dispositivos;

import java.util.Objects;

import ar.edu.unlam.pb2.varios.TipoRegistro;

public class Movil extends Dispositivo {

	private Integer imei;
	private TipoRegistro tipoDeRegistro;

	public Movil(String so, String ip, String localidad, Integer imei, TipoRegistro tipoDeRegistro) {
		super(so, ip, localidad);
		this.imei = imei;
		this.tipoDeRegistro = tipoDeRegistro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(imei);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movil other = (Movil) obj;
		return Objects.equals(imei, other.imei);
	}
	
	

}
