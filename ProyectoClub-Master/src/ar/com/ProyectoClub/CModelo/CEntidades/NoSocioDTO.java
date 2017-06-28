package ar.com.ProyectoClub.CModelo.CEntidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.mysql.jdbc.EscapeTokenizer;

/**
 *Dto no socio contendra los datos unicamente del no socio,basandose de la entidad 
 *persona que contiene los datos del socio y no socio 
 **/
public class  NoSocioDTO {
	private Integer dni;;
	private String nombre; 
	private String apellido;
	private String telefono;
	private String domicilio;
	private Date fecNacimiento;
	private boolean Habilitado;
	private boolean essocio; 
	private String estado;
	
	public NoSocioDTO() {}
	
	public NoSocioDTO (Integer dni,String nombre,String apellido,String telefono,String domicilio,Date fecNacimiento,boolean habilitado,boolean essocio,String estado){
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.telefono=telefono;
		this.domicilio=domicilio;
		this.fecNacimiento=fecNacimiento;
		this.Habilitado=habilitado;
		this.essocio=essocio;
		this.estado=estado;
	}
	
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Date getFecNacimiento() {
		return fecNacimiento;
	}
	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}
	
	public boolean isEssocio() {
		return essocio;
	}
	public boolean isHabilitado() {
		return Habilitado;
	}
	public void setEssocio(boolean essocio) {
		this.essocio = essocio;
	}
	public void setHabilitado(boolean habilitado) {
		Habilitado = habilitado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstado() {
		return estado;
	}

}
