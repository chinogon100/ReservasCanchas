package ec.edu.ups.canchas.objetos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "persona", catalog = "canchas")
public class Persona implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8193941308872709151L;
	private Integer idpersona;
	private Usuario usuario;
	private String nombres;
	private String documentoId;
	private String tipoDocumento;
	private String telefono;
	private String direccion;

	public Persona() {
	}

	public Persona(Usuario usuario) {
		this.usuario = usuario;
	}

	public Persona(Usuario usuario, String nombres, String documentoId, String tipoDocumento, String telefono,
			String direccion) {
		this.usuario = usuario;
		this.nombres = nombres;
		this.documentoId = documentoId;
		this.tipoDocumento = tipoDocumento;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idpersona", unique = true, nullable = false)
	public Integer getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_idusuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "nombres", length = 250)
	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@Column(name = "documento_id", length = 13)
	public String getDocumentoId() {
		return this.documentoId;
	}

	public void setDocumentoId(String documentoId) {
		this.documentoId = documentoId;
	}

	@Column(name = "tipo_documento", length = 45)
	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Column(name = "telefono", length = 10)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "direccion", length = 45)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
