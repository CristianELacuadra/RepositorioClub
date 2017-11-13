package ar.com.ProyectoClub.CModelo.BNegocio;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
    
    public Usuario VerificarUsuario(String nick, String pass) throws BussinessException{
    	Usuario usuario= repositorio.CrearUsuario();
    	usuario=repositorio.ObtenerUsuarioPorNombre(nick);
    	if(usuario != null){
    		if(usuario.getPassword().equals(pass))
    			return usuario;
    		else
    			return new Usuario(null,null,null);
    	}
    	return null;
    }
	
    public Usuario ObtenerUsuarioPorNombre(String nombreUsuario){
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
    
    public void GuardarPersona(Personas persona) throws BussinessException {
    	if(this.PersonaHabilitada(persona.getDni()))
    		repositorio.GuardarPersona(persona);
    	else
    	throw new InvalidDnDOperationException("Persona inhabilitada para realizar operacion");
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
	
	public void habilitarPersona(Personas persona) throws BussinessException {
		persona.setHabilitado(true);
		repositorio.GuardarPersona(persona);
	}
    
	/**
	 * FiltrarPersonasNombeApellido obtiene una lista de personas filtrando por nombre y apellido,
	 * se puede usar tanto para persona como para socio
	 * @param nom
	 * @param ape
	 * @return list<Personas>
	 */
	public List<Personas> FiltrarPersonasNombeApellido(String nom, String ape) {
		List<Personas> listafiltrada= repositorio.FiltrarPersonasPorNombreApellido(nom, ape);
		if(!listafiltrada.isEmpty())
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
		if(this.PersonaHabilitada(socio.getPersonas().getDni()))
			repositorio.GuardarSocio(socio);
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
	
	public List<Caja> TotalEgresos() {
		return repositorio.ListaTotalEgresos();
	}
	
	public List<Caja> TotalIngresos() {
		return repositorio.ListaTotalIngreso();
	}
	
	public List<Caja> ListarCajaPorAnio(Integer anio) {
		if(anio < 1900 || anio== null)
			throw new IllegalArgumentException("formato de año no reconocido");
		else
			return repositorio.ListaCajaPoranio(anio);
	}
	
	public List<Caja> ListarCajaMesAnio(Integer anio, Integer mes) {
		if(anio!=null || mes!=null) { //motodo para validar fecha
			if(anio>1900 && mes<=12)
			   return repositorio.ListaCajaPormes(anio, mes);
			else
				throw new IllegalArgumentException("Error al ingresar la fecha,por favor verifique los datos");
		}
		else
			throw new IllegalArgumentException("Datos ingresado nulos");
	}
	
	public List<Caja> ListarCajaRangoFecha(Date fechaInicio,Date fechaFin) {
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
			return 5;
		if((FechaDesde!=null || FechaHasta != null)&& (!Egreso && Ingreso ) && Descripcion.isEmpty())
			return 5;
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
		switch (this.CasoBusqueda(FechaDesde, FechaHasta, Descripcion, Ingreso, Egreso)) {
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
		case 5:
			ListaCaja=repositorio.ListaCajaPorRangoFecha(FechaDesde, FechaHasta);
			break;
		default:
			break;
		}
		if(!ListaCaja.isEmpty())
			return ListaCaja;
		return null;
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
	public Cuota CrearRegistroCuota() throws BussinessException {
		return repositorio.CrearCuota();
	}
	
	public void GuardarCuota(Cuota cuota) throws BussinessException {
		 repositorio.GuardarCuota(cuota);
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
	
	public List<Cuota> ObtenerCuotasDelSocio(Integer dni) {
		List<Cuota>cuotassocios=repositorio.ListaCuotaSocio(dni);
		if(!cuotassocios.isEmpty())
			return cuotassocios;
		return null;
	}

	
	public List<Inmuebles> ObtenerInmuebles() throws BussinessException {
		return repositorio.ObtenerInmuebles();
	}

	public List<Inmuebles> ListarInmuebleHabilitado() {
		try {
			java.util.List<Inmuebles> listaH =new ArrayList<Inmuebles>();
			java.util.List<Inmuebles> lista =new ArrayList<Inmuebles>();
			lista=repositorio.ObtenerInmuebles();
			int num=lista.size();
			for(int i=0;i<num;i++){
				if((lista.get(i).isHabilitado())==true){
					listaH.add(lista.get(i));
				}
				
			}
			return listaH;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("No se pudo instanciar el servicio debido a un error: ");
		}
	}
//gestion alquiler
	public Alquiler CrearAlquiler() throws BussinessException {
		return repositorio.CrearAlquiler();
	}

	public void GuardarInmueble(Inmuebles entity) throws BussinessException {
		repositorio.GuardarInmueble(entity);
	}

	

	

	

	
	
}
