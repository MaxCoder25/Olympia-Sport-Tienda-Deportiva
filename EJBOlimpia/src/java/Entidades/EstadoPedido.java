/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CAMPOVERDE_R
 */
@Entity
@Table(name = "estado_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPedido.findAll", query = "SELECT e FROM EstadoPedido e"),
    @NamedQuery(name = "EstadoPedido.findByIdEstadoPedido", query = "SELECT e FROM EstadoPedido e WHERE e.idEstadoPedido = :idEstadoPedido"),
    @NamedQuery(name = "EstadoPedido.findByDescripcionEstadoPedido", query = "SELECT e FROM EstadoPedido e WHERE e.descripcionEstadoPedido = :descripcionEstadoPedido")})
public class EstadoPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_estado_pedido")
    private String idEstadoPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion_estado_pedido")
    private String descripcionEstadoPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoPedidoIdEnvioPedido")
    private Collection<Pedido> pedidoCollection;

    public EstadoPedido() {
    }

    public EstadoPedido(String idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public EstadoPedido(String idEstadoPedido, String descripcionEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
        this.descripcionEstadoPedido = descripcionEstadoPedido;
    }

    public String getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(String idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public String getDescripcionEstadoPedido() {
        return descripcionEstadoPedido;
    }

    public void setDescripcionEstadoPedido(String descripcionEstadoPedido) {
        this.descripcionEstadoPedido = descripcionEstadoPedido;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPedido != null ? idEstadoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPedido)) {
            return false;
        }
        EstadoPedido other = (EstadoPedido) object;
        if ((this.idEstadoPedido == null && other.idEstadoPedido != null) || (this.idEstadoPedido != null && !this.idEstadoPedido.equals(other.idEstadoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.EstadoPedido[ idEstadoPedido=" + idEstadoPedido + " ]";
    }
    
}
