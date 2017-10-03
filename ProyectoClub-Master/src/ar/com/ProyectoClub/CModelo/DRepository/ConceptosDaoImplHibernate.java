package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;

import java.util.ArrayList;
import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.CEntidades.Conceptos;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IConceptosEgreIng;

public class ConceptosDaoImplHibernate extends GenericDAOImplHibernate<Conceptos, Integer> implements IConceptosEgreIng {

	public ConceptosDaoImplHibernate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Caja> ListaTotalEgresos() {
		try {

			String consulta=new String();
		    Setsession();
			SetTransaction();
			consulta="SELECT s FROM Caja s WHERE s.tipo=E";	
			List<Caja> listcaja= _sessiondehilo.createQuery(consulta).list();
			if(listcaja.isEmpty())
				return listcaja;
			return listcaja;
		}
		catch(Exception ex){
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(ex);
		}
	}
	//el problema de esta implementacion es que habia un inconveniente con los hijos, 
	//ver como solucionar eso, puede ser en el gestor
	@Override
	public List<Caja> ListaTotalIngreso() {
		try {
			String consulta=new String();
			Setsession();
			SetTransaction();
			consulta="SELECT c FROM Conceptos c WHERE c.tipo= I"; //I identificador ingreso	
			List<Caja> listcaja= new ArrayList<Caja>();
			listcaja=_sessiondehilo.createQuery(consulta).list();
			if(!listcaja.isEmpty())
				return listcaja;
			return null;
		}
		catch(Exception ex){
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(ex);
		}
	}

	
}
