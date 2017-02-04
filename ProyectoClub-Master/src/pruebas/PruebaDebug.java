package pruebas;

import ar.com.ProyectoClub.CModelo.AServicios.FechaHora;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceSocios;


public class PruebaDebug {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		if(FechaHora.DameFechaActual().getDate() > 1 && FechaHora.DameFechaActual().getDate() < 5 ){
			IServiceSocio prueba=new ServiceSocios();
			prueba.ControlEstadoDeudor(FechaHora.DameFechaActual().getMonth()-1, FechaHora.DameFechaActual().getYear()+1900);
			prueba.ControlEstadoMorosos(FechaHora.DameFechaActual());
		}

	}

}
