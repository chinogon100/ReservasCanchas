package ec.edu.ups.canchas.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.primefaces.context.RequestContext;

import ec.edu.ups.canchas.negocio.DAOusuario;
import ec.edu.ups.canchas.objetos.Usuario;

@ManagedBean
@SessionScoped
public class ControlUsrAdm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	DAOusuario daousuario;
	@Inject
	Logger log;
	private Usuario usuario;
	// Login
	@NotNull
	private String nombre;
	private String nombreUsr;
	@Length(min = 8, message = "Dígite mínimo 8 carcteres")
	private String clave1;
	@Length(min = 8, message = "Dígite mínimo 8 carcteres")
	private String clave2;
	private String tipo;
	private List<String> tiposUsuario;
	private String defaultUsuario;

	@PostConstruct
	public void init() {
		clave1 = "";
		clave2 = "";
		tiposUsuario = new ArrayList<>();
		tiposUsuario.add("usuario");
		tiposUsuario.add("administrador");
		if (usuario != null) {
			if (usuario.getIdusuario() != 0) {
				nombre = usuario.getUsuario();
				nombreUsr = usuario.getUsuario();
				//tipo = usuario.getTipo();
			} else
				usuario = null;
		}
	}
	
	public Usuario guardarUsuario() {
		
		RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn=false;
		for (Usuario u : daousuario.getAll()) {
			if (usuario != null) {
				if (u.getIdusuario() != usuario.getIdusuario()) {
					if (nombreUsr.equals(u.getUsuario()))
						return null;
				}
			} else {
				if (nombreUsr.equals(u.getUsuario()))
					return null;
			}
		}
		Usuario u = new Usuario();
		u.setUsuario(nombre);
		u.setContraseña(clave1);
		if (u.getIdusuario() == 0){
			daousuario.crear(u);
			loggedIn=true;
			
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Creado Correctamente", nombre);
			FacesContext.getCurrentInstance().addMessage(null, message);
	        context.addCallbackParam("loggedIn", loggedIn);
	
		}
		else{
			daousuario.update(u);
		}
			return u;
		
		
	}

	public String editarUsuario(Usuario usuario) {
		this.usuario = usuario;
		init();
		return "formulario-adm";
	}

	public String nuevoUsuario() {
		usuario = null;
		init();
		return "formulario-adm";
	}

	public String getClave1() {
		return clave1;
	}

	public void setClave1(String clave1) {
		this.clave1 = clave1;
	}

	public String getClave2() {
		return clave2;
	}

	public void setClave2(String clave2) {
		this.clave2 = clave2;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsr() {
		return nombreUsr;
	}

	public void setNombreUsr(String nombreUsr) {
		this.nombreUsr = nombreUsr;
	}

	public String getTipo() {
		if (tipo == null || tipo.equals(""))
			return "usuario";
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<String> getTiposUsuario() {
		return tiposUsuario;
	}

	public void setTiposUsuario(List<String> tiposUsuario) {
		this.tiposUsuario = tiposUsuario;
	}

	public String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
}
