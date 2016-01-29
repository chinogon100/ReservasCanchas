package ec.edu.ups.canchas.objetos;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-29T01:40:33.090-0500")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, Long> idusuario;
	public static volatile SingularAttribute<Usuario, String> usuario;
	public static volatile SingularAttribute<Usuario, String> contraseña;
	public static volatile SingularAttribute<Usuario, Boolean> habilitado;
	public static volatile SingularAttribute<Usuario, String> email;
}
