package ec.edu.ups.canchas.controlador;


import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import ec.edu.ups.canchas.negocio.DAOusuario;
import ec.edu.ups.canchas.objetos.Usuario;
import ec.edu.ups.canchas.negocio.DAOroles;
import ec.edu.ups.canchas.objetos.Roles;



@ManagedBean
@SessionScoped
public class ControlUsuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5993190429604489654L;
	private Usuario usuario;
	private Usuario usrAux;
	private Roles roles;
	boolean loggedIn;
	
	//	
	
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	@Inject
	DAOusuario daousuario;
	public Usuario getUsrAux() {
		return usrAux;
	}
	public void setUsrAux(Usuario usrAux) {
		this.usrAux = usrAux;
	}

	@Inject
	DAOroles daoroles;
	
	
	

	@Inject
	Logger log;
	public String login(String nombre,String clave){
		
		String pagina="";
		
		log.log(Level.INFO,nombre,nombre);
		
		RequestContext context = RequestContext.getCurrentInstance();
	    FacesMessage msg = null;
        
	    
	    for(Usuario u:daousuario.getAllActivo()){
		
			log.log(Level.INFO, u.getUsuario(),u.getUsuario());
			
			log.log(Level.INFO, nombre,nombre);
			
			
			if(u.getUsuario().equals(nombre) && u.getContraseña().equals(clave)){
				
				
					usuario=u;
				
					roles=daoroles.get(u.getIdusuario());
				
					log.log(Level.INFO, roles.getRol(),roles.getRol());
					
				
				if(roles.getRol().equals("ROLE_USER")){
					
					
					
					loggedIn = true;
	    
					
					context.addCallbackParam("loggedIn", loggedIn);
			
					 msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", nombre);

					
					
					pagina="index";
					break;
				
				}else
				if(roles.getRol().equals("ROLE_DUE")){		
		
					loggedIn = true;
	             	msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido Administrador", nombre);
	             	FacesContext.getCurrentInstance().addMessage(null, msg);
			        context.addCallbackParam("loggedIn", loggedIn);
			
			        pagina="index";
					
			        break;	
				
				}
				
				
		
			
			}else{
				
				loggedIn = false;
             	usuario=new Usuario();
				break;
			}
		}
		
		if(loggedIn){
			
	     	
			
		}else{
			
			
			pagina="iniciar-sesion";
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nombre de Usuario o Contraseña Incorrecto ",nombre);
         	FacesContext.getCurrentInstance().addMessage(null, msg);
         	context.addCallbackParam("loggedIn", loggedIn);	
			
			
		}
		
		return pagina;
	}
	public String logout(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance() 
                .getExternalContext().getSession(false);
session.invalidate();
loggedIn = false;

	return "index";

	}
	

	public DAOusuario getDaousuario() {
		return daousuario;
	}

	public void setDaousuario(DAOusuario daousuario) {
		this.daousuario = daousuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Usuario usrAux(Usuario usrAux) {
		this.usrAux = usrAux;
		return this.usrAux;
	}
	
	
	

	
	public String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	
}
