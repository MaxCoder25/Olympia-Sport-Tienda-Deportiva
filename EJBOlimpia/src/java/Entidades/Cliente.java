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
 * @author KevinMac
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByCedulaCliente", query = "SELECT c FROM Cliente c WHERE c.cedulaCliente = :cedulaCliente"),
    @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Cliente.findByApellidoCliente", query = "SELECT c FROM Cliente c WHERE c.apellidoCliente = :apellidoCliente"),
    @NamedQuery(name = "Cliente.findByTelefonoCliente", query = "SELECT c FROM Cliente c WHERE c.telefonoCliente = :telefonoCliente"),
    @NamedQuery(name = "Cliente.findByCiudadCliente", query = "SELECT c FROM Cliente c WHERE c.ciudadCliente = :ciudadCliente"),
    @NamedQuery(name = "Cliente.findByBarrioCliente", query = "SELECT c FROM Cliente c WHERE c.barrioCliente = :barrioCliente"),
    @NamedQuery(name = "Cliente.findByCallePrincipalCliente", query = "SELECT c FROM Cliente c WHERE c.callePrincipalCliente = :callePrincipalCliente"),
    @NamedQuery(name = "Cliente.findByNumeroCasaCliente", query = "SELECT c FROM Cliente c WHERE c.numeroCasaCliente = :numeroCasaCliente")})
public class Cliente implements Serializable {
    @OneToMany(mappedBy = "clienteIdCliente")
    private Collection<Reclamo> reclamoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteIdCliente")
    private Collection<Pedido> pedidoCollection;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_ventas_cliente")
    private Double totalVentasCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteIdCliente")
    private Collection<CabeceraFactura> cabeceraFacturaCollection;
    @JoinColumn(name = "registro_usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private RegistroUsuario registroUsuarioIdUsuario;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_cliente")
    private String idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cedula_cliente")
    private String cedulaCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "apellido_cliente")
    private String apellidoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "telefono_cliente")
    private String telefonoCliente;
    @Size(max = 255)
    @Column(name = "ciudad_cliente")
    private String ciudadCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "barrio_cliente")
    private String barrioCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "calle_principal_cliente")
    private String callePrincipalCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numero_casa_cliente")
    private String numeroCasaCliente;

    public Cliente() {
    }

    public Cliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String idCliente, String cedulaCliente, String nombreCliente, String apellidoCliente, String telefonoCliente, String barrioCliente, String callePrincipalCliente, String numeroCasaCliente) {
        this.idCliente = idCliente;
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefonoCliente = telefonoCliente;
        this.barrioCliente = barrioCliente;
        this.callePrincipalCliente = callePrincipalCliente;
        this.numeroCasaCliente = numeroCasaCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCiudadCliente() {
        return ciudadCliente;
    }

    public void setCiudadCliente(String ciudadCliente) {
        this.ciudadCliente = ciudadCliente;
    }

    public String getBarrioCliente() {
        return barrioCliente;
    }

    public void setBarrioCliente(String barrioCliente) {
        this.barrioCliente = barrioCliente;
    }

    public String getCallePrincipalCliente() {
        return callePrincipalCliente;
    }

    public void setCallePrincipalCliente(String callePrincipalCliente) {
        this.callePrincipalCliente = callePrincipalCliente;
    }

    public String getNumeroCasaCliente() {
        return numeroCasaCliente;
    }

    public void setNumeroCasaCliente(String numeroCasaCliente) {
        this.numeroCasaCliente = numeroCasaCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cliente[ idCliente=" + idCliente + " ]";
    }

    public RegistroUsuario getRegistroUsuarioIdUsuario() {
        return registroUsuarioIdUsuario;
    }

    public void setRegistroUsuarioIdUsuario(RegistroUsuario registroUsuarioIdUsuario) {
        this.registroUsuarioIdUsuario = registroUsuarioIdUsuario;
    }

    @XmlTransient
    public Collection<CabeceraFactura> getCabeceraFacturaCollection() {
        return cabeceraFacturaCollection;
    }

    public void setCabeceraFacturaCollection(Collection<CabeceraFactura> cabeceraFacturaCollection) {
        this.cabeceraFacturaCollection = cabeceraFacturaCollection;
    }

    public Double getTotalVentasCliente() {
        return totalVentasCliente;
    }

    public void setTotalVentasCliente(Double totalVentasCliente) {
        this.totalVentasCliente = totalVentasCliente;
    }

    @XmlTransient
    public Collection<Reclamo> getReclamoCollection() {
        return reclamoCollection;
    }

    public void setReclamoCollection(Collection<Reclamo> reclamoCollection) {
        this.reclamoCollection = reclamoCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }
    
}
