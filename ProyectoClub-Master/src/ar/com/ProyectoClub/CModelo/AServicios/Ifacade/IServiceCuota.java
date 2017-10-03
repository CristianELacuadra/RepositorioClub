package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.BussinessException;

public interface IServiceCuota {
	public void GeneracionCuota(Date fechaActual,List<Personas> PersonasActivas);
	public Cuota CrearInstanciaCuota();
	public void GuardarCuota(Cuota cuota);
	public Cuota BuscarCuota(Integer Id);
	public List<Cuota> ListarCuotasHabilitadas();
	public void RegistrarPagoCuota(Cuota nueva);
	public Cuota ObtenerUltimaCuota();
	public List<Cuota> ObtenerCuotasImpagas();
	public List<Cuota> ObtenerCuotas(Personas persona);
	
//	public boolean InsertOrUpdateCuota(Cuota nueva);
//	//public Cuota Busqueda(Integer id);
//	public List<Cuota>  listarCuotasimpagas(Integer id);
//	public List<Cuota> ListaCuotas()throws BussinessException;
//	//public List<Sociosa> ListaDeudorMorososMes(int mes,int anio);
	
	

}
