/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.RegistroUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author KevinMac
 */
@Stateless
public class RegistroUsuarioFacade extends AbstractFacade<RegistroUsuario> implements RegistroUsuarioFacadeLocal {
    @PersistenceContext(unitName = "EJBOlimpiaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroUsuarioFacade() {
        super(RegistroUsuario.class);
    }
    
    
    
     @Override
   public List<RegistroUsuario> findByTipoUsuario(String idTipoUsuario){
        
        Query sql = em.createNamedQuery("RegistroUsuario.findByTipoUsuario").setParameter("tipoUsuario", idTipoUsuario);
        
        List<RegistroUsuario> lst = sql.getResultList();
       return lst;
   }  
    
    
    
}
