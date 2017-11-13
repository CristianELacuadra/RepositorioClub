package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

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
	List<Caja> ObtenerRegistrosDeCaja();
	void GuardarRegistroCaja(Caja registro);
	Caja UltimoRegistroCaja();
	List<Caja> ObtenerCajasPorParamatros(Date FechaDesde, Date FechaHasta, String Descripcion,boolean Ingreso, boolean Egreso);
    //contrato usuario
	Usuario CrearUsuario();
	Usuario ValidarUsuario(String nombreUsuario,String PassUsuario);
	Usuario ObtenerUsuarioPorNombre(String nombreUsuario);
	List<Personas> ListarPersonas();
	void GuardarNoSocio(Personas persona);
	List<Cuota>  ObtenerCuotasSocio(Integer dni);
	//contrato inmueble
	Inmuebles BuscarInmueble(Integer id);
	Inmuebles CrearInstanciaInmueble();
	List<Inmuebles> ListarInmuebleHabilitado();
	List<Inmuebles> ListarInmueble();
	List<Inmuebles> ListarInmuebleFiltrado(String text);
	List<Inmuebles> ListarInmueblesParaAlquiler();
	void GuardarInmueble(Inmuebles entity); 
	//contrato alquiler
	Alquiler CrearInstanciaAlquiler();
	Personas ValidarPersona(int dni);
	void GuardarPersona(Personas personas);
	//cuotas
	List<Cuota> ObtenerCuotasPorid(List<Integer> id);
	void RegistrarPagoCuotaSocio(List<Cuota> cuotas);

}
