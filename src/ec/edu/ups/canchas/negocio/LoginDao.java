package ec.edu.ups.canchas.negocio;

import ec.edu.ups.canchas.objetos.Usuario;



public interface LoginDao {
	Usuario findByUserName(String nombre);
}
