package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.mysql.fabric.xmlrpc.base.Array;

import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICuotaDAO;

public class CuotaDaoImplHibernate extends GenericDAOImplHibernate<Cuota, Integer> implements ICuotaDAO{
	private List<Cuota> ListaCuota=new ArrayList<Cuota>();
	
	@Override
	public List<Cuota> ListaCuotaXDNI(Integer dni) {
		Session session=sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			/*
			 * HQL para recuperar solo datos habilitados
			 */
			ListaCuota = session.createQuery("SELECT s FROM Cuota s WHERE s.sociosa.dni="+dni).list();	
		}
		catch (Exception e) {
			if (session.getTransaction().isActive()) {
				session.getTransaction().rollback();
				e.printStackTrace();
			}
			throw new RuntimeException(e);
		} 
		return ListaCuota;
	}
}
