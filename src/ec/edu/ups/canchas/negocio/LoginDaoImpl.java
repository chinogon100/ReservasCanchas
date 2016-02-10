package ec.edu.ups.canchas.negocio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ec.edu.ups.canchas.objetos.Usuario;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public Usuario findByUserName(String nombre) {
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		Usuario user = (Usuario) session.load(Usuario.class, new String(nombre));
		tx.commit();
		return user;
	}

}
