package ar.com.ProyectoClub.CModelo.AServicios.facade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.AServicios.FechaHora;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICuotaDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.CuotaDaoImplHibernate;

public class ServiceCuota implements IServiceCuota {
	private ICuotaDAO _cuotaDao;
	
	public ServiceCuota() {
		_cuotaDao= new CuotaDaoImplHibernate();
	}
	
	@Override
	public boolean RegistrarPagoCuota(Cuota nueva) {
		try {
			Cuota _cuota=new Cuota();
			_cuota=_cuotaDao.BuscarUno(nueva.getId());
			if(_cuota.getFechaPago()==null || _cuota ==null) {
				_cuota.setFechaPago(FechaHora.DameFechaActual());
				_cuota.setEstado("Saldado");
				_cuotaDao.GuardarEntity(_cuota);
				return true;
			}
			else
				return false;
		}
		catch(Exception ex) {
			throw new RuntimeException(ex.toString());
		}
	}
	
	@Override
	public List<Sociosa> ListaDeudorMorososMes(int mes, int anio) {
		List<Sociosa> _list=new ArrayList<Sociosa>();
		List<Cuota> ListarC=this._cuotaDao.ListaCuotaMes(mes, anio); // llega una list con las cuotas del mes anterior
		for(Cuota Lcuotas : ListarC){
			if(Lcuotas.getFechaPago()==null)
				_list.add(Lcuotas.getSociosa());//lista de los que no pagaron
	    }
		return _list;
	}
	/*
	@SuppressWarnings("deprecation")
	@Override
	public List<Sociosa> ListaMorososMes(int mes, int anio) {
		List<Sociosa> _list=new ArrayList<Sociosa>();
		Date _fechaemision= new Date();
		Date _fechavencimiento=new Date();
		for(Cuota _c: _cuotaDao.ListaCuotaMes(mes,anio)){
			if(_c.getFechaPago()==null){
				_fechaemision.setYear(_c.getAnio());
				_fechaemision.setMonth(_c.getMes());
				_fechaemision.setDate(13);
				_fechavencimiento=_fechaemision;
				_fechavencimiento.setMonth(_fechavencimiento.getMonth()+3);  //suma tres meses al mes de emision
				if((_fechavencimiento.compareTo(FechaHora.DameFechaActual())==0) || (_fechavencimiento.compareTo(FechaHora.DameFechaActual())>0))
					_list.add(_c.getSociosa());
			}
		}
		return _list;
	}
	*/


	@Override
	public List<Cuota> ListaCuotas() throws BussinessException {
		List<Cuota> _list= new ArrayList<Cuota>();
		try{
			_list=_cuotaDao.Listar();
			return _list;
		}
		catch(BussinessException ex){
			throw ex;
		}
	}

}
