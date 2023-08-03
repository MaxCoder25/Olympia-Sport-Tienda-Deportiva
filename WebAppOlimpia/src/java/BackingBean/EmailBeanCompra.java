/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import mail.Email;

/**
 *
 * @author kevinmac
 */
@ManagedBean
@RequestScoped
public class EmailBeanCompra implements Serializable{

    private String emisor;
    private String receptor;
    private String usuario;
    private String clave;
    private String mensaje;
    private String asunto;  
    
    
    public EmailBeanCompra() {
    }

    /**
     * @return the emisor
     */
    public String getEmisor() {
        return emisor;
    }

    /**
     * @param emisor the emisor to set
     */
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    /**
     * @return the receptor
     */
    public String getReceptor() {
        return receptor;
    }

    /**
     * @param receptor the receptor to set
     */
    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    
    public void send (String nombre,String apellido,String cedula , String numero,String compra){
        try{
            Email mail=new Email();
            String mensaje1="Estimado/a "+nombre+" "+apellido+" "+ "con cedula: "+cedula+ " y numero de telefono: "+numero 
                    + "\n.Gracias por comprar en OLYMPIA SPORTS usted ha realizado la siguiente compra."
                    + "\n Descripcion de la compra: "+compra+". Le enviaremos su compra lo mas pronto posible. Gracias por utilizar nuestro servicios";
            mail.enviarCorreo("kevinmac2555@gmail.com","kevinmac2555@gmail.com", receptor, "*kevin25123*", mensaje1,"Compra Registrada");
        }catch (Exception e){
            
        }
    }   
    
}
