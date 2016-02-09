package ec.edu.ups.canchas.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.canchas.objetos.Noticias;

@Stateless
public class DAOnoticias {
	@Inject
	EntityManager em;
	
	public DAOnoticias() {
		// TODO Auto-generated constructor stub
	}
	public void crear(Noticias p){
		em.persist(p);
	}
	public void update(Noticias p){
		em.merge(p);
	}
	public Noticias getById(int id){
		return em.find(Noticias.class, id);
	}
	public boolean remove(int id){
		em.remove(getById(id));
		return true;
	}
	public List<Noticias> getAll(){
		return em.createQuery("Select c from Noticias c", Noticias.class).getResultList();
	}
	
}

