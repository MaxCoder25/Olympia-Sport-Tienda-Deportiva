/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.EstadoReclamo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author KevinMac
 */
@Local
public interface EstadoReclamoFacadeLocal {

    void create(EstadoReclamo estadoReclamo);

    void edit(EstadoReclamo estadoReclamo);

    void remove(EstadoReclamo estadoReclamo);

    EstadoReclamo find(Object id);

    List<EstadoReclamo> findAll();

    List<EstadoReclamo> findRange(int[] range);

    int count();
    
}
