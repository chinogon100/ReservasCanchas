package ec.edu.ups.canchas.objetos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import ec.edu.ups.canchas.objetos.Usuario;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "C_ROLES")
public class Roles implements Serializable {

	private static final long serialVersionUID = 1L;

	public Roles() {
	}

	@Id
	private long idroles;
	private String rol;
	@ManyToOne
	private Usuario usuario;
	public long getIdroles() {
		return idroles;
	}

	public void setIdroles(long id) {
		this.idroles = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String param) {
		this.rol = param;
	}

	public Usuario getUsuario() {
	    return usuario;
	}

	public void setUsuario(Usuario param) {
	    this.usuario = param;
	}

}