/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entidades.Cliente;
import Entidades.EstadoReclamo;
import Entidades.Reclamo;
import Entidades.TipoReclamo;
import Entidades.Vendedor;
import Sessions.ClienteFacadeLocal;
import Sessions.EstadoReclamoFacadeLocal;
import Sessions.ReclamoFacadeLocal;
import Sessions.TipoReclamoFacadeLocal;
import Sessions.VendedorFacadeLocal;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author KevinMac
 */
@ManagedBean (name = "ManagedReclamo")
@RequestScoped
public class ManagedReclamo  implements Serializable{

    /**
     * Creates a new instance of ManagedReclamo
     */
    public ManagedReclamo() {
    }
    
    @EJB
    private ReclamoFacadeLocal manejadorReclamo;
   
    private Reclamo reclamo; 

   private List<Reclamo> listaReclamo;
    
   @EJB
    private TipoReclamoFacadeLocal manejadorTipoReclamo;
   
    private TipoReclamo tipoReclamo; 

   private List<TipoReclamo> listatipoReclamo;
   
   
   @EJB
    private EstadoReclamoFacadeLocal manejadorEstadoReclamo;
   
    private EstadoReclamo estadoReclamo; 

   private List<EstadoReclamo> listaestadoReclamo;
   
   
    @EJB
    private VendedorFacadeLocal manejadorVendedor;
     
    private Vendedor vendedor;
   
   private List<Vendedor> listaVendedores;
   
   @EJB
    private ClienteFacadeLocal manejadorCliente;
   
   private Cliente cliente; 
   
   
   
    private String idReclamo;  
    
    private String descripcionReclamo;
    
    private String  tipoReclamoIdTipoReclamo;
 
    
    
    
     @PostConstruct
    private void inicio() {
      //???
         this.setReclamo(new Reclamo());
      
       listaReclamo = manejadorReclamo.findAll();
       listatipoReclamo = manejadorTipoReclamo.findAll();
       listaestadoReclamo = manejadorEstadoReclamo.findAll();
       listaVendedores = manejadorVendedor.findAll();
    }
    
    public void cargarIdReclamo(Reclamo reclamo) {
        this.setReclamo(reclamo);


    }
    
    
     public void editarReclamo(  ) {
         
         //fechaSolucionReclamo = String.valueOf( reclamo.getFechaSolucionReclamo() );
       //  System.out.println("fechaSolucionReclamo" + fechaSolucionReclamo);
         
       //  tipoReclamoIdTipoReclamo=reclamo.getTipoReclamoIdTipoReclamo().getIdTipoReclamo();
              System.out.println("Id reclamo: " + reclamo.getIdReclamo());
              
         reclamo = manejadorReclamo.find(reclamo.getIdReclamo());
         
         // Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(fechaSolucionReclamo);  
         
          reclamo.setFechaSolucionReclamo(new Date());
         
          estadoReclamo = new EstadoReclamo();
          estadoReclamo=manejadorEstadoReclamo.find(tipoReclamoIdTipoReclamo);
          reclamo.setEstadoReclamoIdEstadoReclamo(estadoReclamo);
          
            manejadorReclamo.edit(reclamo);
          reclamo = new Reclamo();
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmacion:", "\n Reclamo editado"));
        
         
         
     }
    
    
    
    
    
    
    
    
    
       public void grabarReclamo(Cliente c) { 
      long id;  
     
       reclamo = new Reclamo();
      id = manejadorReclamo.count() + 1;
         reclamo.setIdReclamo(String.valueOf(id));
         reclamo.setDescripcionReclamo(descripcionReclamo);  
      reclamo.setFechaIngresoReclamo(new Date());
      
      
         
 Calendar calendar = Calendar.getInstance();
    
    // get a date to represent "today"
    Date today = calendar.getTime();
      // add one day to the date/calendar
    calendar.add(Calendar.DAY_OF_YEAR, 2);
    
    // now get "tomorrow"
    Date aDayAfterTomorrow = calendar.getTime();

      reclamo.setFechaSolucionReclamo(aDayAfterTomorrow);
      
      
      
      
      
      tipoReclamo = new TipoReclamo();
      
      tipoReclamo = manejadorTipoReclamo.find(tipoReclamoIdTipoReclamo);
    reclamo.setTipoReclamoIdTipoReclamo(tipoReclamo);
    
    vendedor = new Vendedor();
    /*
    String idVMax;
    String idVMin;
    int idVMaxInt;
    int idVMinInt;
     int idV;
    
    idVMax = listaVendedores.get(  listaVendedores.size()  ).getIdVendedor();
    idVMin = listaVendedores.get(0).getIdVendedor();
    idVMaxInt=Integer.valueOf(idVMax); 
    idVMinInt=Integer.valueOf(idVMin); 
           System.out.println("AFUERA DE LOS FORS");
    outerloop:  
     for (int i = 0; i < listaVendedores.size(); i++) {
         
               System.out.println("primer FOR");
               
               
        idV = (int) (Math.random() * (idVMaxInt - idVMinInt)) + idVMinInt;
          System.out.println("dentro de for1" + "valor idV "+idV);        
         for (int j = 0; j < listaVendedores.size(); j++) {
             if (String.valueOf(idV).equals (listaVendedores.get(j).getIdVendedor() ) )
               {
                   System.out.println("dentro de for 2");
                   vendedor=manejadorVendedor.find(idV);
                   break outerloop;
               }
             
         }
               
               
               
           }
   */
     
     vendedor=manejadorVendedor.find("5");
    
    reclamo.setVendedorIdVendedor(vendedor);
      estadoReclamo = new EstadoReclamo();
      
    estadoReclamo = manejadorEstadoReclamo.find("1");
      reclamo.setEstadoReclamoIdEstadoReclamo(estadoReclamo);
       
      reclamo.setClienteIdCliente(c);
      
    manejadorReclamo.create(reclamo);
    
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Confirmacion:", " Reclamo enviado"));

       }

       
       
    public String getTipoReclamoIdTipoReclamo() {
        return tipoReclamoIdTipoReclamo;
    }

    public void setTipoReclamoIdTipoReclamo(String tipoReclamoIdTipoReclamo) {
        this.tipoReclamoIdTipoReclamo = tipoReclamoIdTipoReclamo;
    }
    
    
    
    
    
    
    
    
    
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

    

    public List<Reclamo> getListaReclamo() {
        return listaReclamo;
    }

    public void setListaReclamo(List<Reclamo> listaReclamo) {
        this.listaReclamo = listaReclamo;
    }

    public TipoReclamoFacadeLocal getManejadorTipoReclamo() {
        return manejadorTipoReclamo;
    }

    public void setManejadorTipoReclamo(TipoReclamoFacadeLocal manejadorTipoReclamo) {
        this.manejadorTipoReclamo = manejadorTipoReclamo;
    }

    public TipoReclamo getTipoReclamo() {
        return tipoReclamo;
    }

    public void setTipoReclamo(TipoReclamo tipoReclamo) {
        this.tipoReclamo = tipoReclamo;
    }

    public List<TipoReclamo> getListatipoReclamo() {
        return listatipoReclamo;
    }

    public void setListatipoReclamo(List<TipoReclamo> listatipoReclamo) {
        this.listatipoReclamo = listatipoReclamo;
    }

    public EstadoReclamoFacadeLocal getManejadorEstadoReclamo() {
        return manejadorEstadoReclamo;
    }

    public void setManejadorEstadoReclamo(EstadoReclamoFacadeLocal manejadorEstadoReclamo) {
        this.manejadorEstadoReclamo = manejadorEstadoReclamo;
    }

    public EstadoReclamo getEstadoReclamo() {
        return estadoReclamo;
    }

    public void setEstadoReclamo(EstadoReclamo estadoReclamo) {
        this.estadoReclamo = estadoReclamo;
    }

    public List<EstadoReclamo> getListaestadoReclamo() {
        return listaestadoReclamo;
    }

    public void setListaestadoReclamo(List<EstadoReclamo> listaestadoReclamo) {
        this.listaestadoReclamo = listaestadoReclamo;
    }

    public VendedorFacadeLocal getManejadorVendedor() {
        return manejadorVendedor;
    }

    public void setManejadorVendedor(VendedorFacadeLocal manejadorVendedor) {
        this.manejadorVendedor = manejadorVendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public String getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(String idReclamo) {
        this.idReclamo = idReclamo;
    }

    public String getDescripcionReclamo() {
        return descripcionReclamo;
    }

    public void setDescripcionReclamo(String descripcionReclamo) {
        this.descripcionReclamo = descripcionReclamo;
    }

    public ClienteFacadeLocal getManejadorCliente() {
        return manejadorCliente;
    }

    public void setManejadorCliente(ClienteFacadeLocal manejadorCliente) {
        this.manejadorCliente = manejadorCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
