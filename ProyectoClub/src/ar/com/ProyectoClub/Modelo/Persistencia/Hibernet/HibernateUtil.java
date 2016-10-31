package ar.com.ProyectoClub.Modelo.Persistencia.Hibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.service.ServiceRegistry;

/*
 * creacion de la clase Hibernet util que funciona tanto en aplicacion de 
 * escritorio como en web sin ningn tipo de incomveniente ya que 
 * objeto Session guarda en una zona de mamoria privada al Thread en el que se está ejecutando 
 * el código
 */
public class HibernateUtil {
     
	private static SessionFactory sessionfactory;
	private static Configuration hibConfig;
	
	public static Configuration getHibConfig() {
    	builsessionfactory();
		return hibConfig;
	}
     
     public static synchronized void builsessionfactory(){
    	 if(sessionfactory== null){
    		 hibConfig = new Configuration();
    		 hibConfig.configure("/hibernate.cfg.xml");
    		 hibConfig.setProperty("hibernet.curren_session_context_class", "thread");
    		 ServiceRegistry _ServiceRegistry  = new StandardServiceRegistryBuilder().applySettings(hibConfig.getProperties()).build();
    		 sessionfactory = hibConfig.buildSessionFactory(_ServiceRegistry);
    	 }
     }
     
     public static void openSessionAndBindToThread(){
    	 Session _Session= sessionfactory.openSession();
    	 ThreadLocalSessionContext.bind(_Session);
     }
     
     public static SessionFactory getSessionFactory(){
    	 if(sessionfactory ==null){
    		builsessionfactory(); 
    	 }
    	 return sessionfactory;
     }
     
     public static void closeSessionAndUnbindFromThread(){
    	 Session _session=ThreadLocalSessionContext.unbind(sessionfactory);
    	 if(_session != null){
    		 _session.close();
    	 }
     }
     
     public static void closeSessionFactory(){
    	 if((sessionfactory != null) && (sessionfactory.isClosed()==false)){
    		 sessionfactory.close();
    	 }
     }
}
