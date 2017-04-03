package ar.com.ProyectoClub.CModelo.BGestores;

import java.util.List;

import ar.com.ProyectoClub.CModelo.BIGestores.IGestorCategoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICategoriaDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.CategoriaDaoImplHibernate;

public class GestorCategoria implements IGestorCategoria {
	private ICategoriaDAO categoriadao;

	public GestorCategoria() {
		try {
			categoriadao=new CategoriaDaoImplHibernate();
		}
		catch (Exception e) {
			throw new RuntimeException("Error al crear el gestor categoria");
		}
	}

	@Override
	public Categoria Crear() throws Exception {
		return categoriadao.crear();
	}

	@Override
	public void Guardar(Categoria entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Categoria Busqueda(Integer id) throws Exception {
		Categoria categoria=this.Crear();
		categoria=categoriadao.BuscarUno(id);
		return categoria;
	}

	@Override
	public List<Categoria> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Inhabilitar(Categoria entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void habilitar(Categoria entity) throws Exception {
		// TODO Auto-generated method stub

	}

}
