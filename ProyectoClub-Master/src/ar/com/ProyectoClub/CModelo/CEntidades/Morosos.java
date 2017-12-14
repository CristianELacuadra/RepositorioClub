package ar.com.ProyectoClub.CModelo.CEntidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Toma los datos del socio, cantidad de cuotas a deber, importe total, y la fecha ultima de movimiento 
 * @author Cristian Lacuadra
 *
 */
public class Morosos {
	private Integer dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String domicilio;
	private String categoria;
	private Integer matricula;
	private Date fechaingreso;
	private String estado;
	private Integer cantidadCuota;
	private Float importeTotal;
	private Date ultimaFecMovim;

	public Morosos() {
	}

	public Morosos(Integer dni,String nombre,String apellido,String telefono,String domicilio,String categoria,Integer matricula,Date fechaingreso,String estado,Integer cantidadCuota,Float importetotal,Date ultimafechaMov) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.telefono = telefono;
		this.domicilio=domicilio;
		this.categoria=categoria;
		this.matricula=matricula;
		this.fechaingreso=fechaingreso;
		this.estado=estado;
		this.cantidadCuota=cantidadCuota;
		this.importeTotal=importetotal;
		this.ultimaFecMovim=ultimaFecMovim;
	}
	
	public void setUltimaFecMovim(Date ultimaFecMovim) {
		this.ultimaFecMovim = ultimaFecMovim;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public void setImporteTotal(Float importeTotal) {
		this.importeTotal = importeTotal;
	}
	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setCantidadCuota(Integer cantidadCuota) {
		this.cantidadCuota = cantidadCuota;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getUltimaFecMovim() {
		return ultimaFecMovim;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public Integer getMatricula() {
		return matricula;
	}
	public Float getImporteTotal() {
		return importeTotal;
	}
	public Date getFechaingreso() {
		return fechaingreso;
	}
	public String getEstado() {
		return estado;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public Integer getDni() {
		return dni;
	}
	public String getCategoria() {
		return categoria;
	}
	public Integer getCantidadCuota() {
		return cantidadCuota;
	}
	public String getApellido() {
		return apellido;
	}
}
