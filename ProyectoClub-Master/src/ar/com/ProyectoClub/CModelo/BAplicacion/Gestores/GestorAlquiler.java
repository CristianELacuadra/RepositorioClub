package ar.com.ProyectoClub.CModelo.BAplicacion.Gestores;

import java.util.List;


import ar.com.ProyectoClub.CModelo.BAplicacion.IGestor.IAlquilerGestor;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IAlquilerDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.AlquilerDaoImplHibernate;



public class GestorAlquiler implements IAlquilerGestor {
	
	private Alquiler _UnAlquiler;
	private IAlquilerDAO _IAlquilerDao;
	private List<Alquiler> _ListaAlquiler;
//___________________________________________________________________________________	
	public GestorAlquiler() {
		try{
			_UnAlquiler=new Alquiler();
			_IAlquilerDao=new AlquilerDaoImplHibernate();
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
//___________________________________________________________________________________
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric#Guardar(java.lang.Object)
	 */
	@Override
	public void Guardar(Alquiler entidad) throws BussinessException {
		try{
			if(entidad.getNroAlquiler() > 0){
				_UnAlquiler=_IAlquilerDao.BuscarUno(entidad.getNroAlquiler());
				ActualizarDatosAlquiler(entidad);
				_IAlquilerDao.Actualizar(_UnAlquiler);
			}
			else
				_IAlquilerDao.Insertar(entidad);// atributo unico de la entidad para no socio es dni por lo tanto no se actualiza,solo inserta
			}
		catch(Exception ex){
			throw new RuntimeException(ex);
			}	
		};
//___________________________________________________________________________________
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric#Habilitar(java.lang.Object)
	 * metodo habilitar,si alquiler esta activo no ha llegado la fecha del alquiler
	 */
	public void Habilitar(Alquiler entidad) throws BussinessException {
		try{
			_UnAlquiler=_IAlquilerDao.BuscarUno(entidad.getNroAlquiler());
			_UnAlquiler.setActivo(entidad.isActivo());
			_IAlquilerDao.Actualizar(_UnAlquiler);
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	};
//___________________________________________________________________________________
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric#Deshabilitar(java.lang.Object)
	 * metodo deshabilitar,alquiler en estado inactivo,ya puede volcarse en la caja
	 */
	
public void Deshabilitar(Alquiler entidad) throws BussinessException {
	try{
		_UnAlquiler=_IAlquilerDao.BuscarUno(entidad.getNroAlquiler());
		_UnAlquiler.setActivo(entidad.isActivo());
		_IAlquilerDao.Actualizar(_UnAlquiler);
	}
	catch(Exception ex){
		throw new RuntimeException(ex);
	}
};
//___________________________________________________________________________________	
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric#Validar(java.lang.Object)
	 */
public void Validar(Alquiler entidad) {
	throw new NotImplementedException("No implementado para la entidad");
};
//___________________________________________________________________________________	
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric#Buscaruno(java.lang.Integer)
	 */

	@Override
	public Alquiler Buscaruno(Integer id) throws BussinessException {
		
		try {
			_UnAlquiler=_IAlquilerDao.BuscarUno(id);
		} 
		catch (Exception e) {
			throw new RuntimeException(e);	
		}
		return _UnAlquiler;
	}
//___________________________________________________________________________________
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric#listar()
	 *devuelve todos los alquileres almacenados en la base de datos 
	 */
	@Override
	public List<Alquiler> listar() throws BussinessException {
		
		
		try {
			_ListaAlquiler=_IAlquilerDao.Todos();
			
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return _ListaAlquiler;
	}
//___________________________________________________________________________________
	public List<Alquiler> listaActivaAlquileres(Integer id) {
		
	};
//___________________________________________________________________________________
	/*
	 * actualiza los datos de la entidad con nuevos valores
	 */
	public void ActualizarDatosAlquiler(Alquiler alquiler) {
		_UnAlquiler.setFechaActual(alquiler.getFechaActual());
		_UnAlquiler.setHoraActual(alquiler.getHoraActual());
		_UnAlquiler.setFechaReserva(alquiler.getFechaReserva());
		_UnAlquiler.setHoraReserva(alquiler.getHoraActual());
		_UnAlquiler.setPrecioTotal(alquiler.getPrecioTotal());
	}

}
