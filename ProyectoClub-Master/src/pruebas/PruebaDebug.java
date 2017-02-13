package pruebas;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ar.com.ProyectoClub.CModelo.AServicios.FechaHora;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCuota;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceUsuario;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceCuota;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceSocios;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceUsuario;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.AHibernet.HibernateUtil;


public class PruebaDebug {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//IServiceSocio SocioService=new ServiceSocios();
		IServiceUsuario usuarioservicieo=new ServiceUsuario();
		/*
		Sociosa uno=new Sociosa();
		uno=SocioService.BusquedaXdni(34598745);
		if(uno==null) {
			System.out.println("no se ha encontrado el socio");
		}
		else {
		System.out.println("Dni: "+uno.getDni());
		System.out.println("Nombre : "+uno.getNombre());
		System.out.println("Apellido: "+uno.getApellido());
		System.out.println("Sus cuotas son las siguientes:");
		IServiceCuota CuotaService=new ServiceCuota();
		List<Cuota> m=new ArrayList<Cuota>(); 
		m=CuotaService.listarCuotasimpagas(uno.getNroSocio());
		for(Cuota s:m) {
			System.out.println("id: "+s.getId());
			System.out.println("Mes: "+s.getMes());
			System.out.println("anio: "+s.getAnio());
			System.out.println("importe: "+s.getImporte());
			System.out.println("fecha de pago: "+s.getFechaPago());
		}
		}
		*/	
		
		String bo=usuarioservicieo.acceder_Administrador("jesus","12347" );
		System.out.println(bo);
		//nuevo.setDescripcion("HOLA MUNDO");
		//assertTrue(Cuotaservice.InsertOrUpdateCuota(nuevo));
		//if(FechaHora.DameFechaActual().getDate() > 1 && FechaHora.DameFechaActual().getDate() < 5 ){
		//	IServiceSocio prueba=new ServiceSocios();
		//	prueba.ControlEstadoDeudor(FechaHora.DameFechaActual().getMonth()-1, FechaHora.DameFechaActual().getYear()+1900);
		//	prueba.ControlEstadoMorosos(FechaHora.DameFechaActual());
		//}

	}

}
