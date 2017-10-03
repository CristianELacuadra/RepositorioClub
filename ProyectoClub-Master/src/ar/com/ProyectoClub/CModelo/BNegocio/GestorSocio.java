package ar.com.ProyectoClub.CModelo.BNegocio;

import java.util.ArrayList;
import java.util.List;

import ar.com.ProyectoClub.CModelo.BIGestores.IGestorSocio;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DIRepository.IPersonaDAO;
import ar.com.ProyectoClub.CModelo.DRepository.PersonaImplHibernate;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.BussinessException;
/**
 * 
 * @author Lacuadra and Gieco.
 * @category GestorSocio se encarga de validar datos u acciones que 
 * pertenecen a la entidad, una ves que se valida llama a la persistencia para que guarde los datos 
 * en la DBB
 */

public class GestorSocio implements IGestorSocio{
	
	private IPersonaDAO _SocioDao;
	
	public GestorSocio() throws Exception {
		_SocioDao=new PersonaImplHibernate();
	}
	//Create,(InsertUpdate),habilitar deshabilitar,,Busqueda,listar
	@Override
	public Personas Crear() throws Exception {
			return(_SocioDao.crear());//->Devuelve nueva instancia de la entidad personas
	}

	@Override
	public void Guardar(Personas entity) throws Exception {
			if(this.NonnullPartnerData(entity)){ //-> antes de guardar verifica si la entidad no trae valores nulos
				_SocioDao.GuardarEntity(entity);
			}
			else
				throw new RuntimeException("No Puede Tener datos nulos,verifique los datos");
	}

	@Override
	public Personas Busqueda(Integer id) throws Exception {
			Personas _uno=this.Crear();
			_uno=_SocioDao.BuscarUno(id);
			return _uno;
	}

//	@Override
//	public List<Personas> ListarPersona() throws Exception {
//		List<Personas> _list=new ArrayList<Personas>();
//		_list=_SocioDao.HistoricoSocio();
//		return _list;

//	}
	
	@Override
	public void habilitar(Personas entity) throws Exception {
		entity.setHabilitado(false);
		this.Guardar(entity);//->guarda los datos
	}
	
	@Override
	public void Inhabilitar(Personas entity) throws Exception {
		entity.setHabilitado(false);
		this.Guardar(entity);//guarda los datos
	}
	
	@Override
	public List<Personas> ListaActivaSocio() throws BussinessException {
		List<Personas> _listaactiva=new ArrayList<Personas>();
		_listaactiva=_SocioDao.ListaActivaSocios();
		return _listaactiva;
	}
	//----------------------------------------------------------------------------------------
	@Override
	public List<Personas> FiltrarNombeApellido(String nom, String ape) {
		try{
			return(_SocioDao.FiltrarNomApe(nom, ape,true));
		}
		catch (Exception e) {
			throw new RuntimeException("ERROR :"+e.toString());
		}
	}
	/*
	 * Verifica si los valores no traen datos nulos
	 */
	private boolean NonnullPartnerData(Personas nuevo) {
		if(nuevo.getNroSocio()==null || nuevo.getMatricula() ==null || nuevo.getSexo()==null || nuevo.getEstado()==null || nuevo.getFecNacimiento()==null || nuevo.getEstadoCivil()==null || nuevo.getFechaIngreso()==null || nuevo.getCategoria()==null)
			return false;
		else
			return true;
	}
	
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
	
	@Override
	public List<Personas> ObtnerTresPrimero(Integer id) {
		List<Personas> personasList=new ArrayList<Personas>();
		int i=0;
		try {			
			for(Personas personas : this.ListaActivaSocio()) 
			{
				if(personas.getDni() != id && i<2)
					personasList.add(personas);
				i++;
			}
			for(Personas personas : this.ListaActivaSocio()) 
			{
				if(personas.getDni() == id ) 
				{
					personasList.add(personas);
					break;
				}
			}
			return personasList;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void EstadosMorosos(List<Personas> morosos)throws Exception {
		 Personas personaMorosa= this.Crear();
		 for(Personas persona :morosos){
			 personaMorosa=_SocioDao.BuscarUno(persona.getDni());
			 personaMorosa.setEstado("Moroso");
			 personaMorosa.setHabilitado(false);
			 this.Guardar(personaMorosa);
		 }
		
	}
	
	private Personas MapearSocio(Personas persona){
		Personas personaA=new Personas();
		personaA.setDni(persona.getDni());
		personaA.setNroSocio(persona.getNroSocio());
		personaA.setNombre(persona.getNombre());
		personaA.setApellido(persona.getApellido());
		personaA.setDomicilio(persona.getDomicilio());
		personaA.setTelefono(persona.getTelefono());
		personaA.setDomicilio(persona.getDomicilio());
		personaA.setFecNacimiento(persona.getFecNacimiento());
		personaA.setMatricula(persona.getMatricula());
		personaA.setSexo(persona.getSexo());
		personaA.setEstado(persona.getEstado());
		personaA.setNacionalidad(persona.getNacionalidad());
		personaA.setEstadoCivil(persona.getEstadoCivil());
		personaA.setFechaIngreso(persona.getFechaIngreso());
		personaA.setHabilitado(persona.isHabilitado());
		personaA.setCategoria(persona.getCategoria());
		return personaA;
	}
	//@Override
	//public List<Personas> listarPersonas() throws Exception {
	//	return Listar();
	//}
	@Override
	public long CantidadSociosRegistrados() throws Exception {
		 return _SocioDao.TotalPersonasRegistrados(true);
	}
	@Override
	public List<Personas> Listar() throws Exception {
		List<Personas> _list=new ArrayList<Personas>();
	   _list=_SocioDao.HistoricoSocio();
  	   return _list;
	}
}
