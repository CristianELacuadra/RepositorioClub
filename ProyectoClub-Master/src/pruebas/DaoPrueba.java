package pruebas;

import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.BAplicacion.Gestores.GestorCategoria;
import ar.com.ProyectoClub.CModelo.BAplicacion.Gestores.GestorNoSocio;
import ar.com.ProyectoClub.CModelo.BAplicacion.Gestores.GestorSocio;
import ar.com.ProyectoClub.CModelo.BAplicacion.IGestor.IGestorCategoria;
import ar.com.ProyectoClub.CModelo.BAplicacion.IGestor.IGestorNoSocio;
import ar.com.ProyectoClub.CModelo.BAplicacion.IGestor.IGestorSocios;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Nosocio;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.AHibernet.HibernateUtil;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;

public class DaoPrueba {

	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		/*
		 * prueba de Gestores
		 */
		//Gestor socio
		//insercion Ok,Actualizacion Ok,Lista activa de socio OK,lista de todos OK,Habilitado OK,Deshabilitado OK,
		//Buscar uno OK,
		
		//Gestor No socio
		//Insertar OK,Actualizar OK,Personas Inhabilitadas OK,Listar todos OK,inhabilitar Ok,
		/*
		IGestorCategoria gestor=new GestorCategoria();
		Categoria una=new Categoria();
		try{
		una=gestor.Buscaruno(5);
		una.setDescripcion("hola");
		}
		catch(BussinessException ex){
			ex.printStackTrace();
			System.out.print("Error al eliminar :"+ex.getMessage());
		}
		*/
		HibernateUtil.buildSessionFactory();
	}
}

