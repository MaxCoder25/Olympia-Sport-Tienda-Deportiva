/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.CabeceraFactura;
import Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author CAMPOVERDE_R
 */
@Stateless
public class CabeceraFacturaFacade extends AbstractFacade<CabeceraFactura> implements CabeceraFacturaFacadeLocal {
    @PersistenceContext(unitName = "EJBOlimpiaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CabeceraFacturaFacade() {
        super(CabeceraFactura.class);
    }
    
     @Override
    public   List<CabeceraFactura> findbyIdCliente(Cliente clienteIdCliente){
      
         List<CabeceraFactura> cf = new ArrayList();
         Query sql = em.createNamedQuery("CabeceraFactura.findByIdCliente").setParameter("clienteIdCliente", clienteIdCliente);
        //Query sql = em.createNativeQuery("SELECT c.num_cuenta, c.val_saldo,c.cod_cuenta,c.num_cedula FROM Cuenta c WHERE c.numCedula.numCedula = :numCedula").setParameter("numCedula"  , numCedula);
        cf=sql.getResultList();
        
        return cf;
         
         
         
     }
    
    
    
}
