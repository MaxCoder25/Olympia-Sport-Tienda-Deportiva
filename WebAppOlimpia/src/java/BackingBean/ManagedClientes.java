/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entidades.Cliente;
import Entidades.Marca;
import Entidades.ModoPago;
import Entidades.RegistroUsuario;
import Entidades.Vendedor;
import Sessions.ClienteFacadeLocal;
import Sessions.ModoPagoFacadeLocal;
import Sessions.RegistroUsuarioFacadeLocal;
import Sessions.VendedorFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author KevinMac
 */
@ManagedBean (name = "ManagedClientes")
@RequestScoped
//@SessionScoped
public class ManagedClientes implements Serializable{

    /**
     * Creates a new instance of ManagedClientes
     */
    public ManagedClientes() {
    }
     
   @EJB
    private ClienteFacadeLocal manejadorCliente;
   
   @EJB
    private RegistroUsuarioFacadeLocal manejadorUsuario;
   
    @EJB
    private VendedorFacadeLocal manejadorVendedor;
     
     
     
   private Cliente cliente; 

   private List<Cliente> listaClientes;
   
    private RegistroUsuario usuario; 
    
   private List<RegistroUsuario> listaUsuarios;

   private List<RegistroUsuario> listaUsuariosV;
   
   private List<RegistroUsuario> listaUsuariosA;
   
   private Vendedor vendedor;
   
   private List<Vendedor> listaVendedores;
   /////////////////
    
   
   
   
   private String cedulaCliente;
   private String nombreCliente;
   private String apellidoCliente;
   private String telefonoCliente;
   private String ciudadCliente;
   private String barrioCliente;
   private String callePrincipalCliente;
   private String numeroCasaCliente;
   
   private String nombreUsuario;
   private String passwordUsuario;
   private String email;

   private String cedulaVendedor;
   private String nombreVendedor;
   private String apellidoVendedor;
   private String telefonoVendedor;
   

    private String nombreAdmin;
   private String passwordAdmin;
   private String emailAdmin;
   
   
    public List<RegistroUsuario> lstUser() {
        List<RegistroUsuario> aux = manejadorUsuario.findAll();
        return aux;
    }
    
    
    public String grabarUsuario() {
       long id1 = 0;
        long id2 = 0;
        /*
          
         //para crear con el id_usuario maximo de registro susuario
         * //Sino hay problemas al borrar un usuario ( sobreescribe)
        String maxUser;
          
           
          List<RegistroUsuario> aux = lstUser();
          
          maxUser = aux.get(0).getIdUsuario();
          
          for (int i = 0; i < aux.size(); i++) {
              if( 1 == ( ( aux.get(i).getIdUsuario() ).compareTo (maxUser) )){
                  maxUser = aux.get(i).getIdUsuario();
              }
          }
             
             */ 
          
        
        usuario = new RegistroUsuario();
        cliente = new Cliente();
           
       id2 = manejadorUsuario.count() + 1;
        usuario.setIdUsuario(String.valueOf(id2));
       // usuario.setIdUsuario(String.valueOf(maxUser));
        
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPasswordUsuario(passwordUsuario);
        usuario.setEmail(email);
        usuario.setTipoUsuario(String.valueOf(2));
        
        manejadorUsuario.create(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario agregado:", "Confirmacion"));
        
       // id1 = manejadorCliente.count() + 1;
        //Cambio id1 a id2, para que el cliente se cree con el mismo id que el usuario
        cliente.setIdCliente(String.valueOf(id2));
        //cliente.setIdCliente(String.valueOf(maxUser));
        
        cliente.setCedulaCliente(cedulaCliente);
        cliente.setNombreCliente(nombreCliente);
        cliente.setApellidoCliente(apellidoCliente);
        cliente.setTelefonoCliente(telefonoCliente);
        cliente.setCiudadCliente(ciudadCliente);
        cliente.setBarrioCliente(barrioCliente);
        cliente.setCallePrincipalCliente(callePrincipalCliente);
        cliente.setNumeroCasaCliente(numeroCasaCliente);      
        cliente.setRegistroUsuarioIdUsuario(usuario);
        cliente.setTotalVentasCliente(0.0);
        
        manejadorCliente.create(cliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmacion","Cliente agregado:"));
     //   FacesContext.getCurrentInstance().getExternalContext().redirect(Login);
           
    return "/Paginas/Login.xhtml";
    }
    
    
     public void grabarVendedor() {
       long id1 = 0;
       long id2 = 0;
       
         //String maxUser;
          
           /*
          List<RegistroUsuario> aux = lstUser();
          
          maxUser = aux.get(0).getIdUsuario();
          
          for (int i = 0; i < aux.size(); i++) {
              if( 1 == ( ( aux.get(i).getIdUsuario() ).compareTo (maxUser) )){
                  maxUser = aux.get(i).getIdUsuario();
              }
          }
          */
         
         
        usuario = new RegistroUsuario();
       vendedor = new Vendedor();
           
        id1 = manejadorUsuario.count() + 1;
        usuario.setIdUsuario(String.valueOf(id1));
       // usuario.setIdUsuario(maxUser);
        
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPasswordUsuario(passwordUsuario);
        usuario.setEmail(email);
        usuario.setTipoUsuario(String.valueOf(3));
        
        manejadorUsuario.create(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario agregado:", "Confirmacion"));
        
     
        
           
       // id2 = manejadorVendedor.count() + 1;
        //Cambio id2 a id1, para que el vendedor se cree con el mismo id que el usuario
       
        vendedor.setIdVendedor(String.valueOf(id1));
       // vendedor.setIdVendedor(maxUser);
        
        vendedor.setCedulaVendedor(cedulaVendedor);
       vendedor.setNombreVendedor(nombreVendedor);
        vendedor.setApellidoVendedor(apellidoVendedor);
        vendedor.setTelefonoVendedor(telefonoVendedor);
        vendedor.setRegistroUsuarioIdUsuario(usuario);
        
        manejadorVendedor.create(vendedor);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Vendedor agregado:", "Confirmacion"));
        
    }
     
      public void grabarAdmin() {
      long id1 = 0;
      usuario = new RegistroUsuario();
        id1 = manejadorUsuario.count() + 100;
        usuario.setIdUsuario(String.valueOf(id1));
        usuario.setNombreUsuario(nombreAdmin);
        usuario.setPasswordUsuario(passwordAdmin);
        usuario.setEmail(emailAdmin);
        usuario.setTipoUsuario(String.valueOf(1));
        
        manejadorUsuario.create(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Administrador agregado:", "Confirmacion"));
        
        
        
        
      }
     
    @PostConstruct
    private void inicio() {
// MOvido a metodo grabarUsuario     
//        usuario = new RegistroUsuario();
//        cliente = new Cliente();
       listaUsuarios = manejadorUsuario.findByTipoUsuario("2");
       listaUsuariosV = manejadorUsuario.findByTipoUsuario("3");
       listaUsuariosA= manejadorUsuario.findByTipoUsuario("1");
       
        listaClientes = manejadorCliente.findAll();
        listaVendedores = manejadorVendedor.findAll();
       
    }
   
   
   
    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCiudadCliente() {
        return ciudadCliente;
    }

    public void setCiudadCliente(String ciudadCliente) {
        this.ciudadCliente = ciudadCliente;
    }

    public String getBarrioCliente() {
        return barrioCliente;
    }

    public void setBarrioCliente(String barrioCliente) {
        this.barrioCliente = barrioCliente;
    }

    public String getCallePrincipalCliente() {
        return callePrincipalCliente;
    }

    public void setCallePrincipalCliente(String callePrincipalCliente) {
        this.callePrincipalCliente = callePrincipalCliente;
    }

    public String getNumeroCasaCliente() {
        return numeroCasaCliente;
    }

    public void setNumeroCasaCliente(String numeroCasaCliente) {
        this.numeroCasaCliente = numeroCasaCliente;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCedulaVendedor() {
        return cedulaVendedor;
    }

    public void setCedulaVendedor(String cedulaVendedor) {
        this.cedulaVendedor = cedulaVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getApellidoVendedor() {
        return apellidoVendedor;
    }

    public void setApellidoVendedor(String apellidoVendedor) {
        this.apellidoVendedor = apellidoVendedor;
    }

    public String getTelefonoVendedor() {
        return telefonoVendedor;
    }

    public void setTelefonoVendedor(String telefonoVendedor) {
        this.telefonoVendedor = telefonoVendedor;
    }
    
    ////////////////////////
    
    
    
       public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
      
    //////////////////////////////////
    
    
    public RegistroUsuarioFacadeLocal getManejadorUsuarios() {
        return manejadorUsuario;
    }

    public void setManejadorUsuarios(RegistroUsuarioFacadeLocal manejadorUsuarios) {
        this.manejadorUsuario = manejadorUsuarios;
    }

    public RegistroUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(RegistroUsuario usuario) {
        this.usuario = usuario;
    }

    public List<RegistroUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<RegistroUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }  

    public RegistroUsuarioFacadeLocal getManejadorUsuario() {
        return manejadorUsuario;
    }

    public void setManejadorUsuario(RegistroUsuarioFacadeLocal manejadorUsuario) {
        this.manejadorUsuario = manejadorUsuario;
    }
 
    
    
      public void eliminarCliente(Cliente cliente) {
        try {
            
           //usuario = new RegistroUsuario();
           //usuario = manejadorUsuario.find( cliente.getRegistroUsuarioIdUsuario() );
          
            this.manejadorCliente.remove(cliente);
           //this.manejadorUsuario.remove(usuario);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cliente eliminado:", "Confirmacion"));
        
        } catch (Exception e) {
           
            e.printStackTrace();
        }
      }
      
      
          public void eliminarUsuario(RegistroUsuario usuario) {
        try {
            
           //usuario = new RegistroUsuario();
           //usuario = manejadorUsuario.find( cliente.getRegistroUsuarioIdUsuario() );
          
            this.manejadorUsuario.remove(usuario);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario eliminado:", "Confirmacion"));
        
        } catch (Exception e) {
           
            e.printStackTrace();
        }
          }
          
        
          public void eliminarVendedor(Vendedor vendedor) {
        try {
            
           //usuario = new RegistroUsuario();
           //usuario = manejadorUsuario.find( cliente.getRegistroUsuarioIdUsuario() );
          
            this.manejadorVendedor.remove(vendedor);
           //this.manejadorUsuario.remove(usuario);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Vendedor eliminado:", "Confirmacion"));
        
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public List<RegistroUsuario> getListaUsuariosV() {
        return listaUsuariosV;
    }

    public void setListaUsuariosV(List<RegistroUsuario> listaUsuariosV) {
        this.listaUsuariosV = listaUsuariosV;
    }

    public List<RegistroUsuario> getListaUsuariosA() {
        return listaUsuariosA;
    }

    public void setListaUsuariosA(List<RegistroUsuario> listaUsuariosA) {
        this.listaUsuariosA = listaUsuariosA;
    }
          
          
          
          
      
}
