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
@Table(name = "cabecera_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CabeceraFactura.findAll", query = "SELECT c FROM CabeceraFactura c"),
     @NamedQuery(name = "CabeceraFactura.findByIdCliente", query = "SELECT c FROM CabeceraFactura c WHERE c.clienteIdCliente = :clienteIdCliente"),
    @NamedQuery(name = "CabeceraFactura.findByNumFactura", query = "SELECT c FROM CabeceraFactura c WHERE c.numFactura = :numFactura"),
    @NamedQuery(name = "CabeceraFactura.findByFecha", query = "SELECT c FROM CabeceraFactura c WHERE c.fecha = :fecha")})
public class CabeceraFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "num_factura")
    private String numFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabeceraFacturaNumFactura")
    private Collection<DetalleFactura> detalleFacturaCollection;
    @JoinColumn(name = "vendedor_id_vendedor", referencedColumnName = "id_vendedor")
    @ManyToOne(optional = false)
    private Vendedor vendedorIdVendedor;
    @JoinColumn(name = "modo_pago_id_modo_pago", referencedColumnName = "id_modo_pago")
    @ManyToOne(optional = false)
    private ModoPago modoPagoIdModoPago;
    @JoinColumn(name = "cliente_id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;

    public CabeceraFactura() {
    }

    public CabeceraFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public CabeceraFactura(String numFactura, Date fecha) {
        this.numFactura = numFactura;
        this.fecha = fecha;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<DetalleFactura> getDetalleFacturaCollection() {
        return detalleFacturaCollection;
    }

    public void setDetalleFacturaCollection(Collection<DetalleFactura> detalleFacturaCollection) {
        this.detalleFacturaCollection = detalleFacturaCollection;
    }

    public Vendedor getVendedorIdVendedor() {
        return vendedorIdVendedor;
    }

    public void setVendedorIdVendedor(Vendedor vendedorIdVendedor) {
        this.vendedorIdVendedor = vendedorIdVendedor;
    }

    public ModoPago getModoPagoIdModoPago() {
        return modoPagoIdModoPago;
    }

    public void setModoPagoIdModoPago(ModoPago modoPagoIdModoPago) {
        this.modoPagoIdModoPago = modoPagoIdModoPago;
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
        hash += (numFactura != null ? numFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabeceraFactura)) {
            return false;
        }
        CabeceraFactura other = (CabeceraFactura) object;
        if ((this.numFactura == null && other.numFactura != null) || (this.numFactura != null && !this.numFactura.equals(other.numFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CabeceraFactura[ numFactura=" + numFactura + " ]";
    }
    
}
