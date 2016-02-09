package ec.edu.ups.canchas.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.canchas.objetos.Reservas;

@Stateless
public class DAOreservas {
	@Inject
	EntityManager em;
	
	public DAOreservas() {
		// TODO Auto-generated constructor stub
	}
	public void crear(Reservas p){
		em.persist(p);
	}
	public void update(Reservas p){
		em.merge(p);
	}
	public Reservas getById(int id){
		return em.find(Reservas.class, id);
	}
	public boolean remove(int id){
		em.remove(getById(id));
		return true;
	}
	public List<Reservas> getAll(){
		return em.createQuery("Select c from Reservas c", Reservas.class).getResultList();
	}
	
}

