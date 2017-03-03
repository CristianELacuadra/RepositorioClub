package ar.com.ProyectoClub.CModelo.BIGestores;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;

public interface IGestorGeneric<T> {
	public T Crear() throws Exception;
	public void Guardar(T entity) throws Exception;
	public T Busqueda(Integer id) throws Exception;
	public List<T> Listar() throws Exception;
	public void  Inhabilitar(T entity) throws Exception;
	public void  habilitar(T entity) throws Exception;
}
