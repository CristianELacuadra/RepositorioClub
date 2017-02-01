package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import ar.com.ProyectoClub.CModelo.CEntidades.DTOPersonalisadoSocio;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;


public class SociosDaoImplHibernate extends GenericDAOImplHibernate<Sociosa, Integer> implements ISociosDAO {
	private List<Sociosa> socios = new ArrayList<Sociosa>();
	public SociosDaoImplHibernate() {
		super();
	}
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO#BusquedaXDni(java.lang.Integer)
	 * HQL busqueda por dni
	 */
	public Sociosa BusquedaXDni(Integer dni) throws BussinessException{
		Session session=sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			Sociosa _nuevo=(Sociosa) session.createQuery("SELECT query FROM Sociosa query WHERE Dni="+dni.toString()).uniqueResult();
			return _nuevo;
		}
		catch (javax.validation.ConstraintViolationException cve){
			throw new BussinessException(cve);
		}
		catch(org.hibernate.exception.ConstraintViolationException ce){
			throw new BussinessException(ce);
		}
		catch(RuntimeException re){
			throw re;
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally{
			session.close();
		}
	}
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO#ListaActivaSocios()
	 * Lista de los socios activos en el club
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Sociosa> ListaActivaSocios() throws BussinessException {
		Session session=sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			/*
			 * HQL para recuperar solo datos habilitados
			 */
			socios = session.createQuery("SELECT s FROM Sociosa s WHERE habilitado=true").list();	
			return socios;
		}
		catch (javax.validation.ConstraintViolationException cve){
			throw new BussinessException(cve);
		}
		catch(org.hibernate.exception.ConstraintViolationException ce){
			throw new BussinessException(ce);
		}
		catch (RuntimeException ex) {
			throw ex;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally{
			session.close();
		}

	}
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO#ListaMorosos()
	 * Lista de morosos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DTOPersonalisadoSocio> ListaMorosos() {
		Session session=sessionFactory.getCurrentSession();
		List<DTOPersonalisadoSocio> _morosos=new ArrayList<DTOPersonalisadoSocio>();
		try{
			session.beginTransaction();
			List<Sociosa> ListaNro=session.createQuery("SELECT s FROM Sociosa s WHERE estado='Moroso'").list();
			for(Sociosa Nro : ListaNro) {
				DTOPersonalisadoSocio DTO=new DTOPersonalisadoSocio();
				DTO.setNroSocio(Nro.getNroSocio());
				DTO.setDni(Nro.getDni());
				DTO.setNombre(Nro.getNombre());
				DTO.setApellido(Nro.getApellido());
				_morosos.add(DTO);
			}
			return _morosos;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally{
			session.close();
		}
		
	}
}
