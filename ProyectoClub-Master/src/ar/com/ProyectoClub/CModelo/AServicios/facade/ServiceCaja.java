package ar.com.ProyectoClub.CModelo.AServicios.facade;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCaja;
import ar.com.ProyectoClub.CModelo.BGestores.GestorCaja;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorCaja;


public class ServiceCaja implements IServiceCaja{
	private IGestorCaja gestorcaja;
	
	public ServiceCaja() {
		gestorcaja=new GestorCaja();
	}

}
