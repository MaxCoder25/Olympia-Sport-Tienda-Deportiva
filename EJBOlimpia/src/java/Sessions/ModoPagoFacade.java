/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.ModoPago;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CAMPOVERDE_R
 */
@Stateless
public class ModoPagoFacade extends AbstractFacade<ModoPago> implements ModoPagoFacadeLocal {
    @PersistenceContext(unitName = "EJBOlimpiaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModoPagoFacade() {
        super(ModoPago.class);
    }
    
}
