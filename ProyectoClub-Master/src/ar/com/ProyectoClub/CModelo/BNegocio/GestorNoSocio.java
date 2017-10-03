package ar.com.ProyectoClub.CModelo.BNegocio;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.NotImplemented;

import ar.com.ProyectoClub.CModelo.BIGestores.IGestorNosocio;
import ar.com.ProyectoClub.CModelo.CEntidades.NoSocioDTO;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DIRepository.IPersonaDAO;
import ar.com.ProyectoClub.CModelo.DRepository.PersonaImplHibernate;

public class GestorNoSocio implements IGestorNosocio {
	private IPersonaDAO _NosocioDao;

	//constructor
	public GestorNoSocio()throws Exception {
		_NosocioDao=new PersonaImplHibernate();
	}
	//Create,Insert,Delete,Update,Busqueda
	@Override
	public NoSocioDTO Crear() throws Exception {
		return(new NoSocioDTO());
	}

	@Override
	public void Guardar(NoSocioDTO entity) throws Exception {
		//if(this.VerificarHabilitado(entity.getDni())) {
			Personas nuevo=_NosocioDao.crear();
			nuevo.setDni(entity.getDni());
			nuevo.setNombre(entity.getNombre());
			nuevo.setApellido(entity.getApellido());
			nuevo.setTelefono(entity.getTelefono());
			nuevo.setDomicilio(entity.getDomicilio());
			nuevo.setDomNro(entity.getDomicilioNro());
			nuevo.setFecNacimiento(entity.getFecNacimiento());
			nuevo.setEssocio(false);
			_NosocioDao.GuardarEntity(nuevo);
	//	}
	//	else 
		//	throw new Exception("Error,Usted possé deudas en este club.Salde las deudas para poder ejercer nuestro servicio");	
	}

	@Override
	public NoSocioDTO Busqueda(Integer id) throws Exception {
		NoSocioDTO SocioDTO=new NoSocioDTO(); 
		SocioDTO=this.PersonaToNoSocioDTO(_NosocioDao.BuscarUno(id));//devuelve una persona y lo convierte a NosocioDTO
		return SocioDTO;
	}

	@Override
	public List<NoSocioDTO> Listar() throws Exception {
		List<NoSocioDTO> listaNoSocio=new ArrayList<NoSocioDTO>();
		List<Personas> listaPersona=new ArrayList<Personas>();
		listaPersona=_NosocioDao.HistoricoNoSocio();//->retorna historico de personas no socias
		for(Personas persona : listaPersona){
			listaNoSocio.add(this.PersonaANoSocio(persona));
		}
		return listaNoSocio;
	}
	
	@Override
	public List<NoSocioDTO> FiltrarNombeApellido(String nom, String ape) {
		try{
			List<NoSocioDTO> listanosocio=new ArrayList<NoSocioDTO>();
			List<Personas> listaPersona=new ArrayList<Personas>();
			listaPersona=_NosocioDao.FiltrarNomApe(nom, ape,false);
			for(Personas persona : listaPersona){
				listanosocio.add(this.PersonaANoSocio(persona));
			}
			return listanosocio;
		}
		catch (Exception e) {
			throw new RuntimeException("ERROR :"+e.toString());
		}
	}
	
	private NoSocioDTO PersonaANoSocio(Personas persona){
		 NoSocioDTO nosocioDTo=new NoSocioDTO();
		 nosocioDTo.setDni(persona.getDni());
		 nosocioDTo.setNombre(persona.getNombre());
		 nosocioDTo.setApellido(persona.getApellido());
		 nosocioDTo.setDomicilio(persona.getDomicilio());
		 nosocioDTo.setEstado(persona.getEstado());
		 nosocioDTo.setEssocio(persona.isEssocio());
		 nosocioDTo.setFecNacimiento(persona.getFecNacimiento());
		 nosocioDTo.setHabilitado(persona.isHabilitado());
		 nosocioDTo.setTelefono(persona.getTelefono());
		 return nosocioDTo;
		 
	}
	@Override
	public void HabilitarNoSocio(NoSocioDTO persona) throws Exception {
		this.Guardar(persona);
		
	}
	@Override
	public void InabilitarNoSocio(NoSocioDTO Persona) throws Exception {
	     this.Guardar(Persona);
		
	}
	private NoSocioDTO PersonaToNoSocioDTO(Personas personas){
		  NoSocioDTO noSocioDto= new NoSocioDTO();
		  noSocioDto.setDni(personas.getDni());
		  noSocioDto.setApellido(personas.getApellido());
		  noSocioDto.setNombre(personas.getNombre());
		  noSocioDto.setDomicilio(personas.getDomicilio());
		  noSocioDto.setFecNacimiento(personas.getFecNacimiento());
		  noSocioDto.setTelefono(personas.getTelefono());
		  noSocioDto.setEssocio(personas.isEssocio());
		  noSocioDto.setHabilitado(personas.isHabilitado());
		  noSocioDto.setEstado(personas.getEstado());
		  return noSocioDto;
	}

	@Override
	public void Inhabilitar(NoSocioDTO entity) throws Exception {
		throw new NotImplemented();
	}

	@Override
	public void habilitar(NoSocioDTO entity) throws Exception {
		throw new NotImplemented();
	}
	
	//----------------------------------------------------------------------------------------------------------------------
	private boolean VerificarHabilitado(Integer dni){
		try{
			boolean _ver=true;
			NoSocioDTO nuevo=new NoSocioDTO();
			//nuevo=this.Busqueda(dni);
			if(this.Busqueda(dni)==null)
				_ver=true;
			else {
				if(nuevo.getDni()==dni && !nuevo.isHabilitado()) //->verifica si el no socio ya estuvo anteriormente y si se encontraba inhabilitado
					_ver=false;

			}
			return _ver;
		}
		catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}
}
