/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.Vendedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author KevinMac
 */
@Local
public interface VendedorFacadeLocal {

    void create(Vendedor vendedor);

    void edit(Vendedor vendedor);

    void remove(Vendedor vendedor);

    Vendedor find(Object id);

    List<Vendedor> findAll();

    List<Vendedor> findRange(int[] range);

    int count(); 
        
        
        
        
} 
