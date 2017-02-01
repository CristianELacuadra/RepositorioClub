package ar.com.ProyectoClub.CModelo.CEntidades;

public class DTOPersonalisadoSocio {
	private Integer NroSocio;
	private Integer dni; 
	private String Nombre;
	private String Apellido;
	
	public DTOPersonalisadoSocio() {}
	
	DTOPersonalisadoSocio(Integer dni,Integer nro,String nombre,String Apellido){
		this.dni=dni;
		this.NroSocio=nro;
		this.Nombre=nombre;
		this.Apellido=Apellido;
	}
	public Integer getNroSocio() {
		return NroSocio;
	}
	
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public void setNroSocio(Integer nroSocio) {
		NroSocio = nroSocio;
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}

}
