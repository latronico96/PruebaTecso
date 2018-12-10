package coop.tecso.examen.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class Cuenta implements Serializable {

	public enum Monedas {
	    Pesos,
	    Dolares,
	    Euros
	}

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
    
	@NotNull    
    @Enumerated(EnumType.STRING)
    private Monedas moneda;

	private Double saldo;

	public Cuenta() {
	}

	public Cuenta(Long id, Monedas moneda) {
		this.id = id;
		this.moneda = moneda;
		this.saldo = 0d;
	}

	public Cuenta(Long id, Monedas moneda, Double saldo) {
		this.id = id;
		this.moneda = moneda;
		this.saldo = saldo;
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

		Cuenta persistentObject = (Cuenta) other;
		return getId() != null && getId().equals(persistentObject.getId());

	}

	@Transient
	public String getDescription() {
		return toString();
	}

	public Long getId() {
		return id;
	}

	public Monedas getMoneda() {
		return moneda;
	}

	public Double getSaldo() {
		return saldo;
	}

	@Override
	public int hashCode() {

		if (getId() != null) {
			return this.getClass().hashCode() + getId().hashCode();
		} else {
			return super.hashCode();
		}
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMoneda(Monedas moneda) {
		this.moneda = moneda;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", moneda=" + moneda + ", saldo=" + saldo + "]";
	}


}
