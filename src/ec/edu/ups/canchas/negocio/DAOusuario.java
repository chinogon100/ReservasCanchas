package ec.edu.ups.canchas.negocio;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.canchas.objetos.Usuario;

@Stateless
public class DAOusuario {
	@Inject
	EntityManager em;
	
	public DAOusuario() {
		// TODO Auto-generated constructor stub
	}
	public void crear(Usuario p){
		em.persist(p);
	}
	public void update(Usuario p){
		em.merge(p);
	}
	public Usuario getById(int id){
		return em.find(Usuario.class, id);
	}
	public boolean remove(int id){
		em.remove(getById(id));
		return true;
	}
	public List<Usuario> getAll(){
		return em.createQuery("Select c from Usuario c", Usuario.class).getResultList();
	}
	
	
	
}
