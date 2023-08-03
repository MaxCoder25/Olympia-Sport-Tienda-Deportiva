/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CAMPOVERDE_R
 */
@Entity
@Table(name = "detalle_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findBySecuencialDetalleFactura", query = "SELECT d FROM DetalleFactura d WHERE d.secuencialDetalleFactura = :secuencialDetalleFactura"),
    @NamedQuery(name = "DetalleFactura.findByIdDetalleFactura", query = "SELECT d FROM DetalleFactura d WHERE d.idDetalleFactura = :idDetalleFactura"),
    @NamedQuery(name = "DetalleFactura.findByCantidadProducto", query = "SELECT d FROM DetalleFactura d WHERE d.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "DetalleFactura.findByPrecioProducto", query = "SELECT d FROM DetalleFactura d WHERE d.precioProducto = :precioProducto")})
public class DetalleFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "secuencial_detalle_factura")
    private String secuencialDetalleFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_detalle_factura")
    private String idDetalleFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cantidad_producto")
    private String cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_producto")
    private double precioProducto;
    @JoinColumn(name = "producto_id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto productoIdProducto;
    @JoinColumn(name = "cabecera_factura_num_factura", referencedColumnName = "num_factura")
    @ManyToOne(optional = false)
    private CabeceraFactura cabeceraFacturaNumFactura;

    public DetalleFactura() {
    }

    public DetalleFactura(String secuencialDetalleFactura) {
        this.secuencialDetalleFactura = secuencialDetalleFactura;
    }

    public DetalleFactura(String secuencialDetalleFactura, String idDetalleFactura, String cantidadProducto, double precioProducto) {
        this.secuencialDetalleFactura = secuencialDetalleFactura;
        this.idDetalleFactura = idDetalleFactura;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
    }

    public String getSecuencialDetalleFactura() {
        return secuencialDetalleFactura;
    }

    public void setSecuencialDetalleFactura(String secuencialDetalleFactura) {
        this.secuencialDetalleFactura = secuencialDetalleFactura;
    }

    public String getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(String idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Producto getProductoIdProducto() {
        return productoIdProducto;
    }

    public void setProductoIdProducto(Producto productoIdProducto) {
        this.productoIdProducto = productoIdProducto;
    }

    public CabeceraFactura getCabeceraFacturaNumFactura() {
        return cabeceraFacturaNumFactura;
    }

    public void setCabeceraFacturaNumFactura(CabeceraFactura cabeceraFacturaNumFactura) {
        this.cabeceraFacturaNumFactura = cabeceraFacturaNumFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuencialDetalleFactura != null ? secuencialDetalleFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.secuencialDetalleFactura == null && other.secuencialDetalleFactura != null) || (this.secuencialDetalleFactura != null && !this.secuencialDetalleFactura.equals(other.secuencialDetalleFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetalleFactura[ secuencialDetalleFactura=" + secuencialDetalleFactura + " ]";
    }
    
}
