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
@Table(name = "noticias", catalog = "canchas")
public class Noticias implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 645013843185004334L;
	private Integer idnoticias;
	private Usuario usuario;
	private String titulo;
	private String noticia;

	public Noticias() {
	}

	public Noticias(Usuario usuario) {
		this.usuario = usuario;
	}

	public Noticias(Usuario usuario, String titulo, String noticia) {
		this.usuario = usuario;
		this.titulo = titulo;
		this.noticia = noticia;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idnoticias", unique = true, nullable = false)
	public Integer getIdnoticias() {
		return this.idnoticias;
	}

	public void setIdnoticias(Integer idnoticias) {
		this.idnoticias = idnoticias;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_idusuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "titulo", length = 200)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "noticia")
	public String getNoticia() {
		return this.noticia;
	}

	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}

}
