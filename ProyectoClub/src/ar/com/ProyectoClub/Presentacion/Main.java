package ar.com.ProyectoClub.Presentacion;
/*
 * clase main para probar la persistencia de la BDD
 */

import ar.com.ProyectoClub.Dominio.Categoria;
import ar.com.ProyectoClub.Persistencia.Dao.BussinessException;
import ar.com.ProyectoClub.Persistencia.Dao.BussinessMessage;
import ar.com.ProyectoClub.Persistencia.Hibernet.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		
		HibernateUtil.builsessionfactory(); //nueva session
		
        try {
            HibernateUtil.openSessionAndBindToThread(); // abre la session 

            CategoriaController categoriaController = new CategoriaController();
            Categoria categoria = new Categoria("Cadete","persona con privilegios reservados",10);//nueva persona con 6 argumentos 
            

            categoriaController.guardar(categoria);

        } 
        catch (BussinessException be) {
        	System.out.println("No se ha podido guardar el profesor.Se han producido los siguientes errores:");
            for (BussinessMessage bussinessMessage : be.getBussinessMessages()) {
            	System.out.println(bussinessMessage.toString());
        }
        } finally {
            HibernateUtil.closeSessionAndUnbindFromThread();
        }

        HibernateUtil.closeSessionFactory(); // se cierra la session
    }
		

}
