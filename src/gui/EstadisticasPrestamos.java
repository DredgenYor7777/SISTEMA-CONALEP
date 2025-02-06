package gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class EstadisticasPrestamos extends JFrame {

    private HashMap<String, ArrayList<String>> prestamos;

    public EstadisticasPrestamos() {
        setTitle("Estadísticas de Préstamos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Obtener datos de préstamos
        prestamos = listaPrestamos();

        // Crear tabla de estadísticas
        JTable table = crearTablaEstadisticas();
        JScrollPane scrollPane = new JScrollPane(table);

        // Crear gráfico de libros más prestados
        JFreeChart chartLibros = crearGraficoLibros();
        ChartPanel chartPanelLibros = new ChartPanel(chartLibros);

        // Crear gráfico de carreras que más piden libros
        JFreeChart chartCarreras = crearGraficoCarreras();
        ChartPanel chartPanelCarreras = new ChartPanel(chartCarreras);

        // Paneles organizados en un SplitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, chartPanelLibros, chartPanelCarreras);
        splitPane.setDividerLocation(400);

        // Agregar componentes al JFrame
        add(scrollPane, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);
    }

    private JTable crearTablaEstadisticas() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Carrera");
        model.addColumn("Libros Prestados");

        for (String carrera : prestamos.keySet()) {
            model.addRow(new Object[]{carrera, prestamos.get(carrera).size()});
        }

        return new JTable(model);
    }

    private JFreeChart crearGraficoLibros() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        HashMap<String, Integer> conteoLibros = new HashMap<>();
        for (ArrayList<String> libros : prestamos.values()) {
            for (String libro : libros) {
                conteoLibros.put(libro, conteoLibros.getOrDefault(libro, 0) + 1);
            }
        }

        for (String libro : conteoLibros.keySet()) {
            dataset.addValue(conteoLibros.get(libro), "Libros", libro);
        }

        return ChartFactory.createBarChart(
                "Libros más Prestados",
                "Libros",
                "Cantidad",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false
        );
    }

    private JFreeChart crearGraficoCarreras() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (String carrera : prestamos.keySet()) {
            dataset.addValue(prestamos.get(carrera).size(), "Carreras", carrera);
        }

        return ChartFactory.createBarChart(
                "Carreras que más Solicitan Libros",
                "Carreras",
                "Cantidad de Préstamos",
                dataset,
                PlotOrientation.HORIZONTAL,
                false, true, false
        );
    }

    public static HashMap<String, ArrayList<String>> listaPrestamos() {
        HashMap<String, ArrayList<String>> prestamos = new HashMap<>();
        ArrayList<String> carreras = listaCarreras();
        ArrayList<String> libros = listaLibros();

        for (String carrera : carreras) {
            ArrayList<String> librosPrestados = new ArrayList<>();
            for (int i = 0; i < (int) (Math.random() * libros.size()); i++) {
                librosPrestados.add(libros.get(i));
            }
            prestamos.put(carrera, librosPrestados);
        }

        return prestamos;
    }

    public static ArrayList<String> listaCarreras() {
        ArrayList<String> nuevaLista = new ArrayList<>();
        nuevaLista.add("Ingeniería en Sistemas Computacionales");
        nuevaLista.add("Ingeniería en Electrónica");
        nuevaLista.add("Ingeniería Industrial");
        nuevaLista.add("Ingeniería Logística");
        nuevaLista.add("Ingeniería Mecatrónica");
        nuevaLista.add("Ingeniería Ferroviaria");
        nuevaLista.add("Licenciatura en Gastronomía");
        nuevaLista.add("Licenciatura en Contaduría");
        nuevaLista.add("Licenciatura en Administración");
        return nuevaLista;
    }

    public static ArrayList<String> listaLibros() {
        ArrayList<String> listaLibros = new ArrayList<>();
        listaLibros.add("Programación funcional, sexta edición, Oracle");
        listaLibros.add("Administración de empresas, segunda edición, Ecured");
        listaLibros.add("Introducción a Dart, primera edición, Google");
        listaLibros.add("Primeros pasos en Flutter framework, primera edición, Google");
        listaLibros.add("Arduino avanzado, sexta edición, Ecured");
        listaLibros.add("Investigación de Operaciones, sexta edición, Ecured");
        return listaLibros;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EstadisticasPrestamos  frame = new EstadisticasPrestamos ();
            frame.setVisible(true);
        });
    }
}
