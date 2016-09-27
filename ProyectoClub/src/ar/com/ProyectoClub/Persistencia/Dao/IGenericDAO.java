package ar.com.ProyectoClub.Persistencia.Dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T,Id extends Serializable > {
      T create() throws BussinessException;
      void GuardarActualizar(T entity) throws BussinessException;
      T GetUno(Id id) throws BussinessException;
      void Eliminar(Id id) throws BussinessException;
      List<T> GetTodos() throws BussinessException;	
}
