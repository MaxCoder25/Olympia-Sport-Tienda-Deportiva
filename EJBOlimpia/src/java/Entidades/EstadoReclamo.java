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
@Table(name = "estado_reclamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoReclamo.findAll", query = "SELECT e FROM EstadoReclamo e"),
    @NamedQuery(name = "EstadoReclamo.findByIdEstadoReclamo", query = "SELECT e FROM EstadoReclamo e WHERE e.idEstadoReclamo = :idEstadoReclamo"),
    @NamedQuery(name = "EstadoReclamo.findByDescripcionEstadoReclamo", query = "SELECT e FROM EstadoReclamo e WHERE e.descripcionEstadoReclamo = :descripcionEstadoReclamo")})
public class EstadoReclamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_estado_reclamo")
    private String idEstadoReclamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion_estado_reclamo")
    private String descripcionEstadoReclamo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoReclamoIdEstadoReclamo")
    private Collection<Reclamo> reclamoCollection;

    public EstadoReclamo() {
    }

    public EstadoReclamo(String idEstadoReclamo) {
        this.idEstadoReclamo = idEstadoReclamo;
    }

    public EstadoReclamo(String idEstadoReclamo, String descripcionEstadoReclamo) {
        this.idEstadoReclamo = idEstadoReclamo;
        this.descripcionEstadoReclamo = descripcionEstadoReclamo;
    }

    public String getIdEstadoReclamo() {
        return idEstadoReclamo;
    }

    public void setIdEstadoReclamo(String idEstadoReclamo) {
        this.idEstadoReclamo = idEstadoReclamo;
    }

    public String getDescripcionEstadoReclamo() {
        return descripcionEstadoReclamo;
    }

    public void setDescripcionEstadoReclamo(String descripcionEstadoReclamo) {
        this.descripcionEstadoReclamo = descripcionEstadoReclamo;
    }

    @XmlTransient
    public Collection<Reclamo> getReclamoCollection() {
        return reclamoCollection;
    }

    public void setReclamoCollection(Collection<Reclamo> reclamoCollection) {
        this.reclamoCollection = reclamoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoReclamo != null ? idEstadoReclamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoReclamo)) {
            return false;
        }
        EstadoReclamo other = (EstadoReclamo) object;
        if ((this.idEstadoReclamo == null && other.idEstadoReclamo != null) || (this.idEstadoReclamo != null && !this.idEstadoReclamo.equals(other.idEstadoReclamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.EstadoReclamo[ idEstadoReclamo=" + idEstadoReclamo + " ]";
    }
    
}
