package ar.com.ProyectoClub.Modelo.Persistencia.Dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T,Id extends Serializable > {
      T crear() throws BussinessException;
      void Insertar(T entity) throws BussinessException;
      void Actualizar(T entity) throws BussinessException;
      T BuscarUno(Id id) throws BussinessException;
      void Eliminar(Id id) throws BussinessException;
      List<T> Todos() throws BussinessException;	
}
