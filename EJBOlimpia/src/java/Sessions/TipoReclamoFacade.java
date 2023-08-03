/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.TipoReclamo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author KevinMac
 */
@Stateless
public class TipoReclamoFacade extends AbstractFacade<TipoReclamo> implements TipoReclamoFacadeLocal {
    @PersistenceContext(unitName = "EJBOlimpiaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoReclamoFacade() {
        super(TipoReclamo.class);
    }
    
}
