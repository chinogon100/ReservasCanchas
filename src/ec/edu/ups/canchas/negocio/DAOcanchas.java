package ec.edu.ups.canchas.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.canchas.objetos.Canchas;

@Stateless
public class DAOcanchas {
	@Inject
	EntityManager em;
	
	public DAOcanchas() {
		// TODO Auto-generated constructor stub
	}
	public void crear(Canchas p){
		em.persist(p);
	}
	public void update(Canchas p){
		em.merge(p);
	}
	public Canchas getById(int id){
		return em.find(Canchas.class, id);
	}
	public boolean remove(int id){
		em.remove(getById(id));
		return true;
	}
	public List<Canchas> getAll(){
		return em.createQuery("Select c from Canchas c", Canchas.class).getResultList();
	}
	
}

