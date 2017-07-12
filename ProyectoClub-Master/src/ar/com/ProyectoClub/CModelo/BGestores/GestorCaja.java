package ar.com.ProyectoClub.CModelo.BGestores;

import java.awt.geom.Arc2D.Float;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;

import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.loader.custom.Return;
import org.jboss.jandex.ThrowsTypeTarget;

import com.mysql.jdbc.NotImplemented;

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
		try {
			return(_cajadao.crear());//->Devuelve nueva instancia de la entidad personas
		}
		catch (BussinessException e) {
			throw new Exception("Error a instanciar la entidad: "+e.getMessage());
		}
	}
	private Date TomarFecha() {
		return(FechaHora.FechaActual());
	}
	
	@Override
	public float DevolverSubtotal() {
		return _cajadao.Subtotal();
	}
	private float CalcularSubTotal( float valor ,float ultvalor,boolean tipo) {
		float resultado=0;
		Integer i=_cajadao.DevolverCantiddad();
		if(i!=0 && !tipo)
			resultado=ultvalor-valor;
		if(i!=0 && tipo)
			resultado=ultvalor+valor;
		if(i==0 && !tipo)
			resultado=i-valor;
		if(i==0 && tipo)
			resultado=i+valor;
		return resultado;
	}

	@Override
	public void Guardar(Caja entity) throws Exception {
		if(!entity.isTipo()) {
			entity.setAlquiler(null);
			entity.setCuota(null);
		}
		entity.setSubTotal(this.CalcularSubTotal(entity.getMonto(), entity.getSubTotal(), entity.isTipo()));  //se calcula el sub total nuevo
		_cajadao.GuardarEntity(entity);	
	}

	@Override
	public Caja Busqueda(Integer id) throws Exception {
		try {
			Caja _uno=this.Crear();
			_uno=_cajadao.BuscarUno(id);
			return _uno;
		}
		catch (BussinessException e) {
			throw new Exception("Fallo, no se puede hallar el registro"+e.getMessage());
		}
	}

	@Override
	public List<Caja> Listar() throws Exception {
		_lista.clear();
		_lista=null;
		try {
			_lista=_cajadao.Listar();
			return _lista;
		}
		catch (BussinessException e) {
			throw new Exception("no se puedo listar los registros de la caja"+e.getMessage());
		}
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

}
