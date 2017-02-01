package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;


public interface IServiceSocio{
	public boolean  NuevoSocio(Sociosa socio)throws BussinessException;
	public String  DeshabilitarSocio(Sociosa socio) throws BussinessException;
	public boolean  ActulizarSocio(Sociosa socio)throws BussinessException;
	public boolean validar(Integer dni)throws BussinessException;
	public List<Sociosa>  ListarSocio()throws BussinessException;//historicos de socios
	public List<Sociosa>  ListaSociosActivo()throws BussinessException;//lista de los activos
	public Sociosa UnSocio(Integer id) throws BussinessException; 
	public void ControlEstadoDeudor(int mes,int anio);
	void ControlEstadoMorosos(int mes, int anio);

}
