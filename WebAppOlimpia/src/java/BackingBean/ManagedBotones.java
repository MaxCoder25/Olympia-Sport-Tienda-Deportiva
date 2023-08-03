/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author KevinMac
 */
@ManagedBean (name = "ManagedBotones")
@SessionScoped
public class ManagedBotones implements Serializable {

    /**
     * Creates a new instance of ManagedBotones
     */
    public ManagedBotones() {
    }
 
    private boolean enabledCarrito;
  private boolean enabledPedido;
    private boolean enabledEmail;
    private boolean enabledReclamo;
    
    public boolean isEnabledCarrito() {
        return enabledCarrito;
    }

    public boolean isEnabledPedido() {
        return enabledPedido;
    }

    public boolean isEnabledEmail() {
        return enabledEmail;
    }
    
 public boolean isEnabledReclamo() {
        return enabledReclamo;
    }

    public void toggleCarrito() {
        enabledCarrito = !enabledCarrito;
        enabledReclamo = !enabledReclamo;
    }
    
 public void togglePedido() {
        enabledPedido = !enabledPedido;
        
    }
 
 public void toggleEmail() {
      enabledCarrito = false;
        enabledEmail = !enabledEmail;
        
    }
    
 
 public void toggleReclamo() {
        enabledReclamo = !enabledReclamo;
        
    }
 
public String llamarConfirmarPedido() {
       return "ConfirmarPedido";
    }

    public String llamarLogin() {
       return "Login";
    }
    
}
