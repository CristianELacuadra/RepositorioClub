
package ar.com.ProyectoClub.CModelo.BIGestores;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;

public interface IGestorInmueble extends IGestorGeneric<Inmuebles> {
	public Inmuebles Crear() throws BussinessException;
	public void Guardar(Inmuebles entity) throws Exception;
	public Integer ObtenerSiguienteIdInmueble();
	public Inmuebles Busqueda(Integer id) throws Exception;
	public List<Inmuebles> Listar() throws Exception;
	public void Inhabilitar(Inmuebles entity) throws Exception;
	public void habilitar(Inmuebles entity) throws Exception;

}
