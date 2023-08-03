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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Producto.findByMarcaProducto", query = "SELECT p FROM Producto p WHERE p.marcaProducto = :marcaProducto"),
    @NamedQuery(name = "Producto.findByDescripcionProducto", query = "SELECT p FROM Producto p WHERE p.descripcionProducto = :descripcionProducto"),
    @NamedQuery(name = "Producto.findByStockProducto", query = "SELECT p FROM Producto p WHERE p.stockProducto = :stockProducto"),
    @NamedQuery(name = "Producto.findByPrecioProducto", query = "SELECT p FROM Producto p WHERE p.precioProducto = :precioProducto"),
    @NamedQuery(name = "Producto.findByPaisFabricaProducto", query = "SELECT p FROM Producto p WHERE p.paisFabricaProducto = :paisFabricaProducto"),
    @NamedQuery(name = "Producto.findByComentariosProducto", query = "SELECT p FROM Producto p WHERE p.comentariosProducto = :comentariosProducto"),
    @NamedQuery(name = "Producto.findByIvaProducto", query = "SELECT p FROM Producto p WHERE p.ivaProducto = :ivaProducto"),
   @NamedQuery(name = "Producto.findBycatSubcat", query = "SELECT p FROM Producto p WHERE p.categoriaIdCategoria = :categoriaIdCategoria AND p.subcategoriaIdSubcategoria = :subcategoriaIdSubcategoria"),
   @NamedQuery(name = "Producto.findBySubcat", query = "SELECT p FROM Producto p WHERE p.subcategoriaIdSubcategoria = :subcategoriaIdSubcategoria"),
   @NamedQuery(name = "Producto.findbyTotalVentas", query = "SELECT p FROM Producto p WHERE p.totalVentasProducto > :totalVentasProducto"),
  @NamedQuery(name = "Producto.findByDescuentoProducto", query = "SELECT p FROM Producto p WHERE p.descuentoProducto = :descuentoProducto")})


public class Producto implements Serializable {
    @Size(max = 255)
    @Column(name = "total_ventas_producto")
    private String totalVentasProducto;
    @Size(max = 255)
    @Column(name = "cantidad_producto")
    private String cantidadProducto;
    @Size(max = 255)
    @Column(name = "imagen")
    private String imagen;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_producto")
    private String idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "marca_producto")
    private String marcaProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion_producto")
    private String descripcionProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "stock_producto")
    private String stockProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_producto")
    private double precioProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pais_fabrica_producto")
    private String paisFabricaProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comentarios_producto")
    private String comentariosProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva_producto")
    private double ivaProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento_producto")
    private double descuentoProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoIdProducto")
    private Collection<PedidoProducto> pedidoProductoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoIdProducto")
    private Collection<DetalleFactura> detalleFacturaCollection;
    @JoinColumn(name = "subcategoria_id_subcategoria", referencedColumnName = "id_subcategoria")
    @ManyToOne(optional = false)
    private Subcategoria subcategoriaIdSubcategoria;
    @JoinColumn(name = "proveedor_id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(optional = false)
    private Proveedor proveedorIdProveedor;
    @JoinColumn(name = "marca_id_marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private Marca marcaIdMarca;
    @JoinColumn(name = "categoria_id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria categoriaIdCategoria;

    public Producto() {
    }

    public Producto(String idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(String idProducto, String nombreProducto, String marcaProducto, String descripcionProducto, String stockProducto, double precioProducto, String paisFabricaProducto, String comentariosProducto, double ivaProducto, double descuentoProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.marcaProducto = marcaProducto;
        this.descripcionProducto = descripcionProducto;
        this.stockProducto = stockProducto;
        this.precioProducto = precioProducto;
        this.paisFabricaProducto = paisFabricaProducto;
        this.comentariosProducto = comentariosProducto;
        this.ivaProducto = ivaProducto;
        this.descuentoProducto = descuentoProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(String stockProducto) {
        this.stockProducto = stockProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getPaisFabricaProducto() {
        return paisFabricaProducto;
    }

    public void setPaisFabricaProducto(String paisFabricaProducto) {
        this.paisFabricaProducto = paisFabricaProducto;
    }

    public String getComentariosProducto() {
        return comentariosProducto;
    }

    public void setComentariosProducto(String comentariosProducto) {
        this.comentariosProducto = comentariosProducto;
    }

    public double getIvaProducto() {
        return ivaProducto;
    }

    public void setIvaProducto(double ivaProducto) {
        this.ivaProducto = ivaProducto;
    }

    public double getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(double descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }

    @XmlTransient
    public Collection<PedidoProducto> getPedidoProductoCollection() {
        return pedidoProductoCollection;
    }

    public void setPedidoProductoCollection(Collection<PedidoProducto> pedidoProductoCollection) {
        this.pedidoProductoCollection = pedidoProductoCollection;
    }

    @XmlTransient
    public Collection<DetalleFactura> getDetalleFacturaCollection() {
        return detalleFacturaCollection;
    }

    public void setDetalleFacturaCollection(Collection<DetalleFactura> detalleFacturaCollection) {
        this.detalleFacturaCollection = detalleFacturaCollection;
    }

    public Subcategoria getSubcategoriaIdSubcategoria() {
        return subcategoriaIdSubcategoria;
    }

    public void setSubcategoriaIdSubcategoria(Subcategoria subcategoriaIdSubcategoria) {
        this.subcategoriaIdSubcategoria = subcategoriaIdSubcategoria;
    }

    public Proveedor getProveedorIdProveedor() {
        return proveedorIdProveedor;
    }

    public void setProveedorIdProveedor(Proveedor proveedorIdProveedor) {
        this.proveedorIdProveedor = proveedorIdProveedor;
    }

    public Marca getMarcaIdMarca() {
        return marcaIdMarca;
    }

    public void setMarcaIdMarca(Marca marcaIdMarca) {
        this.marcaIdMarca = marcaIdMarca;
    }

    public Categoria getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }

    public void setCategoriaIdCategoria(Categoria categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Producto[ idProducto=" + idProducto + " ]";
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getTotalVentasProducto() {
        return totalVentasProducto;
    }

    public void setTotalVentasProducto(String totalVentasProducto) {
        this.totalVentasProducto = totalVentasProducto;
    }
    
}
