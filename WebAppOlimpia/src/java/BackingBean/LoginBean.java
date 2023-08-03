/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entidades.Cliente;
import Entidades.RegistroUsuario;
import Entidades.Vendedor;
import Sessions.ClienteFacadeLocal;
import Sessions.RegistroUsuarioFacadeLocal;
import Sessions.VendedorFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String correo;
    private String clave;
    @EJB
    private RegistroUsuarioFacadeLocal manejadorAcceso;
    private RegistroUsuario u;
    
    @EJB
    private ClienteFacadeLocal manejadorCliente;
    private Cliente c;
    
 
    
    @EJB
    private VendedorFacadeLocal manejadorVendedor;
    private Vendedor v;
    
    //Para que valga hacer login con el usuario que cree y no sea necesario darle deploy de nuevo
    public void reinit() {
        RegistroUsuario u;
        List<RegistroUsuario> aux = lstUser();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " ", "\nUsuario actualizado"));

    }

    public String limpiarCliente() {
        u = new RegistroUsuario();
        c = new Cliente();
         
        
        
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmacion ", "\n Cerrada sesion"));
        return "/index.xhtml";
    }

    @PostConstruct
    public String iniciarSesion() {

        
        List<RegistroUsuario> aux = lstUser();
        
        List<Cliente> aux2 = lstCliente();
        //String redireccion = "";

        System.out.println("" + correo);
        System.out.println("" + clave);

        for (int i = 0; i < aux.size(); i++) {
            System.out.println("" + aux.get(i).getTipoUsuario());
            if ((aux.get(i).getNombreUsuario() == null ? correo == null : aux.get(i).getNombreUsuario().equals(correo)) && (aux.get(i).getPasswordUsuario() == null ? clave == null : aux.get(i).getPasswordUsuario().equals(clave))) {
                
                if ("1".equals(aux.get(i).getTipoUsuario())) {
                    return "/Paginas/PrincipalAdmin.xhtml";
                } else {
                    
                    if ("2".equals(aux.get(i).getTipoUsuario())) {
                        u = manejadorAcceso.find(aux.get(i).getIdUsuario());
                        c = manejadorCliente.find(aux.get(i).getIdUsuario());
                        //c = manejadorCliente.find(aux2.get(i).getRegistroUsuarioIdUsuario());
                        
                        System.out.println(""+c.getApellidoCliente());  
                        
                        
                        return "/Paginas/PaginaPrincipal.xhtml";
                    
                    } else {
                        if ("3".equals(aux.get(i).getTipoUsuario())) {
                            v = manejadorVendedor.find(aux.get(i).getIdUsuario());
                            return "/Paginas/PrincipalVendedor.xhtml";
                        }

                    }
                }
           } else {
                System.out.println("Credenciales Incorrectas");
               //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales Incorrectas", "\nPorfavor ingrese las credenciales correctas o registrese si no tiene una cuenta"));
            }

        }
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales Incorrectas", "\nPorfavor ingrese las credenciales correctas o registrese si no tiene una cuenta"));
          
       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no Registrado", "\nPorfavor registrese para continuar"));
        return "/Paginas/Login.xhtml";
    }

    public List<RegistroUsuario> lstUser() {
        List<RegistroUsuario> aux = manejadorAcceso.findAll();
        return aux;
    }
    
    
public List<Cliente> lstCliente() {
        List<Cliente> aux2 = manejadorCliente.findAll();
        return aux2;
    }
    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    public LoginBean() {
    }

    public RegistroUsuarioFacadeLocal getManejadorAcceso() {
        return manejadorAcceso;
    }

    public void setManejadorAcceso(RegistroUsuarioFacadeLocal manejadorAcceso) {
        this.manejadorAcceso = manejadorAcceso;
    }

    public ClienteFacadeLocal getManejadorCliente() {
        return manejadorCliente;
    }

    public void setManejadorCliente(ClienteFacadeLocal manejadorCliente) {
        this.manejadorCliente = manejadorCliente;
    }

    public VendedorFacadeLocal getManejadorVendedor() {
        return manejadorVendedor;
    }

    public void setManejadorVendedor(VendedorFacadeLocal manejadorVendedor) {
        this.manejadorVendedor = manejadorVendedor;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public Vendedor getV() {
        return v;
    }

    public void setV(Vendedor v) {
        this.v = v;
    }

    public RegistroUsuario getU() {
        return u;
    }

    public void setU(RegistroUsuario u) {
        this.u = u;
    }
    
    
    
}
