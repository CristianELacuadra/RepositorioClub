package ar.com.ProyectoClub.CModelo.BGestores;

import java.util.List;

import ar.com.ProyectoClub.CModelo.BIGestores.IGestorCuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICuotaDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.AlquilerDaoImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.CuotaDaoImplHibernate;

public class GestorCuota implements IGestorCuota {
	
	private ICuotaDAO cuotadao;

	public GestorCuota() {
		try {
			cuotadao=new  CuotaDaoImplHibernate();
		}
		catch (Exception e) {
			throw new RuntimeException("Error al crear el contructor"+e.getMessage());
		}
	}
	

	@Override
	public Cuota Crear() throws Exception {
		return(cuotadao.crear());//->Devuelve nueva instancia de la entidad caja
	}

	@Override
	public void Guardar(Cuota entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Cuota Busqueda(Integer id) throws Exception {
		Cuota cuota=this.Crear();
		cuota=cuotadao.BuscarUno(id);
		return cuota;
	}

	@Override
	public List<Cuota> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Inhabilitar(Cuota entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void habilitar(Cuota entity) throws Exception {
		// TODO Auto-generated method stub

	}

}
