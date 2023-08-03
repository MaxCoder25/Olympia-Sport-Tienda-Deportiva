/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CAMPOVERDE_R
 */
@Entity
@Table(name = "pedido_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoProducto.findAll", query = "SELECT p FROM PedidoProducto p"),
    @NamedQuery(name = "PedidoProducto.findByIdpedidoProducto", query = "SELECT p FROM PedidoProducto p WHERE p.idpedidoProducto = :idpedidoProducto")})
public class PedidoProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "idpedido_producto")
    private String idpedidoProducto;
    @JoinColumn(name = "producto_id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto productoIdProducto;
    @JoinColumn(name = "pedido_num_pedido", referencedColumnName = "num_pedido")
    @ManyToOne(optional = false)
    private Pedido pedidoNumPedido;

    public PedidoProducto() {
    }

    public PedidoProducto(String idpedidoProducto) {
        this.idpedidoProducto = idpedidoProducto;
    }

    public String getIdpedidoProducto() {
        return idpedidoProducto;
    }

    public void setIdpedidoProducto(String idpedidoProducto) {
        this.idpedidoProducto = idpedidoProducto;
    }

    public Producto getProductoIdProducto() {
        return productoIdProducto;
    }

    public void setProductoIdProducto(Producto productoIdProducto) {
        this.productoIdProducto = productoIdProducto;
    }

    public Pedido getPedidoNumPedido() {
        return pedidoNumPedido;
    }

    public void setPedidoNumPedido(Pedido pedidoNumPedido) {
        this.pedidoNumPedido = pedidoNumPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedidoProducto != null ? idpedidoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoProducto)) {
            return false;
        }
        PedidoProducto other = (PedidoProducto) object;
        if ((this.idpedidoProducto == null && other.idpedidoProducto != null) || (this.idpedidoProducto != null && !this.idpedidoProducto.equals(other.idpedidoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PedidoProducto[ idpedidoProducto=" + idpedidoProducto + " ]";
    }
    
}
