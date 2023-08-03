/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.EstadoPedido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CAMPOVERDE_R
 */
@Local
public interface EstadoPedidoFacadeLocal {

    void create(EstadoPedido estadoPedido);

    void edit(EstadoPedido estadoPedido);

    void remove(EstadoPedido estadoPedido);

    EstadoPedido find(Object id);

    List<EstadoPedido> findAll();

    List<EstadoPedido> findRange(int[] range);

    int count();
    
}
