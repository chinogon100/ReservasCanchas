package ec.edu.ups.canchas.objetos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import ec.edu.ups.canchas.objetos.Usuario;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "C_PERSONA")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	public Persona() {
	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idpersona;
	@Column(nullable = true)
	private String nombres;
	@Column(length = 13, unique = true)
	private String documento_id;
	@Column(length = 45)
	private String tipo_documento;
	@Column(length = 13)
	private String telefono;
	private String direccion;
	@OneToOne
	private Usuario usuario;

	public long getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(long id) {
		this.idpersona = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String param) {
		this.nombres = param;
	}

	public String getDocumento_id() {
		return documento_id;
	}

	public void setDocumento_id(String param) {
		this.documento_id = param;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String param) {
		this.tipo_documento = param;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String param) {
		this.telefono = param;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String param) {
		this.direccion = param;
	}

	public Usuario getUsuario() {
	    return usuario;
	}

	public void setUsuario(Usuario param) {
	    this.usuario = param;
	}

}