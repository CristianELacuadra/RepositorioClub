package ar.com.ProyectoClub.Persistencia.Hibernet;

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
     
	private static SessionFactory _Sessionfactory;
     
     public static synchronized void builsessionfactory(){
    	 if(_Sessionfactory== null){
    		 Configuration _Configuration= new Configuration();
    		 _Configuration.configure();
    		 _Configuration.setProperty("hibernet.curren_session_context_class", "thread");
    		 ServiceRegistry _ServiceRegistry  = new StandardServiceRegistryBuilder().applySettings(
    		            _Configuration.getProperties()).build();
    		 _Sessionfactory = _Configuration.buildSessionFactory(_ServiceRegistry);
    	 }
     }
     
     public static void openSessionAndBindToThread(){
    	 Session _Session=_Sessionfactory.openSession();
    	 ThreadLocalSessionContext.bind(_Session);
     }
     
     public static SessionFactory getSessionFactory(){
    	 if(_Sessionfactory ==null){
    		builsessionfactory(); 
    	 }
    	 return _Sessionfactory;
     }
     
     public static void closeSessionAndUnbindFromThread(){
    	 Session _session=ThreadLocalSessionContext.unbind(_Sessionfactory);
    	 if(_session != null){
    		 _session.close();
    	 }
     }
     
     public static void closeSessionFactory(){
    	 if((_Sessionfactory != null) && (_Sessionfactory.isClosed()==false)){
    		 _Sessionfactory.close();
    	 }
     }
}
