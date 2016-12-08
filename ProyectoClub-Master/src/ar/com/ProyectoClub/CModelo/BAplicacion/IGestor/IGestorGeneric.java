package ar.com.ProyectoClub.CModelo.BAplicacion.IGestor;

import java.io.Serializable;
import java.util.List;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;

public interface IGestorGeneric<T> extends Serializable {
	  public void Guardar(T entidad) throws BussinessException; // inserta nueva entidad 
	  public void Habilitar(T entidad) throws BussinessException;
	  public void Deshabilitar(T entidad) throws BussinessException;
	  public T Buscaruno(Integer id) throws BussinessException; //busca la entidad
	  public List<T> listar() throws BussinessException ; //lista todas las entidades 
	  public void Validar (T entidad);
	

}
