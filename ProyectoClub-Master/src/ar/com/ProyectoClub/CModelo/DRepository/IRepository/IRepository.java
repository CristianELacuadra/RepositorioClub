package ar.com.ProyectoClub.CModelo.DRepository.IRepository;

import java.util.Date;
import java.util.List;

import org.jboss.jandex.ThrowsTypeTarget;

import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Conceptos;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.CEntidades.Socios;
import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.BussinessException;

/**
 * 
 * @author Cristian Lacuadra
 *
 */

public interface IRepository  {
	/**
	 * @author Cristian Lacuadra
	 * @exception BussinesException
	 * Declaracion  Contrato en el repositorio   
	 */
	//Creacion 
	Alquiler CrearAlquiler()throws BussinessException;
	Caja CrearCaja() throws BussinessException;
	Categoria CrearCategoria() throws BussinessException;
	Conceptos CrearConcepto() throws BussinessException;
	Cuota CrearCuota() throws BussinessException;
	Personas CrearPersona() throws BussinessException;
	Socios CrearSocio() throws BussinessException;
	Usuario CrearUsuario() throws BussinessException;
	//Metodos de busqueda
	Alquiler  BuscarAlquiler   (Integer id)  throws BussinessException;
	Caja      BuscarCaja       (Integer id)  throws BussinessException;
	Categoria BuscarCategoria  (Integer id)  throws BussinessException;
	Conceptos BuscarConceptos  (Integer id)  throws BussinessException;
	Cuota     BuscarCuota      (Integer id)  throws BussinessException;
	Inmuebles BuscarInmueble   (Integer id)  throws BussinessException; 
	Personas  BuscarPersona    (Integer id)  throws BussinessException;
	Socios    BuscarSocio      (Integer id)  throws BussinessException;
	Usuario   BuscarUsuario    (Integer id)  throws BussinessException;
	//Metodos Guardar,Actualizar
	void  GuardarAlquiler  (Alquiler alquiler) throws BussinessException;
	void  GuardarCaja      (Caja caja) throws BussinessException;
	void  GuardarCategoria (Categoria categoria) throws BussinessException;
	void  GuardarConcepto  (Conceptos concepto) throws BussinessException;
	void  GuardarCuota     (Cuota cuota) throws BussinessException;
	void  GuardarInmueble  (Inmuebles inmueble) throws BussinessException;
	void  GuardarPersona   (Personas persona) throws BussinessException;
	void  GuardarSocio     (Socios socio) throws BussinessException;
	// Metodos que listan
	List<Alquiler>  ObtenerAlquileres() throws BussinessException;
	List<Caja>      ObtenerCajas() throws BussinessException;
	List<Categoria> ObtenerCategorias() throws BussinessException;
	List<Conceptos> ObtenerConceptos() throws BussinessException;
	List<Cuota>     ObtenerCuotas() throws BussinessException;
	List<Inmuebles> ObtenerInmuebles() throws BussinessException;
	List<Personas>  ObtenerPersonas() throws BussinessException;
	List<Socios>    ObtenerSocios() throws BussinessException;
	List<Usuario>   ObtenerUsuarios() throws BussinessException;
	// Metodos Eliminacion
	void EliminarAlquiler  (Integer id) throws BussinessException;
	void EliminarCaja      (Integer id) throws BussinessException;
	void EliminarCategoria (Integer id) throws BussinessException;
	void EliminarConcepto  (Integer id) throws BussinessException;
	void EliminarCuota     (Integer id) throws BussinessException;
	void EliminarInmueble  (Integer id) throws BussinessException;
	void EliminarPersona   (Integer id) throws BussinessException;
	void EliminarSocio     (Integer id) throws BussinessException;
	void EliminarUsuario   (Integer id) throws BussinessException;
	//Consultas
	List<Alquiler> BusquedaAlquilerXFecha(Date fechainicial,Date fechafin);
	long DevolverTotalRegistrosCaja();
	List<Caja> ListaCajaPorRangoFecha(Date FechaDesde,Date FechaHasta);
	List<Caja> ListaCajaPoranio(Integer anio);
	List<Caja> ListaCajaPormes(Integer anio,Integer mes);
	Integer    ObtenerUltimoIdIngresadoCaja();
	List<Caja> BusquedaPorDescripcionCaja(String Descripcion);
	List<Caja> ListaTotalEgresos();
	List<Caja> ListaTotalIngreso();
	
	List<Cuota> ListaCuotaSocio(Integer dni);
	List<Cuota> ListaCuotaMes(int mes,int anio);
	Integer ObtenerUltimoIdIngresadoCuota();
	List<Cuota> ObternerCuotasImpagas();
	
	List<Personas> FiltrarPersonasPorNombreApellido(String Nom,String Ape );
	long NoSociosRegistrados();
	boolean VerificarNick(String usuario);
}
