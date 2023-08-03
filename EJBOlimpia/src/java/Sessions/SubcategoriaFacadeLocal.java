/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.Subcategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CAMPOVERDE_R
 */
@Local
public interface SubcategoriaFacadeLocal {

    void create(Subcategoria subcategoria);

    void edit(Subcategoria subcategoria);

    void remove(Subcategoria subcategoria);

    Subcategoria find(Object id);

    List<Subcategoria> findAll();

    List<Subcategoria> findRange(int[] range);

    int count();
    
}
