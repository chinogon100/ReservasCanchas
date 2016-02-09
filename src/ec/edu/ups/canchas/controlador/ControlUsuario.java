package ec.edu.ups.canchas.controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.FlowEvent;

import ec.edu.ups.canchas.negocio.DAOpersona;
import ec.edu.ups.canchas.negocio.DAOroles;
import ec.edu.ups.canchas.negocio.DAOusuario;
import ec.edu.ups.canchas.objetos.Persona;
import ec.edu.ups.canchas.objetos.Roles;
import ec.edu.ups.canchas.objetos.Usuario;
 
@ManagedBean
@ViewScoped
public class ControlUsuario implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	DAOusuario daou;
	@Inject
	DAOpersona daop;
	@Inject
	DAOroles daor;
	
	private Usuario usuario;

	private Persona persona;
	
	private Roles roles;

	
	List<Usuario> usuarios;
	
	@PostConstruct
	public void init(){
		usuario=new Usuario();
		persona=new Persona();
		roles=new Roles();
	
	
	}
	

	
	public Persona getPersona() {
		return persona;
	}



	public void setPersona(Persona persona) {
		this.persona = persona;
	}



	public Roles getRoles() {
		return roles;
	}



	public void setRoles(Roles roles) {
		this.roles = roles;
	}



	public DAOusuario getDaou() {
		return daou;
	}

	public void setDaou(DAOusuario daou) {
		this.daou = daou;
	}

	public DAOpersona getDaop() {
		return daop;
	}

	public void setDaop(DAOpersona daop) {
		this.daop = daop;
	}

	public DAOroles getDaor() {
		return daor;
	}

	public void setDaor(DAOroles daor) {
		this.daor = daor;
	}

    private boolean skip;
     
    public Usuario getUsuario() {
        return usuario;
    }
 
    public void setUsuario(Usuario Usuario) {
        this.usuario = Usuario;
    }
    
    public String save() {        
    	
    	
		usuarios=daou.getAll();
    	
		if(usuarios.size()==0){
	    	
			
			if(roles.getRol().equalsIgnoreCase("ROLE_DUE")){
					usuario.setHabilitado(false);
			
			}else{
				
				
				    usuario.setHabilitado(true);
				
				
			}
			
			daou.crear(usuario);
    		
	    	persona.setUsuario(usuario);
    	    daop.crear(persona);
    	    roles.setUsuario(usuario);
    	    daor.crear(roles);
    		    
    		
    		

        	
        	
        	
            try {
				Thread.sleep(1200);
				FacesContext context = FacesContext.getCurrentInstance();
	            
	            context.addMessage(null, new FacesMessage("Usuario", "Usuario Creado Correctamente"));
	        
            
            } catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
        	
            
            try {
    			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
            
            

			
			
			
			
		}else
		
		{
	    for(int x=0;x<usuarios.size();x++) {
	        
	    	if(usuario.getUsuario().equalsIgnoreCase(usuarios.get(x).getUsuario())){
	    		
	    	    FacesContext context = FacesContext.getCurrentInstance();
	            
	            context.addMessage(null, new FacesMessage("Usuario", "Nombre de Usuario ya existe "));
	        
	    		
	    		
	    	}else{

	        	daou.crear(usuario);
	    		persona.setUsuario(usuario);
	    	    daop.crear(persona);
	    	    roles.setUsuario(usuario);
	    	    daor.crear(roles);
	    		    
	    		
	    		

	        	
	        	
	        	FacesContext context = FacesContext.getCurrentInstance();
	            
	            context.addMessage(null, new FacesMessage("Usuario", "Usuario Creado Correctamente"));
	        
	            try {
					Thread.sleep(1200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	            
	            try {
	    			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		
	    		
	    		
	    	}
	    
	    
	    }
		
		}
        
    	return "index.xhtml";
        
    	   
    	
         }
    
    
    public void mensaje(){
    	
    	
    	FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
    	
    }
    
    
    
    
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case Usuario goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}

