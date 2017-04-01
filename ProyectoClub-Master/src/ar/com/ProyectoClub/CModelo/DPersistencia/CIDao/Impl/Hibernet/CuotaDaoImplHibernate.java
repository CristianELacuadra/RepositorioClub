package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICuotaDAO;

public class CuotaDaoImplHibernate extends GenericDAOImplHibernate<Cuota, Integer> implements ICuotaDAO{
	public CuotaDaoImplHibernate() throws Exception {
		super();
	}
	private List<Cuota> ListaCuota=new ArrayList<Cuota>();
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICuotaDAO#ListaCuotaMes(int) 
	 */
	@SuppressWarnings("unchecked")
	public List<Cuota> ListaCuotaMes(int mes, int anio) {
		ListaCuota.clear();
		try{
			Setsession();
			SetTransaction();
			Query _query= _sessiondehilo.createQuery("SELECT c FROM Cuota c WHERE c.mes="+mes+"AND c.anio="+anio);
			ListaCuota = _query.list();
			return ListaCuota;
		}
		catch(Exception ex){
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException("Error al realizar la consulta"+ex.toString()) ;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cuota> ListaCuotaXDNI(Integer dni) {
		try {
			Setsession();
			SetTransaction();
			/*
			 * HQL para recuperar solo datos habilitados
			 */
			ListaCuota.clear();
			ListaCuota = _sessiondehilo.createQuery("SELECT s FROM Cuota s WHERE s.sociosa.dni="+dni).list();	
		    return ListaCuota;
		}
		catch(RuntimeException ex){
			_sessiondehilo.close();
			throw ex;
		}
		catch (Exception e) {
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException("Error al realizar la consulta"+e.toString());
		}
	}
}
