package ar.com.ProyectoClub.CModelo.BAplicacion.IGestor;

import java.io.Serializable;
import java.util.List;

public interface IGestorGeneric<T> extends Serializable {
	  public void Guardar(T entidad); // inserta nueva entidad 
	  public void Habilitar(T entidad);
	  public void Deshabilitar(T entidad);
	  public T Buscaruno(Integer id); //busca la entidad
	  public List<T> listar(); //lista todas las entidades 
	  public void Validar (T entidad);
}
