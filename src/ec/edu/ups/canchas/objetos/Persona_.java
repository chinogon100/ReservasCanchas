package ec.edu.ups.canchas.objetos;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-29T01:13:07.406-0500")
@StaticMetamodel(Persona.class)
public class Persona_ {
	public static volatile SingularAttribute<Persona, Long> idpersona;
	public static volatile SingularAttribute<Persona, String> nombres;
	public static volatile SingularAttribute<Persona, String> documento_id;
	public static volatile SingularAttribute<Persona, String> tipo_documento;
	public static volatile SingularAttribute<Persona, String> telefono;
	public static volatile SingularAttribute<Persona, String> direccion;
	public static volatile SingularAttribute<Persona, Usuario> usuario;
}
