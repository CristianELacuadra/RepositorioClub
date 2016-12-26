package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao;


import java.util.List;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;

public interface ICajaDAO extends IGenericDAO<Caja, Integer> {
	public List<Caja>  ListaPoranio(Integer anio);
	public List<Caja>  ListaPormes(Integer anio,Integer mes);
	public List<Caja>  ListaTotalIngreso();
	public List<Caja>  ListaTotalEgresos();
}
