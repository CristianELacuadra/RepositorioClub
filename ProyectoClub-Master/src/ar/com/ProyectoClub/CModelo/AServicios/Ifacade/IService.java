package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.*;

public interface IService {
	//contrato categoria
     Categoria CrearInstanciaCategoria();
     Categoria BuscarCategoria(Integer IdCategoria);
     List<Categoria> DevolverListaCategoria();
    //contrato Persona
	Personas CrearInstanciaPersona();
	Personas BuscarPersona(Integer dni);
	//contrato socio
	List<Socios> ListarSocios();
	void InhabilitarPersona(Integer dni);
	void GuardarSocio(Socios socio);
	Socios CrearInstanciaSocio();
	Socios BuscarSocio(Integer dni);
	//contrato caja
	Caja CrearInstanciaCaja();
	long ObtenerRegistrosDeCaja();
	void GuardarRegistroCaja(Caja registro);
	Caja UltimoRegistroCaja();
	List<Caja> ObtenerCajasPorParamatros(Date FechaDesde, Date FechaHasta, String Descripcion,boolean Ingreso, boolean Egreso);
	List<Conceptos> ObtenerConceptos();
	Conceptos CrearInstanciaConcepto();
	Conceptos BuscarConcepto(Integer id);
    //contrato usuario
	Usuario CrearUsuario();
	Usuario ValidarUsuario(Usuario usuario);
	Usuario ObtenerUsuarioPorNombre(String nombreUsuario);
	List<Personas> ListarPersonas();
	//contrato inmueble
	Inmuebles BuscarInmueble(Integer id);
	Inmuebles CrearInstanciaInmueble();
	List<Inmuebles> ListarInmuebleHabilitado();
	List<Inmuebles> ListarInmueble();
	List<Inmuebles> ListarInmuebleFiltrado(String text);
	List<Inmuebles> ListarInmueblesParaAlquiler();
	void GuardarInmueble(Inmuebles entity); 
	boolean validarNombreInmueble(String tex, Integer id);
	void EliminacionFisicaInmueble(Integer idInmueble);
	
	//contrato alquiler
	Alquiler CrearInstanciaAlquiler();
	Personas ValidarPersona(int dni);
	void GuardarPersona(Personas personas,boolean tipoEntrada);
	
	void GuardarAlquiler(Alquiler alqui);//33 falta
	List<Alquiler> ListarAlquileres();
	List<Alquiler> ListarAlquileresRealizados(Inmuebles inm, Date a);
	Alquiler buscarAlquiler(Integer numAlquiler);
	List<Alquiler> BusquedaAlquilerXFecha(Date fechaIn, Date fechaFin);
	List<Alquiler> BusquedaAlquilerEntreFechas(Date fechaInicio, Date fechaFin);
	List<Alquiler> ListaAlquilerPormes(Integer anio, Integer mes);
	List<Alquiler> ListarAlquilerPorDia(int anio, int mes, int dia);
	List<Alquiler> ListarAlquilerPorDia(Date dia);
	void EliminarAlquiler(int nroAlqui);
	long NumeroAlquileresPorInmueble(Integer idInmueble);
	boolean NoTieneAlquileres(Integer idInmueble);
	
	//cuotas
	List<Cuota> ObtenerCuotasPorid(List<Integer> id);
	void RegistrarPagoCuotaSocio(List<Cuota> cuotas);
	float ObtenerPrecioCuota();
	List<Cuota> ObtenerCuotaSocio(Integer dni);
	//Morosos
	List<Morosos> ListarMorososDeudores();
	void GuardarCategoria(Categoria categoria);
	void habilitarInhabilitarCategoria(int id);
	void HabilitarPersona(int dni);
	List<Cuota> ControlCuotaSocio(Integer dni);
	List<Personas> ObtenerPersonaNomApe(String nom, String ape);
	List<Morosos> FiltrarMorosos();
	List<Morosos> FiltrarDeudores();

	ArrayList<String> ObtenerNombreCategorias();
	Categoria ObtenerCategoriaXNombre(String nombreCategoria);

	


}
