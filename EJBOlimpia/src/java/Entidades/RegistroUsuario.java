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
@Table(name = "registro_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroUsuario.findAll", query = "SELECT r FROM RegistroUsuario r"),
    @NamedQuery(name = "RegistroUsuario.findByIdUsuario", query = "SELECT r FROM RegistroUsuario r WHERE r.idUsuario = :idUsuario"),
    @NamedQuery(name = "RegistroUsuario.findByNombreUsuario", query = "SELECT r FROM RegistroUsuario r WHERE r.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "RegistroUsuario.findByPasswordUsuario", query = "SELECT r FROM RegistroUsuario r WHERE r.passwordUsuario = :passwordUsuario"),
    @NamedQuery(name = "RegistroUsuario.findByEmail", query = "SELECT r FROM RegistroUsuario r WHERE r.email = :email"),
    @NamedQuery(name = "RegistroUsuario.findByTipoUsuario", query = "SELECT r FROM RegistroUsuario r WHERE r.tipoUsuario = :tipoUsuario")})
public class RegistroUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_usuario")
    private String idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password_usuario")
    private String passwordUsuario;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registroUsuarioIdUsuario")
    private Collection<Vendedor> vendedorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registroUsuarioIdUsuario")
    private Collection<Cliente> clienteCollection;

    public RegistroUsuario() {
    }

    public RegistroUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public RegistroUsuario(String idUsuario, String nombreUsuario, String passwordUsuario, String email, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @XmlTransient
    public Collection<Vendedor> getVendedorCollection() {
        return vendedorCollection;
    }

    public void setVendedorCollection(Collection<Vendedor> vendedorCollection) {
        this.vendedorCollection = vendedorCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroUsuario)) {
            return false;
        }
        RegistroUsuario other = (RegistroUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.RegistroUsuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
