package ec.edu.ups.canchas.controlador;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ec.edu.ups.canchas.negocio.DAOcomplejo;
import ec.edu.ups.canchas.objetos.Complejo;
@ManagedBean
@SessionScoped
public class ControlProUsu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	DAOcomplejo dao;
	@Inject 
	Logger log;
	private Complejo Complejo;
	private int cantidad;
	private List<Complejo> Complejos;
	
	
	public ControlProUsu() {
		super();
	}

	@PostConstruct
	public void init(){
		Complejo=new Complejo();
		Complejos=dao.getAll();
		//log.log(Level.INFO, "Init", "Init");
	}

	public String verComplejo(int id){
		Complejo=dao.getById(id);
		cantidad=0;
		return "Complejo-usr";
	}

	public void verComplejo_lis(int id){
		Complejo=dao.getById(id);
		cantidad=0;
		
	}
	
	
	public void disminuirCantidad(){
		if(cantidad>0)
			cantidad--;
	}
	public String nuevoComplejo(){
		Complejo=new Complejo();
		return "Complejo-adm";
	}
	public Complejo getComplejo() {
		return Complejo;
	}
	public void setComplejo(Complejo Complejo) {
		this.Complejo = Complejo;
	}
	public DAOcomplejo getDao() {
		return dao;
	}
	public void setDao(DAOcomplejo dao) {
		this.dao = dao;
	}
	public List<Complejo> getComplejos() {
		return Complejos;
	}
	public void setComplejos(List<Complejo> Complejos) {
		this.Complejos = Complejos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
