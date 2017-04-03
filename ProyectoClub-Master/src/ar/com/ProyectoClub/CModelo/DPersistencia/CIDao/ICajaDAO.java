package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao;


import java.util.List;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;

public interface ICajaDAO extends IGenericDAO<Caja, Integer> {
	public Integer DevolverCantiddad();
	public float Subtotal();
	public List<Caja>  ListaPoranio(Integer anio,boolean tipo);
	public List<Caja>  ListaPormes(Integer anio,Integer mes,boolean tipo);
	public List<Caja>  ListaFecha(Integer anio,Integer mes,Integer dia,boolean tipo);
	public List<Caja>  ListaTotalIngreso();
	public List<Caja>  ListaTotalEgresos();
}
