package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao;




import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;
import java.util.List;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;

public interface ISociosDAO extends IGenericDAO<Sociosa,Integer>{
	public List<Sociosa> ListaActivaSocios();
}
