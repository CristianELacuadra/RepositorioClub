package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao;




import java.util.List;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;

public interface ICuotaDAO extends IGenericDAO<Cuota, Integer>{
 List<Cuota> ListaCuotaXDNI(Integer dni);
 //lanza las cuotas de un mes dado
 List<Cuota> ListaCuotaMes(int mes,int anio);
}
