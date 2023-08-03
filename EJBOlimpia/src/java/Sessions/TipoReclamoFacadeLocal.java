/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.TipoReclamo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author KevinMac
 */
@Local
public interface TipoReclamoFacadeLocal {

    void create(TipoReclamo tipoReclamo);

    void edit(TipoReclamo tipoReclamo);

    void remove(TipoReclamo tipoReclamo);

    TipoReclamo find(Object id);

    List<TipoReclamo> findAll();

    List<TipoReclamo> findRange(int[] range);

    int count();
    
}
