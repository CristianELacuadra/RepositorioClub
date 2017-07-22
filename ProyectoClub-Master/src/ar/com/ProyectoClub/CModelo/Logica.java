package ar.com.ProyectoClub.CModelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCategorias;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceNoSocio;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceUsuario;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceCategoria;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceNoSocio;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceSocios;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceUsuario;
import ar.com.ProyectoClub.CModelo.AServicios.facade.*;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.*;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.CEntidades.NoSocioDTO;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;

/*Esta clase permite realizar las operaciones asociadas a la lógica de negocio como tal, desde ella 
 * realizamos las validaciones y llamados a las operaciones CRUD del sistema.
*/
public class Logica {
	private ControllerCoordinador miCoordinador;
	public static boolean consultaPersona=false;
	public static boolean modificaPersona=false;
	//servicios del modelo
	private IServiceUsuario servicioUsuario;
	private IServiceSocio servicioSocio;
	private IServiceCategorias serviciocategoria;
	private IServiceNoSocio serviceNoSocio;
	private IServiceAlquileres servicioAlquiler;
	private IServiceInmuebles servicioInmueble;
	
	//instancia los servicios
	
	public Logica() {
		servicioUsuario=new ServiceUsuario();
		servicioSocio=new ServiceSocios();
		serviciocategoria=new ServiceCategoria();
		serviceNoSocio=new ServiceNoSocio();
		
		
	}
	public void GuardarSocio(Personas socio){
		servicioSocio.GuardarSocio(socio);
	}
	public void GuardarNoSocio(Personas persona){
		NoSocioDTO EntidadNoSocio= new NoSocioDTO();
		EntidadNoSocio.setDni(persona.getDni());
		EntidadNoSocio.setApellido(persona.getApellido());
		EntidadNoSocio.setNombre(persona.getNombre());
		EntidadNoSocio.setFecNacimiento(persona.getFecNacimiento());
		EntidadNoSocio.setDomicilio(persona.getDomicilio());
		EntidadNoSocio.setTelefono(persona.getTelefono());
		EntidadNoSocio.setEssocio(false);
		serviceNoSocio.GuardarNoSocio(EntidadNoSocio);
	}
	public Personas BuscarSocio(Integer id){
		 return servicioSocio.BusquedaId(id);
	}
	public NoSocioDTO BuscarNoSocio(Integer id){
		 return serviceNoSocio.BuscarNoSocio(id);
	}


	public List<Personas> filtrarNombreApellidoSocio(String nom,String ape){
		return servicioSocio.FiltrarNombreApellido(nom, ape);
	}
	public List<NoSocioDTO> filtrarNombreApellidoNosocio(String nom,String ape){
		return serviceNoSocio.FiltrarNombreApellido(nom, ape);
	}
	public List<Personas>ListarParcialSocio(){
		return servicioSocio.ListaSociosActivo(); 
	}
	
	public List<NoSocioDTO>ListaHabilitadosNoSocio(){
		return (serviceNoSocio.ListarNoSocios()) ;
	}
	
//	private Personas NoSocioAPersona(NoSocioDTO noSocio){
//		 Personas persona=servicioSocio.CrearSocio();
//		 persona.setDni(noSocio.getDni());
//		 persona.setNombre(noSocio.getNombre());
//		 persona.setApellido(noSocio.getApellido());
//		 persona.setDomicilio(noSocio.getDomicilio());
//		 persona.setEstado(noSocio.getEstado());
//		 persona.setEssocio(noSocio.isEssocio());
//		 persona.setFecNacimiento(noSocio.getFecNacimiento());
//		 persona.setHabilitado(noSocio.isHabilitado());
//		 persona.setTelefono(noSocio.getTelefono());
//		 return persona;
//		 
//	}
	public List<NoSocioDTO>ListaNoSocio(){
		return serviceNoSocio.ListarNoSocios();//retorna historico de no socios
	}
	public Personas CrearInstanciaPersona(){
		return servicioSocio.CrearSocio();
	}
	public Categoria CrearinstanciaCategoria(){
		return serviciocategoria.CrearCategoria();
	}
	public Categoria BuscarCategoria(Integer id){
		return serviciocategoria.BuscarCategoria(id);
	}
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	public Usuario DevolverUsuario(Usuario usuario){
		Usuario usuarioNew=servicioUsuario.newusuario();
		usuarioNew=servicioUsuario.DevolverUsuario(usuario.getNick(), usuario.getPassword());
		return usuarioNew;
	}
	
	public Integer DevolverUltimoID(){
		return servicioSocio.UltimoIdSocio();
	}
	
	public List<Categoria> DevolverListaCategoria(){
		return serviciocategoria.ListarCategorias();
	}
	public Inmuebles CrearInstanciaInmueble() {
		return servicioInmueble.CrearInmueble();
		 
	}
	public Alquiler CrearInstanciaAlquiler() {
		
		return servicioAlquiler.CrearAlquiler();
	}
	
/*
	public void validarRegistro(PersonaVo miPersona) {
		PersonaDao miPersonaDao;
		if (miPersona.getIdPersona() > 99) {
			miPersonaDao = new PersonaDao();
			miPersonaDao.registrarPersona(miPersona);						
		}else {
			JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}

	public PersonaVo validarConsulta(String codigoPersona) {
		PersonaDao miPersonaDao;
		
		try {
			int codigo=Integer.parseInt(codigoPersona);	
			if (codigo > 99) {
				miPersonaDao = new PersonaDao();
				consultaPersona=true;
				return miPersonaDao.buscarPersona(codigo);						
			}else{
				JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaPersona=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaPersona=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaPersona=false;
		}
					
		return null;
	}

	public void validarModificacion(PersonaVo miPersona) {
		PersonaDao miPersonaDao;
		if (miPersona.getNombrePersona().length()>5) {
			miPersonaDao = new PersonaDao();
			miPersonaDao.modificarPersona(miPersona);	
			modificaPersona=true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre de la persona debe ser mayor a 5 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaPersona=false;
		}
	}

	public void validarEliminacion(String codigo) {
		PersonaDao miPersonaDao=new PersonaDao();
		miPersonaDao.eliminarPersona(codigo);
	}
	*/
}
