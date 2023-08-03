/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entidades.CabeceraFactura;
import Entidades.Cliente;
import Entidades.DetalleFactura;
import Entidades.EstadoPedido;
import Entidades.ModoPago;
import Entidades.Pedido;
import Entidades.PedidoProducto;
import Entidades.Producto;
import Entidades.Reclamo;
import Entidades.RegistroUsuario;
import Entidades.Vendedor;
import Sessions.CabeceraFacturaFacadeLocal;
import Sessions.ClienteFacadeLocal;
import Sessions.DetalleFacturaFacadeLocal;
import Sessions.EstadoPedidoFacadeLocal;
import Sessions.ModoPagoFacadeLocal;
import Sessions.PedidoFacadeLocal;
import Sessions.PedidoProductoFacadeLocal;
import Sessions.ProductoFacadeLocal;
import Sessions.ReclamoFacadeLocal;
import Sessions.RegistroUsuarioFacadeLocal;
import Sessions.VendedorFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author KevinMac
 */
@ManagedBean (name = "JSFMBPedidoFactura")
@ViewScoped
public class JSFMBPedidoFactura implements Serializable {

    /**
     * Creates a new instance of JSFMBPedido
     */
    public JSFMBPedidoFactura() {
    }
    
    
    @EJB
    private PedidoFacadeLocal manejadorPedido;
    private Pedido p;
    
    private List<Pedido> listadoPedidos;
    
    @EJB
    private PedidoProductoFacadeLocal manejadorPedidoProducto;
    private PedidoProducto pprod;
    
    private List<PedidoProducto> listadoPedidoProducto;
    
    
     @EJB
    private CabeceraFacturaFacadeLocal manejadorCabeceraFactura;
    private CabeceraFactura cf;
    
    private List<CabeceraFactura> listadoCabeceraFactura;
    
    @EJB
    private DetalleFacturaFacadeLocal manejadorDetalleFactura;
    private DetalleFactura df;
    
    private List<DetalleFactura> listadoDetalleFactura;
     private List<DetalleFactura> listadoDetalleFacturaFiltradaCliente;
    
    
    
    @EJB
    private ProductoFacadeLocal manejadorProducto;
    private Producto produc;
    
    private List<Producto> listadoProducto;
    
    @EJB
    private EstadoPedidoFacadeLocal manejadorEstadoPedido;
    private EstadoPedido estPedido;
    
     @EJB
    private RegistroUsuarioFacadeLocal manejadorAcceso;
    private RegistroUsuario u;
    
    
    @EJB
    private ClienteFacadeLocal manejadorCliente;
    private Cliente c;
    
     @EJB
    private VendedorFacadeLocal manejadorVendedor;
    private Vendedor v;
    
    private List<Vendedor> listadoVendedor;
    
    @EJB
    private ModoPagoFacadeLocal manejadorModoPago;
    private ModoPago mp;
   
    private List<ModoPago> listadoModoPago;
    private List<EstadoPedido> listadoEstadoPedido;
    
    @EJB
    private ReclamoFacadeLocal manejadorReclamo;
    private Reclamo reclamo;
    
    
    
    
    
     private Collection<CabeceraFactura> cabeceraFacturaCollection;
    
    private Collection<DetalleFactura> detalleFacturaCollection;
    
       private Collection<Reclamo> reclamoCollection;
       
       private Collection<Pedido> pedidoCollection;
       
         
   private String modoDePago;
   private String estadoPedidoid_FK; 
    private String idCabeceraFactura;
   private String idPedido;

     
       private int cantidadProducto;
 
       
    public ReclamoFacadeLocal getManejadorReclamo() {
        return manejadorReclamo;
    }

    public void setManejadorReclamo(ReclamoFacadeLocal manejadorReclamo) {
        this.manejadorReclamo = manejadorReclamo;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }
  
        
       
       
       
    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public Collection<Reclamo> getReclamoCollection() {
        return reclamoCollection;
    }

    public void setReclamoCollection(Collection<Reclamo> reclamoCollection) {
        this.reclamoCollection = reclamoCollection;
    }
       
      
         
       
       
    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
     
     
    
    
    
    public Collection<DetalleFactura> getDetalleFacturaCollection() {
        return detalleFacturaCollection;
    }

    public void setDetalleFacturaCollection(Collection<DetalleFactura> detalleFacturaCollection) {
        this.detalleFacturaCollection = detalleFacturaCollection;
    }

    public String getIdCabeceraFactura() {
        return idCabeceraFactura;
    }

    public void setIdCabeceraFactura(String idCabeceraFactura) {
        this.idCabeceraFactura = idCabeceraFactura;
    }

   
   
   
   
    public List<DetalleFactura> getListadoDetalleFacturaFiltradaCliente() {
        return listadoDetalleFacturaFiltradaCliente;
    }

    public void setListadoDetalleFacturaFiltradaCliente(List<DetalleFactura> listadoDetalleFacturaFiltradaCliente) {
        this.listadoDetalleFacturaFiltradaCliente = listadoDetalleFacturaFiltradaCliente;
    }

    public Collection<CabeceraFactura> getCabeceraFacturaCollection() {
        return cabeceraFacturaCollection;
    }

    public void setCabeceraFacturaCollection(Collection<CabeceraFactura> cabeceraFacturaCollection) {
        this.cabeceraFacturaCollection = cabeceraFacturaCollection;
    }
   
    public void ingresarIdCabeceraFactura(Cliente cliente){
            
      // setListadoCabeceraFactura( manejadorCabeceraFactura.findbyIdCliente(cliente) );
      // listadoCabeceraFactura = (manejadorCabeceraFactura.findbyIdCliente(cliente) );
     listadoCabeceraFactura = manejadorCabeceraFactura.findAll();

         setCabeceraFacturaCollection(listadoCabeceraFactura);
             
        //setDetalleFacturaCollection(getDetalleFacturaCollection());
        
        
        setCabeceraFacturaCollection(cliente.getCabeceraFacturaCollection());
     
    }
    
    public void ingresarIdPedido(Cliente cliente){
            
      // setListadoCabeceraFactura( manejadorCabeceraFactura.findbyIdCliente(cliente) );
      // listadoCabeceraFactura = (manejadorCabeceraFactura.findbyIdCliente(cliente) );
       setPedidoCollection(cliente.getPedidoCollection());
     
       
    }
    
   public void filtrarPedidoCliente (Cliente cliente){
       System.out.println("idPedido " + idPedido);
       setP(manejadorPedido.find(idPedido));
    //System.out.println("NumFactura2  " + cf.getNumFactura());
       setPedidoCollection(cliente.getPedidoCollection());
     
    //setPedidoProductoCollection(p.getPedidoProductoCollection());
     
        
   }
   
   
   
               
           
    
   
   public void filtrarFacturaCliente (Cliente cliente){
       
       
       //listadoCabeceraFactura =  manejadorCabeceraFactura.findbyIdCliente(cliente);
       System.out.println("dentro de filtrado");
           //   setC(manejadorCliente.find(cliente.getIdCliente()));
       System.out.println("cliente filtrar " + cliente.getIdCliente());       
            System.out.println("idCabeceraFactura " + idCabeceraFactura);
      System.out.println("NumFactura1 " + cf.getNumFactura());
       
      /////////////////
      setCabeceraFacturaCollection(cliente.getCabeceraFacturaCollection());
     ///////////
       setCf(manejadorCabeceraFactura.find(idCabeceraFactura));
    System.out.println("NumFactura2  " + cf.getNumFactura());
       
    setDetalleFacturaCollection(  cf.getDetalleFacturaCollection());
     
    
    
        
       
       
       
   }
   
   
   
   
   
    @PostConstruct
    public void init() {
        
        p = new Pedido();
        cf = new CabeceraFactura();
        df = new DetalleFactura();
        //nuevo 
        
        //setPedidoCollection(c.getPedidoCollection());
     
        listadoPedidos = manejadorPedido.findAll();
      //  listadoCabeceraFactura = manejadorCabeceraFactura.findAll();
        
        
        //filtrar esta lista guardar en otra lista
        listadoDetalleFactura = manejadorDetalleFactura.findAll();
       // listadoDetalleFacturaFiltradaCliente = manejadorDetalleFactura.findAll();
         
        
        listadoVendedor = manejadorVendedor.findAll();
        listadoModoPago = manejadorModoPago.findAll();
        listadoEstadoPedido = manejadorEstadoPedido.findAll();
       
       // listadoCabeceraFactura = manejadorCabeceraFactura.findAll();

        // setCabeceraFacturaCollection(listadoCabeceraFactura);
             
       // setDetalleFacturaCollection(getDetalleFacturaCollection());
        
        
        
        
    }

    public List<EstadoPedido> getListadoEstadoPedido() {
        return listadoEstadoPedido;
    }

    public void setListadoEstadoPedido(List<EstadoPedido> listadoEstadoPedido) {
        this.listadoEstadoPedido = listadoEstadoPedido;
    }
    
    
    
       public void cargarIdPedido(Pedido pedido) {
        this.setP(pedido);


    }  
      
        public void editarPedido(  ) {
            
            
            
            
            p = manejadorPedido.find(p.getNumPedido() );
          
            estPedido = new EstadoPedido();
              
               estPedido= manejadorEstadoPedido.find(estadoPedidoid_FK);
                 
               p.setEstadoPedidoIdEnvioPedido(estPedido);
            
               
    
      manejadorPedido.edit(p);
      
            p = new Pedido();
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmacion:", "\nPedido editado"));
    
    
    
    }
        
           public void listarPedido( List<Producto> lstarticulos  ) {
              
            
            System.out.println("prueba lista precios");
       for (int i = 0; i < lstarticulos.size(); i++) {
                System.out.println(lstarticulos.get(i).getIdProducto());
           System.out.println(lstarticulos.get(i).getCantidadProducto() );  
            }
               System.out.println("final lista ");
               
               
               
           }
        
        
        
        public void guardarPedido(Cliente c, List<Producto> lstarticulos) {
 
            //listadoDetalleFacturaFiltradaCliente =  (List<DetalleFactura>) manejadorDetalleFactura.find(c.getIdCliente());
        
            
           // listadoDetalleFactura = manejadorDetalleFactura.find(c.getIdCliente());
      
            
       
       
        long id1 ; 
        long id2 ; 
        p = new Pedido();
        
        produc = new Producto();
                
        pprod = new PedidoProducto(); 
        
        
        EstadoPedido estPedi = new EstadoPedido();
        estPedi = manejadorEstadoPedido.find("1");
       
        id1 = manejadorPedido.count() + 1;
        p.setNumPedido(String.valueOf(id1));
        
        p.setClienteIdCliente(c);
        p.setFechaPedido(new Date());
        p.setBarrioEntregaPedido(c.getBarrioCliente());
        p.setCallePrincipalEntregaPedido(c.getCallePrincipalCliente());
        p.setNumeroCasaEntregaPedido(c.getNumeroCasaCliente());
        p.setEstadoPedidoIdEnvioPedido(estPedi);
        
        manejadorPedido.create(p);
        
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Confirmacion:", "Pedido creado"));
        
          
          
        for (int i = 0; i < lstarticulos.size(); i++) {
            
            id2 = manejadorPedidoProducto.count() + 1;
            pprod.setIdpedidoProducto((String.valueOf(id2)));
            
            p.setNumPedido(String.valueOf(id1));
            pprod.setPedidoNumPedido(p);
            
            produc = manejadorProducto.find(lstarticulos.get(i).getIdProducto());
             
            pprod.setProductoIdProducto(produc);

           
            
            
            
        manejadorPedidoProducto.create(pprod);
        
        }
        

    }
  
        
        
       String compra = "";
       
       
      public void crearFactura(Cliente c, List<Producto> lstarticulos) {

        long id ;  
        long id2;
        
        cf = new CabeceraFactura();
        df = new DetalleFactura();
        v =  new Vendedor();
        mp = new ModoPago();
        produc = new Producto();
        
        id = manejadorCabeceraFactura.count() + 1;
        
        
        cf.setNumFactura(String.valueOf(id));
        
       
        
        cf.setClienteIdCliente(c);
        
        //aqui un for para sacar un random de la lista de vendedores
        v = manejadorVendedor.find("5");
        //v.getIdVendedor();
        cf.setVendedorIdVendedor(v);
        cf.setFecha(new Date());
        
       mp = manejadorModoPago.find(modoDePago);
        
        
        cf.setModoPagoIdModoPago(mp); 
        
        manejadorCabeceraFactura.create(cf);
        
         
        id2 = 0;
        
        double precioP;
        
      
        
        for (int i = 0; i < lstarticulos.size(); i++) {
             
             id = manejadorDetalleFactura.count() + 1;
            df.setSecuencialDetalleFactura(String.valueOf(id));
            
            id2 += 1;
            df.setIdDetalleFactura(String.valueOf(id2));    
            
            df.setCantidadProducto(lstarticulos.get(i).getCantidadProducto());
         
            
             produc = manejadorProducto.find(lstarticulos.get(i).getIdProducto());
            
            df.setPrecioProducto( ( (lstarticulos.get(i).getPrecioProducto() ) + (lstarticulos.get(i).getIvaProducto() ) - (lstarticulos.get(i).getDescuentoProducto() )  ) * Integer.parseInt(lstarticulos.get(i).getCantidadProducto()) );
             System.out.println("c.getTotalVentasCliente() "+c.getTotalVentasCliente()  + "df.getPrecioProducto() " +df.getPrecioProducto());
            c.setTotalVentasCliente(c.getTotalVentasCliente() + df.getPrecioProducto());
            manejadorCliente.edit(c);
            
            df.setCabeceraFacturaNumFactura(cf);
            
             
            df.setProductoIdProducto(produc);

           this.compra += "\n                                                    ";
           this.compra += lstarticulos.get(i).getNombreProducto().toString();
           this.compra += "      ";
           this.compra += "\n";
            
            
        manejadorDetalleFactura.create(df);
        
        
        
        
        produc.setTotalVentasProducto   (String.valueOf(  Integer.parseInt( produc.getTotalVentasProducto() ) + Integer.parseInt( lstarticulos.get(i).getCantidadProducto() ) )   );
       
         produc.setStockProducto(String.valueOf(  Integer.parseInt( produc.getStockProducto() ) - Integer.parseInt( lstarticulos.get(i).getCantidadProducto() ) )   );
       
        
        manejadorProducto.edit(produc);
        
        }
        
        
         this.compra += "                               ";
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Factura creada:", "Confirmacion"));

        EmailBeanCompra em1 = new EmailBeanCompra();
        
        em1.setReceptor(c.getRegistroUsuarioIdUsuario().getEmail());
        
        em1.send(c.getNombreCliente(),c.getApellidoCliente(),c.getCedulaCliente(), c.getTelefonoCliente(), this.compra);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correo enviado:", "Confirmacion"));

        compra = "";
        
        lstarticulos.clear();
        //{JSFMBCarrito.lstarticulos};
      
      }
     

    public PedidoFacadeLocal getManejadorPedido() {
        return manejadorPedido;
    }

    public void setManejadorPedido(PedidoFacadeLocal manejadorPedido) {
        this.manejadorPedido = manejadorPedido;
    }

    public Pedido getP() {
        return p;
    }

    public void setP(Pedido p) {
        this.p = p;
    }

    public List<Pedido> getListadoPedidos() {
        return listadoPedidos;
    }

    public void setListadoPedidos(List<Pedido> listadoPedidos) {
        this.listadoPedidos = listadoPedidos;
    }

    public RegistroUsuarioFacadeLocal getManejadorAcceso() {
        return manejadorAcceso;
    }

    public void setManejadorAcceso(RegistroUsuarioFacadeLocal manejadorAcceso) {
        this.manejadorAcceso = manejadorAcceso;
    }

    public RegistroUsuario getU() {
        return u;
    }

    public void setU(RegistroUsuario u) {
        this.u = u;
    }

    public ClienteFacadeLocal getManejadorCliente() {
        return manejadorCliente;
    }

    public void setManejadorCliente(ClienteFacadeLocal manejadorCliente) {
        this.manejadorCliente = manejadorCliente;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public EstadoPedidoFacadeLocal getManejadorEstadoPedido() {
        return manejadorEstadoPedido;
    }

    public void setManejadorEstadoPedido(EstadoPedidoFacadeLocal manejadorEstadoPedido) {
        this.manejadorEstadoPedido = manejadorEstadoPedido;
    }

    public EstadoPedido getEstPedido() {
        return estPedido;
    }

    public void setEstPedido(EstadoPedido estPedido) {
        this.estPedido = estPedido;
    }

    public PedidoProductoFacadeLocal getManejadorPedidoProducto() {
        return manejadorPedidoProducto;
    }

    public void setManejadorPedidoProducto(PedidoProductoFacadeLocal manejadorPedidoProducto) {
        this.manejadorPedidoProducto = manejadorPedidoProducto;
    }

    public PedidoProducto getPprod() {
        return pprod;
    }

    public void setPprod(PedidoProducto pprod) {
        this.pprod = pprod;
    }

    public List<PedidoProducto> getListadoPedidoProducto() {
        return listadoPedidoProducto;
    }

    public void setListadoPedidoProducto(List<PedidoProducto> listadoPedidoProducto) {
        this.listadoPedidoProducto = listadoPedidoProducto;
    }

    public CabeceraFacturaFacadeLocal getManejadorCabeceraFactura() {
        return manejadorCabeceraFactura;
    }

    public void setManejadorCabeceraFactura(CabeceraFacturaFacadeLocal manejadorCabeceraFactura) {
        this.manejadorCabeceraFactura = manejadorCabeceraFactura;
    }

    public CabeceraFactura getCf() {
        return cf;
    }

    public void setCf(CabeceraFactura cf) {
        this.cf = cf;
    }

    public List<CabeceraFactura> getListadoCabeceraFactura() {
        return listadoCabeceraFactura;
    }

    public void setListadoCabeceraFactura(List<CabeceraFactura> listadoCabeceraFactura) {
        this.listadoCabeceraFactura = listadoCabeceraFactura;
    }

    public DetalleFacturaFacadeLocal getManejadorDetalleFactura() {
        return manejadorDetalleFactura;
    }

    public void setManejadorDetalleFactura(DetalleFacturaFacadeLocal manejadorDetalleFactura) {
        this.manejadorDetalleFactura = manejadorDetalleFactura;
    }

    public DetalleFactura getDf() {
        return df;
    }

    public void setDf(DetalleFactura df) {
        this.df = df;
    }

    public List<DetalleFactura> getListadoDetalleFactura() {
        return listadoDetalleFactura;
    }

    public void setListadoDetalleFactura(List<DetalleFactura> listadoDetalleFactura) {
        this.listadoDetalleFactura = listadoDetalleFactura;
    }

    public ProductoFacadeLocal getManejadorProducto() {
        return manejadorProducto;
    }

    public void setManejadorProducto(ProductoFacadeLocal manejadorProducto) {
        this.manejadorProducto = manejadorProducto;
    }

    public Producto getProduc() {
        return produc;
    }

    public void setProduc(Producto produc) {
        this.produc = produc;
    }

    public List<Producto> getListadoProducto() {
        return listadoProducto;
    }

    public void setListadoProducto(List<Producto> listadoProducto) {
        this.listadoProducto = listadoProducto;
    }

    public VendedorFacadeLocal getManejadorVendedor() {
        return manejadorVendedor;
    }

    public void setManejadorVendedor(VendedorFacadeLocal manejadorVendedor) {
        this.manejadorVendedor = manejadorVendedor;
    }

    public Vendedor getV() {
        return v;
    }

    public void setV(Vendedor v) {
        this.v = v;
    }

    public List<Vendedor> getListadoVendedor() {
        return listadoVendedor;
    }

    public void setListadoVendedor(List<Vendedor> listadoVendedor) {
        this.listadoVendedor = listadoVendedor;
    }

    public ModoPagoFacadeLocal getManejadorModoPago() {
        return manejadorModoPago;
    }

    public void setManejadorModoPago(ModoPagoFacadeLocal manejadorModoPago) {
        this.manejadorModoPago = manejadorModoPago;
    }


    public List<ModoPago> getListadoModoPago() {
        return listadoModoPago;
    }

    public void setListadoModoPago(List<ModoPago> listadoModoPago) {
        this.listadoModoPago = listadoModoPago;
    }

    public ModoPago getMp() {
        return mp;
    }

    public void setMp(ModoPago mp) {
        this.mp = mp;
    }

    public String getModoDePago() {
        return modoDePago;
    }

    public void setModoDePago(String modoDePago) {
        this.modoDePago = modoDePago;
    }

    public String getEstadoPedidoid_FK() {
        return estadoPedidoid_FK;
    }

    public void setEstadoPedidoid_FK(String estadoPedidoid_FK) {
        this.estadoPedidoid_FK = estadoPedidoid_FK;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }
    
    
    
    
     public void eliminarPedido(Pedido pedido) {
        try {
            this.manejadorPedido.remove(pedido);
           
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Pedido eliminado:", "\nConfirmacion"));
         
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    
        
     }
        
         public void eliminarFactura(CabeceraFactura cabefactura) {
        try {
            this.manejadorCabeceraFactura.remove(cabefactura);
           
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cabecera factura:", "/n Eliminada"));
         
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    
        
     }
          public void eliminarFactura2(DetalleFactura detfactura) {
        try {
            this.manejadorDetalleFactura.remove(detfactura);
           
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Detalle factura:", "/n Eliminada"));
         
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    
        
     }
        
        
        
        
        
        
        
        

    }