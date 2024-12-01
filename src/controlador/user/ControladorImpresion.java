
package controlador.user;


import controlador.bd.Conexion;
import java.awt.Desktop;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ControladorImpresion {
    

        public static void generarReporte(JTable inventario) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
        // Obtener la conexión antes de ejecutar la consulta
        conn = Conexion.iniciar();

        // Crear la sentencia y ejecutar la consulta
        stmt = conn.createStatement();  // Crear la sentencia
        rs = stmt.executeQuery("SELECT * FROM inventario");  // Ejecutar la consulta

        // Crear un nuevo libro de trabajo y hoja de Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Inventario");

        // Crear un estilo de fuente
        org.apache.poi.ss.usermodel.Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 20);  // Tamaño de la fuente

        // Crear un estilo de celda
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(font);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);  // Centrar el texto
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);  // Centrar verticalmente
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);  // Fondo azul claro
        headerStyle.setBorderBottom(BorderStyle.THIN);  // Borde inferior
        headerStyle.setBorderTop(BorderStyle.THIN);  // Borde superior
        headerStyle.setBorderLeft(BorderStyle.THIN);  // Borde izquierdo
        headerStyle.setBorderRight(BorderStyle.THIN);  // Borde derecho

        // Crear la fila de encabezado
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Clave Inventario", "Stock", "Cantidad Disponible", "Id Libro"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Crear un estilo para las celdas de datos
        CellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setAlignment(HorizontalAlignment.CENTER);
        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dataStyle.setBorderBottom(BorderStyle.THIN);
        dataStyle.setBorderTop(BorderStyle.THIN);
        dataStyle.setBorderLeft(BorderStyle.THIN);
        dataStyle.setBorderRight(BorderStyle.THIN);

        // Llenar los datos en las filas
        int rowNum = 1;
        while (rs.next()) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(rs.getInt("id_inventario"));
            row.createCell(1).setCellValue(rs.getInt("stock"));
            row.createCell(2).setCellValue(rs.getInt("cantidadDisponible"));
            row.createCell(3).setCellValue(rs.getInt("id_libro"));

            // Aplicar el estilo a cada celda
            for (int i = 0; i < 4; i++) {
                row.getCell(i).setCellStyle(dataStyle);
            }
        }

        // Ajustar el ancho de las columnas
        for (int i = 0; i < 4; i++) {
            sheet.autoSizeColumn(i);
        }

        // Definir la ruta donde se guardará el archivo
        String ruta = "C:/Users/Dell/Documents/reporte.xlsx";
        File archivo = new File(ruta);

        // Guardar el archivo Excel
        try (FileOutputStream fileOut = new FileOutputStream(archivo)) {
            workbook.write(fileOut);
            JOptionPane.showMessageDialog(null, "Reporte generado con éxito en " + archivo.getAbsolutePath());
        }
        
        
        // Preguntar al usuario si desea abrir el archivo
            int abrir = JOptionPane.showConfirmDialog(null, "¿Desea abrir el reporte?", "Abrir archivo", JOptionPane.YES_NO_OPTION);
            if (abrir == JOptionPane.YES_OPTION) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(archivo);
                } else {
                    JOptionPane.showMessageDialog(null, "Abrir archivo no es compatible en este sistema.");
                }
            }

    } catch (SQLException | IOException e) {
        JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + e.getMessage());
        e.printStackTrace();
    } 
}
        
        
        
        
             public static void generarReporteLibros(JTable libros) throws IOException {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
        // Obtener la conexión antes de ejecutar la consulta
        conn = Conexion.iniciar();

        // Crear la sentencia y ejecutar la consulta
        stmt = conn.createStatement();  // Crear la sentencia
        rs = stmt.executeQuery("SELECT * FROM libro");  // Ejecutar la consulta

        // Crear un nuevo libro de trabajo y hoja de Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Libro");

        // Crear un estilo de fuente
        org.apache.poi.ss.usermodel.Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 20);  // Tamaño de la fuente

        // Crear un estilo de celda
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(font);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);  // Centrar el texto
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);  // Centrar verticalmente
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);  // Fondo azul claro
        headerStyle.setBorderBottom(BorderStyle.THIN);  // Borde inferior
        headerStyle.setBorderTop(BorderStyle.THIN);  // Borde superior
        headerStyle.setBorderLeft(BorderStyle.THIN);  // Borde izquierdo
        headerStyle.setBorderRight(BorderStyle.THIN);  // Borde derecho

        // Crear la fila de encabezado
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Clave Libro", "Nombre", "Categoria","Editorial", "Autor", "Num página", "Cantidad"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Crear un estilo para las celdas de datos
        CellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setAlignment(HorizontalAlignment.CENTER);
        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dataStyle.setBorderBottom(BorderStyle.THIN);
        dataStyle.setBorderTop(BorderStyle.THIN);
        dataStyle.setBorderLeft(BorderStyle.THIN);
        dataStyle.setBorderRight(BorderStyle.THIN);

        // Llenar los datos en las filas
        int rowNum = 1;
        while (rs.next()) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(rs.getInt("id_libro"));
            row.createCell(1).setCellValue(rs.getString("nombreLibro"));
            row.createCell(2).setCellValue(rs.getString("categoriaLibro"));
            row.createCell(3).setCellValue(rs.getString("editorial"));
            row.createCell(4).setCellValue(rs.getString("autor"));
            row.createCell(5).setCellValue(rs.getInt("numeroPagina"));
            row.createCell(6).setCellValue(rs.getInt("cantidad"));
           

            // Aplicar el estilo a cada celda
            for (int i = 0; i < 7; i++) {
                row.getCell(i).setCellStyle(dataStyle);
            }
        }

        // Ajustar el ancho de las columnas
        for (int i = 0; i < 7; i++) {
            sheet.autoSizeColumn(i);
        }

        // Definir la ruta donde se guardará el archivo
        String ruta = "C:/Users/Dell/Documents/reporteLibro.xlsx";
        File archivo = new File(ruta);

        // Guardar el archivo Excel
        try (FileOutputStream fileOut = new FileOutputStream(archivo)) {
            workbook.write(fileOut);
            JOptionPane.showMessageDialog(null, "Reporte generado con éxito en " + archivo.getAbsolutePath());
        }
        
        
        // Preguntar al usuario si desea abrir el archivo
            int abrir = JOptionPane.showConfirmDialog(null, "¿Desea abrir el reporte?", "Abrir archivo", JOptionPane.YES_NO_OPTION);
            if (abrir == JOptionPane.YES_OPTION) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(archivo);
                } else {
                    JOptionPane.showMessageDialog(null, "Abrir archivo no es compatible en este sistema.");
                }
            }
        

    } catch (SQLException | IOException e) {
        JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + e.getMessage());
        e.printStackTrace();
    } 
}

    
}
