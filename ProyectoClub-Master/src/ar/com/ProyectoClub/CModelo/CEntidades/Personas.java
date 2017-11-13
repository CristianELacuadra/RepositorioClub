package ar.com.ProyectoClub.CModelo.CEntidades;
// Generated 12-nov-2017 13:20:02 by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Personas generated by hbm2java
 */
public class Personas implements java.io.Serializable {

	private Integer dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String domicilio;
	private Date fechanac;
	private String sexo;
	private String nacionalidad;
	private String estadocivil;
	private boolean habilitado;
	private Socios socios;
	private Set alquilers = new HashSet(0);

	public Personas() {
	}

	public Personas(Integer dni, String nombre, String apellido, String telefono, String domicilio, Date fechanac,
			String sexo, String nacionalidad, String estadocivil, boolean habilitado) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.fechanac = fechanac;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.estadocivil = estadocivil;
		this.habilitado = habilitado;
	}

	public Personas(Integer dni, String nombre, String apellido, String telefono, String domicilio, Date fechanac,
			String sexo, String nacionalidad, String estadocivil, boolean habilitado, Socios socios, Set alquilers) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.fechanac = fechanac;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.estadocivil = estadocivil;
		this.habilitado = habilitado;
		this.socios = socios;
		this.alquilers = alquilers;
	}

	public Integer getDni() {
		return this.dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Date getFechanac() {
		return this.fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEstadocivil() {
		return this.estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public boolean isHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Socios getSocios() {
		return this.socios;
	}

	public void setSocios(Socios socios) {
		this.socios = socios;
	}

	public Set getAlquilers() {
		return this.alquilers;
	}

	public void setAlquilers(Set alquilers) {
		this.alquilers = alquilers;
	}

}
