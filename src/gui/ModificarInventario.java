
package gui;

import controlador.bd.Crud;
import controlador.bd.Sql3;
import controlador.user.ControladorTabla;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import modelo.InventarioLibros;

/**
 *
 * @author Dell
 */
public class ModificarInventario extends javax.swing.JDialog {

  private int id_seleccionado;
    Inventario inventario = new Inventario();
    InventarioLibros inventarioL;
    public ModificarInventario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Ustock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Ucant = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar inventario");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setBackground(new java.awt.Color(0, 51, 153));
        titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(17, 152, 85));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Modificar inventario");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 280, 40));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(17, 152, 85));
        jLabel5.setText("Stock:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 20));

        Ustock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UstockKeyTyped(evt);
            }
        });
        getContentPane().add(Ustock, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 101, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(17, 152, 85));
        jLabel6.setText("Cantidad disponible:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 130, 20));

        Ucant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UcantKeyTyped(evt);
            }
        });
        getContentPane().add(Ucant, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 211, 101, -1));

        guardar.setBackground(new java.awt.Color(204, 255, 0));
        guardar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        guardar.setForeground(new java.awt.Color(0, 0, 0));
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        getContentPane().add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 120, 30));

        cancelar.setBackground(new java.awt.Color(204, 255, 0));
        cancelar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        cancelar.setForeground(new java.awt.Color(0, 0, 0));
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UstockKeyTyped
        // TODO add your handling code here:

        if (this.Ustock.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Limite de caracteres alcanzado", "Longitud de caracteres", JOptionPane.INFORMATION_MESSAGE);

        }

        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "No puede ingresar letras", "Tipo de entrada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_UstockKeyTyped

    private void UcantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UcantKeyTyped
        // TODO add your handling code here:

        if (this.Ucant.getText().length() >= 30) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Limite de caracteres alcanzado", "Longitud de caracteres", JOptionPane.INFORMATION_MESSAGE);

        }

        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "No puede ingresar letras", "Tipo de entrada", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_UcantKeyTyped

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:

        if (this.Ustock.getText().isEmpty() || this.Ucant.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos", "Campos en blanco", JOptionPane.INFORMATION_MESSAGE);
        } else {

            this.inventarioL = new InventarioLibros();
            //recogemos los datos

            try {
                int stock = Integer.parseInt(this.Ustock.getText());
                inventarioL.setStock(stock);

                int cantDisponible = Integer.parseInt(this.Ucant.getText());
                inventarioL.setCantDisponible(cantDisponible); // Set the correct field
                id_seleccionado = ControladorTabla.getInstance().getIdSeleccionado();
                inventarioL.setId_inventario(id_seleccionado);

                //        inventarioL.setId_inventario();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos para stock y cantidad disponible", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;  // Exit the code block if input is invalid
            }

            Crud crud = new Crud();

            //ACTUALIZAR  EN LA BD
            boolean resultado = crud.actualizarEliminar(Sql3.actualizarinventario(inventarioL));

            if (resultado) {
                JOptionPane.showMessageDialog(null, "Actualizado exitosamente", "Actualización", JOptionPane.INFORMATION_MESSAGE);

                this.dispose();  // Cierra el formulario

                
                
//                Inventario inventario2 = new Inventario();
//                inventario2.setVisible(true);
                

            } else {
                JOptionPane.showMessageDialog(null, "No se actualizó correctamente", "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }

        }

    }//GEN-LAST:event_guardarActionPerformed

    
    
    // Método para establecer los datos iniciales en los campos
    public void setDatos(String stock, String cantidad) {
        Ustock.setText(stock);
        Ucant.setText(cantidad);
    }
    
    
    
    
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Ucant;
    public javax.swing.JTextField Ustock;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}