package ar.com.ProyectoClub.CModelo.CEntidades;

// Generated 26-dic-2016 12:08:49 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Caja generated by hbm2java
 */
public class Caja implements java.io.Serializable {

	private Integer idCaja;
	private Cuota cuota;
	private Alquiler alquiler;
	private Date fecha;
	private String descripcion;
	private float monto;
	private float subTotal;
	private boolean tipo;

	public Caja() {
	}

	public Caja(Date fecha, String descripcion, float monto, float subTotal,
			boolean tipo) {
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.monto = monto;
		this.subTotal = subTotal;
		this.tipo = tipo;
	}

	public Caja(Cuota cuota, Alquiler alquiler, Date fecha, String descripcion,
			float monto, float subTotal, boolean tipo) {
		this.cuota = cuota;
		this.alquiler = alquiler;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.monto = monto;
		this.subTotal = subTotal;
		this.tipo = tipo;
	}

	public Integer getIdCaja() {
		return this.idCaja;
	}

	public void setIdCaja(Integer idCaja) {
		this.idCaja = idCaja;
	}

	public Cuota getCuota() {
		return this.cuota;
	}

	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}

	public Alquiler getAlquiler() {
		return this.alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getMonto() {
		return this.monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public float getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public boolean isTipo() {
		return this.tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

}
