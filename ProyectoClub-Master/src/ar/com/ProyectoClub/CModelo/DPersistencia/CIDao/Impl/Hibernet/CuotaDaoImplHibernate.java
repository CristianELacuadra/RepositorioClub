package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.RelanzadorExcepciones;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICuotaDAO;

public class CuotaDaoImplHibernate extends GenericDAOImplHibernate<Cuota, Integer> implements ICuotaDAO{
	private List<Cuota> ListaCuota=new ArrayList<Cuota>();
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICuotaDAO#ListaCuotaMes(int) 
	 */
	@SuppressWarnings("unchecked")
	public List<Cuota> ListaCuotaMes(int mes, int anio) {
		Session session=sessionFactory.getCurrentSession();
		List<Cuota> _lista=null;
		try{
			session.beginTransaction();
			Query _query= session.createQuery("SELECT c FROM Cuota c WHERE c.mes="+mes+"AND c.anio="+anio);
			_lista = _query.list();
		}
		catch(RuntimeException ex){
			session.beginTransaction().rollback();
			throw ex;
		}
		catch(Exception ex){
			session.beginTransaction().rollback();
			RelanzadorExcepciones.Lanzar(ex);
		}
		finally{
			session.close();
		}
		return _lista ;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Cuota> ListaCuotaXDNI(Integer dni) {
		Session session=sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			/*
			 * HQL para recuperar solo datos habilitados
			 */
			ListaCuota = session.createQuery("SELECT s FROM Cuota s WHERE s.sociosa.dni="+dni).list();	
		    return ListaCuota;
		}
		catch(RuntimeException ex){
			throw ex;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally{
			session.close();
		}
		
	}
}
