package pruebas;

import ar.com.ProyectoClub.CModelo.AServicios.FechaHora;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceSocios;


public class PruebaDebug {

	public static void main(String[] args) {
		if(FechaHora.DameFechaActual().getDate() > 13 && FechaHora.DameFechaActual().getDate() < 16 ){
			IServiceSocio prueba=new ServiceSocios();
			//prueba.ControlEstadoDeudor(FechaHora.DameFechaActual().getMonth()-1, FechaHora.DameFechaActual().getYear()+1900);
			//prueba.ControlEstadoMorosos(FechaHora.DameFechaActual().getMonth()-3, FechaHora.DameFechaActual().getYear()+1900);
		}

	}

}
