package ar.com.ProyectoClub.CModelo.BAplicacion.IGestor;

import java.io.Serializable;
import java.util.List;

import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;

public interface IGestorGeneric<T> extends Serializable {
	  //operaciones compartidas por las entidades
	  //update,insert,delete
	  public void Actualizar(T entidad) throws BussinessException;
	  public void insertar(T entidad) throws BussinessException;
	  public void eliminar(T entidad)throws BussinessException;
	  //habilitar,deshabilitar
	  public void Habilitar(T entidad);
	  public void Deshabilitar(T entidad);
	  //busquda uno
	  public T Buscaruno(Integer id) throws BussinessException; //busca la entidad
	  //todos
	  public List<T> listar() throws BussinessException; //lista todas las entidades 
}
