package ar.com.ProyectoClub.CModelo.CEntidades;
// Generated 01-oct-2017 13:17:29 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Inmuebles generated by hbm2java
 */
public class Inmuebles implements java.io.Serializable {

	private Integer idInmubles;
	private String nombre;
	private String dirreccion;
	private String descripcion;
	private float preciohora;
	private byte habilitado;
	private Set alquilers = new HashSet(0);

	public Inmuebles() {
	}

	public Inmuebles(String nombre, String dirreccion, String descripcion, float preciohora, byte habilitado) {
		this.nombre = nombre;
		this.dirreccion = dirreccion;
		this.descripcion = descripcion;
		this.preciohora = preciohora;
		this.habilitado = habilitado;
	}

	public Inmuebles(String nombre, String dirreccion, String descripcion, float preciohora, byte habilitado,
			Set alquilers) {
		this.nombre = nombre;
		this.dirreccion = dirreccion;
		this.descripcion = descripcion;
		this.preciohora = preciohora;
		this.habilitado = habilitado;
		this.alquilers = alquilers;
	}

	public Integer getIdInmubles() {
		return this.idInmubles;
	}

	public void setIdInmubles(Integer idInmubles) {
		this.idInmubles = idInmubles;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirreccion() {
		return this.dirreccion;
	}

	public void setDirreccion(String dirreccion) {
		this.dirreccion = dirreccion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPreciohora() {
		return this.preciohora;
	}

	public void setPreciohora(float preciohora) {
		this.preciohora = preciohora;
	}

	public byte getHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(byte habilitado) {
		this.habilitado = habilitado;
	}

	public Set getAlquilers() {
		return this.alquilers;
	}

	public void setAlquilers(Set alquilers) {
		this.alquilers = alquilers;
	}

}
