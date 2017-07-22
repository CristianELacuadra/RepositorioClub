package ar.com.ProyectoClub.CModelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.AServicios.FechaHora;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCaja;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCategorias;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCuota;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceNoSocio;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceUsuario;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceCaja;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceCategoria;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceCuota;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceNoSocio;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceSocios;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceUsuario;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.AServicios.facade.*;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.*;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
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
	private IServiceCaja serviceCaja;
	private IServiceCuota serviceCuota;
	private IServiceAlquileres servicioAlquiler;
	private IServiceInmuebles servicioInmueble;
	
	//instancia los servicios
	
	public Logica() {
		serviceCuota=new ServiceCuota();
		servicioUsuario=new ServiceUsuario();
		servicioSocio=new ServiceSocios();
		serviciocategoria=new ServiceCategoria();
		serviceNoSocio=new ServiceNoSocio();
		serviceCaja=new ServiceCaja();
	}
	
	public Cuota CrearInstanciaCuota(){
		return serviceCuota.CrearInstanciaCuota();
	}
	public List<Cuota> ObtenerCuotasSocios(Personas persona){
		return null;
	}
	public void ProcesoMorosos(){
		List<Cuota> listaCuotasImpagas=new ArrayList<Cuota>();
		List<Personas> listaMorosos=new ArrayList<Personas>();
		listaCuotasImpagas=serviceCuota.ObtenerCuotasImpagas();
		//comparo fechas
		
		for(Cuota cuota : listaCuotasImpagas ){
			Date fechaSumada=new Date();
			fechaSumada=sumarFechasDias(cuota.getFechaGeneracion(),3);
			if(CompararFechas(fechaSumada)){
				listaMorosos.add(cuota.getPersonas());
			}
		}
		servicioSocio.CambiarEstadoMoroso(listaMorosos);
	}
	private boolean CompararFechas(Date fechaSumada){
		if(fechaSumada.compareTo(FechaHora.FechaActual())<0)
			return true;
		else
			return false;
	}
	
	
	public Date FechaUltimaGeneracionCuota(){
		Cuota cuota=serviceCuota.CrearInstanciaCuota();
		cuota=serviceCuota.ObtenerUltimaCuota();
		return cuota.getFechaGeneracion();
	}
	
	public static Date sumarFechasDias(java.util.Date fch,int mes) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.MONTH, mes);
        return new java.sql.Date(cal.getTimeInMillis());
    }
	
	public static Date sumarFechasDias(java.util.Date fch) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.MONTH, 1);
        return new java.sql.Date(cal.getTimeInMillis());
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
	public Caja CrearInstanciaCaja(){
		return serviceCaja.Crear();
	}
	public void GuardarIngresoEgreso(Caja registro){
		serviceCaja.GuardarIngresoEgreso(registro);
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
	public List<Caja> TotalRegistradoCaja(){
		return serviceCaja.listarRegistrosDeCaja();
	}
	
	public Caja UltimoRegistroDeCaja(){
		return serviceCaja.UltimoRegistroCaja();
	}
    public List<Caja> BuscarCajasParametros(Date FechaDesde,Date FechaHasta,String Descripcion,boolean Ingreso,boolean Egreso){
		return serviceCaja.ObtenerCajasPorParamatros(FechaDesde, FechaHasta, Descripcion, Ingreso, Egreso);
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
    @SuppressWarnings("deprecation")
    public void LanzarPrcesoGeneracionCuota(){
    	List<Personas> listaSocios=new ArrayList<Personas>();
    	listaSocios=servicioSocio.ListaSociosActivo();
    	serviceCuota.GeneracionCuota(FechaHora.FechaActual(),listaSocios);
    }
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
