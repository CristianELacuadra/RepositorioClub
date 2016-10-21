package ar.com.ProyectoClub.Aplicacion.IGestor;

import ar.com.ProyectoClub.Dominio.Categoria;

public interface ICategoriaGestor extends IGestorGeneric<Categoria> {
    public void ActualizarCategoria(Categoria cat1,Categoria cat2);
}
