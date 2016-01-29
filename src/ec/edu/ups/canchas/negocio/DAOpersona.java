package ec.edu.ups.canchas.negocio;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.canchas.objetos.Persona;

@Stateless
public class DAOpersona {
	@Inject
	EntityManager em;
	
	public DAOpersona() {
		// TODO Auto-generated constructor stub
	}
	public void crear(Persona p){
		em.persist(p);
	}
	public void update(Persona p){
		em.merge(p);
	}
	public Persona getById(int id){
		return em.find(Persona.class, id);
	}
	public boolean remove(int id){
		em.remove(getById(id));
		return true;
	}
	public List<Persona> getAll(){
		return em.createQuery("Select c from Persona c", Persona.class).getResultList();
	}
	
}
