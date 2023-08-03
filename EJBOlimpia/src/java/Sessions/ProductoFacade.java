/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entidades.Categoria;
import Entidades.Producto;
import Entidades.Subcategoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author KevinMac
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> implements ProductoFacadeLocal {
    @PersistenceContext(unitName = "EJBOlimpiaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
    @Override
////METODO DE LISTAR STOCK DE PRODUCTOS
    public List<Producto> listarStock() {

        Query consulta = em.createNativeQuery("Select id_producto,nombre_producto,stock_producto from Public.Producto");

        List<Producto> lst = consulta.getResultList();

        for (int i = 0; i < lst.size(); i++) {
            System.out.println("**************************************************************");
            System.out.println(lst.get(i).getNombreProducto() + "holaa"+ lst.get(i).getStockProducto());
            System.out.println("**************************************************************");
        }
        return lst;
    }
    
    
     @Override
   public List<Producto> findbyTotalVentas(){
       String minimoVentas = "4";
        Query sql = em.createNamedQuery("Producto.findbyTotalVentas").setParameter("totalVentasProducto", minimoVentas);
        
        //Query consulta = em.createNativeQuery("Select * from cuenta where cuenta = ;");
       List<Producto> lst = sql.getResultList();
       return lst;
   }  
    
    @Override
   public List<Producto> buscarCatsubCat(Categoria categoria,Subcategoria subcategoria){
       
        Query sql = em.createNamedQuery("Producto.findBycatSubcat").setParameter("categoriaIdCategoria", categoria).setParameter("subcategoriaIdSubcategoria", subcategoria);
        
        //Query consulta = em.createNativeQuery("Select * from cuenta where cuenta = ;");
       List<Producto> lst = sql.getResultList();
       return lst;
   }  
    
    @Override
    public List<Producto> buscarSubCat( Subcategoria subcategoria){
       
        Query sql = em.createNamedQuery("Producto.findBySubcat").setParameter("subcategoriaIdSubcategoria", subcategoria);
        
        //Query consulta = em.createNativeQuery("Select * from cuenta where cuenta = ;");
       List<Producto> lst = sql.getResultList();
       return lst;
   }   
    
    
}
