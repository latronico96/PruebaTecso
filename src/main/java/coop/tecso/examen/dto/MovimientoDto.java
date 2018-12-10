package coop.tecso.examen.dto;

import java.io.Serializable;

import javax.persistence.Transient;

/**
 * @author latronico
 *
 */
public class MovimientoDto implements Serializable {

	private static final long serialVersionUID = 666545600794571829L;

	private Long cuenta;
	private java.util.Date fecha;
	private String descripcion;
	private Double importe;
	private String tipo;

	public MovimientoDto() {
	}

	public MovimientoDto(Long cuenta, java.util.Date fecha, String tipo, String descripcion, Double importe) {
		this.cuenta = cuenta;
		this.fecha = fecha;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.importe = importe;
	}

	public Long getCuenta() {
		return cuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public Double getImporte() {
		return importe;
	}

	public String getTipo() {
		return tipo;
	}

	public void setCuenta(Long cuenta) {
		this.cuenta = cuenta;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
