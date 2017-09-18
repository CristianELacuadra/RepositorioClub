package ar.com.ProyectoClub.CModelo.CEntidades;
// Generated 17-sep-2017 22:07:28 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Conceptos generated by hbm2java
 */
public class Conceptos implements java.io.Serializable {

	private Integer idConcepto;
	private String nombre;
	private String tipo;
	private Set cajas = new HashSet(0);

	public Conceptos() {
	}

	public Conceptos(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public Conceptos(String nombre, String tipo, Set cajas) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.cajas = cajas;
	}

	public Integer getIdConcepto() {
		return this.idConcepto;
	}

	public void setIdConcepto(Integer idConcepto) {
		this.idConcepto = idConcepto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set getCajas() {
		return this.cajas;
	}

	public void setCajas(Set cajas) {
		this.cajas = cajas;
	}

}
