package ec.edu.ups.canchas.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ec.edu.ups.canchas.negocio.DAOusuario;
import ec.edu.ups.canchas.objetos.Usuario;

@ManagedBean
@SessionScoped
public class ControlLoginUsuario {
	// Login
	private String usuario;
	private String clave;
	@Inject
	DAOusuario daousuario;

	public Usuario login() {
		for (Usuario u : daousuario.getAll()) {
			if (u.getUsuario().equals(usuario) && u.getContraseña().equals(clave)) {
				return u;
			}
		}
		return null;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public DAOusuario getDaousuario() {
		return daousuario;
	}

	public void setDaousuario(DAOusuario daousuario) {
		this.daousuario = daousuario;
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
