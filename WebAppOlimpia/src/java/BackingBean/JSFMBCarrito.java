/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entidades.Categoria;
import Entidades.Producto;
import Entidades.Subcategoria;
import Sessions.CategoriaFacadeLocal;
import Sessions.ProductoFacadeLocal;
import Sessions.SubcategoriaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author CAMPOVERDE_R
 */
@ManagedBean(name = "JSFMBCarrito")
@SessionScoped
public class JSFMBCarrito implements Serializable {

    /**
     * Creates a new instance of JSFMBCarrito
     */
    @EJB
    private ProductoFacadeLocal manejadorProducto;
    private Producto p;
    
    
    private List<Producto> ListadoProductos;
   private List<Producto> listadoMejoresProductos;
    private List<Producto> lstarticulos;
    private int number3;
    private double subtotal;
    private double total;
     private double totalFinal;
    private String idCategoriaParaFiltrado;
    private String idsubCategoriaParaFiltrado;

    
    private Collection<Producto> productoCollection;

    private Categoria categoria; 

     private Subcategoria Subcategoria; 

   private List<Categoria> listaCategoria;

   private List<Subcategoria> listaSubcategoria;

     @EJB
    private CategoriaFacadeLocal manejadorCategoria;

     @EJB
    private SubcategoriaFacadeLocal manejadorSubcategoria;

     
     
       private int cantidadProducto;

    public List<Producto> getListadoMejoresProductos() {
        return listadoMejoresProductos;
    }

    public void setListadoMejoresProductos(List<Producto> listadoMejoresProductos) {
        this.listadoMejoresProductos = listadoMejoresProductos;
    }
       
       
       
       
       
       

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
     
     
     
    public String getIdsubCategoriaParaFiltrado() {
        return idsubCategoriaParaFiltrado;
    }

    public void setIdsubCategoriaParaFiltrado(String idsubCategoriaParaFiltrado) {
        this.idsubCategoriaParaFiltrado = idsubCategoriaParaFiltrado;
    }

    public Subcategoria getSubcategoria() {
        return Subcategoria;
    }

    public void setSubcategoria(Subcategoria Subcategoria) {
        this.Subcategoria = Subcategoria;
    }

    public SubcategoriaFacadeLocal getManejadorSubcategoria() {
        return manejadorSubcategoria;
    }

    public void setManejadorSubcategoria(SubcategoriaFacadeLocal manejadorSubcategoria) {
        this.manejadorSubcategoria = manejadorSubcategoria;
    }

    public List<Subcategoria> getListaSubcategoria() {
        return listaSubcategoria;
    }

    public void setListaSubcategoria(List<Subcategoria> listaSubcategoria) {
        this.listaSubcategoria = listaSubcategoria;
    }

     
     
     
     
     
    public CategoriaFacadeLocal getManejadorCategoria() {
        return manejadorCategoria;
    }

    public void setManejadorCategoria(CategoriaFacadeLocal manejadorCategoria) {
        this.manejadorCategoria = manejadorCategoria;
    }
   
   
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
   
     public String getIdCategoriaParaFiltrado() {
        return idCategoriaParaFiltrado;
    }

    public void setIdCategoriaParaFiltrado(String idCategoriaParaFiltrado) {
        this.idCategoriaParaFiltrado = idCategoriaParaFiltrado;
    }
    
    
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }
    
   
      public void verTodosProductos() {
            setProductoCollection(  ListadoProductos );
         categoria=new Categoria();
      
      }
    
    
     public void filtrarPorCategoria() {
         setCategoria(manejadorCategoria.find(idCategoriaParaFiltrado));
    setProductoCollection(  categoria.getProductoCollection()  );
     }
     
     public void filtrarPorSubcategoria() {
     
         setSubcategoria(manejadorSubcategoria.find(idsubCategoriaParaFiltrado));
   // setProductoCollection(Subcategoria.getProductoCollection()  );
       
        
         if(categoria.getIdCategoria()!= null){
            setProductoCollection(manejadorProducto.buscarCatsubCat( categoria ,Subcategoria));
    
         }else{
              //categoria=new Categoria();
         setProductoCollection(manejadorProducto.buscarSubCat(Subcategoria));
   
              
         }
   
    // setProductoCollection(  manejadorProducto.findAll()  );
     }
    
    
    public JSFMBCarrito() {
    }

    @PostConstruct
    public void init() {
        
       
       p = new Producto();
        ListadoProductos = new ArrayList<Producto>();
        listadoMejoresProductos = new ArrayList<Producto>();
       ////////////////////
        lstarticulos = new ArrayList<Producto>();
        llenarCarrucel();
        
         ListadoProductos = manejadorProducto.findAll();
         listadoMejoresProductos = manejadorProducto.findbyTotalVentas();
                 
                 
         setProductoCollection(  ListadoProductos );
         
        listaCategoria = manejadorCategoria.findAll();
         listaSubcategoria = manejadorSubcategoria.findAll();
        
         subtotal = subTotal(lstarticulos);
         total = Total(lstarticulos);
         totalFinal = totalFinal(lstarticulos);
         
      
    }

    
    public void calcularTotal (List<Producto>  lstarticulos){
        
        this.total = Total(lstarticulos);
         this.totalFinal = totalFinal(lstarticulos);
    }
    
    
    public void llenarCarrucel() {
        this.setListadoProductos(manejadorProducto.findAll());
        for (int i = 0; i < ListadoProductos.size(); i++) {
            System.out.println("" + ListadoProductos.get(i).getNombreProducto());
        }
    
    
    
    }

    /*----------------------------------------------------------*/
    //    public void createNew() {
    //        lstarticulos.add(p);
    //        p = new Producto();
    //    }
    public void reinit() {
        this.subtotal = subTotal(lstarticulos);
         this.total = Total(lstarticulos);
         this.totalFinal = totalFinal(lstarticulos);
        p = new Producto();
       
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmación:", "\nProducto añadido al carrito" ));

    }
    
    
    public void limpiarTotales() {
        this.subtotal = 0.0;
        this.total = 0.0;
        
    }
    
    
    public double subTotal(List<Producto> lst) {
        double suma = 0.0;
        for (int i = 0; i < lst.size(); i++) {
            suma += lst.get(i).getPrecioProducto();     
        }
        
      suma  =  Math.round (suma * 100.0) / 100.0;
            return suma;
    }
    
public double Total(List<Producto> lst) {
        double suma2 = 0.0;
        for (int i = 0; i < lst.size(); i++) {
            suma2 += lst.get(i).getPrecioProducto();
            suma2 += lst.get(i).getIvaProducto();
            suma2-= lst.get(i).getDescuentoProducto();
        }
        
      suma2  =  Math.round (suma2 * 100.0) / 100.0;
            return suma2;
    }
    
public double totalFinal(List<Producto> lst) {
        double suma2 = 0.0;
        for (int i = 0; i < lst.size(); i++) {
            suma2 += lst.get(i).getPrecioProducto();
            suma2 += lst.get(i).getIvaProducto();
            suma2-= lst.get(i).getDescuentoProducto();
            suma2*= Integer.parseInt(lst.get(i).getCantidadProducto() );
        }
        
      suma2  =  Math.round (suma2 * 100.0) / 100.0;
            return suma2;
    }

    public int getNumber3() {
        return number3;
    }

    public void setNumber3(int number3) {
        this.number3 = number3;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(double totalFinal) {
        this.totalFinal = totalFinal;
    }

    
    /*----------------------------------------------------------*/
    public ProductoFacadeLocal getManejadorProducto() {
        return manejadorProducto;
    }

    public void setManejadorProducto(ProductoFacadeLocal manejadorProducto) {
        this.manejadorProducto = manejadorProducto;
    }

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }

    public List<Producto> getListadoProductos() {
        return ListadoProductos;
    }

    public void setListadoProductos(List<Producto> ListadoProductos) {
        this.ListadoProductos = ListadoProductos;
    }

    public List<Producto> getLstarticulos() {
        return lstarticulos;
    }

    public void setLstarticulos(List<Producto> lstarticulos) {
        this.lstarticulos = lstarticulos;
    }
    
    
}
