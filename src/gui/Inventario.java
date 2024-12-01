package gui;

import controlador.bd.Crud;
import controlador.bd.Sql3;
import controlador.user.ControladorImpresion;
import controlador.user.ControladorTabla;
import controlador.user.ControladorVentana;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import controlador.bd.Conexion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.InventarioLibros;
import gui.RegistroLibro;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class Inventario extends javax.swing.JFrame {

    Crud crud;
    private Conexion conexion;

    private int idSeleccionado = -1;
    Alumnos examinarAlumno;
    InventarioLibros invL;

    DefaultTableModel modelo;
    private int idFilaTemporal;
    ControladorImpresion contEx;

    public Inventario() {

        
        initComponents();
        estiloBuscador();
        estiloTabla();
        this.setTitle("Inventario");
        this.crud = new Crud();
        this.modelo = new DefaultTableModel();
        this.mostrarInventario();

        this.setExtendedState(MAXIMIZED_BOTH);
        ControladorVentana.ExitConfirmation(this);

    }
    

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtBuscador = new javax.swing.JTextField();
        btnBuscador = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        impDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar libros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 12), new java.awt.Color(17, 152, 85))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscadorKeyTyped(evt);
            }
        });
        jPanel1.add(txtBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 680, 40));

        btnBuscador.setForeground(new java.awt.Color(17, 152, 85));
        btnBuscador.setText("Buscar");
        btnBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscadorActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, -1, 40));

        tblInventario.setForeground(new java.awt.Color(17, 152, 85));
        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblInventario.getTableHeader().setReorderingAllowed(false);
        tblInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInventario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1160, 290));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(17, 152, 85));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Clave del libro:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 100, 40));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 1240, 430));

        jPanel3.setBackground(new java.awt.Color(17, 152, 85));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setForeground(new java.awt.Color(17, 152, 85));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salida.png"))); // NOI18N
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 0, 200, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 30));

        jLabel2.setBackground(new java.awt.Color(0, 51, 153));
        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(17, 152, 85));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/libro.png"))); // NOI18N
        jLabel2.setText("Inventario");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 420, 90));

        btnGuardar.setBackground(new java.awt.Color(204, 255, 0));
        btnGuardar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setOpaque(true);
        btnGuardar.setSelected(true);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 610, 150, 70));

        btnActualizar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(17, 152, 85));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 610, 160, 70));

        btnEliminar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(17, 152, 85));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash2.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 610, 170, 70));

        impDatos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        impDatos.setForeground(new java.awt.Color(17, 152, 85));
        impDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-microsoft-excel-2019-48(@1×).png"))); // NOI18N
        impDatos.setText("Generar reporte");
        impDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                impDatosActionPerformed(evt);
            }
        });
        jPanel2.add(impDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 610, 210, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        VentanaPrincipal newframe = new VentanaPrincipal();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

//        tblInventario.setEnabled(true);
//        btnGuardar.setEnabled(true);

    }//GEN-LAST:event_btnGuardarMouseClicked

    private void tblInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventarioMouseClicked

        int fila = this.tblInventario.getSelectedRow();
        idSeleccionado = Integer.parseInt(tblInventario.getValueAt(fila, 0).toString());
        ControladorTabla.getInstance().setIdSeleccionado(idSeleccionado);
        System.out.println("fila = " + fila);
    }//GEN-LAST:event_tblInventarioMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        tblInventario.setEnabled(true);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

tblInventario.setEnabled(false);
btnGuardar.setEnabled(false);

if (tblInventario.getSelectedRow() == -1) { // Validar si se seleccionó un registro
    JOptionPane.showMessageDialog(null, "Error, no seleccionó un registro");
    tblInventario.setEnabled(true);  // Volver a habilitar si no hay acción
    btnGuardar.setEnabled(true);
} else {
    // Crear y mostrar la ventana de actualización como un JDialog
    int fil = tblInventario.getSelectedRow();

    int idSeleccionado = Integer.parseInt(tblInventario.getValueAt(fil, 0).toString());
    String stock = tblInventario.getValueAt(fil, 1).toString();
    String cantidad = tblInventario.getValueAt(fil, 2).toString();

    // Abrir el diálogo
    ModificarInventario actInv = new ModificarInventario(this, true); // JDialog modal
    actInv.setDatos(stock, cantidad); // Método para enviar datos al diálogo
    actInv.setVisible(true);
    
    mostrarInventario();

    // Rehabilitar componentes después de cerrar el diálogo
    tblInventario.setEnabled(true);
    btnGuardar.setEnabled(true);
}
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

boolean resultado = false;

if (tblInventario.getSelectedRow() == -1) {
    JOptionPane.showMessageDialog(null, "Error no seleccionó un registro");
} else {
    int respuesta = JOptionPane.showConfirmDialog(
        null, 
        "¿Está seguro de que desea eliminar este registro?", 
        "Confirmar eliminación", 
        JOptionPane.YES_NO_OPTION
    );

    if (respuesta == JOptionPane.YES_OPTION) {
        // Proceder con la eliminación
        resultado = this.crud.actualizarEliminar(Sql3.eliminarInventario(this.idSeleccionado));

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Eliminado");
            mostrarInventario();
        } else {
            JOptionPane.showMessageDialog(null, "No eliminado");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Operación cancelada");
    }
}

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscadorActionPerformed
        // TODO add your handling code here:

        if (evt.getSource() == this.btnBuscador) {
            buscar();
        }
    }//GEN-LAST:event_btnBuscadorActionPerformed

    private void txtBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyTyped
        // TODO add your handling code here:

        if (this.txtBuscador.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Limite de caracteres alcanzado", "Longitud de caracteres", JOptionPane.INFORMATION_MESSAGE);

        }

        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "No puede ingresar letras", "Tipo de entrada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_txtBuscadorKeyTyped

    private void impDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_impDatosActionPerformed
         

        ControladorImpresion.generarReporte(tblInventario);
        RegistroLibro newLibro = new RegistroLibro();
        try {
            ControladorImpresion.generarReporteLibros(newLibro.tblLibros);
        } catch (IOException ex) {
            System.out.println("Error al generar reporte = " +ex);
        }

        
        


    }//GEN-LAST:event_impDatosActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscador;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton impDatos;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables

    protected void mostrarInventario() {

        this.modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas sean no editables
            }
        };

        this.modelo.addColumn("Clave inventario");
        this.modelo.addColumn("Stock");
        this.modelo.addColumn("Cantidad Disponible");
        this.modelo.addColumn("ID Libro");
//        this.modelo.addColumn("Estado");

        try {
            ResultSet resultado = this.crud.seleccionar(Sql3.seleccionarInventario());

            while (resultado.next()) {  //usar objeto resultado y el metodo next que permitira iterar entre todos los resultados

                Object[] alumnos = { //objeto que se anexara al modelo

                    resultado.getInt(1),
                    resultado.getInt(2), //Stock
                    resultado.getInt(3),
                    resultado.getInt(4) // ID Libro
//                    resultado.getInt(5)
//                    resultado.getString(4)
                };

                modelo.addRow(alumnos);

            }//cierra while

            this.tblInventario.setModel(modelo);

        } catch (SQLException e) {
            System.out.println("error " + e.getMessage());
        }

    }// cierra metodo mostrar

    private void buscar() {
        try {
            int idBuscar = Integer.parseInt(this.txtBuscador.getText());
            int filas = this.modelo.getRowCount();
//              int filas = this.tblInventario.getSelectedRow();
//            boolean encontrado = false;
            if (idBuscar != -1) {
                for (int i = 0; i < filas; i++) {
                    
//                    int idModelo = Integer.parseInt(tblInventario.getValueAt(i, 0).toString());
                    idSeleccionado = Integer.parseInt(tblInventario.getValueAt(i, 0).toString());
                    if (idSeleccionado == idBuscar) {
                        this.idSeleccionado = i;
                        this.tblInventario.setRowSelectionInterval(i, i);
                        this.tblInventario.scrollRectToVisible(this.tblInventario.getCellRect(i, 0, true));
                        ControladorTabla.getInstance().setIdSeleccionado(idSeleccionado);

//                        encontrado = true;
                        System.out.println(idSeleccionado);
                        return;
                    }
                }

            }
            JOptionPane.showMessageDialog(null, "Número no encontrado",
                    "Error", JOptionPane.ERROR_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Formato invalido",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        } //cierra catch
    } //cierra buscar

    public String getTableData(DefaultTableModel modelo) {
        StringBuilder data = new StringBuilder();
        int columnCount = modelo.getColumnCount();
        int rowCount = modelo.getRowCount();

        // Obtener los nombres de las columnas
        for (int i = 0; i < columnCount; i++) {
            data.append(modelo.getColumnName(i)).append("\t");
        }
        data.append("\n");

        // Obtener las filas
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                data.append(modelo.getValueAt(i, j)).append("\t");
            }
            data.append("\n");
        }
        System.out.println("rowCount = " + rowCount);
        return data.toString();
    }
    
    
    
    // Método para verificar la disponibilidad de un libro antes de prestar
public boolean verificarDisponibilidad(int idLibro) {
    int cantidadDisponible = obtenerCantidadDisponible(idLibro);
    return cantidadDisponible > 0;
}

// Método para obtener la cantidad disponible de un libro
public int obtenerCantidadDisponible(int idLibro) {
    int cantidadDisponible = 0;
    String query = "SELECT cantidadDisponible FROM inventario WHERE id_libro = " + idLibro;
    try (Statement stmt = Conexion.conexion.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
        if (rs.next()) {
            cantidadDisponible = rs.getInt("cantidadDisponible");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return cantidadDisponible;
}

private void estiloBuscador(){
    
    txtBuscador.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar...");
    
    txtBuscador.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("img/buscador.svg"));
     
    txtBuscador.putClientProperty(FlatClientProperties.STYLE, ""
        + "arc:13;"
        + "borderWidth:0;"
        + "focusWidth:0;"
        + "innerFocusWidth:0;"
        + "margin:5,20,5,20;"
        + "background:$Panel.background");
}

private void estiloTabla(){
    
     jScrollPane1.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background;");
    
     tblInventario.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
        + "height:30;"
        + "hoverBackground:null;"
        + "pressedBackground:null;"
        + "separatorColor:$TableHeader.background;"
        + "font:bold;");
     
     tblInventario.putClientProperty(FlatClientProperties.STYLE, ""
        + "rowHeight:30;"
        + "showHorizontalLines:true;"
        + "intercellSpacing:0,1;"
        + "cellFocusColor:$TableHeader.hoverBackground;"
        + "selectionBackground:$TableHeader.hoverBackground;"
        + "selectionForeground:$Table.foreground;");
    
    
}

//pendiente






}//class
