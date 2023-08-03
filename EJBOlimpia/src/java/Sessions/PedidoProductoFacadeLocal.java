/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.PedidoProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CAMPOVERDE_R
 */
@Local
public interface PedidoProductoFacadeLocal {

    void create(PedidoProducto pedidoProducto);

    void edit(PedidoProducto pedidoProducto);

    void remove(PedidoProducto pedidoProducto);

    PedidoProducto find(Object id);

    List<PedidoProducto> findAll();

    List<PedidoProducto> findRange(int[] range);

    int count();
    
}
