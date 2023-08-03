/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.RegistroUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author KevinMac
 */
@Local
public interface RegistroUsuarioFacadeLocal {

    void create(RegistroUsuario registroUsuario);

    void edit(RegistroUsuario registroUsuario);

    void remove(RegistroUsuario registroUsuario);

    RegistroUsuario find(Object id);

    List<RegistroUsuario> findAll();

    List<RegistroUsuario> findRange(int[] range);

    int count();
    
     List<RegistroUsuario> findByTipoUsuario(String idTipoUsuario);
    
}
