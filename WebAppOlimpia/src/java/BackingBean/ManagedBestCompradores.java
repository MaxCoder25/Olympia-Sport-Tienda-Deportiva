/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Entidades.Cliente;
import Sessions.ClienteFacadeLocal;
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
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author KevinMac
 */
@ManagedBean(name = "managedBestCompradores")
@ViewScoped
public class ManagedBestCompradores implements Serializable {

    public ManagedBestCompradores() {
    }
    @EJB
    private ClienteFacadeLocal clieFacadeLocal;
    private List<Cliente> listadoClientes;
    private BarChartModel barra;
    private LineChartModel modeloLineal = new LineChartModel();
    private LineChartSeries serie1 = new LineChartSeries();
    private Cliente cliente;

    public void listarClientes() {
        setListadoClientes(clieFacadeLocal.findAll());
        graficarLineal();
        graficarBarra();
    }

    public LineChartModel getModeloLineal() {
        return modeloLineal;
    }

    public void setModeloLineal(LineChartModel modeloLineal) {
        this.modeloLineal = modeloLineal;
    }

    public LineChartModel iniciarModeloLineal() {
        serie1.setLabel("Vendido");

        for (int i = 0; i < listadoClientes.size(); i++) {

//            serie1.set(listadoClientes.get(i).getNombreCliente() + " " + listadoClientes.get(i).getApellidoCliente(), listadoClientes.get(i).getTotalVentasCliente());

            serie1.set(i, listadoClientes.get(i).getTotalVentasCliente());
        }
        modeloLineal.addSeries(serie1);
        return modeloLineal;
    }

    public void graficarLineal() {

        modeloLineal = iniciarModeloLineal();



        modeloLineal.setTitle("Ventas");
        modeloLineal.setLegendPosition("e");
        modeloLineal.setAnimate(true);
        Axis xAxis = modeloLineal.getAxis(AxisType.X);
        xAxis.setLabel("Meses");
        xAxis.setTickFormat("%d");
        xAxis.setMin(0);
        xAxis.setMax(12);

        Axis yAxis = modeloLineal.getAxis(AxisType.Y);
        yAxis.setLabel(" Vendido");
        yAxis.setMin(0);
        yAxis.setMax(1000);
        yAxis.setTickFormat("%d");
    }

    public void graficarBarra() {

        barra = new BarChartModel();

        for (int i = 0; i < listadoClientes.size(); i++) {
            ChartSeries serie = new BarChartSeries();
            serie.setLabel(listadoClientes.get(i).getNombreCliente());
            serie.set(listadoClientes.get(i).getCedulaCliente(), listadoClientes.get(i).getTotalVentasCliente());
            barra.addSeries(serie);

        }

        barra.setTitle("Mejores Compradores");
        barra.setLegendPosition("ne");
        barra.setAnimate(true);
        Axis xAxis = barra.getAxis(AxisType.X);
        xAxis.setLabel("Compradores");
        Axis yAxis = barra.getAxis(AxisType.Y);
        xAxis.setLabel("Total Vendido");
        yAxis.setMin(500);
        xAxis.setMin(5000);
    }

    public List<Cliente> getListadoClientes() {
        return listadoClientes;
    }

    public void setListadoClientes(List<Cliente> listadoClientes) {
        this.listadoClientes = listadoClientes;
    }

    public BarChartModel getBarra() {
        return barra;
    }

    public void setBarra(BarChartModel barra) {
        this.barra = barra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @PostConstruct
    public void inicio() {
        cliente = new Cliente();
        listarClientes();
    }
}
