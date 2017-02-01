package ar.com.ProyectoClub.CModelo.CEntidades;
// Generated 01-feb-2017 12:33:45 by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Alquiler generated by hbm2java
 */
public class Alquiler implements java.io.Serializable {

	private Integer nroAlquiler;
	private Sociosa sociosa;
	private Inmuebles inmuebles;
	private Nosocio nosocio;
	private Date fechaActual;
	private Date horaActual;
	private Date fechaReserva;
	private Date horaReserva;
	private float precioTotal;
	private boolean activo;
	private Set cajas = new HashSet(0);

	public Alquiler() {
	}

	public Alquiler(Inmuebles inmuebles, Date fechaActual, Date horaActual, Date fechaReserva, Date horaReserva,
			float precioTotal, boolean activo) {
		this.inmuebles = inmuebles;
		this.fechaActual = fechaActual;
		this.horaActual = horaActual;
		this.fechaReserva = fechaReserva;
		this.horaReserva = horaReserva;
		this.precioTotal = precioTotal;
		this.activo = activo;
	}

	public Alquiler(Sociosa sociosa, Inmuebles inmuebles, Nosocio nosocio, Date fechaActual, Date horaActual,
			Date fechaReserva, Date horaReserva, float precioTotal, boolean activo, Set cajas) {
		this.sociosa = sociosa;
		this.inmuebles = inmuebles;
		this.nosocio = nosocio;
		this.fechaActual = fechaActual;
		this.horaActual = horaActual;
		this.fechaReserva = fechaReserva;
		this.horaReserva = horaReserva;
		this.precioTotal = precioTotal;
		this.activo = activo;
		this.cajas = cajas;
	}

	public Integer getNroAlquiler() {
		return this.nroAlquiler;
	}

	public void setNroAlquiler(Integer nroAlquiler) {
		this.nroAlquiler = nroAlquiler;
	}

	public Sociosa getSociosa() {
		return this.sociosa;
	}

	public void setSociosa(Sociosa sociosa) {
		this.sociosa = sociosa;
	}

	public Inmuebles getInmuebles() {
		return this.inmuebles;
	}

	public void setInmuebles(Inmuebles inmuebles) {
		this.inmuebles = inmuebles;
	}

	public Nosocio getNosocio() {
		return this.nosocio;
	}

	public void setNosocio(Nosocio nosocio) {
		this.nosocio = nosocio;
	}

	public Date getFechaActual() {
		return this.fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public Date getHoraActual() {
		return this.horaActual;
	}

	public void setHoraActual(Date horaActual) {
		this.horaActual = horaActual;
	}

	public Date getFechaReserva() {
		return this.fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Date getHoraReserva() {
		return this.horaReserva;
	}

	public void setHoraReserva(Date horaReserva) {
		this.horaReserva = horaReserva;
	}

	public float getPrecioTotal() {
		return this.precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set getCajas() {
		return this.cajas;
	}

	public void setCajas(Set cajas) {
		this.cajas = cajas;
	}

}
