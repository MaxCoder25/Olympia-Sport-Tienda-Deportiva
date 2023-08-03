/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.CabeceraFactura;
import Entidades.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CAMPOVERDE_R
 */
@Local
public interface CabeceraFacturaFacadeLocal {

    void create(CabeceraFactura cabeceraFactura);

    void edit(CabeceraFactura cabeceraFactura);

    void remove(CabeceraFactura cabeceraFactura);

    CabeceraFactura find(Object id);

    List<CabeceraFactura> findAll();

    List<CabeceraFactura> findRange(int[] range);

    int count();
    
    List<CabeceraFactura> findbyIdCliente(Cliente clienteIdCliente);
    
}
