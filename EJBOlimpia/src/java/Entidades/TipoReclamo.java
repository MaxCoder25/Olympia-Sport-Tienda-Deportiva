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
@Table(name = "tipo_reclamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoReclamo.findAll", query = "SELECT t FROM TipoReclamo t"),
    @NamedQuery(name = "TipoReclamo.findByIdTipoReclamo", query = "SELECT t FROM TipoReclamo t WHERE t.idTipoReclamo = :idTipoReclamo"),
    @NamedQuery(name = "TipoReclamo.findByTipoDeReclamo", query = "SELECT t FROM TipoReclamo t WHERE t.tipoDeReclamo = :tipoDeReclamo"),
    @NamedQuery(name = "TipoReclamo.findByDescripcioTipoReclamo", query = "SELECT t FROM TipoReclamo t WHERE t.descripcioTipoReclamo = :descripcioTipoReclamo")})
public class TipoReclamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_tipo_reclamo")
    private String idTipoReclamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tipo_de_reclamo")
    private String tipoDeReclamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcio_tipo_reclamo")
    private String descripcioTipoReclamo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoReclamoIdTipoReclamo")
    private Collection<Reclamo> reclamoCollection;

    public TipoReclamo() {
    }

    public TipoReclamo(String idTipoReclamo) {
        this.idTipoReclamo = idTipoReclamo;
    }

    public TipoReclamo(String idTipoReclamo, String tipoDeReclamo, String descripcioTipoReclamo) {
        this.idTipoReclamo = idTipoReclamo;
        this.tipoDeReclamo = tipoDeReclamo;
        this.descripcioTipoReclamo = descripcioTipoReclamo;
    }

    public String getIdTipoReclamo() {
        return idTipoReclamo;
    }

    public void setIdTipoReclamo(String idTipoReclamo) {
        this.idTipoReclamo = idTipoReclamo;
    }

    public String getTipoDeReclamo() {
        return tipoDeReclamo;
    }

    public void setTipoDeReclamo(String tipoDeReclamo) {
        this.tipoDeReclamo = tipoDeReclamo;
    }

    public String getDescripcioTipoReclamo() {
        return descripcioTipoReclamo;
    }

    public void setDescripcioTipoReclamo(String descripcioTipoReclamo) {
        this.descripcioTipoReclamo = descripcioTipoReclamo;
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
        hash += (idTipoReclamo != null ? idTipoReclamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoReclamo)) {
            return false;
        }
        TipoReclamo other = (TipoReclamo) object;
        if ((this.idTipoReclamo == null && other.idTipoReclamo != null) || (this.idTipoReclamo != null && !this.idTipoReclamo.equals(other.idTipoReclamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoReclamo[ idTipoReclamo=" + idTipoReclamo + " ]";
    }
    
}
