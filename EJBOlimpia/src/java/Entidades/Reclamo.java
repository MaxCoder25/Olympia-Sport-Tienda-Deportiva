/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KevinMac
 */
@Entity
@Table(name = "reclamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reclamo.findAll", query = "SELECT r FROM Reclamo r"),
    @NamedQuery(name = "Reclamo.findByIdReclamo", query = "SELECT r FROM Reclamo r WHERE r.idReclamo = :idReclamo"),
    @NamedQuery(name = "Reclamo.findByDescripcionReclamo", query = "SELECT r FROM Reclamo r WHERE r.descripcionReclamo = :descripcionReclamo"),
    @NamedQuery(name = "Reclamo.findByFechaIngresoReclamo", query = "SELECT r FROM Reclamo r WHERE r.fechaIngresoReclamo = :fechaIngresoReclamo"),
    @NamedQuery(name = "Reclamo.findByFechaSolucionReclamo", query = "SELECT r FROM Reclamo r WHERE r.fechaSolucionReclamo = :fechaSolucionReclamo")})
public class Reclamo implements Serializable {
    @JoinColumn(name = "cliente_id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente clienteIdCliente;
    @JoinColumn(name = "estado_reclamo_id_estado_reclamo", referencedColumnName = "id_estado_reclamo")
    @ManyToOne(optional = false)
    private EstadoReclamo estadoReclamoIdEstadoReclamo;
    @JoinColumn(name = "tipo_reclamo_id_tipo_reclamo", referencedColumnName = "id_tipo_reclamo")
    @ManyToOne(optional = false)
    private TipoReclamo tipoReclamoIdTipoReclamo;
    @JoinColumn(name = "vendedor_id_vendedor", referencedColumnName = "id_vendedor")
    @ManyToOne(optional = false)
    private Vendedor vendedorIdVendedor;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_reclamo")
    private String idReclamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion_reclamo")
    private String descripcionReclamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso_reclamo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngresoReclamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_solucion_reclamo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolucionReclamo;

    public Reclamo() {
    }

    public Reclamo(String idReclamo) {
        this.idReclamo = idReclamo;
    }

    public Reclamo(String idReclamo, String descripcionReclamo, Date fechaIngresoReclamo, Date fechaSolucionReclamo) {
        this.idReclamo = idReclamo;
        this.descripcionReclamo = descripcionReclamo;
        this.fechaIngresoReclamo = fechaIngresoReclamo;
        this.fechaSolucionReclamo = fechaSolucionReclamo;
    }

    public String getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(String idReclamo) {
        this.idReclamo = idReclamo;
    }

    public String getDescripcionReclamo() {
        return descripcionReclamo;
    }

    public void setDescripcionReclamo(String descripcionReclamo) {
        this.descripcionReclamo = descripcionReclamo;
    }

    public Date getFechaIngresoReclamo() {
        return fechaIngresoReclamo;
    }

    public void setFechaIngresoReclamo(Date fechaIngresoReclamo) {
        this.fechaIngresoReclamo = fechaIngresoReclamo;
    }

    public Date getFechaSolucionReclamo() {
        return fechaSolucionReclamo;
    }

    public void setFechaSolucionReclamo(Date fechaSolucionReclamo) {
        this.fechaSolucionReclamo = fechaSolucionReclamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReclamo != null ? idReclamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reclamo)) {
            return false;
        }
        Reclamo other = (Reclamo) object;
        if ((this.idReclamo == null && other.idReclamo != null) || (this.idReclamo != null && !this.idReclamo.equals(other.idReclamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Reclamo[ idReclamo=" + idReclamo + " ]";
    }

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public EstadoReclamo getEstadoReclamoIdEstadoReclamo() {
        return estadoReclamoIdEstadoReclamo;
    }

    public void setEstadoReclamoIdEstadoReclamo(EstadoReclamo estadoReclamoIdEstadoReclamo) {
        this.estadoReclamoIdEstadoReclamo = estadoReclamoIdEstadoReclamo;
    }

    public TipoReclamo getTipoReclamoIdTipoReclamo() {
        return tipoReclamoIdTipoReclamo;
    }

    public void setTipoReclamoIdTipoReclamo(TipoReclamo tipoReclamoIdTipoReclamo) {
        this.tipoReclamoIdTipoReclamo = tipoReclamoIdTipoReclamo;
    }

    public Vendedor getVendedorIdVendedor() {
        return vendedorIdVendedor;
    }

    public void setVendedorIdVendedor(Vendedor vendedorIdVendedor) {
        this.vendedorIdVendedor = vendedorIdVendedor;
    }
    
}
