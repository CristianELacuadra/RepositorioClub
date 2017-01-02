package ar.com.ProyectoClub.CModelo.BAplicacion.IGestor;


import java.util.List;

import ar.com.ProyectoClub.CModelo.BAplicacion.ExceptionAplicacion.NroSocioErronea;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;

public interface IGestorSocios extends IGestorGeneric<Sociosa>  {
	public void InsertarSocio(Sociosa socio) throws NroSocioErronea,BussinessException ;
	public List<Sociosa> ListaActivaSocios();
}
