package ar.com.ProyectoClub.CModelo;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceAlquileres;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCaja;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCategorias;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCuota;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceInmuebles;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceUsuario;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceAlquileres;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceCaja;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceCategoria;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceCuota;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceInmueble;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceSocios;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceUsuario;

public class Modelo {
	
    //servicios del modelo
	private IServiceSocio mdlservicesocio;
	private IServiceUsuario mdlserviceusuario;
	//private IServiceCategorias mdlservicecategoria;
	//private IServiceAlquileres mdlservicealquiler;
	//private IServiceCaja mdlservicecaja;
	//private IServiceInmuebles mdlserviceinmuebles;
	//private IServiceCuota mdlservicecuota;
	
	//constructor
    public Modelo() {
    	//mdlservicecategoria=new ServiceCategoria();
    	//mdlservicealquiler=new ServiceAlquileres();
    	//mdlservicecaja=new ServiceCaja();
    	//mdlservicecuota=new ServiceCuota();
    	//mdlserviceinmuebles=new ServiceInmueble();
    	mdlservicesocio=new ServiceSocios();
    	mdlserviceusuario=new ServiceUsuario();
    }
    
    //getteres
    /*
    public IServiceAlquileres getMdlservicealquiler() {
		return mdlservicealquiler;
	}
    public IServiceCategorias getMdlservicecategoria() {
		return mdlservicecategoria;
	}
    public IServiceInmuebles getMdlserviceinmuebles() {
		return mdlserviceinmuebles;
	}
    public IServiceCaja getMdlservicecaja() {
		return mdlservicecaja;
	}
    public IServiceCuota getMdlservicecuota() {
		return mdlservicecuota;
	}
	*/
    public IServiceSocio getMdlservicesocio() {
		return mdlservicesocio;
	}
	
    public IServiceUsuario getMdlserviceusuario() {
		return mdlserviceusuario;
	}
    
    //setters
    public void setMdlserviceusuario(IServiceUsuario mdlserviceusuario) {
		this.mdlserviceusuario = mdlserviceusuario;
	}
    
    public void setMdlservicesocio(IServiceSocio mdlservicesocio) {
		this.mdlservicesocio = mdlservicesocio;
	}
    /*
    public void setMdlserviceinmuebles(IServiceInmuebles mdlserviceinmuebles) {
		this.mdlserviceinmuebles = mdlserviceinmuebles;
	}
    public void setMdlservicecuota(IServiceCuota mdlservicecuota) {
		this.mdlservicecuota = mdlservicecuota;
	}
    public void setMdlservicecategoria(IServiceCategorias mdlservicecategoria) {
		this.mdlservicecategoria = mdlservicecategoria;
	}
    public void setMdlservicecaja(IServiceCaja mdlservicecaja) {
		this.mdlservicecaja = mdlservicecaja;
	}
    public void setMdlservicealquiler(IServiceAlquileres mdlservicealquiler) {
		this.mdlservicealquiler = mdlservicealquiler;
	}
	*/

}
