package ar.com.ProyectoClub.CModelo.BGestores;

import java.awt.geom.Arc2D.Float;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;

import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.loader.custom.Return;
import org.jboss.jandex.ThrowsTypeTarget;

import com.mysql.jdbc.NotImplemented;
import com.toedter.calendar.JDateChooser;

import ar.com.ProyectoClub.CModelo.AServicios.FechaHora;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorCaja;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICajaDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.CajaDaoImplHibernate;

public class GestorCaja implements IGestorCaja {
	private ICajaDAO _cajadao;
	private List<Caja> _lista;

	public GestorCaja() {
		try {
			_cajadao=new CajaDaoImplHibernate();
			_lista=new ArrayList<Caja>();
		}
		catch (Exception e) {
			throw new RuntimeException("Error al iniciar el gestor: "+e.toString());
		}
	}

	@Override
	public Caja Crear() throws Exception {
		return(_cajadao.crear());//->Devuelve nueva instancia de la entidad personas
	}
	
	private Date TomarFecha() {
		return(FechaHora.FechaActual());
	}
	
	@Override
	public float DevolverSubtotal() {
		return _cajadao.Subtotal();
	}

	@Override
	public void Guardar(Caja entity) throws Exception {
		//si es un egreso pone alquiler y cuota es null
		//(es valido que ingreso llegue con null y se guarde correctamente )
		if(!entity.isTipo()) {
			entity.setAlquiler(null);
			entity.setCuota(null);
		}
		_cajadao.GuardarEntity(entity);	
	}

	@Override
	public Caja Busqueda(Integer id) throws Exception {
			Caja _uno=this.Crear();
			_uno=_cajadao.BuscarUno(id);
			return _uno;
	}

	@Override
	public List<Caja> Listar() throws Exception {
		_lista.clear();
		_lista=null;
			_lista=_cajadao.Listar();
			return _lista;
	}
	/**
	 * (non-Javadoc)
	 * @return lista total de egresos
	 * @see ar.com.ProyectoClub.CModelo.BIGestores.IGestorCaja#TotalEgresos(java.lang.Integer, java.lang.Integer)
	 **/
	@Override
	public List<Caja> FiltrarEgresos() {
		_lista.clear();
		_lista=null;
		if(_cajadao.ListaTotalEgresos()!=null)
			_lista=_cajadao.ListaTotalEgresos();
		return _lista;
	}
	/**
	 * (non-Javadoc)
	 * @return lista total de egresos
	 * @see ar.com.ProyectoClub.CModelo.BIGestores.IGestorCaja#TotalEgresos(java.lang.Integer, java.lang.Integer)
	 **/
	@Override
	public List<Caja> FiltrarIngresos() {
		_lista.clear();
		_lista=null;
		if(_cajadao.ListaTotalEgresos()!=null)
			_lista=_cajadao.ListaTotalIngreso();
		return _lista;
	}
	
	@Override
	public List<Caja> ListarEgresoAnio(Integer anio) {
		_lista.clear();
		_lista=null;
		if(anio<1900 || anio==null) //motodo para validar fecha
			throw new IllegalArgumentException("Error al ingresar el año");
		else {
				_lista=_cajadao.ListaPoranio(anio,false); //filtrar por fecha	 
		}
		return _lista;
	}
	
	@Override
	public List<Caja> ListarEgresoFecha(Integer anio, Integer mes, Integer dia) {
		_lista.clear();
		_lista=null;
		if(anio!=null || mes!=null || dia!=null) { //motodo para validar fecha
			if(FechaHora.ValidarFechaEntrada(anio, mes, dia))
				_lista=_cajadao.ListaPoranio(anio,false); //filtrar por fecha   
		}
		else
			throw new IllegalArgumentException("Error al ingresar la fecha,por favor verifique los datos");

		return _lista;
	}
	
	@Override
	public List<Caja> ListarEgresoMesAnio(Integer anio, Integer mes) {
		_lista.clear();
		_lista=null;
		if(anio!=null || mes!=null) { //motodo para validar fecha
			if(anio>1900 && mes<=12)
				_lista=_cajadao.ListaPoranio(anio,false); //filtrar por fecha   
		}
		else
			throw new IllegalArgumentException("Error al ingresar la fecha,por favor verifique los datos");

		return _lista;
	}
	@Override
	public List<Caja> ListaringresoAnio(Integer anio) {
		_lista.clear();
		_lista=null;
		if(anio<1900 || anio==null) //motodo para validar fecha
			throw new IllegalArgumentException("Error al ingresar el año");
		else {
				_lista=_cajadao.ListaPoranio(anio,true); //filtrar por fecha	 
		}
		return _lista;
	}
	
	@Override
	public List<Caja> ListaringresoFecha(Integer anio, Integer mes, Integer dia) {
		_lista.clear();
		_lista=null;
		if(anio!=null || mes!=null || dia!=null) { //motodo para validar fecha
			if(FechaHora.ValidarFechaEntrada(anio, mes, dia))
				_lista=_cajadao.ListaPoranio(anio,true); //filtrar por fecha   
		}
		else
			throw new IllegalArgumentException("Error al ingresar la fecha,por favor verifique los datos");

		return _lista;
	}
	@Override
	public List<Caja> ListaringresoMesAño(Integer anio, Integer mes) {
		_lista.clear();
		_lista=null;
		if(anio!=null || mes!=null) { //motodo para validar fecha
			if(anio>1900 && mes<=12)
				_lista=_cajadao.ListaPoranio(anio,true); //filtrar por fecha   
		}
		else
			throw new IllegalArgumentException("Error al ingresar la fecha,por favor verifique los datos");

		return _lista;
	}
	
	@Override
	public void Inhabilitar(Caja entity) throws Exception {
		throw new NotImplemented();

	}

	@Override
	public void habilitar(Caja entity) throws Exception {
		throw new NotImplemented();
	}

	@Override
	public Caja ObtenerUltimoRegistro() {
		try{
			Caja caja=_cajadao.crear();
			Integer id=_cajadao.ObtenerUltimoIdIngresado();
			caja=_cajadao.BuscarUno(id);
			return caja;
		}
		catch (Exception e) {
			throw new RuntimeException("ERROR"+e.toString()); 
		}
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

	@Override
	public List<Caja> ObtenerRegistroCajasPorParametros(Date FechaDesde, Date FechaHasta, String Descripcion,boolean Ingreso, boolean Egreso) throws Exception {
		List<Caja> ListaCaja=new ArrayList<Caja>();
		switch (this.CasoBusqueda(FechaDesde, FechaHasta, Descripcion, Ingreso, Egreso)) {
		case 0:
			break;
		case 1:
			ListaCaja=_cajadao.BusquedaPorDescripcion(Descripcion,Ingreso,Egreso);
			break;
		case 2:
			ListaCaja=_cajadao.Listar();
			break;
		case 3:
			ListaCaja=_cajadao.ListaTotalEgresos();
			break;
		case 4:
			ListaCaja=_cajadao.ListaTotalIngreso();
			break;
		case 5:
			ListaCaja=_cajadao.ListaPorRangoFecha(FechaDesde, FechaHasta, Ingreso, Egreso);
			break;
		default:
			break;
		}
		return ListaCaja;
	}
	public void JDateChooserToString(JDateChooser fecha){
		String fecha2=new String();
		String formato = fecha.getDateFormatString();
		Date date = fecha.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		String fnacim = String.valueOf(sdf.format(date));
		
	}
}
