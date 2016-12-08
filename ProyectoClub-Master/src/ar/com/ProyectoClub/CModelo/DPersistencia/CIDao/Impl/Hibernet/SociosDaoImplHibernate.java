package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import ar.com.ProyectoClub.CModelo.DPersistencia.AHibernet.HibernateUtil;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class SociosDaoImplHibernate extends GenericDAOImplHibernate<Sociosa, Integer> implements ISociosDAO {
	private List<Sociosa> socios = new ArrayList<Sociosa>();
	
	@Override
	public List<Sociosa> ListaActivaSocios() {
		Session session=sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			/*
			 * HQL para recuperar solo datos habilitados
			 */
			socios = session.createQuery("SELECT s FROM Sociosa s WHERE habilitado=true").list();	
		}
		catch (Exception e) {
			if (session.getTransaction().isActive()) {
				session.getTransaction().rollback();
				e.printStackTrace();
			}
			throw new RuntimeException(e);
		} 
		return socios;
	}
	
}
