package pruebas;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.metamodel.ListAttribute;

import ar.com.ProyectoClub.CModelo.AServicios.FechaHora;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCategorias;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceCategoria;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceSocios;
import ar.com.ProyectoClub.CModelo.BGestores.GestorAlquiler;
import ar.com.ProyectoClub.CModelo.BGestores.GestorCaja;
import ar.com.ProyectoClub.CModelo.BGestores.GestorCuota;
import ar.com.ProyectoClub.CModelo.BGestores.GestorNoSocio;
import ar.com.ProyectoClub.CModelo.BGestores.GestorSocio;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorAlquiler;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorCaja;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorCuota;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorSocio;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.AHibernet.HibernateUtil;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessMessage;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IinmueblesDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.InmueblesDaoImplHibernate;

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
		//ListaActivaSocios(); //->ok
		//InhabilitarHabilitar(); //ok
		//GuardarAlquiler(); //ok
		  //BusquedaAlquiler(); //->ok
	      //ListarXFechaReserva();
		// guardarregistrocaja();
		//Servicio socio
	//	AltaSocio();
	}
	
//	private void ListaActivaSocios(){
//		IGestorSocio _GestorSocio=new GestorSocio();
//		try{
//			for(Personas per : _GestorSocio.ListaActivaSocio()) {
//				System.out.print("Dni: "+per.getDni());
//				System.out.print("Nombre: "+per.getNombre());
//				System.out.print("Apellido: "+per.getApellido());
//				System.out.println();
//			}
//		}
//		catch (BussinessException e) {
//			System.out.println("No se ha podido guardar el profesor.Se han producido los siguientes errores:");
//		//	for (BussinessMessage bussinessMessage : e.getBussinessMessages()) {
//		//		System.out.println(bussinessMessage.toString());
//		//	}
//		}
//	}
	
//	private void InhabilitarHabilitar() {
//		IGestorSocio _GestorSocio=new GestorSocio();
//		try {
//
//			Personas nuevo=_GestorSocio.Crear();
//			nuevo=_GestorSocio.Busqueda(35709368);
//			nuevo.setHabilitado(true);
//			_GestorSocio.habilitar(nuevo);
//
//			nuevo=_GestorSocio.Busqueda(32012354);
//			nuevo.setHabilitado(false);
//			_GestorSocio.Inhabilitar(nuevo);;
//		}
//		catch (Exception e) {
//			e.getMessage();
//		}
//	}
	private void BusquedaAlquiler() {
		IGestorAlquiler _GestorAlquiler=new GestorAlquiler();
		try {
		Alquiler _objalquiler=_GestorAlquiler.Crear();
		_objalquiler=_GestorAlquiler.Busqueda(3);
		System.out.println("dni"+_objalquiler.getPersonas().getDni());
		System.out.println("nombre: "+_objalquiler.getPersonas().getNombre());
		System.out.println("Apellido: "+_objalquiler.getPersonas().getApellido());
		System.out.println("fecha reserva: "+_objalquiler.getFechaReserva());
		System.out.println("hora reserva: "+_objalquiler.getHoraReserva());
		System.out.println("Cantidad de horas: "+_objalquiler.getCantidadHora());
		//System.out.println("precio total: "+_objalquiler.getPrecioTotal());
		System.out.println("inmueble: "+_objalquiler.getInmuebles().getNombre());
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
//	private void GuardarAlquiler() {
//		IGestorAlquiler _GestorAlquiler=new GestorAlquiler();
//		IGestorSocio _GestorSocio=new GestorSocio();
//		
//		try {
//		IinmueblesDAO s= new InmueblesDaoImplHibernate();
//		Alquiler _objalquiler=_GestorAlquiler.Crear();
//		Personas nuevo=_GestorSocio.Crear();
//		nuevo=_GestorSocio.Busqueda(3478964);
//		Inmuebles inmu=s.crear();
//		inmu=s.BuscarUno(1);
//		_objalquiler.setPersonas(nuevo);
//		_objalquiler.setInmuebles(inmu);
//		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//		Date fecha=sdf.parse("2017-09-09");
//		Calendar calendario = new GregorianCalendar();
//		_objalquiler.setFechaReserva(fecha);
//		_objalquiler.setHoraReserva(calendario.getTime());
//		_objalquiler.setCantidadHora(3);
//		_objalquiler.setPrecioTotal(2100);
//		//_objalquiler.setActivo(true);
//		_GestorAlquiler.Guardar(_objalquiler);
//		}
//		catch (Exception e) {
//			System.out.println("Error"+e.toString());
//		}
//	}
	
	@SuppressWarnings("deprecation")
	private void ListarXFechaReserva() {
		IGestorAlquiler _GestorAlquiler=new GestorAlquiler();
		try {
			String fechainicial= "2017/04/03";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			Date dateFrom = formatter.parse(fechainicial);
			String fechafin = "2017/10/03";
			Date dateTo = formatter.parse(fechafin);
			List<Alquiler> listaalquiler=_GestorAlquiler.BusquedaXFecha(dateFrom, dateTo);
			for(Alquiler _objalquiler : listaalquiler) {
				System.out.print("dni"+_objalquiler.getPersonas().getDni());
				System.out.print("  nombre: "+_objalquiler.getPersonas().getNombre());
				System.out.print("  Apellido: "+_objalquiler.getPersonas().getApellido());
				System.out.print("  fecha reserva: "+_objalquiler.getFechaReserva());
				System.out.print("  hora reserva: "+_objalquiler.getHoraReserva());
				System.out.print("  Cantidad de horas: "+_objalquiler.getCantidadHora());
				//System.out.println("precio total: "+_objalquiler.getPrecioTotal());
				System.out.println("    inmueble: "+_objalquiler.getInmuebles().getNombre());
			}
		}
		catch (Exception e) {
			System.out.println("Error:"+ e.getMessage());
		}
	}
	
//	private void guardarregistrocaja() {
//		IGestorCaja gestorcaja=new GestorCaja();
//		IGestorCuota gestorcouta=new GestorCuota();
//		try {
//		Caja uno=gestorcaja.Crear();
//		//uno.setCuota(gestorcouta.Busqueda(1));
//		//uno.setAlquiler(alquiler);
//		uno.setDescripcion("prueba");
//		uno.setFecha(FechaHora.FechaActual());
//		uno.setMonto(2000);
//		uno.setSubTotal(gestorcaja.DevolverSubtotal());
//		uno.setTipo(false);
//		}
//		catch (Exception e) {
//			System.out.println("Error:"+ e.getMessage());
//		}
//	}
//	private void AltaSocio() {
//		IServiceSocio servicio= new ServiceSocios();
//		IServiceCategorias servicio2=new ServiceCategoria();
//		try {
//		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//	    Date fechan=sdf.parse("1991-03-06");
//		Personas nueva=servicio.CrearSocio();
//		nueva.setDni(36123456);
//		nueva.setNombre("Agustin");
//		nueva.setApellido("Caceres");
//		nueva.setTelefono("03434302020");
//		nueva.setDomicilio("brav lll 031");
//		nueva.setFecNacimiento(fechan);
//		nueva.setFechaIngreso(FechaHora.FechaActual());
//		nueva.setNroSocio(servicio.UltimoIdSocio()); //-> cuando venga de la vista ya estara cargada con el ultimo id socio
//		nueva.setMatricula(1012);
//		nueva.setSexo("Masculino");
//		nueva.setEstado("Activo");
//		nueva.setNacionalidad("Argentina");
//		nueva.setEstadoCivil("Soltero");
//		nueva.setHabilitado(true);
//		nueva.setEssocio(true);
//		nueva.setCategoria(servicio2.BuscarCategoria(1));
//		servicio.AltaSocio(nueva);
//		}
//		catch (Exception e) {
//			System.out.println("Error"+e.getMessage());
//		}
//	}
}
