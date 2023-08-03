/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.Categoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CAMPOVERDE_R
 */
@Local
public interface CategoriaFacadeLocal {

    void create(Categoria categoria);

    void edit(Categoria categoria);

    void remove(Categoria categoria);

    Categoria find(Object id);

    List<Categoria> findAll();

    List<Categoria> findRange(int[] range);

    int count();
    
}
