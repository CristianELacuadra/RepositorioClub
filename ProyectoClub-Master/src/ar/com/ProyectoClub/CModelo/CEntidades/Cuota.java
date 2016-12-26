package ar.com.ProyectoClub.CModelo.CEntidades;

// Generated 26-dic-2016 12:08:49 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cuota generated by hbm2java
 */
public class Cuota implements java.io.Serializable {

	private Integer id;
	private Sociosa sociosa;
	private Date fecha;
	private float monto;
	private String estado;
	private Set cajas = new HashSet(0);

	public Cuota() {
	}

	public Cuota(Sociosa sociosa, Date fecha, float monto, String estado) {
		this.sociosa = sociosa;
		this.fecha = fecha;
		this.monto = monto;
		this.estado = estado;
	}

	public Cuota(Sociosa sociosa, Date fecha, float monto, String estado,
			Set cajas) {
		this.sociosa = sociosa;
		this.fecha = fecha;
		this.monto = monto;
		this.estado = estado;
		this.cajas = cajas;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sociosa getSociosa() {
		return this.sociosa;
	}

	public void setSociosa(Sociosa sociosa) {
		this.sociosa = sociosa;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getMonto() {
		return this.monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set getCajas() {
		return this.cajas;
	}

	public void setCajas(Set cajas) {
		this.cajas = cajas;
	}

}
