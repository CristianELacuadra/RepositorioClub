package pruebas;


import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;






import org.hibernate.service.ServiceRegistryBuilder;

import ar.com.ProyectoClub.Modelo.Entidades.Nosocio;
import ar.com.ProyectoClub.Modelo.Entidades.Personas;
import ar.com.ProyectoClub.Modelo.Entidades.Socios;
import ar.com.ProyectoClub.Modelo.Persistencia.Hibernet.HibernateUtil;





public class Pruebas {

	public static void main(String[] args) {
		
		//prueba sin hibernetutil
		
		/*
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		
		Date fecha=new Date(1991/02/03);
		Date fechaing=new Date(2010, 05, 02);
		Categoria categoria1=new Categoria("vip","Socio Cadette con 19% de descuento",19,true);
		Personas Persona1=new Personas(35709368,"Cristian Emanuel C","Lacuadra",154640914,"Cuyas y San Peres",fecha);
		Socios socio1=new Socios(categoria1,Persona1,10111,1,"masculino","activo","Argentina","soltero",fechaing,true,1);
		
		
		Personas persona2= new Personas(3698712,"Pedro alfonso","Casano",156896200,"Corrientes 914",fecha);
		Nosocio nosocio1=new Nosocio(persona2,true);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(persona2);
		session.save(nosocio1);
		session.getTransaction().commit();
		session.close();
		*/
		//prueba con hibernetutil
		
		HibernateUtil.buildSessionFactory();
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			/*
			//leer
			Socios socio = (Socios) session.get(Socios.class, 35709368);
			datos de la entidad persona
			System.out.println(socio.getDniSocios().toString());
			System.out.println(socio.getPersonas().getNombre().toString());
			System.out.println(socio.getPersonas().getApellido().toString());
			System.out.println(socio.getPersonas().getApellido().toString());
			System.out.println(socio.getPersonas().getDomicilio().toString());
			System.out.println(socio.getPersonas().getFechanacimiento().toString());
			System.out.println(socio.getPersonas().getTelefono());
			datos del socio
			System.out.println(socio.getEstadocivil().toString());
			System.out.println(socio.getNacionalidad().toString());
			System.out.println(socio.getSexo().toString());
			nombre de la categoria*
			System.out.println(socio.getCategoria().getNombre());
		
			System.out.println(socio.getSexo().toString());
			*/
			} finally {
				HibernateUtil.closeSessionAndUnbindFromThread();
				}
		HibernateUtil.closeSessionFactory();
		}


	}
  

