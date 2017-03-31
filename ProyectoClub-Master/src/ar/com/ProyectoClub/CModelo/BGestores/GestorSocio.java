package ar.com.ProyectoClub.CModelo.BGestores;

import java.util.ArrayList;
import java.util.List;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.SociosDaoImplHibernate;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorSocio;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO;
/**
 * 
 * @author Lacuadra and Gieco.
 * @category GestorSocio se encarga de validar datos u acciones que 
 * pertenecen a la entidad, una ves que se valida llama a la persistencia para que guarde los datos 
 * en la DBB
 */

public class GestorSocio implements IGestorSocio{
	
	private ISociosDAO _SocioDao;
	
	public GestorSocio() {
		try {
			_SocioDao=new SociosDaoImplHibernate();
		}
		catch (Exception e) {
			throw new RuntimeException("Error al iniciar el gestor"+e.toString());
		}
	}
	//----------------------------------------------------------------------------------------
	@Override
	public Personas Crear() throws Exception {
		try {
			return(_SocioDao.crear());//->Devuelve nueva instancia de la entidad personas
		}
		catch (BussinessException e) {
			throw new Exception("Error a instanciar la entidad personas"+e.getMessage());
		}
	}
	//----------------------------------------------------------------------------------------
	/*
	 * Verifica si los valores no traen datos nulos
	 */
	private boolean NonnullPartnerData(Personas nuevo) {
		if(nuevo.getNroSocio()==null || nuevo.getMatricula() ==null || nuevo.getSexo()==null || nuevo.getEstado()==null || nuevo.getFecNacimiento()==null || nuevo.getEstadoCivil()==null || nuevo.getFechaIngreso()==null || nuevo.getCategoria()==null)
			return false;
		else
			return true;
	}
	//----------------------------------------------------------------------------------------
	@Override
	public void Guardar(Personas entity) throws Exception {
		try {
			if(this.NonnullPartnerData(entity)) //-> antes de guardar verifica si la entidad no trae valores nulos
				_SocioDao.GuardarEntity(entity);
			else
				throw new RuntimeException("No Puede Tener datos nulos,verifique los datos");
		}
		catch (BussinessException e) {
			throw new Exception("Error al intentar guardar los datos del socio"+e.getMessage());
		}
		
	}
	//----------------------------------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.BIGestores.IGestorSocio#DevolverUltimoNroSocio()
	 * para crear un nuevo socio el numero de socio debe llamar a este metodo
	 */
	public Integer DevolverUltimoNroSocio() {
		Integer nro=0;
		try {
			nro=_SocioDao.MaxNroSocio();//->devuelve el mayor de los numeros de socio
			if(nro!=null)
			return (++nro); //-> le suma uno al ultimo numero de socio y devuelve
			else
				return 1;
			
		}
		catch (Exception e) {
			throw new RuntimeException("Ocurrio un error al momento de buscar el dato"+e.getMessage());
		}
		
	}
	//----------------------------------------------------------------------------------------
	@Override
	public Personas Busqueda(Integer id) throws Exception {
		try {
			Personas _uno=this.Crear();
			_uno=_SocioDao.BuscarUno(id);
			return _uno;
		}
		catch (BussinessException e) {
			throw new Exception("Fallo,no se pudo hallar el socio"+e.getMessage());
		}
	}
	//----------------------------------------------------------------------------------------
	@Override
	public List<Personas> Listar() throws Exception {
		List<Personas> _list=new ArrayList<Personas>();
		try {
			_list=_SocioDao.HistoricoSocio();
			return _list;
		}
		catch (BussinessException e) {
			throw new Exception("No se pudo Listar los socio"+e.getMessage());
		}
	}
	//----------------------------------------------------------------------------------------
	@Override
	public void Inhabilitar(Personas entity) throws Exception {
		try {
			Personas _uno=this.Crear();
			_uno=this.Busqueda(entity.getDni());
			_uno.setHabilitado(entity.isHabilitado());//Inhabilita al socio a realizar tareas
			this.Guardar(_uno);//guarda los datos
		}
		catch (BussinessException e) {
			throw new Exception("No se pudo realizar la operacion debido al siguiente error"+e.getMessage());
		}
	}
	//----------------------------------------------------------------------------------------
	@Override
	public void habilitar(Personas entity) throws Exception {
		try {
			Personas _uno=this.Crear();
			_uno=this.Busqueda(entity.getDni());
			_uno.setHabilitado(entity.isHabilitado());//->habilita al socio al realizar tarea
			this.Guardar(_uno);//->guarda los datos
		}
		catch (BussinessException e) {
			throw new Exception("No se pudo realizar la operacion debido al siguiente error"+e.getMessage());
		}
	}
	//----------------------------------------------------------------------------------------
	@Override
	public List<Personas> ListaActivaSocio() throws BussinessException {
		List<Personas> _listaactiva=new ArrayList<Personas>();
		_listaactiva=_SocioDao.ListaActivaSocios();
		return _listaactiva;
	}
}
