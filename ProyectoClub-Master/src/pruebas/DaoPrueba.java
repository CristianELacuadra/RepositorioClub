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
		Date fechanacimiento=new Date(85,02,06);
		IGestorCategoria gestorCategoria=new GestorCategoria();
		Categoria _categoria=new Categoria();
		_categoria=gestorCategoria.Buscaruno(2);
		gestorCategoria.Eliminar(_categoria.getIdCategoria());
		
		/*
		for(Nosocio a : Gestornosocio.listar()){
			System.out.print("Dni: "+a.getDni()+"       ");
			System.out.print("Nombre: "+a.getNombre()+"     ");
			System.out.println("Apellido: "+a.getApellido());
		}
		*/
		
	}
}

