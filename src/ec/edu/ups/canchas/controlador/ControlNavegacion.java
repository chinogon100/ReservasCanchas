package ec.edu.ups.canchas.controlador;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ControlNavegacion  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9208706767129707977L;

	
	public String login(){
	
		return "iniciar-sesion";

		
	}
	
	public String perfil(){
		
		return "iniciar-sesion";
	
	}
    public String buscar_cancha(){
		
		return "mapa";
	
	}
	
    public String listacancha(){
		
		return "reserva.xhtml";
	
	}
    
	
}
