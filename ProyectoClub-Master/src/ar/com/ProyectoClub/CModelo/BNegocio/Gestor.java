package ar.com.ProyectoClub.CModelo.BNegocio;

import java.awt.dnd.InvalidDnDOperationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ar.com.ProyectoClub.CModelo.CEntidades.*;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.BussinessException;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.BussinessMessage;
import ar.com.ProyectoClub.CModelo.DRepository.IRepository.IRepository;
import ar.com.ProyectoClub.CModelo.DRepository.Repository.Repository;

public class Gestor {
	//Declaracion de mi Contrato al repositorio
    private IRepository repositorio;
    
    //instancia mi repositorio
    public Gestor() throws Exception
    {
    	repositorio = new Repository();
    }
    
//    //Gestion Alquiler
//    public  CrearAlquiler() throws BussinessException {
//		return repositorio.CrearAlquiler();//->Devuelve nueva instancia de la entidad Alquiler
//	}
//    
//    private Date Tomarhora() {
//		return(FechaHora.HoraActual().getTime());
//	}
//	
//	private Date TomarFecha() {
//		return(FechaHora.FechaActual());
//	}
//	
//	public void Guardar(Alquiler entity) throws Exception {
//		try {
//			if(entity.getFechaReserva().compareTo(this.TomarFecha())>0 || entity.getFechaReserva().compareTo(this.TomarFecha())==0){
//				if(entity.getNroAlquiler()==null)
//					entity.setActivo(true); //si es un insert si o si activo tiene que ser true
//				entity.setFechaActual(this.TomarFecha());
//				entity.setHoraActual(this.Tomarhora());
//				_AlquilerDao.GuardarEntity(entity);
//			}
//			else {
//				throw new RuntimeException("¡¡ERROR!!,la fecha de reserva no puede ser menor a la fecha actual");
//			}
//		}
//		catch (BussinessException e) {
//			throw new Exception("No se puede guardar los datos debido al siguiente error: "+e.toString());
//		}
//
//	}
//
//	public Alquiler Busqueda(Integer id) throws Exception {
//			Alquiler _uno=this.Crear();
//			_uno=_AlquilerDao.BuscarUno(id);
//			return _uno;
//	}
//	
//	/**
//	 * public List<Alquiler> Listar() 
//	 * lista historicos de alquileres ya sea activos e inactivos;
//	 **/
//
//	public List<Alquiler> Listar() throws Exception {   
//		List<Alquiler> _list=new ArrayList<Alquiler>();
//		_list=_AlquilerDao.Listar();
//		return _list;
//
//	}
//	/**
//	 * public List<Alquiler> Lista_activo
//	 * metodo publico lista todos los alquileres activos  
//	 **/
//	
//	public List<Alquiler> Listar_activos() {
//		List<Alquiler> _list=new ArrayList<Alquiler>();
//		try {
//			for(Alquiler _ObjAlquiler: _AlquilerDao.Listar()) {
//				if(_ObjAlquiler.isActivo())
//					_list.add(_ObjAlquiler);
//		}
//			return _list;
//		}
//		catch (BussinessException e) {
//			throw new RuntimeException("No se pudo realizar la consulta debido al siguiente error"+e.getMessage());
//		}
//	}
//	/**
//	 * Public List<Alquiler> BusquedaXFecha();
//	 */
//	@SuppressWarnings("null")
//
//	public List<Alquiler> BusquedaXFecha(Date fechainicial,Date fechafin) throws Exception {
//		List<Alquiler> _list=new ArrayList<Alquiler>();
//		_list.clear();
//		//_list=null;
//		for(Alquiler _alq : _AlquilerDao.BusquedaXFecha(fechainicial,fechafin)) { //llama al dao que contiene una Query de rango de fecha
//			if(_alq.isActivo())
//				_list.add(_alq);
//		}
//
//		return _list;
//	}
//	
//	@Override
//	public void Inhabilitar(Alquiler entity) throws Exception {
//			Alquiler _uno=this.Crear();
//			_uno=this.Busqueda(entity.getNroAlquiler());
//			_uno.setActivo(entity.isActivo());//el alquiler pasa a estado inactivo
//			this.Guardar(_uno);//guarda los datos
//	}
//
//	@Override
//	public void habilitar(Alquiler entity) throws Exception {
//			Alquiler _uno=this.Crear();
//			_uno=this.Busqueda(entity.getNroAlquiler());
//			_uno.setActivo(entity.isActivo());//el alquiler pasa a estado activo
//			this.Guardar(_uno);//guarda los datos
//	}
//	
//	public Integer ObtenerSiguienteIdAlquiler(){
//
//		Integer aux=0;
//		List<Alquiler> _list=new ArrayList<Alquiler>();
//		try {
//			_list=this.Listar();
//			if(!_list.isEmpty()){
//				for(Alquiler inm:_list){
//					if(inm.getNroAlquiler()>aux){
//					aux=(inm.getNroAlquiler()+1);
//					}
//				}
//			}
//		
//		} catch (Exception e) {
//			}
//		return aux;
//		
//	}
    
    //Gestion Inmuebles
//	public GestorInmueble() throws Exception{
//		try {
//			_InmueblesDAO=new InmueblesDaoImplHibernate();
//			}catch (Exception e) {
//				 throw new RuntimeException("Reintente Para Crear El Contructor");
//			}
//	}
//
//	@Override
//	public Inmuebles Crear() throws BussinessException {
//		return (_InmueblesDAO.crear());
//	}
//
//	@Override
//	public void Guardar(Inmuebles entity) throws Exception {
//		try{
//			Inmuebles _uno=this.Crear();
//			_uno=entity;
//			_InmueblesDAO.GuardarEntity(_uno);
//		
//			}
//		catch (BussinessException e) {
//			throw new Exception("No se puede guardar los datos debido al siguiente error: "+e.toString());
//		}
//	}
//
//	public Integer ObtenerSiguienteIdInmueble(){
//		Integer aux=0;
//	
//		List<Inmuebles> _list=new ArrayList<Inmuebles>();
//		try {
//			_list=this.Listar();
//			if(!_list.isEmpty()){
//				for(Inmuebles inm:_list){
//					if(inm.getIdInmueble()>aux){
//					aux=inm.getIdInmueble();
//					}
//				}
//			}
//			return aux++;
//		
//		} catch (Exception e) {
//				throw new RuntimeException("ERROR :"+e.toString());
//		}
//		
//		
//	}
//
//	
//	@Override
//	public Inmuebles Busqueda(Integer id) throws Exception {
//		Inmuebles _uno=this.Crear();
//		_uno=_InmueblesDAO.BuscarUno(id);
//		return _uno;
//	}
//
//	@Override
//	public List<Inmuebles> Listar() throws Exception {
//		List<Inmuebles> _list=new ArrayList<Inmuebles>();
//		_list=_InmueblesDAO.Listar();
//		return _list;
//	}
//
//	@Override
//	public void Inhabilitar(Inmuebles entity) throws Exception {
//		Inmuebles _e=this.Crear();
//		_e=this.Busqueda(entity.getIdInmueble());
//		_e.setHabilitado(false);
//		this.Guardar(_e);
//		
//	}
//
//	@Override
//	public void habilitar(Inmuebles entity) throws Exception {
//		Inmuebles _e=this.Crear();
//		_e=this.Busqueda(entity.getIdInmueble());
//		_e.setHabilitado(true);
//		this.Guardar(_e);
//	}
    
   

    //Gestion usuario
    public Usuario CrearUsuario() throws BussinessException{
    	return repositorio.CrearUsuario();
    }
    
    @SuppressWarnings("unused")
	public Usuario VerificarUsuario(Usuario usuario) throws BussinessException{
    	Usuario nuevoUsuario= repositorio.CrearUsuario();
    	nuevoUsuario=repositorio.ObtenerUsuarioPorNombre(usuario.getNick());
    	if(nuevoUsuario != null){
    		if(nuevoUsuario.getPassword().equals(usuario.getPassword()))
    			return nuevoUsuario;
    		else
    			return new Usuario("",null,"");
    	}
    	return new Usuario(null,"","");
    }
	
    public Usuario ObtenerUsuarioPorNombre(String nombreUsuario) throws BussinessException{
    	return repositorio.ObtenerUsuarioPorNombre(nombreUsuario);
    }
	//Gestion Persona
    
    public Personas ValidarPersona(int dni) throws BussinessException {
		Personas persona= this.CrearPersona(); 
    	persona=repositorio.BuscarPersona(dni);
    	if(persona!= null)
    		return persona;
    	return null;
	}
    
    public void GuardarPersona(Personas persona,boolean tipoEntrada) throws BussinessException {
    	try{
    		if(this.PersonaHabilitada(persona.getDni())){
    			repositorio.GuardarPersona(persona);
    			if(persona.getSocios() != null && tipoEntrada){
    					this.ArmarPrimerCuota(persona.getSocios(),persona.getNombre(),persona.getApellido());
    			}
    		}
    		else
    			throw new InvalidDnDOperationException("Persona inhabilitada para realizar operacion");
    	}
    	catch (Exception e) {
    		throw new RuntimeException(e.getMessage());
    	}
    }

    public List<Personas> ObtenerPersonas() throws BussinessException {
    	List<Personas> lista=repositorio.ObtenerPersonas();
		if(!lista.isEmpty())
			return lista;
		return null;
	}
    
	public Personas CrearPersona() throws BussinessException 
	{
		return repositorio.CrearPersona();
	}
	
	public void RegistrarPersona(Personas persona) throws BussinessException {
		if(this.PersonaHabilitada(persona.getDni()))
			repositorio.GuardarPersona(persona);
		throw new InvalidDnDOperationException("Persona inhabilitada para realizar operacion");
	}
	
	public Personas BuscarPersona(Integer id) throws BussinessException {
		Personas persona=repositorio.CrearPersona();
		persona=repositorio.BuscarPersona(id);
		if(persona != null){
			String sexo;
			if(persona.getSexo().equals("M"))
				sexo="MASCULINO";
			else
				sexo="FEMENINO";
			persona.setSexo(sexo);			
			return persona;
		}

		return null;
	}
	
	/**
	 * ObtenerNoSocios Obtiene la lista de personas que no son socios y que tuvieron actividad en el club
	 * @return List<Personas>
	 * @throws BussinessException
	 */
	public List<Personas> ObtenerNoSocios() throws BussinessException {	
		List<Personas> listaPersonas=repositorio.ObtenerPersonas();
		//Recorro mi collection
		for (Iterator<Personas> iter = listaPersonas.listIterator(); iter.hasNext(); ) {
			Personas persona = iter.next();
			//remuevo los socios que no esten dado de baja
			if (persona.getSocios() != null && !persona.getSocios().isBaja()){
				iter.remove();
			}
		}
		
		//los socios que esten dado de baja se toma como no socio
		for(Personas persona : listaPersonas){
			if(persona.getSocios() != null && persona.getSocios().isBaja())
				persona.setSocios(null);			
		}
		
		if(!listaPersonas.isEmpty())
			return listaPersonas;
		return null;
	}
	
	public void InhabilitarPersona(Integer dni) throws BussinessException {
		Personas persona= repositorio.BuscarPersona(dni);
		persona.setHabilitado(false);
		repositorio.GuardarPersona(persona);
	}
	
	public void habilitarPersona(int dni) throws BussinessException {
		Personas persona=repositorio.CrearPersona();
		persona=repositorio.BuscarPersona(dni);
		persona.setHabilitado(true);
		repositorio.GuardarPersona(persona);
	}
    
	/**
	 * FiltrarPersonasNombeApellido obtiene una lista de personas filtrando por nombre y apellido,
	 * se puede usar tanto para persona como para socio
	 * @param nom
	 * @param ape
	 * @return list<Personas>
	 * @throws BussinessException 
	 */
	public List<Personas> FiltrarPersonasNombeApellido(String nom, String ape) throws BussinessException {
		List<Personas> listafiltrada= repositorio.FiltrarPersonasPorNombreApellido(nom, ape);
		if(listafiltrada != null)
			return listafiltrada;
		return null;
	}
	
	private boolean PersonaHabilitada(Integer dni) throws BussinessException{
		Personas persona=repositorio.BuscarPersona(dni);
		if(persona != null){
			//Valido para socio(si es socio y no esta dado de baja)
			if(persona.getSocios() != null && !persona.getSocios().isBaja()){
				//Inhabilitado:
				//si el socio se dio de baja != moroso return true
				//si el socio es es moroso == moroso return false
				boolean valor= (!persona.isHabilitado() && persona.getSocios().getEstado().equals("Moroso"))
						      ?false:true;
				return valor;
			}
			//valido para los no socios
			else{
				//valida unicamente si esta habilitado o no 
				boolean valor= (!persona.isHabilitado())?false:true;
				return valor;
			}
		}
		return true;
	}

	public Socios CrearSocio() throws BussinessException 
	{
		return repositorio.CrearSocio();
	}
	
	
	
	public void GuardarSocio(Socios socio) throws BussinessException {
		if(this.PersonaHabilitada(socio.getPersonas().getDni())){	
			repositorio.GuardarSocio(socio);
		}
		else
		throw new InvalidDnDOperationException("Persona inhabilitada para realizar operacion");
    }
	
	public List<Socios> ListarSocio() throws BussinessException{
		List<Socios> lista=repositorio.ObtenerSocios();
		if(!lista.isEmpty())
			return lista;
		return null;
	}
	
	public Socios ObtenerSocio(Integer dni) throws BussinessException{
		return repositorio.BuscarSocio(dni);
	}
	
	public List<Socios> ListaActivaSocio() throws BussinessException {
		List<Socios> listaActivaSocio=new ArrayList<Socios>();
		List<Socios> listaSocios=repositorio.ObtenerSocios();
		for(Socios socio: listaSocios)
		{
			if(!socio.getEstado().equals("Moroso") && socio.getPersonas().isHabilitado())
			{
				listaActivaSocio.add(socio);
			}
		}
		if(!listaActivaSocio.isEmpty())
			return listaActivaSocio; 
		return null;
	}
//	public List<Socios> ObtnerTresPrimero(Integer id) {
//		List<Personas> personasList=new ArrayList<Personas>();
//		int i=0;
//		try {			
//			for(Personas personas : this.ListaActivaSocio()) 
//			{
//				if(personas.getDni() != id && i<2)
//					personasList.add(personas);
//				i++;
//			}
//			for(Personas personas : this.ListaActivaSocio()) 
//			{
//				if(personas.getDni() == id ) 
//				{
//					personasList.add(personas);
//					break;
//				}
//			}
//			return personasList;
//		}
//		catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}

	//Gestion Caja
	public Caja CrearCaja() throws BussinessException
	{
		return repositorio.CrearCaja();
	}
	
	public Conceptos CrearInstanciaConcepto() throws BussinessException {
		return repositorio.CrearConcepto();
	}
	
	public void GuardarRegistroCaja(Caja caja) throws BussinessException {
		repositorio.GuardarCaja(caja);
	}
	
	/**
	 * Calcula el subtotal de una lista de caja dependiendo el tipo de concepto
	 * @param listacaja
	 * @return float subtotal
	 */
	public float CalcularSubtotal(List<Caja> listacaja) {
		float subtotal=0;
		for(Caja caja : listacaja){
			if(caja.getConceptos().getTipo() == "I" && caja.isHabilitar())
				subtotal += caja.getMonto();		
			else{
				if(caja.getConceptos().getTipo() == "E" && caja.isHabilitar()){
					subtotal -= caja.getMonto();
				}
			}				
		}
		return subtotal;
	}

	public Caja BuscarRegistroCaja(Integer id) throws BussinessException {
		Caja caja=repositorio.BuscarCaja(id);
		if(caja != null)
			return caja;
		return null;
	}
	
	public List<Caja> ObtenerRegistrosCaja() throws BussinessException  {
		List<Caja> lista= repositorio.ObtenerCajas();
		if(!lista.isEmpty())
			return lista;
		return null;
	}
	
	public List<Caja> TotalEgresos() throws BussinessException {
		return repositorio.ListaTotalEgresos();
	}
	
	public List<Caja> TotalIngresos() throws BussinessException {
		return repositorio.ListaTotalIngreso();
	}
	
	public long ObtenerTotalRegistradosCaja() throws BussinessException {
		return repositorio.ObtenertotalRegistradoCaja();
		
	}
	
	public List<Caja> ListarCajaPorAnio(Integer anio) throws BussinessException {
		if(anio < 1900 || anio== null)
			throw new IllegalArgumentException("formato de año no reconocido");
		else
			return repositorio.ListaCajaPoranio(anio);
	}
	
	public List<Caja> ListarCajaMesAnio(Integer anio, Integer mes) throws BussinessException {
		if(anio!=null || mes!=null) { //motodo para validar fecha
			if(anio>1900 && mes<=12)
			   return repositorio.ListaCajaPormes(anio, mes);
			else
				throw new IllegalArgumentException("Error al ingresar la fecha,por favor verifique los datos");
		}
		else
			throw new IllegalArgumentException("Datos ingresado nulos");
	}
	
	public List<Caja> ListarCajaRangoFecha(Date fechaInicio,Date fechaFin) throws BussinessException {
		if(fechaInicio!=null && fechaFin!=null)//motodo para validar fecha
				return repositorio.ListaCajaPorRangoFecha(fechaInicio, fechaFin);
		else
			throw new IllegalArgumentException("Error al ingresar la fecha,por favor verifique los datos");
	}
	
	public void Inhabilitar(Caja entity) throws BussinessException {
		entity.setHabilitar(false);
        repositorio.GuardarCaja(entity);
	}
	
	public void habilitar(Caja entity) throws Exception {
		entity.setHabilitar(true);
        repositorio.GuardarCaja(entity);
	}
	
	public Caja ObtenerUltimoRegistro() throws BussinessException {
		int id= repositorio.ObtenerUltimoIdIngresadoCaja();
		if(id != 0 ){
			Caja caja=repositorio.CrearCaja();
			caja=repositorio.BuscarCaja(id);
			return caja;
		}
		return null;				
	}
	
	private int CasoBusqueda(Date FechaDesde, Date FechaHasta, String Descripcion,boolean Ingreso, boolean Egreso){		
		//Casos de filtro por descripcion en toda la caja
		if(!Descripcion.isEmpty())
			return 1;
		//Caso de filtro Egreso y Ingreso todos
		if((FechaDesde==null || FechaHasta == null)&& (Egreso && Ingreso) && Descripcion.isEmpty())
			return 2;
		//Caso de filtro Egresos todos
		if((FechaDesde==null || FechaHasta == null)&& ( Egreso && !Ingreso) && Descripcion.isEmpty())
			return 3;
		//Caso de filtro Ingresos Todos
		if((FechaDesde==null || FechaHasta == null)&& (!Egreso && Ingreso) && Descripcion.isEmpty())
			return 4;
		//Filtro por Rango de fechas en toda la caja
		if((FechaDesde!=null || FechaHasta != null)&& (Egreso && Ingreso ) && Descripcion.isEmpty())
			return 5;
		if((FechaDesde!=null || FechaHasta != null)&& (Egreso && !Ingreso ) && Descripcion.isEmpty())
			return 6;
		if((FechaDesde!=null || FechaHasta != null)&& (!Egreso && Ingreso ) && Descripcion.isEmpty())
			return 7;
		return 0;
	}
	
	
	/**
	 * ObtenerRegistroCajasPorParametros Obtiene diferentes listas de objetos caja dependiendo de los parametros 
	 * que se recien en la firma
	 * @param FechaDesde
	 * @param FechaHasta
	 * @param Descripcion
	 * @param Ingreso
	 * @param Egreso
	 * @return java.util.List caja 
	 * @throws BussinessException 
	 */
	public List<Caja> ObtenerRegistroCajasPorParametros(Date FechaDesde, Date FechaHasta, String Descripcion,boolean Ingreso, boolean Egreso) throws BussinessException{
		List<Caja> ListaCaja=new ArrayList<Caja>();
		switch (this.CasoBusqueda(FechaDesde,FechaHasta, Descripcion, Ingreso, Egreso)) {
		case 0:
			break;
		case 1:
			ListaCaja=repositorio.BusquedaPorDescripcionCaja(Descripcion);
			break;
		case 2:
			ListaCaja=repositorio.ObtenerCajas();
			break;
		case 3:
			ListaCaja=repositorio.ListaTotalEgresos();
			break;
		case 4:
			ListaCaja=repositorio.ListaTotalIngreso();
			break;
		case 5:  //todos
			ListaCaja=FiltrarPorIngreEgreso(repositorio.ListaCajaPorRangoFecha(FechaDesde, FechaHasta),true,true);
			break;
		case 6:  //egresos
			ListaCaja=FiltrarPorIngreEgreso(repositorio.ListaCajaPorRangoFecha(FechaDesde, FechaHasta),false,true);
			break;
		case 7:  //ingresos
			ListaCaja=FiltrarPorIngreEgreso(repositorio.ListaCajaPorRangoFecha(FechaDesde, FechaHasta),true,false);
			break;
		default:
			break;
		}
		return ListaCaja;
	}
	private List<Caja> FiltrarPorIngreEgreso(List<Caja> lista,Boolean ingreso,Boolean egreso){
		System.err.println("sdsa");;
		if(ingreso && !egreso){
			Iterator<Caja> it = lista.iterator();
			while (it.hasNext()) {
				String id = it.next().getConceptos().getTipo();
				if(id.equals("E"))
					it.remove();
			}
			
		}
		if(!ingreso && egreso){
			Iterator<Caja> it = lista.iterator();
			while (it.hasNext()) {
				String id = it.next().getConceptos().getTipo();
				if(id.equals("I"))
					it.remove();
			}
		}
		return lista;
	}
	
//	public void JDateChooserToString(JDateChooser fecha){
//		String fecha2=new String();
//		String formato = fecha.getDateFormatString();
//		Date date = fecha.getDate();
//		SimpleDateFormat sdf = new SimpleDateFormat(formato);
//		String fnacim = String.valueOf(sdf.format(date));
//		
//	}
	
	//Gestion Categoria
	public Categoria CrearRegistroCategoria() throws BussinessException {
		return  repositorio.CrearCategoria();
	}

	public void GuardarCaegoria(Categoria categoria) throws BussinessException {
		repositorio.GuardarCategoria(categoria);

	}
	
	public Categoria BuscarCategoria(Integer id) throws BussinessException {
		 return repositorio.BuscarCategoria(id);
	}
	
	public List<Categoria> ObtenerCategorias() throws BussinessException {
		List<Categoria> listaCategoria=repositorio.ObtenerCategorias();
		if(!listaCategoria.isEmpty())
			return listaCategoria;
		return null;
	}
	
	public void InhabilitarCategoria(Categoria categoria) throws BussinessException {
		categoria.setHabilitado(false);
		repositorio.GuardarCategoria(categoria);
	}

	public void habilitarCategoria(Categoria categoria) throws BussinessException {
		categoria.setHabilitado(true);
		repositorio.GuardarCategoria(categoria);
	}
	
	//Gestion Cuota
	
	public void ArmarPrimerCuota(Socios socio,String nombre,String apellido) throws Exception{
		Cuota cuota=repositorio.CrearCuota();
		cuota.setDescripcion("Primer Ingreso Cuota, Matricula socio: "+socio.getMatricula());
		cuota.setSocios(socio);
		cuota.setFechageneracion(new Date());
		cuota.setImporte(socio.getCategoria().getMonto());
		cuota.setEstado("Debe");
		repositorio.GuardarCuota(cuota);
	}
	
//	private float CalcularImporteCuota(Categoria categoria) throws Exception{
//		//leo el precio fijo en el archivo
//		float importeBase=this.LeerPrecioCuota();
//		//Calculo Precio
//		float total=importeBase+categoria.getMonto();
//		//retorno el total con descuento de porcentaje categoria
//		return total;//((total*categoria.getDescuento())/100);
//	}

	public float ObtenerPrecioCuota() throws Exception {
		return this.LeerPrecioCuota();
	}
	private boolean ComprobarCuota() throws BussinessException{
		int id=repositorio.ObtenerUltimoIdIngresadoCaja();
		if(id != -1){ // tabla contiene datos
			Cuota cuota=repositorio.BuscarCuota(id); 
			int mescuota=FechaHora.obtenerMes(cuota.getFechageneracion()); //llamo al metodo estatico de fecha hora y obtengo el mes
			int mesactual=FechaHora.obtenerMes(new Date());
			if(mescuota != mesactual)
				return true; //<-mes y anio distito de la ultima
			else
				return false;
		}
		else
			return true; //<- la tabla esta vacia
	}
	
    public void GenerarCuotas() throws BussinessException {
		int id=repositorio.ObtenerUltimoIdIngresadoCaja();// obtengo el ultimo id
		Cuota cuota=repositorio.BuscarCuota(id); // busco la cuota 
		
		repositorio.ObtenerCategorias();
		
	}
	
	public Cuota CrearRegistroCuota() throws BussinessException {
		return repositorio.CrearCuota();
	}
	
	private void VolcarDatosCuotaCaja(String tipo,Cuota cuota) throws BussinessException{
		Caja caja=repositorio.CrearCaja();
		int id= repositorio.ObtenerIdCaja(tipo);
		caja.setConceptos(repositorio.BuscarConceptos(id));		
		String nom=cuota.getSocios().getPersonas().getNombre();
		String ape=cuota.getSocios().getPersonas().getApellido();
		caja.setDescripcion("Ingreso Cuota Socio "+nom+" "+ape);
		caja.setFecha(cuota.getFechapago());
		caja.setHabilitar(true);
		caja.setMonto(cuota.getImporte());
		repositorio.GuardarCaja(caja);
		
	}
	
	public void GuardarCuota(Cuota cuota) throws BussinessException {
		ActualizarCuota(cuota);
		if(cuota.getIdCuota()<0)
			cuota.setIdCuota(null);
		repositorio.GuardarCuota(cuota);
		VolcarDatosCuotaCaja("I",cuota);
	}
	private Cuota ActualizarCuota(Cuota cuota){
		cuota.setDescripcion("Cuota paga mes "+(cuota.getFechageneracion().getMonth()+1)+" Anio "+(cuota.getFechageneracion().getYear()+1900));
		cuota.setFechapago(new Date());
		cuota.setEstado("PAGO");
		return cuota;
	}

	public Cuota BuscarCuota(Integer id) throws BussinessException {
		return repositorio.BuscarCuota(id);
	}
	
	public List<Cuota> ObtenerCuotas() throws BussinessException {
		List<Cuota> listacuota= repositorio.ObtenerCuotas();
		if(!listacuota.isEmpty())
			return listacuota;
		return null;
	}
	
	 private float LeerPrecioCuota() throws Exception{
		 File archivo= new File("src/ar/com/ProyectoClub/Configuraciones/Archivo_Precio_Cuota.txt");
		 BufferedReader leer= new BufferedReader(new FileReader(archivo));
		 String linea=leer.readLine();
		 float precioCuota= Float.parseFloat(linea);
		 return precioCuota;
	 }
	
	/**
	 * CambiarEstadoCuota
	 * Cambia el estado de una cuota segun el parametro que se pase como string
	 * Ejemplo: Activo Baja,etc
	 * @param cuota
	 * @param nuevoEstado
	 * @throws BussinessException
	 * 
	 */
	public void CambiarEstadoCuota(Cuota cuota,String nuevoEstado) throws BussinessException {
		 cuota.setEstado(nuevoEstado);
		 repositorio.GuardarCuota(cuota);
	}
	
	public void RegistrarPagoCuota(Cuota cuota) throws BussinessException{
		cuota.setFechapago(FechaHora.FechaActual());
		this.CambiarEstadoCuota(cuota,"Saldado");
	}

//	private void Generecion(Date fechaActual,Personas persona,float importeFinal) throws Exception{
//		Cuota nuevaCuota = new Cuota(); 
//		nuevaCuota.setPersonas(persona);
//		nuevaCuota.setFechaGeneracion(fechaActual);
//		nuevaCuota.setDescripcion("Generacion de la cuota del socio Numero "+persona.getNroSocio()+", Mes "+(fechaActual.getMonth()+1)+" Año "+(fechaActual.getYear()+1900));
//		nuevaCuota.setImporte(importeFinal);
//		nuevaCuota.setEstado("Debe");
//		nuevaCuota.setFechaPago(null);
//		this.Guardar(nuevaCuota);
//	}

	
//	@Override
//	public void GeneracionDeCuotas(Date fechaActual, List<Personas> PersonasActivas) throws Exception {
//		Integer idUltimo=cuotadao.ObtenerUltimoIdIngresado();
//		if(this.Busqueda(idUltimo).getFechaGeneracion().compareTo(fechaActual)!=0){ 
//			float precioOrigiCate,porcentajedesc,descuento;
//			Categoria categoria=new Categoria();
//			for(Personas socios : PersonasActivas){
//				categoria=socios.getCategoria();
//				precioOrigiCate=categoria.getMonto();
//				porcentajedesc=categoria.getDescuento();
//				descuento =(porcentajedesc/100)*precioOrigiCate; //Obtengo el Descuento
//				float importefinal=precioOrigiCate-descuento; //Importe final
//				this.Generecion(fechaActual,socios, importefinal);
//			}
//		}
//	}
	
	public Cuota ObtenerUltimaCuotaIngresado() throws BussinessException {
		Integer id=repositorio.ObtenerUltimoIdIngresadoCaja();
		Cuota cuota=repositorio.BuscarCuota(id);
		return cuota;
	}
	
	public List<Cuota> ObtenerCuotasPorid(List<Integer> listaId) throws BussinessException {
		List<Cuota> cuotas=new ArrayList<Cuota>();
		for(Integer idCuota : listaId)
			cuotas.add(repositorio.BuscarCuota(idCuota));
		if(!cuotas.isEmpty())
			return cuotas;
		return null;
					
	}
	
	public List<Cuota> ObtenerCuotasXEstado(String estado) throws BussinessException {
		List<Cuota> listacuota=repositorio.ObtenerCuotas();
		List<Cuota> listadocuotas=new ArrayList<Cuota>();
		if(!listacuota.isEmpty()){			
			for(Cuota cuota : listacuota){
				if(cuota.getEstado().equals(estado))
					listadocuotas.add(cuota);
			}
			return listadocuotas;
		}
		return null;
	}


	
	public List<Inmuebles> ObtenerInmuebles() throws BussinessException {
		return repositorio.ObtenerInmuebles();
	}

//	public List<Inmuebles> ListarInmuebleHabilitado() {
//		try {
//			java.util.List<Inmuebles> listaH =new ArrayList<Inmuebles>();
//			java.util.List<Inmuebles> lista =new ArrayList<Inmuebles>();
//			lista=repositorio.ObtenerInmuebles();
//			int num=lista.size();
//			for(int i=0;i<num;i++){
//				if((lista.get(i).isHabilitado())==true){
//					listaH.add(lista.get(i));
//				}
//				
//			}
//			return listaH;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			throw new RuntimeException("No se pudo instanciar el servicio debido a un error: ");
//		}
//	}
//gestion alquiler
	public Alquiler CrearAlquiler() throws BussinessException {
		return repositorio.CrearAlquiler();
	}

	public void GuardarInmueble(Inmuebles entity) throws BussinessException {
		repositorio.GuardarInmueble(entity);
	}

	
	public List<Conceptos> ObtenerConceptos() throws BussinessException {
		List<Conceptos> lista=repositorio.ObtenerConceptos();
		if(!lista.isEmpty())
			return lista;
		return null;
	}

	public Conceptos BuscarConcepto(Integer id) throws BussinessException {
		return repositorio.BuscarConceptos(id);
	}

	public void GuardarAlquiler(Alquiler alqui) throws BussinessException {
		repositorio.GuardarAlquiler(alqui);
	}

	public Alquiler buscarAlquiler(Integer numAlquiler) throws BussinessException {
			return repositorio.BuscarAlquiler(numAlquiler);
		 
	}
	
	public Inmuebles buscarInmueble(Integer id) throws BussinessException {
		
		return repositorio.BuscarInmueble(id);
	}
	

	public List<Alquiler> listarAlquileres() throws BussinessException {
		// TODO Auto-generated method stub
		List<Alquiler> lista= repositorio.ObtenerAlquileres();
		if(!lista.isEmpty())
			return lista;
		return null;
	}
	

	
	public void HabiliInhabiCategoria(int id) throws BussinessException {
		//Busco la categoria
		Categoria categoria= repositorio.CrearCategoria();
		categoria=	repositorio.BuscarCategoria(id);
		if(categoria != null){
			if(categoria.isHabilitado())
				categoria.setHabilitado(false);
			else
				categoria.setHabilitado(true);
			repositorio.GuardarCategoria(categoria);
		}
	}

	public Inmuebles CrearInmueble() throws BussinessException {
		return repositorio.CrearInmueble();
	}

	//Morosos
	public void ValidarCuotasSocio(List<Socios> listaSocio) throws BussinessException {
		Date fechaUltActiv=new Date();
		for(Socios socio : listaSocio){
			
			Cuota cuota=repositorio.CrearCuota();
			//obtengo el id del ultimo registro de cuota ingresado
			Integer id= repositorio.ObtenerUltimoIdCuotaSocio(socio.getDni());
			//Busco la cuota
			cuota=repositorio.BuscarCuota(id);
			if(cuota.getFechapago() != null)
				fechaUltActiv=FechaHora.sumarRestarMesFecha(cuota.getFechageneracion(), 1);
			else
				fechaUltActiv=cuota.getFechageneracion();
			
			Calendar fechaInicio = new GregorianCalendar();
			Calendar fechaFin = new GregorianCalendar();
			
			if(FechaHora.CompararFecha(fechaUltActiv))// FechaHora.FechaActual())
				fechaUltActiv= FechaHora.sumarRestarDiasFecha(fechaUltActiv, 1);
			
			int CantidadMes=FechaHora.DiferenciaMesFechas(fechaUltActiv,new Date()); //Obtengo la cantidad de meses de diferencia
			Socios socioMoroso=repositorio.CrearSocio();
			if(CantidadMes==0){
				//ACTIVO
				socioMoroso=socio;
				socioMoroso.setEstado("ACTIVO"); //Cambio su estado de Activo(mantiene su estado)
				socioMoroso.getPersonas().setHabilitado(true);
				//this.habilitarPersona(socio.getDni()); //Actualizo a habilitado
			}
			else{
				if(CantidadMes < 3 && CantidadMes>=1){
					//DEUDOR
					socioMoroso=socio;
					socioMoroso.setEstado("DEUDOR"); //Cambio su estado a Deudor
					socioMoroso.getPersonas().setHabilitado(true);
					//this.habilitarPersona(socio.getDni()); //Actualizo a habilitado
				}
				else{
					if(CantidadMes >= 3){
						//MOROSOS
						socioMoroso=socio;
						socioMoroso.setEstado("MOROSO"); //Cambio su estado de morosidad
						socioMoroso.getPersonas().setHabilitado(false);
						//this.InhabilitarPersona(socio.getDni()); //Actualizo a inhabilitado
					}
				}

			}
			repositorio.GuardarSocio(socioMoroso); //Actualizo para ese socio
		}
	}


	public boolean validarNombreInmueble(String tex,Integer id) throws BussinessException  {
		List<Inmuebles> list=new ArrayList<Inmuebles>();
		list=repositorio.ObtenerInmuebles();
		int num=list.size();
		boolean ban=false;
		if(!tex.equals(""))
		{
			
			for(int i=0;i<num;i++)
			{		String aux=list.get(i).getNombre();	
				if(aux.equals(tex))
				{
					if((id==null)||(!list.get(i).getIdInmubles().equals(id))){
						ban=true;
						break;
						}
					}
				}
			
		}else ban=true;
		
		 return ban;
	}

	public List<Alquiler> BusquedaAlquilerXFecha(Date fechaIn, Date fechaFin) throws BussinessException {
		
		return repositorio.BusquedaAlquilerXFecha(fechaIn, fechaFin);
	}

	public List<Alquiler> BusquedaAlquilerEntreFechas(Date fechaInicio,
			Date fechaFin) throws BussinessException {
		return repositorio.BusquedaAlquilerEntreFechas(fechaInicio, fechaFin);
	}
	public List<Alquiler> ListaAlquilerPormes(Integer anio, Integer mes)
			throws BussinessException {
		return repositorio.ListaAlquilerPormes(anio, mes);
	}

	public List<Alquiler> ListarAlquilerPorDia(int anio, int mes, int dia) throws BussinessException {
		
		return repositorio.ListarAlquilerPorDia(anio,mes,dia);
	}

	public List<Alquiler> ListarAlquilerPorDia(Date dia) throws BussinessException{
		return repositorio.ListarAlquilerPorDia(dia);
	}
	
	public List<Morosos> ListarMorososDeudor() throws BussinessException {
		 List<Morosos> listaMorDeu=new ArrayList<Morosos>();
		 List<Socios> listaMorosos=repositorio.ObtenerMorosos();
		 List<Socios> listaDeudores=repositorio.ObtenerDeudores();
		 if(listaMorosos != null ){
			 for(Socios socio:listaMorosos)
				 listaMorDeu.add(this.MapearSocioAMorososDeudor(socio,true));
		 }
		 if(listaDeudores != null){
			 for(Socios socio:listaDeudores)
				 listaMorDeu.add(this.MapearSocioAMorososDeudor(socio,false));
		 }
		return listaMorDeu;
	}
	
	private Morosos MapearSocioAMorososDeudor(Socios socio,Boolean esMoroso)throws BussinessException{
		Morosos moroso=new Morosos();
		Date fechaUltMov = new Date();
		moroso.setDni(socio.getDni());
		moroso.setNombre(socio.getPersonas().getNombre());
		moroso.setApellido(socio.getPersonas().getApellido());
		moroso.setTelefono(socio.getPersonas().getTelefono());
		moroso.setDomicilio(socio.getPersonas().getDomicilio());
		moroso.setCategoria(socio.getCategoria().getNombre());
		moroso.setMatricula(socio.getMatricula());
		moroso.setFechaingreso(socio.getFechaingreso());
		moroso.setEstado(socio.getEstado());
		fechaUltMov=repositorio.ObtenerUltimoFechaActividad(socio.getDni());
		if(fechaUltMov == null)
			fechaUltMov = repositorio.ObtenerUltimaFechaGeneracion(socio.getDni());	
		
		if(fechaUltMov==FechaHora.FechaActual())
			fechaUltMov= FechaHora.sumarRestarDiasFecha(fechaUltMov, 1);
		
		int diferencia=FechaHora.DiferenciaMesFechas(fechaUltMov, new Date());
		moroso.setCantMesAtraso(diferencia);  //meses atrasados
		moroso.setUltimaFecMovim(fechaUltMov); //ultima fecha de movimiento
		Categoria categoria=repositorio.ObtenerCategoriaSocio(socio.getDni());
		//si es moroso se multiplica por 3 el importe
		if(esMoroso)
			moroso.setImporteTotal(categoria.getMonto()*3);
		else{
			if(diferencia == 1 )
				moroso.setImporteTotal(categoria.getMonto()); //solo un mes de atraso-> importe solo
			else{
				if(diferencia == 2)
					moroso.setImporteTotal(categoria.getMonto()*2);
			}
		}
		return moroso;
	}

	public List<Morosos> FiltrarMoroso() throws BussinessException {
		List<Morosos> listaMorosos=new ArrayList<Morosos>();
		List<Socios> listasocios=repositorio.ObtenerMorosos();
		for(Socios socio:listasocios)
			listaMorosos.add(this.MapearSocioAMorososDeudor(socio,true));
		 return listaMorosos;
	}
	
	public List<Morosos> FiltrarDeudores() throws BussinessException {
		List<Morosos> listaDeudores=new ArrayList<Morosos>();
		List<Socios> listasocios=repositorio.ObtenerDeudores();
		for(Socios socio:listasocios)
			listaDeudores.add(this.MapearSocioAMorososDeudor(socio,true));
		 return listaDeudores;
	}

	//proceso Generacion cuota
	public List<Cuota> GeneracionCuotaSocio(Integer dni) throws BussinessException{
		Date fechaUltActiv =  new Date();
		List<Cuota> listaCuota= new ArrayList<Cuota>();
		Cuota cuota=repositorio.CrearCuota();
				
		
		//obtengo el id del ultimo registro de cuota ingresado
		Integer id= repositorio.ObtenerUltimoIdCuotaSocio(dni);
		//Busco la cuota
		cuota=repositorio.BuscarCuota(id);
		
		if(cuota.getFechapago() != null)
			fechaUltActiv=FechaHora.sumarRestarMesFecha(cuota.getFechageneracion(), 1);
		else
			fechaUltActiv=cuota.getFechageneracion();
		
		if(FechaHora.CompararFecha(fechaUltActiv))// FechaHora.FechaActual())
			fechaUltActiv=FechaHora.sumarRestarDiasFecha(fechaUltActiv, 1);
		int diferencia=FechaHora.DiferenciaMesFechas(fechaUltActiv, new Date()); //obtengo la diferencia de meses
		
		int c=1;
		switch (diferencia) {
		case 0:
			break; // no paso un mes por lo tanto no se genera la cuota
		case 1:
			if(cuota.getFechapago() != null) //si la fecha de pago es null genero cuota sino agrego la cuota registrada
				listaCuota.add(GenerarCuota(cuota,1)); 
			else
				listaCuota.add(cuota);
			break;
		case 2:
			if(cuota.getFechapago() != null){
				while(c<=2){
					listaCuota.add(GenerarCuota(cuota, c)); 
					c++;
				}
			}
			else{
				listaCuota.add(cuota);
				listaCuota.add(GenerarCuota(cuota,1)); 
			}
			break;
		default:
			if(cuota.getFechapago() != null){
				while(c<=3){
					listaCuota.add(GenerarCuota(cuota, c)); //para cualquier otro caso mayor o igual a 3 meses de atraso genera 3 cuotas de atraso
					c++;
				}
			}
			else{
				listaCuota.add(cuota);
				while(c<=2){
					listaCuota.add(GenerarCuota(cuota, c)); //para cualquier otro caso mayor o igual a 3 meses de atraso genera 3 cuotas de atraso
					c++;
				}
			}
			break;
		}
		return listaCuota;
		
	}

	private Cuota GenerarCuota(Cuota cuota,int i) throws BussinessException {
		Cuota nuevaCuota=repositorio.CrearCuota();
		nuevaCuota.setIdCuota(-i);//Genero id ficticcion para poder buscarlo en la grilla
		nuevaCuota.setDescripcion("Cuota impaga del socio, estado socio: "+cuota.getSocios().getEstado());
		nuevaCuota.setEstado(cuota.getSocios().getEstado());		
		nuevaCuota.setFechageneracion(FechaHora.sumarRestarMesFecha(cuota.getFechageneracion(),i));
	    nuevaCuota.setFechapago(null);
	    Categoria categoria=repositorio.ObtenerCategoriaSocio(cuota.getSocios().getDni());
	    nuevaCuota.setImporte(categoria.getMonto());
		nuevaCuota.setSocios(cuota.getSocios());
		return nuevaCuota;
	}

	
	public List<Cuota> ObtenerCuotasSocio(Integer dni) throws BussinessException {
		List<Cuota> listaCuota= repositorio.ListaCuotaSocio(dni);
		for (Iterator<Cuota> iter = listaCuota.listIterator(); iter.hasNext(); ) {
			Cuota cuota = iter.next();
			//remuevo los socios que no esten dado de baja
			if (cuota.getFechapago() == null)
				iter.remove();			
		}
		return listaCuota;
	}
}

