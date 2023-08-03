/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entidades.Categoria;
import Entidades.Producto;
import Entidades.Subcategoria;
import Sessions.ProductoFacadeLocal;
import Sessions.SubcategoriaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author KevinMac
 */
@ManagedBean(name = "managedStock")
@ViewScoped
public class ManagedStock implements Serializable {

    /**
     * Creates a new instance of managedStock
     */
    public ManagedStock() {
    }
    @EJB
    private ProductoFacadeLocal producFacadeLocal;
    @EJB
    private SubcategoriaFacadeLocal subCatFacadeLocal;
    private List<Producto> listadoStock;
    private List<Subcategoria> listadoSubCategoria;
    private BarChartModel barra;
    private PieChartModel pieModel;
    private Producto producto;

    public void listarStock() {
        setListadoStock(producFacadeLocal.findAll());  //con findAll funciona
        setListadoSubCategoria(subCatFacadeLocal.findAll());
        graficar();
        graficarSubCat();
    }

    public void graficar() {

        barra = new BarChartModel();

        for (int i = 0; i < listadoStock.size(); i++) {
            ChartSeries serie = new BarChartSeries();
            serie.setLabel(listadoStock.get(i).getNombreProducto());
            serie.set(listadoStock.get(i).getNombreProducto(), Integer.parseInt(listadoStock.get(i).getStockProducto()));
            barra.addSeries(serie);

        }

        barra.setTitle("Stock de todos los productos");
        barra.setLegendPosition("ne");
        barra.setAnimate(true);
        Axis xAxis = barra.getAxis(AxisType.X);
        xAxis.setLabel("Productos");
        Axis yAxis = barra.getAxis(AxisType.Y);
        xAxis.setLabel("Stock");
        yAxis.setMin(5000);
        xAxis.setMin(50000);
    }

    private void graficarSubCat() {
        pieModel = new PieChartModel();

        for (Subcategoria sub : listadoSubCategoria) {
            pieModel.set(sub.getNombreSubcategoria(), Integer.parseInt(sub.getTotalProductosSubcategoria()));
        }

        pieModel.setTitle("Stock de los productos por subcategoria");
        pieModel.setLegendPosition("w");
        pieModel.setFill(true);
        pieModel.setShadow(false);
        pieModel.setShowDataLabels(true);
        pieModel.setDiameter(400);

    }

    public List<Producto> getListadoStock() {
        return listadoStock;
    }

    public void setListadoStock(List<Producto> listadoStock) {
        this.listadoStock = listadoStock;
    }

    public List<Subcategoria> getListadoSubCategoria() {
        return listadoSubCategoria;
    }

    public void setListadoSubCategoria(List<Subcategoria> listadoSubCategoria) {
        this.listadoSubCategoria = listadoSubCategoria;
    }

    public BarChartModel getBarra() {
        return barra;
    }

    public void setBarra(BarChartModel barra) {
        this.barra = barra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    @PostConstruct
    public void inicio() {
        producto = new Producto();

        listarStock();
    }
}
