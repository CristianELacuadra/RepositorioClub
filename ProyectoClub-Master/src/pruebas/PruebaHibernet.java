package pruebas;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ar.com.ProyectoClub.CModelo.CEntidades.Nosocio;
import ar.com.ProyectoClub.CModelo.DPersistencia.AHibernet.HibernateUtil;

public class PruebaHibernet {

	public static void main(String[] args)throws Exception {
		HibernateUtil.buildSessionFactory();

		try {
			HibernateUtil.openSessionAndBindToThread();

			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Nosocio profesor = (Nosocio) session.get(Nosocio.class, 36987451);
			System.out.println(profesor.toString());
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
		/*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		@SuppressWarnings("deprecation")
		Date fecha=new Date(91,03,06); 
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Nosocio p = new Nosocio(36987451,"Juan","Perez","436987","corrientes 334",fecha,true);
		session.save(p);
		tr.commit();
		System.out.println("Se guardó satisfactoriamente");
		sessionFactory.close();
		*/
		}

	}
