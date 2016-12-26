package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICuotaDAO;

public class CuotaDaoImplHibernate extends GenericDAOImplHibernate<Cuota, Integer> implements ICuotaDAO{
	private List<Cuota> ListaCuota=new ArrayList<Cuota>();
	
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
