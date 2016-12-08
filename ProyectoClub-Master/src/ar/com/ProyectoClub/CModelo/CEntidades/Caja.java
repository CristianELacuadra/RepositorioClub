package ar.com.ProyectoClub.CModelo.CEntidades;

// Generated 07-dic-2016 12:36:53 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Caja generated by hbm2java
 */
public class Caja implements java.io.Serializable {

	private Integer idCaja;
	private Date fecha;
	private String descripcion;
	private float monto;
	private float subTotal;
	private boolean tipo;
	private CajaCuota cajaCuota;
	private CajaAlquiler cajaAlquiler;

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

	public Caja(Date fecha, String descripcion, float monto, float subTotal,
			boolean tipo, CajaCuota cajaCuota, CajaAlquiler cajaAlquiler) {
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.monto = monto;
		this.subTotal = subTotal;
		this.tipo = tipo;
		this.cajaCuota = cajaCuota;
		this.cajaAlquiler = cajaAlquiler;
	}

	public Integer getIdCaja() {
		return this.idCaja;
	}

	public void setIdCaja(Integer idCaja) {
		this.idCaja = idCaja;
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

	public CajaCuota getCajaCuota() {
		return this.cajaCuota;
	}

	public void setCajaCuota(CajaCuota cajaCuota) {
		this.cajaCuota = cajaCuota;
	}

	public CajaAlquiler getCajaAlquiler() {
		return this.cajaAlquiler;
	}

	public void setCajaAlquiler(CajaAlquiler cajaAlquiler) {
		this.cajaAlquiler = cajaAlquiler;
	}

}
