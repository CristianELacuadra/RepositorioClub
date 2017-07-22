package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao;




import java.util.List;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;

public interface ICuotaDAO extends IGenericDAO<Cuota, Integer>{
 public List<Cuota> ListaCuotaXDNI(Integer dni);
 //lanza las cuotas de un mes dado
 public List<Cuota> ListaCuotaMes(int mes,int anio);
 public Integer ObtenerUltimoIdIngresado();
 public List<Cuota> ObternerCuotasImpagas(); 
}
