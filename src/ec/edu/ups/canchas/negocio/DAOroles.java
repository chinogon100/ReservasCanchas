package ec.edu.ups.canchas.negocio;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.canchas.objetos.Roles;

@Stateless
public class DAOroles {
	@Inject
	EntityManager em;
	
	public DAOroles() {
		// TODO Auto-generated constructor stub
	}
	public void crear(Roles p){
		em.persist(p);
	}
	public void update(Roles p){
		em.merge(p);
	}
	public Roles getById(int id){
		return em.find(Roles.class, id);
	}
	public boolean remove(int id){
		em.remove(getById(id));
		return true;
	}
	public List<Roles> getAll(){
		return em.createQuery("Select c from Roles c", Roles.class).getResultList();
	}
	
	
	public Roles get(int id){
		return em.createQuery("Select c from Roles c  where c.usuario.idusuario="+id, Roles.class).getSingleResult();
	}
	
}
