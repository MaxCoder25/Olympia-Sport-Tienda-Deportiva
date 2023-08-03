/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CAMPOVERDE_R
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByNumPedido", query = "SELECT p FROM Pedido p WHERE p.numPedido = :numPedido"),
    @NamedQuery(name = "Pedido.findByFechaPedido", query = "SELECT p FROM Pedido p WHERE p.fechaPedido = :fechaPedido"),
    @NamedQuery(name = "Pedido.findByBarrioEntregaPedido", query = "SELECT p FROM Pedido p WHERE p.barrioEntregaPedido = :barrioEntregaPedido"),
    @NamedQuery(name = "Pedido.findByCallePrincipalEntregaPedido", query = "SELECT p FROM Pedido p WHERE p.callePrincipalEntregaPedido = :callePrincipalEntregaPedido"),
    @NamedQuery(name = "Pedido.findByNumeroCasaEntregaPedido", query = "SELECT p FROM Pedido p WHERE p.numeroCasaEntregaPedido = :numeroCasaEntregaPedido")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "num_pedido")
    private String numPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "barrio_entrega_pedido")
    private String barrioEntregaPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "calle_principal_entrega_pedido")
    private String callePrincipalEntregaPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "numero_casa_entrega_pedido")
    private String numeroCasaEntregaPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoNumPedido")
    private Collection<PedidoProducto> pedidoProductoCollection;
    @JoinColumn(name = "estado_pedido_id_envio_pedido", referencedColumnName = "id_estado_pedido")
    @ManyToOne(optional = false)
    private EstadoPedido estadoPedidoIdEnvioPedido;
    @JoinColumn(name = "cliente_id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;

    public Pedido() {
    }

    public Pedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public Pedido(String numPedido, Date fechaPedido, String barrioEntregaPedido, String callePrincipalEntregaPedido, String numeroCasaEntregaPedido) {
        this.numPedido = numPedido;
        this.fechaPedido = fechaPedido;
        this.barrioEntregaPedido = barrioEntregaPedido;
        this.callePrincipalEntregaPedido = callePrincipalEntregaPedido;
        this.numeroCasaEntregaPedido = numeroCasaEntregaPedido;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getBarrioEntregaPedido() {
        return barrioEntregaPedido;
    }

    public void setBarrioEntregaPedido(String barrioEntregaPedido) {
        this.barrioEntregaPedido = barrioEntregaPedido;
    }

    public String getCallePrincipalEntregaPedido() {
        return callePrincipalEntregaPedido;
    }

    public void setCallePrincipalEntregaPedido(String callePrincipalEntregaPedido) {
        this.callePrincipalEntregaPedido = callePrincipalEntregaPedido;
    }

    public String getNumeroCasaEntregaPedido() {
        return numeroCasaEntregaPedido;
    }

    public void setNumeroCasaEntregaPedido(String numeroCasaEntregaPedido) {
        this.numeroCasaEntregaPedido = numeroCasaEntregaPedido;
    }

    @XmlTransient
    public Collection<PedidoProducto> getPedidoProductoCollection() {
        return pedidoProductoCollection;
    }

    public void setPedidoProductoCollection(Collection<PedidoProducto> pedidoProductoCollection) {
        this.pedidoProductoCollection = pedidoProductoCollection;
    }

    public EstadoPedido getEstadoPedidoIdEnvioPedido() {
        return estadoPedidoIdEnvioPedido;
    }

    public void setEstadoPedidoIdEnvioPedido(EstadoPedido estadoPedidoIdEnvioPedido) {
        this.estadoPedidoIdEnvioPedido = estadoPedidoIdEnvioPedido;
    }

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numPedido != null ? numPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.numPedido == null && other.numPedido != null) || (this.numPedido != null && !this.numPedido.equals(other.numPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pedido[ numPedido=" + numPedido + " ]";
    }
    
}
