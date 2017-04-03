package ar.com.ProyectoClub.CModelo.DPersistencia.BDao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T,Id extends Serializable > {
      /*
       * CRUD(create,read,update,delete)
       * Listar
       */
	  T crear() throws BussinessException;
	  void GuardarEntity(T entity)throws BussinessException;//Actualiza o inserta la entidad
	  void Eliminar(Id id) throws BussinessException ;
      T BuscarUno(Id id) throws BussinessException;
      List<T> Listar() throws BussinessException;
      
}
