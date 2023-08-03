/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.Categoria;
import Entidades.Producto;
import Entidades.Subcategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author KevinMac
 */
@Local
public interface ProductoFacadeLocal {

    void create(Producto producto);

    void edit(Producto producto);

    void remove(Producto producto);

    Producto find(Object id);

    List<Producto> findAll();

    List<Producto> findRange(int[] range);

    int count();
    
    List<Producto> listarStock();
    
    List<Producto> buscarCatsubCat(Categoria categoria,Subcategoria subcategoria);
    
    List<Producto> buscarSubCat( Subcategoria subcategoria);
   
    List<Producto> findbyTotalVentas(); 
   
}
