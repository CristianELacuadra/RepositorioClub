package ar.com.ProyectoClub.CModelo.CEntidades;

// Generated 07-dic-2016 12:36:53 by Hibernate Tools 3.4.0.CR1

/**
 * CajaCuota generated by hbm2java
 */
public class CajaCuota implements java.io.Serializable {

	private Integer idCaja;
	private Caja caja;
	private Cuota cuota;

	public CajaCuota() {
	}

	public CajaCuota(Caja caja, Cuota cuota) {
		this.caja = caja;
		this.cuota = cuota;
	}

	public Integer getIdCaja() {
		return this.idCaja;
	}

	public void setIdCaja(Integer idCaja) {
		this.idCaja = idCaja;
	}

	public Caja getCaja() {
		return this.caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public Cuota getCuota() {
		return this.cuota;
	}

	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}

}
