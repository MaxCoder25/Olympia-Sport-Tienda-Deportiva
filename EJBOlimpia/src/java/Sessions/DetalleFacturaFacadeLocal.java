/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.DetalleFactura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CAMPOVERDE_R
 */
@Local
public interface DetalleFacturaFacadeLocal {

    void create(DetalleFactura detalleFactura);

    void edit(DetalleFactura detalleFactura);

    void remove(DetalleFactura detalleFactura);

    DetalleFactura find(Object id);

    List<DetalleFactura> findAll();

    List<DetalleFactura> findRange(int[] range);

    int count();
    
}
