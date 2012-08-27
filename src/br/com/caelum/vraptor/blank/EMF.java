package br.com.caelum.vraptor.blank;

import javax.annotation.PostConstruct;  
import javax.annotation.PreDestroy;  
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;  
import javax.persistence.Persistence;  
  
import br.com.caelum.vraptor.ioc.ApplicationScoped;  
import br.com.caelum.vraptor.ioc.Component;  
import br.com.caelum.vraptor.ioc.ComponentFactory;  
  
@Component  
@ApplicationScoped  
public class EMF implements  
        ComponentFactory<EntityManagerFactory> {  
  
    private EntityManagerFactory factory;  
  
    @PostConstruct  
    public void abre() {          
        factory = Persistence.createEntityManagerFactory("ep1-esw");  
    }  
  
    @Override  
    public EntityManagerFactory getInstance() {  
        return factory;  
    }
    
    public EntityManager em(){
    	return getInstance().createEntityManager();
    }
      
    @PreDestroy  
    public void fecha(){  
        this.factory.close();  
    }  
  
}  
