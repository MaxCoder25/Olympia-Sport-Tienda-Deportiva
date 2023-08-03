/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.Reclamo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author KevinMac
 */
@Local
public interface ReclamoFacadeLocal {

    void create(Reclamo reclamo);

    void edit(Reclamo reclamo);

    void remove(Reclamo reclamo);

    Reclamo find(Object id);

    List<Reclamo> findAll();

    List<Reclamo> findRange(int[] range);

    int count();
    
}
