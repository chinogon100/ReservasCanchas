package ec.edu.ups.canchas.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.canchas.objetos.Observaciones;

@Stateless
public class DAOobservaciones {
	@Inject
	EntityManager em;
	
	public DAOobservaciones() {
		// TODO Auto-generated constructor stub
	}
	public void crear(Observaciones p){
		em.persist(p);
	}
	public void update(Observaciones p){
		em.merge(p);
	}
	public Observaciones getById(int id){
		return em.find(Observaciones.class, id);
	}
	public boolean remove(int id){
		em.remove(getById(id));
		return true;
	}
	public List<Observaciones> getAll(){
		return em.createQuery("Select c from Observaciones c", Observaciones.class).getResultList();
	}
	
}

