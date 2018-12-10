package coop.tecso.examen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class Movimiento implements Serializable {

	public enum Tipo {
		Haber,
	    Debe,
	}

	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @ManyToOne
    @NotNull
	private Cuenta cuenta;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date fecha;

	@NotNull    
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

	@Column(length = 200)
	private String descripcion;

	@Column(scale = 2)
	private Double importe;

	public Movimiento() {
	}

	public Movimiento(Long id, Cuenta cuenta, java.util.Date fecha, Tipo tipo, String descripcion, Double importe) {
		this.id = id;
		this.cuenta = cuenta;
		this.fecha = fecha;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.importe = importe;
	}

	@Override
	public boolean equals(Object other) {
		if (super.equals(other)) {
			return true;
		}

		if (other == null) {
			return false;
		}

		if (this.getClass() != other.getClass()) {
			return false;
		}

		Movimiento persistentObject = (Movimiento) other;
		return getId() != null && getId().equals(persistentObject.getId());

	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Transient
	public String getDescription() {
		return toString();
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public Long getId() {
		return id;
	}
	
	public Double getImporte() {
		return importe;
	}

	public Tipo getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() {

		if (getId() != null) {
			return this.getClass().hashCode() + getId().hashCode();
		} else {
			return super.hashCode();
		}
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", cuenta=" + cuenta + ", fecha=" + fecha + ", tipo="
				+ tipo + ", descripcion=" + descripcion + ", importe=" + importe + "]";
	}


}
