/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entidades.Producto;
import Sessions.ProductoFacadeLocal;
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

/**
 *
 * @author KevinMac
 */
@ManagedBean(name = "managedMasVendidos")
@ViewScoped
public class ManagedMasVendidos implements Serializable {

    public ManagedMasVendidos() {
    }
    @EJB
    private ProductoFacadeLocal producFacadeLocal;
    private List<Producto> listadoProductos;
    private BarChartModel barra;
    private Producto producto;
    private Producto pmasVendido;
    private String idProducmasVendido;

    public void listarProductos() {
        setListadoProductos(producFacadeLocal.findAll());
        graficar();
    }

    public void graficar() {

        barra = new BarChartModel();

        pmasVendido = new Producto();


        int maxAux = Integer.parseInt(listadoProductos.get(0).getTotalVentasProducto());
        for (int i = 0; i < listadoProductos.size(); i++) {
            ChartSeries serie = new BarChartSeries();
            serie.setLabel(listadoProductos.get(i).getNombreProducto());
            serie.set(listadoProductos.get(i).getNombreProducto(), Integer.parseInt(listadoProductos.get(i).getTotalVentasProducto()));
            barra.addSeries(serie);


            int maxActual = Integer.parseInt(listadoProductos.get(i).getTotalVentasProducto());
            
            if (maxActual > maxAux) {
                maxAux = maxActual;
                idProducmasVendido = listadoProductos.get(i).getIdProducto();
                pmasVendido = producFacadeLocal.find(listadoProductos.get(i).getIdProducto());
                System.out.println("*********************************");
                System.out.println(pmasVendido.getNombreProducto());
                System.out.println("**************************************");
            }


        }

        barra.setTitle("Productos Vendidos");
        barra.setLegendPosition("ne");
        barra.setAnimate(true);
        Axis xAxis = barra.getAxis(AxisType.X);
        xAxis.setLabel("Productos");
        Axis yAxis = barra.getAxis(AxisType.Y);
        xAxis.setLabel("Cantidad Vendida");
        yAxis.setMin(5000);
        xAxis.setMin(50000);
    }

    public List<Producto> getListadoProductos() {
        return listadoProductos;
    }

    public void setListadoProductos(List<Producto> listadoProductos) {
        this.listadoProductos = listadoProductos;
    }

    public Producto getPmasVendido() {
        return pmasVendido;
    }

    public void setPmasVendido(Producto pmasVendido) {
        this.pmasVendido = pmasVendido;
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

    @PostConstruct
    public void inicio() {
        producto = new Producto();
        listarProductos();
    }
}
