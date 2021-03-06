package ar.com.ProyectoClub.CModelo.DRepository.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import ar.com.ProyectoClub.CModelo.CEntidades.*;
import ar.com.ProyectoClub.CModelo.DRepository.ClassParameterized.*;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.BussinessException;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.IGenericDAO;
import ar.com.ProyectoClub.CModelo.DRepository.GenericDaoAndSession.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DRepository.IRepository.IRepository;

@SuppressWarnings("rawtypes")
public class Repository extends GenericDAOImplHibernate implements IRepository {
	
	//por cada clase de mi modelo un objeto a genericdao
	private IGenericDAO<Personas, Integer>  personadao;
	private IGenericDAO<Socios, Integer>    sociodao;
	private IGenericDAO<Alquiler, Integer>  alquilerDao;
	private IGenericDAO<Caja, Integer>      cajadao;
	private IGenericDAO<Categoria, Integer> categoriaDao;
	private IGenericDAO<Cuota, Integer>     cuotaDao;
	private IGenericDAO<Inmuebles, Integer> InmuebleDao;
	private IGenericDAO<Usuario, Integer>   usuarioDao;
	private IGenericDAO<Conceptos, Integer> conceptosDao;

	public Repository() throws Exception 
	{
		super();
		personadao=   new PersonaImplHibernate();
		sociodao =    new SociosDaoImplHibernate();
		alquilerDao = new AlquilerDaoImplHibernate();
		cajadao =     new CajaDaoImplHibernate();
		categoriaDao= new CategoriaDaoImplHibernate();
		cuotaDao =    new CuotaDaoImplHibernate();
		InmuebleDao=  new InmueblesDaoImplHibernate();
		usuarioDao =  new UsuarioDaoImplHibernate();
		conceptosDao= new ConceptosDaoImplHibernate();
	}
	
	@Override
	public Alquiler CrearAlquiler() throws BussinessException {
		return alquilerDao.crear();
	}
	
	@Override
	public Socios CrearSocio() throws BussinessException {
		return sociodao.crear();
	}
	
	@Override
	public Categoria CrearCategoria() throws BussinessException {
		return categoriaDao.crear();
	}

	@Override
	public Conceptos CrearConcepto() throws BussinessException {
	     return conceptosDao.crear();	
	}

	@Override
	public Cuota CrearCuota() throws BussinessException {
		return cuotaDao.crear();
	}

	@Override
	public Usuario CrearUsuario() throws BussinessException {
		return usuarioDao.crear();
	}
	
	@Override
	public Caja CrearCaja() throws BussinessException {
		return cajadao.crear();
	}
	
	@Override
    public Personas CrearPersona() throws BussinessException {
		return personadao.crear();
	}
		
	@Override
	public Inmuebles BuscarInmueble(Integer id) throws BussinessException 
	{
		return InmuebleDao.BuscarUno(id);
	}

	@Override
	public Personas BuscarPersona(Integer id) throws BussinessException 
	{	
		return personadao.BuscarUno(id);
	}

	@Override
	public Socios BuscarSocio(Integer id) throws BussinessException 
	{
		return sociodao.BuscarUno(id);		
	}

	@Override
	public Alquiler BuscarAlquiler(Integer id) throws BussinessException 
	{
		return alquilerDao.BuscarUno(id);
	}

	@Override
	public Caja BuscarCaja(Integer id) throws BussinessException 
	{
		return cajadao.BuscarUno(id);	
	}

	@Override
	public Categoria BuscarCategoria(Integer id) throws BussinessException
	{
		return categoriaDao.BuscarUno(id);	
	}

	@Override
	public Conceptos BuscarConceptos(Integer id) throws BussinessException 
	{
		return conceptosDao.BuscarUno(id);
	}

	@Override
	public Cuota BuscarCuota(Integer id) throws BussinessException {
		return cuotaDao.BuscarUno(id);
	}

	@Override
	public Usuario BuscarUsuario(Integer id) throws BussinessException 
	{
		return usuarioDao.BuscarUno(id);
	}

	@Override
	public void GuardarAlquiler(Alquiler alquiler) throws BussinessException 
	{
		alquilerDao.GuardarEntity(alquiler);	
	}

	@Override
	public void GuardarCaja(Caja caja) throws BussinessException 
	{
		cajadao.GuardarEntity(caja);
	}

	@Override
	public void GuardarCategoria(Categoria categoria) throws BussinessException 
	{
		categoriaDao.GuardarEntity(categoria);		
	}

	@Override
	public void GuardarConcepto(Conceptos concepto) throws BussinessException 
	{	
		conceptosDao.GuardarEntity(concepto);
	}

	@Override
	public void GuardarCuota(Cuota cuota) throws BussinessException 
	{
		cuotaDao.GuardarEntity(cuota);
	}

	@Override
	public void GuardarInmueble(Inmuebles inmueble) throws BussinessException 
	{
		InmuebleDao.GuardarEntity(inmueble);			
	}

	@Override
	public void GuardarPersona(Personas persona) throws BussinessException 
	{
		personadao.GuardarEntity(persona);		
	}

	@Override
	public void GuardarSocio(Socios socio) throws BussinessException 
	{
		sociodao.GuardarEntity(socio);	
	}
	@Override
	public List<Alquiler> ObtenerAlquileres() throws BussinessException 
	{
		return alquilerDao.Listar();
	}
	@Override
	public List<Caja> ObtenerCajas() throws BussinessException 
	{
		return cajadao.Listar();
	}
	@Override
	public List<Categoria> ObtenerCategorias() throws BussinessException 
	{
		return categoriaDao.Listar();
	}
	@Override
	public List<Conceptos> ObtenerConceptos() throws BussinessException 
	{
		return conceptosDao.Listar();
	}
	@Override
	public List<Cuota> ObtenerCuotas() throws BussinessException 
	{
		return cuotaDao.Listar();
	}
	@Override
	public List<Inmuebles> ObtenerInmuebles() throws BussinessException 
	{
		return InmuebleDao.Listar();	
	}
	@Override
	public List<Personas> ObtenerPersonas() throws BussinessException 
	{
		return personadao.Listar();
	}
	@Override
	public List<Socios> ObtenerSocios() throws BussinessException 
	{
		List<Socios> listaSocio=new ArrayList<Socios>();
		for(Socios socio : sociodao.Listar()){
			if(!socio.isBaja()){//filtro unicamente lo que no estan dado de baja
				listaSocio.add(socio);
			}
		}
		return listaSocio;
	}
	@Override
	public List<Usuario> ObtenerUsuarios() throws BussinessException 
	{
		return usuarioDao.Listar();
	}
	@Override
	public void EliminarAlquiler(Integer id) throws BussinessException 
	{
		alquilerDao.Eliminar(id);
	}
	@Override
	public void EliminarCaja(Integer id) throws BussinessException 
	{
		cajadao.Eliminar(id);

	}
	@Override
	public void EliminarCategoria(Integer id) throws BussinessException 
	{
		categoriaDao.Eliminar(id);
	}
	@Override
	public void EliminarConcepto(Integer id) throws BussinessException 
	{
		conceptosDao.Eliminar(id);

	}
	@Override
	public void EliminarCuota(Integer id) throws BussinessException 
	{
		cuotaDao.Eliminar(id);		
	}
	@Override
	public void EliminarInmueble(Integer id) throws BussinessException 
	{
		InmuebleDao.Eliminar(id);

	}
	@Override
	public void EliminarPersona(Integer id) throws BussinessException 
	{
		personadao.Eliminar(id);

	}
	@Override
	public void EliminarSocio(Integer id) throws BussinessException 
	{
		sociodao.Eliminar(id);	
	}
	@Override
	public void EliminarUsuario(Integer id) throws BussinessException 
	{
		usuarioDao.Eliminar(id);

	}
	
	//Consultas (Hibernate Query Lenguaje)
	@SuppressWarnings("unchecked")
	/**
	 *
	 * public List<Alquiler> BusquedaAlquilerXFecha(Date fecha) : realiza una consulta sobre la base de dato
	 * para buscar todos los alquiler que se hicieron en una fecha particular(fecha de reserva)
	 * devuelve lista de alquileres
	 **/
	@Override
	public List<Alquiler> BusquedaAlquilerXFecha(Date fechainicial, Date fechafin) throws BussinessException 
	{
		Setsession();
		SetTransaction();
			String consulta = "SELECT a FROM Alquiler a WHERE a.fechareserva BETWEEN :start AND :end "; //Query rango de fecha
			//String consulta = "SELECT a FROM Alquiler a WHERE a.fechareserva BETWEEN @fechainicial AND @fechafin "; //Query rango de fecha
			Query query = _sessiondehilo.createQuery(consulta);
			query.setDate("start", fechainicial);
			query.setDate("end",fechafin);
			List<Alquiler> listAlquiler=query.list();
			if(!listAlquiler.isEmpty())
				return listAlquiler;
			return null;
//			_query.setParameter("start", fechainicial); //parametro inicial
//			_query.setParameter("end", fechafin); //parametro final
//			return _query.list(); //return lista alquileres		
			
	}

	@SuppressWarnings("unchecked")
	public List<Alquiler> BusquedaAlquilerEntreFechas(Date fechaInicial,Date fechaFinal)  throws BussinessException 
	{
		Setsession();
		SetTransaction();
		String consulta="SELECT a FROM Alquiler a WHERE a.fechaactual BETWEEN :start AND :end ";
		
		Query query = _sessiondehilo.createQuery(consulta);
		query.setDate("start", fechaInicial);
		query.setDate("end", fechaFinal);
		List<Alquiler> listAlquileres=query.list();
		if(!listAlquileres.isEmpty())
			return listAlquileres;
		return null;

	}	
	
	
	@SuppressWarnings("unchecked")
	public List<Alquiler> ListaAlquilerPormes(Integer anio, Integer mes) throws BussinessException {
		Setsession();
		SetTransaction();
		String query="SELECT a FROM Alquiler a WHERE month(a.fechareserva)="+mes+"AND YEAR(a.fechareserva)="+anio;
		List<Alquiler> listAlquileres= _sessiondehilo.createQuery(query).list();
		if(!listAlquileres.isEmpty() )
			return listAlquileres;
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Alquiler> ListarAlquilerPorDia(int anio, int mes, int dia) throws BussinessException {
		Setsession();
		SetTransaction();
		String query="SELECT a FROM Alquiler a WHERE month(a.fechareserva)="+mes+ "AND year(a.fechareserva)="+anio+ "AND day(a.fechareserva)="+dia;
		List<Alquiler> listAlquileres= _sessiondehilo.createQuery(query).list();
		if(!listAlquileres.isEmpty() )
			return listAlquileres;
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Alquiler> ListarAlquilerPorDia(Date dia) throws BussinessException{
		Setsession();
		SetTransaction();
		String query= "SELECT a FROM Alquiler a WHERE Date(a.fechareserva)="+dia;
		List<Alquiler> listAlquileres= _sessiondehilo.createQuery(query).list();
		if(!listAlquileres.isEmpty() )
			return listAlquileres;
		return null;
	}
	
	public List<Alquiler> listaAlquileresPorInmueble(Integer idInmueble) throws BussinessException{
		Setsession();
		SetTransaction();
		String query="SELECT a FROM Alquiler a WHERE a.inmuebles.idInmubles="+idInmueble;
		List<Alquiler> listAlquileres= _sessiondehilo.createQuery(query).list();
		if(!listAlquileres.isEmpty())
			return listAlquileres;
		return null;
	}	
	
	public long NumeroAlquileresPorInmueble(Integer idInmueble) throws BussinessException {
		Setsession();
		SetTransaction();
		String query="SELECT count(a) FROM Alquiler a WHERE a.inmuebles.idInmubles="+idInmueble;
		long i=(long) _sessiondehilo.createQuery(query).uniqueResult();
		if(i!=0)
			return i;
		return 0;
				
	};
	
	@Override
	public long DevolverTotalRegistrosCaja() throws BussinessException 
	{
		Setsession();
		SetTransaction();
		String consulta="SELECT count(caja) from Caja caja";
		long i= (Long) _sessiondehilo.createQuery(consulta).uniqueResult();
		if(i != 0)
			return i;
		return 0;
	}
	
	//este metodo hay fijarse en el gestor para dividir rango de fecha ingresos y rango de fecha egresos
	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaCajaPorRangoFecha(Date FechaDesde, Date FechaHasta) throws BussinessException 
	{
		Setsession();
		SetTransaction();
		String consulta="SELECT c FROM Caja c WHERE c.fecha BETWEEN :start AND :end ";
		Query query = _sessiondehilo.createQuery(consulta);
		query.setDate("start", FechaDesde);
		query.setDate("end", FechaHasta);
		List<Caja> listcaja=query.list();
		if(!listcaja.isEmpty())
			return listcaja;
		return null;

	}
	//este metodo sera llamado por 2 metodos en el gestor para dividir los ingresos por un lado e egresos por otro lado
	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaCajaPoranio(Integer anio) throws BussinessException 
	{
		Setsession();
		SetTransaction();
		String query="SELECT c FROM Caja c WHERE YEAR(c.fecha)="+anio;
		List<Caja> listaCaja=_sessiondehilo.createQuery(query).list();
		if(!listaCaja.isEmpty())
			return listaCaja;
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaCajaPormes(Integer anio, Integer mes) throws BussinessException {
		Setsession();
		SetTransaction();
		String query="SELECT c FROM Caja c WHERE month(c.fecha)="+mes+"and YEAR(c.fecha)="+anio;
		List<Caja> listaCaja= _sessiondehilo.createQuery(query).list();
		if(!listaCaja.isEmpty() )
			return listaCaja;
		return null;
	}

	@Override
	public Integer ObtenerUltimoIdIngresadoCaja() throws BussinessException {
		Setsession();
		SetTransaction();
		Integer IdCaja= (Integer) _sessiondehilo.createQuery("SELECT MAX (q.idCaja) FROM Caja q").uniqueResult();
		if(IdCaja != 0)
			return IdCaja;
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> BusquedaPorDescripcionCaja(String Descripcion) throws BussinessException {
		Setsession();
		SetTransaction();
		String consulta="SELECT c FROM Caja c WHERE c.descripcion LIKE '%"+Descripcion+"%'"; //filtro por descripcion			
		List<Caja> listacaja =_sessiondehilo.createQuery(consulta).list();
		if(!listacaja.isEmpty())
			return listacaja;
		return null;						
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaTotalEgresos() throws BussinessException{
		Setsession();
		SetTransaction();
		String consulta="SELECT c.cajas FROM Conceptos c WHERE c.tipo='E'";
		List<Caja> listcaja= _sessiondehilo.createQuery(consulta).list();
		if(!listcaja.isEmpty())
			return listcaja;
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaTotalIngreso() throws BussinessException {
		Setsession();
		SetTransaction();
		String consulta="SELECT c.cajas FROM Conceptos c WHERE c.tipo='I'";
		List<Caja> listcaja=_sessiondehilo.createQuery(consulta).list();
		if(!listcaja.isEmpty())
			return listcaja;
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cuota> ListaCuotaSocio(Integer dni) throws BussinessException {
		Setsession();
		SetTransaction();
		String query="SELECT s.cuotas FROM Socios s WHERE s.dni="+ dni; 
		List<Cuota> listacouta=_sessiondehilo.createQuery(query).list();
		if(!listacouta.isEmpty())
			return listacouta;
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cuota> ListaCuotaMes(int mes, int anio) throws BussinessException {
		Setsession();
		SetTransaction();
		String query="SELECT c FROM Cuota c WHERE MONTH(c.fechageneracion)="+mes+" and  YEAR(c.fechageneracion)="+anio;
		List<Cuota> listacouta=_sessiondehilo.createQuery(query).list();
		if(!listacouta.isEmpty())			
			return listacouta;
		return null;
	}

	@Override
	public Integer ObtenerUltimoIdIngresadoCuota() throws BussinessException {
		Setsession();
		SetTransaction();
		String query="SELECT COUNT(*) FROM Cuota c";
		long total= (Long)_sessiondehilo.createQuery(query) .uniqueResult();
		if(total != 0){
			Integer UltimoId= (Integer) _sessiondehilo.createQuery("SELECT MAX (c.id) FROM Cuota c").uniqueResult();
			return UltimoId;
		}
		else return -1;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cuota> ObternerCuotasImpagas() throws BussinessException {
		Setsession();
		SetTransaction();
		List<Cuota> listacuota=_sessiondehilo.createQuery("SELECT c  from Cuota c where c.fechaPago IS NULL").list();
		if(!listacuota.isEmpty())
			return listacuota;
		return null;
	}

	@Override
	public List<Personas> FiltrarPersonasPorNombreApellido(String Nom, String Ape) throws BussinessException {
		Setsession();
		SetTransaction();
		String consulta=new String();
		if(!Nom.isEmpty() && Ape.isEmpty())
			consulta="SELECT p FROM Personas p WHERE nombre LIKE '%"+Nom+"%'"; //filtro por nombre
		if(Nom.isEmpty() && !Ape.isEmpty())
			consulta="SELECT p FROM Personas p WHERE apellido LIKE '%"+Ape+"%'"; //filtro por apellido
		if(!Nom.isEmpty() && !Ape.isEmpty())
			consulta="SELECT p FROM Personas p WHERE nombre LIKE '%"+Nom+"%' OR apellido LIKE '%"+Ape+"%'"; //filtro por nombre y apellido
		@SuppressWarnings("unchecked")
		List<Personas> lista=_sessiondehilo.createQuery(consulta).list();
		if(!lista.isEmpty())
			return lista;
		return null;
	}
	
	@Override
	public long NoSociosRegistrados() throws BussinessException {
			Setsession();
			SetTransaction();
			long total= (Long) _sessiondehilo.createQuery("SELECT COUNT(*) FROM Personas p WHERE p.essocio=false").uniqueResult();
			if(total != 0)
				return  total;
			return 0;
	}

	@Override
	public Usuario ObtenerUsuarioPorNombre(String nombreUsuario) throws BussinessException {
			Setsession();
			SetTransaction();
			Usuario usuario= new Usuario();
			String consulta="SELECT u FROM Usuario u WHERE u.nick= '"+nombreUsuario+"'";
			usuario= (Usuario) _sessiondehilo.createQuery(consulta).uniqueResult();
			if(usuario != null)
				return usuario;
			return null;
	}

	@Override
	public long ObtenertotalRegistradoCaja() throws BussinessException {
			Setsession();
			SetTransaction();
			long total= (Long) _sessiondehilo.createQuery("SELECT COUNT(*) FROM Caja c").uniqueResult();
			return total;
	}

	@Override
	public Inmuebles CrearInmueble() throws BussinessException {
		return InmuebleDao.crear();
	}

	@Override
	public int ObtenerIdCaja(String tipo) throws BussinessException {
		Setsession();
		SetTransaction();
		String consulta="SELECT c.idConcepto FROM Conceptos c WHERE c.tipo="+"'"+tipo+"'";
		int i= (int) _sessiondehilo.createQuery(consulta).uniqueResult();
		if(i != 0)
			return i;
		return 0;
	}

	
	@Override
	public Date ObtenerUltimoFechaActividad(Integer dni) throws BussinessException {
		Setsession();
		SetTransaction();
		String query="select MAX(c.fechapago) from Cuota c inner join c.socios as s where s in(select s from Socios s where s.dni="+dni+")";
		return (Date) _sessiondehilo.createQuery(query).uniqueResult();
	}
	
	@Override
	public Date ObtenerUltimaFechaGeneracion(Integer dni) throws BussinessException {
		Setsession();
		SetTransaction();
		String query="select MAX(c.fechageneracion) from Cuota c inner join c.socios as s where s in(select s from Socios s where s.dni="+dni+")";
		return (Date) _sessiondehilo.createQuery(query).uniqueResult();
	}
	
	@Override
	public float ObtenerUltimoImporteSocio(Date fechaultReg,Integer dni) throws BussinessException {
		Setsession();
		SetTransaction();
		String query="select c.importe from Cuota c inner join c.socios as s where c.fechapago='"+fechaultReg+"' and s in(select s from Socios s where s.dni="+dni+")";
		return (float) _sessiondehilo.createQuery(query).uniqueResult();
	}

	@Override
	public List<Socios> ObtenerMorosos() throws BussinessException {
		Setsession();
		SetTransaction();
		String consulta="SELECT s FROM Socios s WHERE s.estado='MOROSO' and s.baja=false";
		List<Socios> listsSocios= _sessiondehilo.createQuery(consulta).list();
		if(!listsSocios.isEmpty())
			return listsSocios;
		return null;
		
	}

	@Override
	public List<Socios> ObtenerDeudores() throws BussinessException {
		Setsession();
		SetTransaction();
		String consulta="SELECT s FROM Socios s WHERE s.estado='DEUDOR' and s.baja=false";
		List<Socios> listaDeudor= _sessiondehilo.createQuery(consulta).list();
		return listaDeudor;
	}

	
	@Override
	public Categoria ObtenerCategoriaSocio(Integer dni) throws BussinessException {
		Setsession();
		SetTransaction();
		String consulta="SELECT s.categoria FROM Socios s WHERE s.dni="+dni;
		return (Categoria) _sessiondehilo.createQuery(consulta).uniqueResult();
	}

	
	@Override
	public Integer ObtenerUltimoIdCuotaSocio(Integer dni) throws BussinessException {
		Setsession();
		SetTransaction();
		String query= "select MAX(c.id) from Cuota c inner join c.socios as s where s in (select s from Socios s where s.dni="+dni+")";
		return (Integer) _sessiondehilo.createQuery(query).uniqueResult();
		
	}

	
	
	@Override
	public Categoria ObteerCategoriaXNombre(String nombreCategoria) throws BussinessException {
		Setsession();
		SetTransaction();
		String consulta="SELECT c FROM Categoria c WHERE c.nombre= '"+nombreCategoria+"'";
		return (Categoria) _sessiondehilo.createQuery(consulta).uniqueResult();
	}
	
}
