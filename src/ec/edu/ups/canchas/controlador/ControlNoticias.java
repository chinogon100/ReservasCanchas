package ec.edu.ups.canchas.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.canchas.objetos.Noticias;
import ec.edu.ups.canchas.negocio.DAOnoticias;



@ManagedBean
@ViewScoped
public class ControlNoticias implements Serializable {
    
   /**
	 * 
	 */
	private static final long serialVersionUID = 8775521192643053475L;

private List<Noticias> Noticiass;
    
   private Noticias selectedNoticias;
    
   @Inject
   DAOnoticias dao;
   
   
   
   
    
   @PostConstruct
   public void init() {
       Noticiass = dao.getAll();
   }

   public List<Noticias> getNoticiass() {
       return Noticiass;
   }

 
   public Noticias getSelectedNoticias() {
       return selectedNoticias;
   }

   public void setSelectedNoticias(Noticias selectedNoticias) {
       this.selectedNoticias = selectedNoticias;
   }






}
