package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;

public interface IServiceCuota {
	public List<Cuota> ListaCuotas()throws BussinessException;
	public List<Sociosa> ListaDeudorMorososMes(int mes,int anio);
	public boolean RegistrarPagoCuota(Cuota nueva);

}
