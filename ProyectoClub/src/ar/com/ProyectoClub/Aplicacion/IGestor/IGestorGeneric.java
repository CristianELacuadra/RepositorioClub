package ar.com.ProyectoClub.Aplicacion.IGestor;

import java.io.Serializable;

public interface IGestorGeneric<T> extends Serializable {
	  public void Guardar(T entidad);
	  public void actualizar(T entidad);
	

}
