package pruebas;

import javax.persistence.metamodel.ListAttribute;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ar.com.ProyectoClub.CModelo.BGestores.GestorNoSocio;
import ar.com.ProyectoClub.CModelo.BGestores.GestorSocio;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorSocio;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.AHibernet.HibernateUtil;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessMessage;

public class PruebaDebug  {
	//private final static Logger log = Logger.getLogger(PruebaDebug.class);

	public static void main(String[] args)  {
		HibernateUtil.buildSessionFactory();
		try {
			HibernateUtil.openSessionAndBindToThread();
			//BasicConfigurator.configure();
			//Logger.getLogger("org.hibernate").setLevel(Level.WARN);
			new PruebaDebug();		
		} 
		catch ( Exception be) {
			System.out.println("No se ha podido guardar el profesor.Se han producido los siguientes errores:");
			be.getMessage();
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();


	}
	
	PruebaDebug() {
		//Metodos a Probar,Gestor Socio
		ListaActivaSocios(); //->ok
		InhabilitarHabilitar();
	}
	
	private void ListaActivaSocios(){
		IGestorSocio _GestorSocio=new GestorSocio();
		try{
			for(Personas per : _GestorSocio.ListaActivaSocio()) {
				System.out.print("Dni: "+per.getDni());
				System.out.print("Nombre: "+per.getNombre());
				System.out.print("Apellido: "+per.getApellido());
				System.out.println();
			}
		}
		catch (BussinessException e) {
			System.out.println("No se ha podido guardar el profesor.Se han producido los siguientes errores:");
			for (BussinessMessage bussinessMessage : e.getBussinessMessages()) {
				System.out.println(bussinessMessage.toString());
			}
		}
	}
	
	private void InhabilitarHabilitar() {
		IGestorSocio _GestorSocio=new GestorSocio();
		try {

			Personas nuevo=_GestorSocio.Crear();
			nuevo=_GestorSocio.Busqueda(35709368);
			nuevo.setHabilitado(true);
			_GestorSocio.habilitar(nuevo);

			nuevo=_GestorSocio.Busqueda(32012354);
			nuevo.setHabilitado(false);
			_GestorSocio.Inhabilitar(nuevo);;
		}
		catch (Exception e) {
			e.getMessage();
		}
	}
}
