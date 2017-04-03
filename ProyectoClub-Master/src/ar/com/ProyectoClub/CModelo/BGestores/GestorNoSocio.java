package ar.com.ProyectoClub.CModelo.BGestores;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.NotImplemented;

import ar.com.ProyectoClub.CModelo.BIGestores.IGestorNosocio;
import ar.com.ProyectoClub.CModelo.CEntidades.NoSocioDTO;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.INoSocioDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.NoSocioDaoImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.SociosDaoImplHibernate;

public class GestorNoSocio implements IGestorNosocio {
	private INoSocioDAO _NosocioDao;
	private ISociosDAO _sociodao;
	public GestorNoSocio() {
		try {
			_NosocioDao=new NoSocioDaoImplHibernate();
			_sociodao=new SociosDaoImplHibernate();
		}
		catch (Exception e) {
			throw new RuntimeException("Error al iniciar el gestor"+e.toString());
		}
	}

	@Override
	public NoSocioDTO Crear() throws Exception {
		throw new NotImplemented();
	}
	
	
	private boolean VerificarHabilitado(Integer dni) throws Exception {
		boolean _ver=true;
		NoSocioDTO nuevo=new NoSocioDTO();
		nuevo=this.Busqueda(dni);
		if(nuevo==null)
			_ver=true;
		else {
			if(nuevo.getDni()==dni && !nuevo.isHabilitado()) //->verifica si el no socio ya estuvo anteriormente y si se encontraba inhabilitado
				_ver=false;

		}
		return _ver;
	}
	
	@Override
	public void Guardar(NoSocioDTO entity) throws Exception {
		try {
			if(this.VerificarHabilitado(entity.getDni())) {
			Personas nuevo=_sociodao.crear();
			nuevo.setDni(entity.getDni());
			nuevo.setNombre(entity.getNombre());
			nuevo.setApellido(entity.getApellido());
			nuevo.setTelefono(entity.getTelefono());
			nuevo.setDomicilio(entity.getDomicilio());
			nuevo.setFecNacimiento(entity.getFecNacimiento());
			nuevo.setHabilitado(true);
			nuevo.setEssocio(false);
			_NosocioDao.GuardarEntity(nuevo);
			}
			else 
				throw new Exception("Error,Usted possé deudas en este club.Salde las deudas para poder ejercer nuestro servicio");
		}
		catch (BussinessException e) {
			throw new Exception("Error al guardar,por favor verifique los datos"+e.getMessage());
		}		
	}


	@Override
	public NoSocioDTO Busqueda(Integer id) throws Exception {
			NoSocioDTO SocioDTO=new NoSocioDTO(); 
			SocioDTO=_NosocioDao.BusquedaXDni(id);
			return SocioDTO;
	}

	@Override
	public List<NoSocioDTO> Listar() throws Exception {
		List<NoSocioDTO> lista=new ArrayList<NoSocioDTO>();
		lista=_NosocioDao.ListaNosocio();//->retorna historico de no socios
		return lista;
	}

	@Override
	public void Inhabilitar(NoSocioDTO entity) throws Exception {
		NoSocioDTO ObjNosocio=new NoSocioDTO();
		ObjNosocio=this.Busqueda(entity.getDni());
		ObjNosocio.setHabilitado(entity.isHabilitado());
		this.Guardar(ObjNosocio);
	}

	@Override
	public void habilitar(NoSocioDTO entity) throws Exception {
		NoSocioDTO ObjNosocio=new NoSocioDTO();
		ObjNosocio=this.Busqueda(entity.getDni());
		ObjNosocio.setHabilitado(entity.isHabilitado());
		this.Guardar(ObjNosocio);

	}

}
