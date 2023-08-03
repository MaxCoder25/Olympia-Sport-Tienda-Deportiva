/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.DetalleFactura;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CAMPOVERDE_R
 */
@Stateless
public class DetalleFacturaFacade extends AbstractFacade<DetalleFactura> implements DetalleFacturaFacadeLocal {
    @PersistenceContext(unitName = "EJBOlimpiaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleFacturaFacade() {
        super(DetalleFactura.class);
    }
    
}
