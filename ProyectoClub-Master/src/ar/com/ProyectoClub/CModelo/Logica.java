package ar.com.ProyectoClub.CModelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
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
import ar.com.ProyectoClub.CModelo.BNegocio.FechaHora;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceAlquileres;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceAlquileres;
import ar.com.ProyectoClub.CModelo.AServicios.facade.*;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.*;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
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
	private IServiceAlquileres serviceAlquiler;
	private IServiceInmuebles serviceInmueble;
		
	
	
	//instancia los servicios
	
	public long CantidadSociosRegistrados(){
		return servicioSocio.CantidadSociosRegistrados();
	}
	
	public Logica() {
		serviceCuota=new ServiceCuota();
		servicioUsuario=new ServiceUsuario();
		servicioSocio=new ServiceSocios();
		serviciocategoria=new ServiceCategoria();
		serviceNoSocio=new ServiceNoSocio();
		serviceCaja=new ServiceCaja();
		serviceAlquiler=new ServiceAlquileres();
		serviceInmueble=new ServiceInmueble();
	}
	public List<Personas> HistoricosSocios(){
		return servicioSocio.ListaPersona();
	}
	
	public List<Personas> ListaActivoinactivo(){
		List<Personas> lista=new ArrayList<Personas>();
		
		for(Personas persona: servicioSocio.ListaPersona()){
			if(persona.isEssocio())
				lista.add(persona);
		}
		return lista;
	}
	
	public void InhabilitarSocio(Integer dni){
		Personas persona =servicioSocio.CrearSocio();
		persona=servicioSocio.BusquedaId(dni);
		servicioSocio.DeshabilitarSocio(persona);
	}
	
	public void InhabilitarNoSocio(Integer dni){
		NoSocioDTO persona =serviceNoSocio.Crear();
		persona=serviceNoSocio.BuscarNoSocio(dni);
		//serviceNoSocio.DeshabilitarNoSocio(dni); .DeshabilitarSocio(persona);
	}
	
	public Cuota CrearInstanciaCuota(){
		return serviceCuota.CrearInstanciaCuota();
	}
	public List<Cuota> ObtenerCuotasSocios(Personas persona){
		return serviceCuota.ObtenerCuotas(persona);
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
	
	public void CobranzaCuotas(Integer dni,List<Integer> IdCuotas){
		//Se obtienen las cuotas para actualizar el pago 
		List<Cuota> ListaCuotas=new ArrayList<>();
		for(Integer id:IdCuotas){
			ListaCuotas.add(serviceCuota.BuscarCuota(id));	
		}
		//Regista los pagos
		for(Cuota cuotas: ListaCuotas){
			serviceCuota.RegistrarPagoCuota(cuotas);
		}

		//Actualizo el estado del socio
		servicioSocio.GuardarSocio(CambiarEstadoSocio(dni));

		//Registro un nuevo ingreso en la caja
		for(Cuota cuotas: ListaCuotas){
			serviceCaja.GuardarIngresoEgreso(CuotaIngresaCaja(cuotas));
		}
	}
	private Personas CambiarEstadoSocio(Integer dni){
		Personas persona= servicioSocio.CrearSocio();
		persona=servicioSocio.BusquedaId(dni);
		persona.setEstado("Activo");
		persona.setHabilitado(true);
		return persona;
	}
	
	private Caja CuotaIngresaCaja(Cuota cuotas){
		Caja caja=this.CrearInstanciaCaja();
		caja.setCuota(cuotas);
		caja.setDescripcion("pago de cuota socio numero "+cuotas.getPersonas().getNroSocio());
		caja.setFecha(FechaHora.FechaActual());
		caja.setHabilitar(true);
		caja.setMonto(cuotas.getImporte());
		caja.setTipo(true);
		return caja;
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
		EntidadNoSocio.setDomicilioNro(persona.getDomNro());
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
		return serviceInmueble.CrearInmueble();
		 
	}
	public Alquiler CrearInstanciaAlquiler() {
		return serviceAlquiler.CrearAlquiler();
	}

	public void GuardarInmueble(Inmuebles entity) {
		serviceInmueble.GuardarInmueble(entity);
		
	}

	public void ModificarInmueble(Inmuebles entity) {
		// TODO Auto-generated method stub
		serviceInmueble.GuardarInmueble(entity);
	}

	public void EliminarInmueble(Inmuebles entity) {
		// TODO Auto-generated method stub
		//e
		if(entity.isHabilitado()==true){
			entity.setHabilitado(false);
			serviceInmueble.GuardarInmueble(entity);
		}
		//servicioSocio.GuardarSocio(socio);
	}

	public void RestaurarInmueble(Inmuebles entity) {
		// TODO Auto-generated method stub
		//e
		if(entity.isHabilitado()==false){
			entity.setHabilitado(true);
			serviceInmueble.GuardarInmueble(entity);
		//servicioSocio.GuardarSocio(socio);
		}
	}
	
	public Inmuebles BuscarInmueble(Integer id) {
		return serviceInmueble.BusquedaInmueble(id);
		 
	}
	
	public java.util.List<Inmuebles> ListarInmueblesParaAlquiler(){
	return serviceInmueble.ListarInmuebleHabilitado();
}
	
	public void ListarInmuebles(JTable jtdatos, String text, boolean selected){
		java.util.List<Inmuebles> listaInmuebles=new ArrayList<Inmuebles>();
		
		if(text.isEmpty() && !selected){//si es verdadero incluye todos los inmuebles
			listaInmuebles=serviceInmueble.ListarInmuebleHabilitado();
			// solo inmuebles habilitados
		}else if(selected){
			listaInmuebles=serviceInmueble.ListarInmueble();
			//incluir todos habilitados y no habilitados
			
		}else if(!text.isEmpty()){
			listaInmuebles=serviceInmueble.ListarInmuebleFiltrado(text);
			//listar resultados
		}
		
		DefaultTableModel  modeloT = (DefaultTableModel) jtdatos.getModel();
		//"Numero", "Nombre", "Precio por hora", "Direccion"
		Object[] columna = new Object[4];
		int numr=listaInmuebles.size();
		for(int i=0;i<numr;i++){
			columna[0]=listaInmuebles.get(i).getIdInmueble();
			columna[1]=listaInmuebles.get(i).getNombre();
			columna[2]=listaInmuebles.get(i).getPrecioHora();
			columna[3]=listaInmuebles.get(i).getDireccion();
			modeloT.addRow(columna);
		}
		jtdatos.setModel(modeloT);
			
	}

	public void GuardarAlquiler(Alquiler alqui) {
		serviceAlquiler.GuardarAlquiler(alqui);
		
	}

	public void ListarPersonasTodos() {
		 
		
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
