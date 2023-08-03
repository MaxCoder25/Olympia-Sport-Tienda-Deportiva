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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v"),
    @NamedQuery(name = "Vendedor.findByIdVendedor", query = "SELECT v FROM Vendedor v WHERE v.idVendedor = :idVendedor"),
    @NamedQuery(name = "Vendedor.findByCedulaVendedor", query = "SELECT v FROM Vendedor v WHERE v.cedulaVendedor = :cedulaVendedor"),
    @NamedQuery(name = "Vendedor.findByNombreVendedor", query = "SELECT v FROM Vendedor v WHERE v.nombreVendedor = :nombreVendedor"),
    @NamedQuery(name = "Vendedor.findByApellidoVendedor", query = "SELECT v FROM Vendedor v WHERE v.apellidoVendedor = :apellidoVendedor"),
    @NamedQuery(name = "Vendedor.findByTelefonoVendedor", query = "SELECT v FROM Vendedor v WHERE v.telefonoVendedor = :telefonoVendedor")})
public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_vendedor")
    private String idVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cedula_vendedor")
    private String cedulaVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_vendedor")
    private String nombreVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "apellido_vendedor")
    private String apellidoVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "telefono_vendedor")
    private String telefonoVendedor;
    @JoinColumn(name = "registro_usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private RegistroUsuario registroUsuarioIdUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedorIdVendedor")
    private Collection<Reclamo> reclamoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedorIdVendedor")
    private Collection<CabeceraFactura> cabeceraFacturaCollection;

    public Vendedor() {
    }

    public Vendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Vendedor(String idVendedor, String cedulaVendedor, String nombreVendedor, String apellidoVendedor, String telefonoVendedor) {
        this.idVendedor = idVendedor;
        this.cedulaVendedor = cedulaVendedor;
        this.nombreVendedor = nombreVendedor;
        this.apellidoVendedor = apellidoVendedor;
        this.telefonoVendedor = telefonoVendedor;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
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

    public RegistroUsuario getRegistroUsuarioIdUsuario() {
        return registroUsuarioIdUsuario;
    }

    public void setRegistroUsuarioIdUsuario(RegistroUsuario registroUsuarioIdUsuario) {
        this.registroUsuarioIdUsuario = registroUsuarioIdUsuario;
    }

    @XmlTransient
    public Collection<Reclamo> getReclamoCollection() {
        return reclamoCollection;
    }

    public void setReclamoCollection(Collection<Reclamo> reclamoCollection) {
        this.reclamoCollection = reclamoCollection;
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
        hash += (idVendedor != null ? idVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.idVendedor == null && other.idVendedor != null) || (this.idVendedor != null && !this.idVendedor.equals(other.idVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Vendedor[ idVendedor=" + idVendedor + " ]";
    }
    
}
