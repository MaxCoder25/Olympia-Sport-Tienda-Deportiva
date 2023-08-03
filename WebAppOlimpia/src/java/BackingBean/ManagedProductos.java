
package BackingBean;

import Entidades.Categoria;
import Entidades.Marca;
import Entidades.Producto;
import Entidades.Proveedor;
import Entidades.Subcategoria;
import Sessions.CategoriaFacadeLocal;
import Sessions.MarcaFacadeLocal;
import Sessions.ProductoFacadeLocal;
import Sessions.ProveedorFacadeLocal;
import Sessions.SubcategoriaFacadeLocal;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
//import org.primefaces.context.RequestContext;


@ManagedBean (name = "ManagedProductos")
@RequestScoped
//@SessionScoped
public class ManagedProductos implements Serializable {

    /**
     * Creates a new instance of ManagedProductos
     */
    public ManagedProductos() {
    }
    
    @EJB
    private CategoriaFacadeLocal manejadorCategoria;
   
   @EJB
    private SubcategoriaFacadeLocal manejadorSubcategoria;
   
   @EJB
    private ProveedorFacadeLocal manejadorProveedor;
   
   @EJB
    private MarcaFacadeLocal manejadorMarca;
   
   @EJB
    private ProductoFacadeLocal manejadorProducto;
   
   
  /* ----------------------------------------          */ 
   private Categoria categoria; 

   private List<Categoria> listaCategoria;
   
    private Subcategoria subcategoria; 

   private List<Subcategoria> listaSubcategoria;
   
    private Proveedor proveedor; 

   private List<Proveedor> listaProveedor;
   
    private Marca marca; 

   private List<Marca> listaMarca;
   
    private Producto producto; 

   private List<Producto> listaProducto;
   
  /* Variables para cada clase
   
   */
    private String idCategoria;
    private String nombreCategoria;
    private String descripcionCategoria;
     
    private String idSubcategoria;
    private String nombreSubcategoria;
    private String descripcionSubcategoria;    
    
    private String idMarca;
    private String nombreMarca;
    private String paisMarca;
    
    private String idProveedor;
    private String nombreProveedor;
    private String rucProveedor;
    private String telefonoProveedor;
    private String direccionProveedor;
    
    private String idProducto;
    private String nombreProducto;
    private String marcaProducto;
    private String descripcionProducto; 
    private String stockProducto;
    private Double precioProducto;
    private String paisProducto;
    private String comentariosProducto;
    private Double ivaProducto;
    private Double descuentoProducto;
    private String marcaid_FK_Producto;
    private String proveedorid_FK_Producto;
    private String categoriaid_FK_Producto;
    private String subcategoriaid_FK_Producto;
 
    private String imagen;
    
    private Double totalprecioProducto;
    
     
    /* ----------------------------------------          */

    
    public String getTotalprecioProducto() {
        Double total = 0.0;
        
        for(Producto produ : getListaProducto()) {
            total += produ.getPrecioProducto();
                    }
         
        //para dar solo con 2 decimales 
        return new DecimalFormat("###.##").format(total);
    }
    
      @PostConstruct
    private void inicio() {
          //???
       this.setProducto(new Producto());
       
       
       listaCategoria = manejadorCategoria.findAll();
        listaSubcategoria = manejadorSubcategoria.findAll();
        listaProveedor = manejadorProveedor.findAll();
        listaMarca = manejadorMarca.findAll();
        listaProducto = manejadorProducto.findAll();
        getTotalprecioProducto();
        
        
        
    }
      
       public void cargarIdProducto(Producto producto) {
        this.setProducto(producto);


    }
      
        public void editarProducto(  ) {
  
        try {
              System.out.println("IdProducto: " + producto.getIdProducto());
            //System.out.println("Idmarca: " + producto.getMarcaIdMarca().getIdMarca()  );
              
              
              
              // producto.setIdProducto("1");
              //producto.setIdProducto(producto.getIdProducto());
               
             
              
              System.out.println("descuento" + producto.getDescuentoProducto());
              
              
             nombreProducto = producto.getNombreProducto(); 
             descripcionProducto = producto.getDescripcionProducto();
               stockProducto = producto.getStockProducto();
             comentariosProducto = producto.getComentariosProducto();
             precioProducto= producto.getPrecioProducto();
             // falta cambiar id tambien, abria que agregar un listbox 
             marcaProducto = producto.getMarcaProducto();
              // marcaid_FK_Producto=marca.getIdMarca();
             
             paisProducto = producto.getPaisFabricaProducto();
             
             descuentoProducto = producto.getDescuentoProducto();
              
              
                      
              producto = manejadorProducto.find(producto.getIdProducto());
         
              producto.setNombreProducto(nombreProducto);
              producto.setDescripcionProducto(descripcionProducto);
              producto.setStockProducto(stockProducto);
            producto.setComentariosProducto(comentariosProducto);
               producto.setPrecioProducto(precioProducto);
               
               if(marcaid_FK_Producto!= null){
                   marca= new Marca();
               marca= manejadorMarca.find(marcaid_FK_Producto);
              
               producto.setMarcaProducto(marca.getNombreMarca());
              
               producto.setPaisFabricaProducto(marca.getPaisOrigenMarca());
              
               
               producto.setMarcaIdMarca(marca);
            
               }
               
               
               producto.setIvaProducto(precioProducto*0.12);
                producto.setDescuentoProducto(descuentoProducto); 
              
             System.out.println("stock" + producto.getStockProducto());
            
            manejadorProducto.edit(producto);
            producto = new Producto();
            addMessage(FacesMessage.SEVERITY_INFO, "Confirmacion: ", "Producto editado");

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }
    

      
      
      
      /* ----------------------------------------          */
       public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
       
       
       
       
     public String grabarCategoria() { 
      long id;   
         
          categoria = new Categoria();
         id = manejadorCategoria.count() + 1;
         categoria.setIdCategoria(String.valueOf(id));
         categoria.setNombreCategoria(nombreCategoria);
        categoria.setDescripcionCategoria(descripcionCategoria);
      
        
        if("".equals(nombreCategoria) || "".equals(descripcionCategoria)) {
            addMessage(FacesMessage.SEVERITY_INFO, "Falta agregar un campo: ", "Categoria no agregada ");

        } else {
            manejadorCategoria.create(categoria);
            addMessage(FacesMessage.SEVERITY_INFO, "Confirmacion: ", "Categoria agregada");

        }
         
 
        //  nombreCategoria = "";
        // descripcionCategoria = "";
        //en el sevn
        // PrimeFaces.current().update(":formADP"); 
        // RequestContext.getCurrentInstance().update(":formADP");

        return "AgregarDatosProducto";
    }

    public String grabarSubcategoria() {
        long id;

        subcategoria = new Subcategoria();
        id = manejadorSubcategoria.count() + 1;
        subcategoria.setIdSubcategoria(String.valueOf(id));
        subcategoria.setNombreSubcategoria(nombreSubcategoria);
        subcategoria.setDescripcionSubcategoria(descripcionSubcategoria);
        subcategoria.setTotalProductosSubcategoria("0");
        manejadorSubcategoria.create(subcategoria);
         addMessage(FacesMessage.SEVERITY_INFO, "Subcategoria agregada: ", "Confirmacion");
          
         return "AgregarDatosProducto";      
     }
      
        public String grabarProveedor() { 
      long id;   
         
          proveedor = new Proveedor();
         id = manejadorProveedor.count() + 1;
         proveedor.setIdProveedor(String.valueOf(id));
         proveedor.setNombreProveedor(nombreProveedor);
        proveedor.setRucProveedor(rucProveedor);
        proveedor.setTelefonoProveedor(telefonoProveedor);
        proveedor.setDireccionProveedor(direccionProveedor);
        manejadorProveedor.create(proveedor);
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proveedor agregado:", "Confirmacion"));
          return "AgregarDatosProducto";      
     }
        
       public String grabarMarca() { 
      long id;   
         
          marca = new Marca();
         id = manejadorMarca.count() + 1;
         marca.setIdMarca(String.valueOf(id));
         marca.setNombreMarca(nombreMarca);
        marca.setPaisOrigenMarca(paisMarca);
        manejadorMarca.create(marca);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marca agregada:", "\nConfirmacion"));
          return "AgregarDatosProducto";      
     }
       
       public String grabarProducto() { 
      long id;   

         producto = new Producto();
         id = manejadorProducto.count() + 1;
         producto.setIdProducto(String.valueOf(id));
         producto.setNombreProducto(nombreProducto);  
         
         producto.setMarcaProducto(manejadorMarca.find(marcaid_FK_Producto).getNombreMarca());
         
         producto.setDescripcionProducto(descripcionProducto);
         producto.setStockProducto(stockProducto);
         
         producto.setPrecioProducto(precioProducto);
         
         producto.setPaisFabricaProducto(manejadorMarca.find(marcaid_FK_Producto).getPaisOrigenMarca());
         producto.setComentariosProducto(comentariosProducto);
         
         
         ivaProducto = precioProducto * 0.12;
         descuentoProducto = 0.0;
         
         producto.setIvaProducto(ivaProducto);
         producto.setDescuentoProducto(descuentoProducto);
         
         producto.setMarcaIdMarca(manejadorMarca.find(marcaid_FK_Producto));
         producto.setProveedorIdProveedor(manejadorProveedor.find(proveedorid_FK_Producto));
         producto.setCategoriaIdCategoria(manejadorCategoria.find(categoriaid_FK_Producto));
         producto.setSubcategoriaIdSubcategoria(manejadorSubcategoria.find(subcategoriaid_FK_Producto));
         
         subcategoria= new Subcategoria();
           System.out.println("marcaid_FK_Producto "+marcaid_FK_Producto);
         subcategoria = manejadorSubcategoria.find(subcategoriaid_FK_Producto);
           System.out.println("subcategoria.getTotalProductosSubcategoria() "+subcategoria.getTotalProductosSubcategoria());
         subcategoria.setTotalProductosSubcategoria( String.valueOf( Integer.parseInt( subcategoria.getTotalProductosSubcategoria()) + 1) );
         manejadorSubcategoria.edit(subcategoria);
         
         producto.setImagen(imagen);
         
         producto.setCantidadProducto("1");
         producto.setTotalVentasProducto("0");
         
        manejadorProducto.create(producto);
          
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Producto agregado:", "Confirmacion"));

           nombreProducto = "";
           descripcionProducto = "";
           stockProducto = "";
           precioProducto = 0.0;
           comentariosProducto = "";
           comentariosProducto = "";
           ivaProducto = 0.0;
           
          // RequestContext.getCurrentInstance().update(":formAP");

 listaProducto = manejadorProducto.findAll();
          return "AgregarProducto";      
     }
       
      
   /* ----------------------------------------          */   
    public CategoriaFacadeLocal getManejadorCategoria() {
        return manejadorCategoria;
    }

    public void setManejadorCategoria(CategoriaFacadeLocal manejadorCategoria) {
        this.manejadorCategoria = manejadorCategoria;
    }

    public SubcategoriaFacadeLocal getManejadorSubcategoria() {
        return manejadorSubcategoria;
    }

    public void setManejadorSubcategoria(SubcategoriaFacadeLocal manejadorSubcategoria) {
        this.manejadorSubcategoria = manejadorSubcategoria;
    }

    public ProveedorFacadeLocal getManejadorProveedor() {
        return manejadorProveedor;
    }

    public void setManejadorProveedor(ProveedorFacadeLocal manejadorProveedor) {
        this.manejadorProveedor = manejadorProveedor;
    }

    public MarcaFacadeLocal getManejadorMarca() {
        return manejadorMarca;
    }

    public void setManejadorMarca(MarcaFacadeLocal manejadorMarca) {
        this.manejadorMarca = manejadorMarca;
    }

    public ProductoFacadeLocal getManejadorProducto() {
        return manejadorProducto;
    }

    public void setManejadorProducto(ProductoFacadeLocal manejadorProducto) {
        this.manejadorProducto = manejadorProducto;
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

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public List<Subcategoria> getListaSubcategoria() {
        return listaSubcategoria;
    }

    public void setListaSubcategoria(List<Subcategoria> listaSubcategoria) {
        this.listaSubcategoria = listaSubcategoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Marca> getListaMarca() {
        return listaMarca;
    }

    public void setListaMarca(List<Marca> listaMarca) {
        this.listaMarca = listaMarca;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public String getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(String idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getNombreSubcategoria() {
        return nombreSubcategoria;
    }

    public void setNombreSubcategoria(String nombreSubcategoria) {
        this.nombreSubcategoria = nombreSubcategoria;
    }

    public String getDescripcionSubcategoria() {
        return descripcionSubcategoria;
    }

    public void setDescripcionSubcategoria(String descripcionSubcategoria) {
        this.descripcionSubcategoria = descripcionSubcategoria;
    }

    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getPaisMarca() {
        return paisMarca;
    }

    public void setPaisMarca(String paisMarca) {
        this.paisMarca = paisMarca;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getRucProveedor() {
        return rucProveedor;
    }

    public void setRucProveedor(String rucProveedor) {
        this.rucProveedor = rucProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(String stockProducto) {
        this.stockProducto = stockProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getPaisProducto() {
        return paisProducto;
    }

    public void setPaisProducto(String paisProducto) {
        this.paisProducto = paisProducto;
    }

    public String getComentariosProducto() {
        return comentariosProducto;
    }

    public void setComentariosProducto(String comentariosProducto) {
        this.comentariosProducto = comentariosProducto;
    }

    public Double getIvaProducto() {
        return ivaProducto;
    }

    public void setIvaProducto(Double ivaProducto) {
        this.ivaProducto = ivaProducto;
    }

    public Double getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(Double descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }

    public String getMarcaid_FK_Producto() {
        return marcaid_FK_Producto;
    }

    public void setMarcaid_FK_Producto(String marcaid_FK_Producto) {
        this.marcaid_FK_Producto = marcaid_FK_Producto;
    }

    public String getProveedorid_FK_Producto() {
        return proveedorid_FK_Producto;
    }

    public void setProveedorid_FK_Producto(String proveedorid_FK_Producto) {
        this.proveedorid_FK_Producto = proveedorid_FK_Producto;
    }

    public String getCategoriaid_FK_Producto() {
        return categoriaid_FK_Producto;
    }

    public void setCategoriaid_FK_Producto(String categoriaid_FK_Producto) {
        this.categoriaid_FK_Producto = categoriaid_FK_Producto;
    }

    public String getSubcategoriaid_FK_Producto() {
        return subcategoriaid_FK_Producto;
    }

    public void setSubcategoriaid_FK_Producto(String subcategoriaid_FK_Producto) {
        this.subcategoriaid_FK_Producto = subcategoriaid_FK_Producto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
     public void eliminarCategoria(Categoria categoria) {
        try {
            
            this.manejadorCategoria.remove(categoria);
            addMessage(FacesMessage.SEVERITY_WARN, "Categoria eliminada: ", "Confirmacion");
        
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    }
            
            public void eliminarSubcategoria(Subcategoria subcategoria) {
        try {
            this.manejadorSubcategoria.remove(subcategoria);
           addMessage(FacesMessage.SEVERITY_WARN, "Subcategoria eliminada: ", "Confirmacion");
        
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    }
            
             public void eliminarMarca(Marca marca) {
        try {
            this.manejadorMarca.remove(marca);
           addMessage(FacesMessage.SEVERITY_WARN, "Marca eliminada: ", "Confirmacion");
        
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    }
             
              public void eliminarProveedor(Proveedor proveedor) {
        try {
            this.manejadorProveedor.remove(proveedor);
           addMessage(FacesMessage.SEVERITY_WARN, "Proveedor eliminado: ", "Confirmacion");
        
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    }
              
               public void eliminarProducto(Producto producto) {
        try {
            
            
             subcategoria= new Subcategoria();
        //   System.out.println("marcaid_FK_Producto "+marcaid_FK_Producto);
         subcategoria = manejadorSubcategoria.find(producto.getSubcategoriaIdSubcategoria().getIdSubcategoria());
         //  System.out.println("subcategoria.getTotalProductosSubcategoria() "+subcategoria.getTotalProductosSubcategoria());
         subcategoria.setTotalProductosSubcategoria( String.valueOf( Integer.parseInt( subcategoria.getTotalProductosSubcategoria()) - 1) );
         manejadorSubcategoria.edit(subcategoria);
         
         this.manejadorProducto.remove(producto);
           addMessage(FacesMessage.SEVERITY_WARN, "Producto eliminado: ", "Confirmacion");
        
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    }
            
            
}
