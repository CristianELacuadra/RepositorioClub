package ar.com.ProyectoClub.CModelo.BGestores;

import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.AServicios.FechaHora;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorCuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICuotaDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.CuotaDaoImplHibernate;

public class GestorCuota implements IGestorCuota {
	
	private ICuotaDAO cuotadao;

	public GestorCuota() {
		try {
			cuotadao=new  CuotaDaoImplHibernate();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public Cuota Crear() throws Exception {
		return(cuotadao.crear());//->Devuelve nueva instancia de la entidad caja
	}

	@Override
	public void Guardar(Cuota entity) throws Exception {
		 cuotadao.GuardarEntity(entity);
	}

	@Override
	public Cuota Busqueda(Integer id) throws Exception {
		Cuota cuota=this.Crear();
		cuota=cuotadao.BuscarUno(id);
		return cuota;
	}

	@Override
	public List<Cuota> Listar() throws Exception {
		return cuotadao.Listar();
	}

	@Override
	public void Inhabilitar(Cuota entity) throws Exception {
		 entity.setEstado("Baja");
		 this.Guardar(entity);
	}

	@Override
	public void habilitar(Cuota entity) throws Exception {
		entity.setEstado("Activo");
		this.Guardar(entity);

	}


	@Override
	public void RegistrarPagoCuota(Cuota cuota)throws Exception {
		Cuota regCuota=this.Crear();
		regCuota=cuota;
		regCuota.setFechaPago(FechaHora.FechaActual());
		regCuota.setEstado("Saldado");
		this.Guardar(regCuota);
		
	}
	
	private void Generecion(Date fechaActual,Personas persona,float importeFinal) throws Exception{
		Cuota nuevaCuota = new Cuota(); 
		nuevaCuota.setPersonas(persona);
		nuevaCuota.setFechaGeneracion(fechaActual);
		nuevaCuota.setDescripcion("Generacion de la cuota del socio Numero "+persona.getNroSocio()+", Mes "+(fechaActual.getMonth()+1)+" Año "+(fechaActual.getYear()+1900));
		nuevaCuota.setImporte(importeFinal);
		nuevaCuota.setEstado("Debe");
		nuevaCuota.setFechaPago(null);
		this.Guardar(nuevaCuota);
	}


	@Override
	public void GeneracionDeCuotas(Date fechaActual, List<Personas> PersonasActivas) throws Exception {
		Integer idUltimo=cuotadao.ObtenerUltimoIdIngresado();
		if(this.Busqueda(idUltimo).getFechaGeneracion().compareTo(fechaActual)!=0){ 
			float precioOrigiCate,porcentajedesc,descuento;
			Categoria categoria=new Categoria();
			for(Personas socios : PersonasActivas){
				categoria=socios.getCategoria();
				precioOrigiCate=categoria.getMonto();
				porcentajedesc=categoria.getDescuento();
				descuento =(porcentajedesc/100)*precioOrigiCate; //Obtengo el Descuento
				float importefinal=precioOrigiCate-descuento; //Importe final
				this.Generecion(fechaActual,socios, importefinal);
			}
		}
	}


	@Override
	public Cuota ObtenerUltimaCuotaIngresado() throws Exception {
		Cuota cuota=cuotadao.crear();
		Integer id=cuotadao.ObtenerUltimoIdIngresado();
		cuota=cuotadao.BuscarUno(id);
		return cuota;
	}


	@Override
	public List<Cuota> ObtenerCuotasImpagas() {
		return cuotadao.ObternerCuotasImpagas();
	}


	@Override
	public List<Cuota> ObtenerCuotasSocio(Integer dni) {
		return(cuotadao.ListaCuotaXDNI(dni)); 
	}
}
