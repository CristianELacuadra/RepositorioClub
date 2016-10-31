package ar.com.ProyectoClub.Modelo.Aplicacion.Gestores;

import java.util.List;

import ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric;
import ar.com.ProyectoClub.Modelo.Dominio.Socios;
import ar.com.ProyectoClub.Modelo.Persistencia.Dao.BussinessException;
import ar.com.ProyectoClub.Modelo.Persistencia.IDao.Impl.Hibernet.SociosDaoImplHibernate;

public class GestorSocio implements IGestorGeneric<Socios> {
	private Socios Gscoio;
	private SociosDaoImplHibernate _iSocioImpl;

	public GestorSocio() {
		try{
			_iSocioImpl=new SociosDaoImplHibernate();
			Gscoio=new Socios();
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	@Override
	public void Guardar(Socios entidad) throws BussinessException {
		try{
			if(entidad.getDniSocios()>0){
				categoria=_icategoria.BuscarUno(entidad.getIdCategoria());
				actualizarcategoria(entidad, categoria); // actualiza los datos de categoria de la BDD con los de entidad
				_icategoria.Actualizar(entidad);
			}
			else
				_icategoria.Insertar(entidad);
		}
		catch(Exception ex){
			 throw new RuntimeException(ex);
		}
		
	}
@Override
	public Socios Buscaruno(Integer id) throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}
@Override
	public void Habilitar(Socios entidad) throws BussinessException {
		// TODO Auto-generated method stub
		
}@Override
	public void Deshabilitar(Socios entidad) throws BussinessException {
			// TODO Auto-generated method stub
			
	}
@Override
	public List<Socios> listar() throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}
@Override
	public void Validar(Socios entidad) {
		// TODO Auto-generated method stub
		
	}

}
