/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.EstadoReclamo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author KevinMac
 */
@Stateless
public class EstadoReclamoFacade extends AbstractFacade<EstadoReclamo> implements EstadoReclamoFacadeLocal {
    @PersistenceContext(unitName = "EJBOlimpiaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoReclamoFacade() {
        super(EstadoReclamo.class);
    }
    
}
