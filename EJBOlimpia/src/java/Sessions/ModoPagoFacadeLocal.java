/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.ModoPago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CAMPOVERDE_R
 */
@Local
public interface ModoPagoFacadeLocal {

    void create(ModoPago modoPago);

    void edit(ModoPago modoPago);

    void remove(ModoPago modoPago);

    ModoPago find(Object id);

    List<ModoPago> findAll();

    List<ModoPago> findRange(int[] range);

    int count();
    
}
