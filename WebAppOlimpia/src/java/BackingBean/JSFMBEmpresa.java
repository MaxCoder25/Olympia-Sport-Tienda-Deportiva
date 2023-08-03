/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entidades.CabeceraFactura;
import Entidades.Cliente;
import Entidades.DetalleFactura;
import Sessions.CabeceraFacturaFacadeLocal;
import Sessions.ClienteFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 

/**
 *
 * @author CAMPOVERDE_R
 */
@ManagedBean(name = "JSFMBEmpresa")
@SessionScoped
public class JSFMBEmpresa implements Serializable {
 
    public JSFMBEmpresa() {
    }
    private List<String> images;
    
    @PostConstruct
    public void init() {
     
        images = new ArrayList<String>();
        for (int i = 1; i <= 7; i++) {
            images.add("tienda" + i + ".jpg");
        }
    }
   

    public List<String> getImages() {
        return images;
    } 
   
   
}
