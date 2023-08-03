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
@Table(name = "subcategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcategoria.findAll", query = "SELECT s FROM Subcategoria s"),
    @NamedQuery(name = "Subcategoria.findByIdSubcategoria", query = "SELECT s FROM Subcategoria s WHERE s.idSubcategoria = :idSubcategoria"),
    @NamedQuery(name = "Subcategoria.findByNombreSubcategoria", query = "SELECT s FROM Subcategoria s WHERE s.nombreSubcategoria = :nombreSubcategoria"),
    @NamedQuery(name = "Subcategoria.findByDescripcionSubcategoria", query = "SELECT s FROM Subcategoria s WHERE s.descripcionSubcategoria = :descripcionSubcategoria")})
public class Subcategoria implements Serializable {
    @Size(max = 255)
    @Column(name = "total_productos_subcategoria")
    private String totalProductosSubcategoria;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_subcategoria")
    private String idSubcategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_subcategoria")
    private String nombreSubcategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion_subcategoria")
    private String descripcionSubcategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subcategoriaIdSubcategoria")
    private Collection<Producto> productoCollection;

    public Subcategoria() {
    }

    public Subcategoria(String idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public Subcategoria(String idSubcategoria, String nombreSubcategoria, String descripcionSubcategoria) {
        this.idSubcategoria = idSubcategoria;
        this.nombreSubcategoria = nombreSubcategoria;
        this.descripcionSubcategoria = descripcionSubcategoria;
    }

    public String getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(String idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getNombreSubcategoria() {
        return nombreSubcategoria;
    }

    public void setNombreSubcategoria(String nombreSubcategoria) {
        this.nombreSubcategoria = nombreSubcategoria;
    }

    public String getDescripcionSubcategoria() {
        return descripcionSubcategoria;
    }

    public void setDescripcionSubcategoria(String descripcionSubcategoria) {
        this.descripcionSubcategoria = descripcionSubcategoria;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubcategoria != null ? idSubcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcategoria)) {
            return false;
        }
        Subcategoria other = (Subcategoria) object;
        if ((this.idSubcategoria == null && other.idSubcategoria != null) || (this.idSubcategoria != null && !this.idSubcategoria.equals(other.idSubcategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Subcategoria[ idSubcategoria=" + idSubcategoria + " ]";
    }

    public String getTotalProductosSubcategoria() {
        return totalProductosSubcategoria;
    }

    public void setTotalProductosSubcategoria(String totalProductosSubcategoria) {
        this.totalProductosSubcategoria = totalProductosSubcategoria;
    }
    
}
