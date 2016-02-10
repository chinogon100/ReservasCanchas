package ec.edu.ups.canchas.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.canchas.objetos.Complejo;

@Stateless
public class DAOcomplejo {
	@Inject
	EntityManager em;
	
	public DAOcomplejo() {
		// TODO Auto-generated constructor stub
	}
	public void crear(Complejo p){
		em.persist(p);
	}
	public void update(Complejo p){
		em.merge(p);
	}
	public Complejo getById(int id){
		return em.find(Complejo.class, id);
	}
	public boolean remove(int id){
		em.remove(getById(id));
		return true;
	}
	public List<Complejo> getAll(){
		return em.createQuery("Select c from Complejo c", Complejo.class).getResultList();
	}
	
}

