package ar.com.ProyectoClub.CModelo.CEntidades;
// Generated 11-jul-2017 9:12:03 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Inmuebles generated by hbm2java
 */
public class Inmuebles implements java.io.Serializable {

	private Integer idInmueble;
	private String descripcion;
	private float precioHora;
	private String direccion;
	private String nombre;
	private boolean habilitado;
	private Set alquilers = new HashSet(0);

	public Inmuebles() {
	}

	public Inmuebles(float precioHora, String direccion, String nombre, boolean habilitado) {
		this.precioHora = precioHora;
		this.direccion = direccion;
		this.nombre = nombre;
		this.habilitado = habilitado;
	}

	public Inmuebles(String descripcion, float precioHora, String direccion, String nombre, boolean habilitado,
			Set alquilers) {
		this.descripcion = descripcion;
		this.precioHora = precioHora;
		this.direccion = direccion;
		this.nombre = nombre;
		this.habilitado = habilitado;
		this.alquilers = alquilers;
	}

	public Integer getIdInmueble() {
		return this.idInmueble;
	}

	public void setIdInmueble(Integer idInmueble) {
		this.idInmueble = idInmueble;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecioHora() {
		return this.precioHora;
	}

	public void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Set getAlquilers() {
		return this.alquilers;
	}

	public void setAlquilers(Set alquilers) {
		this.alquilers = alquilers;
	}

}
