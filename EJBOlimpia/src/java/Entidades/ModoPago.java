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
@Table(name = "modo_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModoPago.findAll", query = "SELECT m FROM ModoPago m"),
    @NamedQuery(name = "ModoPago.findByIdModoPago", query = "SELECT m FROM ModoPago m WHERE m.idModoPago = :idModoPago"),
    @NamedQuery(name = "ModoPago.findByDescripcionModoPago", query = "SELECT m FROM ModoPago m WHERE m.descripcionModoPago = :descripcionModoPago"),
    @NamedQuery(name = "ModoPago.findByDetallesModoPago", query = "SELECT m FROM ModoPago m WHERE m.detallesModoPago = :detallesModoPago")})
public class ModoPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_modo_pago")
    private String idModoPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion_modo_pago")
    private String descripcionModoPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "detalles_modo_pago")
    private String detallesModoPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modoPagoIdModoPago")
    private Collection<CabeceraFactura> cabeceraFacturaCollection;

    public ModoPago() {
    }

    public ModoPago(String idModoPago) {
        this.idModoPago = idModoPago;
    }

    public ModoPago(String idModoPago, String descripcionModoPago, String detallesModoPago) {
        this.idModoPago = idModoPago;
        this.descripcionModoPago = descripcionModoPago;
        this.detallesModoPago = detallesModoPago;
    }

    public String getIdModoPago() {
        return idModoPago;
    }

    public void setIdModoPago(String idModoPago) {
        this.idModoPago = idModoPago;
    }

    public String getDescripcionModoPago() {
        return descripcionModoPago;
    }

    public void setDescripcionModoPago(String descripcionModoPago) {
        this.descripcionModoPago = descripcionModoPago;
    }

    public String getDetallesModoPago() {
        return detallesModoPago;
    }

    public void setDetallesModoPago(String detallesModoPago) {
        this.detallesModoPago = detallesModoPago;
    }

    @XmlTransient
    public Collection<CabeceraFactura> getCabeceraFacturaCollection() {
        return cabeceraFacturaCollection;
    }

    public void setCabeceraFacturaCollection(Collection<CabeceraFactura> cabeceraFacturaCollection) {
        this.cabeceraFacturaCollection = cabeceraFacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModoPago != null ? idModoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModoPago)) {
            return false;
        }
        ModoPago other = (ModoPago) object;
        if ((this.idModoPago == null && other.idModoPago != null) || (this.idModoPago != null && !this.idModoPago.equals(other.idModoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ModoPago[ idModoPago=" + idModoPago + " ]";
    }
    
}
