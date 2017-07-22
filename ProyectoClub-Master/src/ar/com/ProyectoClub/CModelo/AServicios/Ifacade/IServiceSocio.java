package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import java.util.Date;
import java.util.List;
import java.util.Set;

import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;


public interface IServiceSocio{
	public void GuardarSocio(Personas persona);
	
	public Personas CrearSocio(); 
	public Integer UltimoIdSocio();
	public List<Personas>  ListaSociosActivo();//lista de los activos
	public List<Personas> ObtnerTresPersonas(Integer id);
	public Personas BusquedaId(Integer dni); //busqueda por dni
	public List<Personas> FiltrarNombreApellido(String nom,String ape);
	public void CambiarEstadoMoroso(List<Personas> listaPersonas);
	
	//public String  DeshabilitarSocio(Sociosa socio) throws BussinessException;
	//public boolean  ActulizarSocio(Sociosa socio)throws BussinessException;
	//public boolean validar(Integer id)throws BussinessException;
	//public List<Sociosa>  ListarSocio()throws BussinessException;//historicos de socios
	//public Sociosa UnSocio(Integer id) throws BussinessException; //busqueda atraves del numero de socio
	//public Sociosa BusquedaXdni(Integer dni); //busqueda por dni
	//public void ControlEstadoDeudor(int mes,int anio);
	//void ControlEstadoMorosos(Date fecha);
	//public Set<Cuota> listarCuotasSocio(Integer id);
}
