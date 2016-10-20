package ar.com.ProyectoClub.Aplicacion.IGestor;

import java.io.Serializable;
import java.util.List;

public interface IGestor<T,ID extends Serializable> {
	void Guardar(T entidad);
	T obtener(ID id);
    List<T> listar();
    Boolean validar(T entidad);
}
