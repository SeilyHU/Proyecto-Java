/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacionpf;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
/**
 *
 * @author seily
 */
public class FacturaCompras extends javax.swing.JFrame {
    public static Connection con1 = facturacionpf.ConeccionP.getconexion();
    public static Statement stmt = null;
    public static Statement inserta = null;
    public static ResultSet allArticulos=null;
    public static ResultSet Producto ;
    public static ResultSet Prod ;
    public static ResultSet allProveedor=null;
    public int conteo = 0;
    public double total = 0.0;
    /**
     * Creates new form FacturaCompras
     */
    public FacturaCompras() {
        initComponents();
        this.setLocationRelativeTo(this);
        SetImageLabel(jLabel6,"src/image/LogoPrograNegro.png");
        this.GetProveedor();
        this.GetArticulos();
    }
    
       public void GetProveedor(){
      try {
          
         stmt = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         String sql = "SELECT ProveedorID, NombreProveedor from Proveedores order by ProveedorID";
         allProveedor = stmt.executeQuery(sql);  
          System.out.println(allProveedor);
        // rs.row();
        } catch (SQLException ex) {
            //Logger.getLogger(Conectarse.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Error: " + ex);
        }
          
        try {
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while(allProveedor.next()){
                model.addElement(allProveedor.getString("NombreProveedor"));
            }
            System.out.println(model);
            JComboBoxProveedor.setModel(model);
        } catch (SQLException ex) {
            //Logger.getLogger(Conectarse.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Error: " + ex);
        }
    }
       public void GetArticulos(){
      try {
         stmt = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         String sql = "SELECT ArticuloID,NombreArticulo,PrecioCompra from Articulos order by ArticuloID";
         allArticulos = stmt.executeQuery(sql);  
          System.out.println(allArticulos);
        // rs.row();
        } catch (SQLException ex) {
            //Logger.getLogger(Conectarse.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Error: " + ex);
        }
          
        try {
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while(allArticulos.next()){
                model.addElement(allArticulos.getString("NombreArticulo"));
            }
            System.out.println(model);
            JComboBoxArticulos.setModel(model);
        } catch (SQLException ex) {
            //Logger.getLogger(Conectarse.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Error: " + ex);
        }
    }
    
      public ResultSet GetArtuculosAllData(String nombre) {
      try {
          System.out.println("Error: " + nombre );
          
         stmt = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         String sql = "SELECT ArticuloID,NombreArticulo,PrecioCompra from Articulos where NombreArticulo = '" + nombre + "'";
         System.out.println(sql );
         Producto = stmt.executeQuery(sql);  
          System.out.println(Producto);
      
        // rs.row();
        } catch (SQLException ex) {
            //Logger.getLogger(Conectarse.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Error: " + ex);
        }
      
      return Producto;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label6 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalleFactura = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        textFieldCantidad = new java.awt.TextField();
        jButton3 = new javax.swing.JButton();
        label5 = new java.awt.Label();
        label9 = new java.awt.Label();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        label1 = new java.awt.Label();
        JComboBoxProveedor = new javax.swing.JComboBox<>();
        JComboBoxArticulos = new javax.swing.JComboBox<>();
        jButtonCrearProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(251, 168, 52));

        label6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label6.setName("ArticuloID"); // NOI18N
        label6.setText("ID Articulo");

        jTableDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableDetalleFactura);

        jButton4.setBackground(new java.awt.Color(51, 58, 115));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Cancelar Creacion");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        textFieldCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textFieldCantidad.setName("txt_Cantidad"); // NOI18N
        textFieldCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCantidadActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 58, 115));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Guardar Factura");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        label5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label5.setName("Cantidad"); // NOI18N
        label5.setText("Cantidad");

        label9.setFont(new java.awt.Font("Berlin Sans FB", 1, 36)); // NOI18N
        label9.setText("Factura de Compras");

        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton2.setBackground(new java.awt.Color(51, 58, 115));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Borrar Producto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label1.setName("ProveedorID"); // NOI18N
        label1.setText("ID Proveedor");

        JComboBoxProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JComboBoxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxProveedorActionPerformed(evt);
            }
        });

        JComboBoxArticulos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JComboBoxArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxArticulosActionPerformed(evt);
            }
        });

        jButtonCrearProducto.setBackground(new java.awt.Color(51, 58, 115));
        jButtonCrearProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonCrearProducto.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCrearProducto.setText(" Crear Producto");
        jButtonCrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JComboBoxArticulos, 0, 156, Short.MAX_VALUE)
                                .addComponent(JComboBoxProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(33, 33, 33)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonCrearProducto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JComboBoxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JComboBoxArticulos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2)
                                .addComponent(jButtonCrearProducto))
                            .addComponent(label5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(14, 14, 14))
        );

        textFieldCantidad.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
             DefaultTableModel modelTable = (DefaultTableModel) jTableDetalleFactura.getModel();
        double subtotal = (double) modelTable.getValueAt(jTableDetalleFactura.getSelectedRow(), 4);
        modelTable.removeRow(jTableDetalleFactura.getSelectedRow());
        total = total - subtotal;
        conteo = conteo - 1;
        modelTable.setNumRows(conteo);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void JComboBoxArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxArticulosActionPerformed
        // TODO add your handling code here:
        // Articulo
        System.out.println(JComboBoxArticulos.getSelectedIndex());
        System.out.println("evt: " + evt);
    }//GEN-LAST:event_JComboBoxArticulosActionPerformed

    private void JComboBoxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxProveedorActionPerformed
        // TODO add your handling code here:
        // Proveedor
        System.out.println(JComboBoxProveedor.getSelectedIndex());
        System.out.println("evt: " + evt);
    }//GEN-LAST:event_JComboBoxProveedorActionPerformed

    private void jButtonCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearProductoActionPerformed
        // TODO add your handling code here:
         DefaultTableModel modelTable = (DefaultTableModel) jTableDetalleFactura.getModel();
            String[] tableColumnsName = {"ArticuloID ","Nombre_Producto","Precio_Compra","Cantidad","Subtotal"}; 
             //jTableDetalleFactura.getColumn("Accion").setCellRenderer(new BotonRenderizado());
            // jTableDetalleFactura.getColumn("Accion").setCellEditor(new UpdateItem());
            modelTable.setColumnIdentifiers(tableColumnsName);
            
            Connection connection = ConeccionP.getconexion();
              int ArticuloID = 0;
              double Precio_Compra = 0.0;
              int Cantidad = Integer.valueOf(textFieldCantidad.getText());
              double Subtotal= 0.0;
              String NombreProducto = "";
              String sql = "SELECT ArticuloID,NombreArticulo,PrecioCompra from Articulos where NombreArticulo = '" + JComboBoxArticulos.getSelectedItem().toString() + "'";
             System.out.println(sql);
              try {
             PreparedStatement selectStatement = connection.prepareStatement(sql);
             ResultSet prod = selectStatement.executeQuery();
             while (prod.next())
             {
              ArticuloID = prod.getInt("ArticuloID");
              Precio_Compra = prod.getDouble("PrecioCompra");
              NombreProducto = prod.getString("NombreArticulo");
             
             }
            selectStatement.close();
            connection.close();
         } catch (SQLException ex) {
             Logger.getLogger(FacturaCompras.class.getName()).log(Level.SEVERE, null, ex);
         }
            Subtotal = Precio_Compra * Cantidad;
            total = Subtotal + Subtotal;
            modelTable.setNumRows(conteo);
            modelTable.addRow(new Object[] {ArticuloID,NombreProducto, Precio_Compra, Cantidad, Subtotal});
           
            conteo = conteo + 1;
            jTableDetalleFactura.setModel(modelTable);
    
    }//GEN-LAST:event_jButtonCrearProductoActionPerformed

    private void textFieldCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCantidadActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         Connection connection = ConeccionP.getconexion();
        DefaultTableModel modelTable = (DefaultTableModel) jTableDetalleFactura.getModel();
        //toma datos proveedor
           int ProveedorID = 0;
           int FacturaID = 0;
              String sql = "SELECT ProveedorID from Proveedores where NombreProveedor = '" + JComboBoxProveedor.getSelectedItem().toString() + "'";
             System.out.println(sql);
              try {
             PreparedStatement selectStatement = connection.prepareStatement(sql);
             ResultSet prod = selectStatement.executeQuery();
             while (prod.next())
             {
              ProveedorID = prod.getInt("ProveedorID");
             }
             selectStatement.close();
            
         } catch (SQLException ex) {
             Logger.getLogger(FacturaCompras.class.getName()).log(Level.SEVERE, null, ex);
         }
        //ingresa encabezado
         try {
             LocalDate fechaActual = LocalDate.now();
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String fechaString = fechaActual.format(formatoFecha);
            
             String sql1 = "exec sp_factura_compra "+ ProveedorID + ", " + total + ", '" + fechaString + "'";
             System.out.println(sql1);
              
             PreparedStatement selectStatement = connection.prepareStatement(sql1);
             ResultSet Producto = selectStatement.executeQuery();
             while (Producto.next())
             {
              FacturaID = Producto.getInt("idfactura");
             }
             selectStatement.close();
            System.out.println(FacturaID);
             
         } 
         catch (SQLException ex) {
             Logger.getLogger(FacturaCompras.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        //ingresa detalle factura
        try {
           
           for(int i = 0; i < jTableDetalleFactura.getRowCount();i++)
            {
                
             String sql1 = "exec sp_facturadetalle_compra " + FacturaID + ", " + jTableDetalleFactura.getValueAt(i, 0) + ", " + jTableDetalleFactura.getValueAt(i, 3) + " , " + jTableDetalleFactura.getValueAt(i, 2);
             System.out.println(sql1);
              
             PreparedStatement selectStatement = connection.prepareStatement(sql1);
             ResultSet Producto =  selectStatement.executeQuery();
             selectStatement.close();
            }
            connection.close();
            
            
         
             
         } 
         catch (SQLException ex) {
             Logger.getLogger(FacturaCompras.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        JOptionPane.showMessageDialog(null,"Factura Guardada Correctamente ");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String[] columnNames = {"ArticuloID", "Nombre_Producto", "Precio_Compra", "Cantidad", "Subtotal"}; // Nombres de las columnas
        DefaultTableModel model = new DefaultTableModel(columnNames, 0); // 0 filas
        jTableDetalleFactura.setModel(model);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FacturaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturaCompras().setVisible(true);
            }
        });
    }
    
    
    //Adapatar imagen
    public void SetImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT)); 
        labelName.setIcon(icon);
        labelName.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBoxArticulos;
    private javax.swing.JComboBox<String> JComboBoxProveedor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonCrearProducto;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDetalleFactura;
    private java.awt.Label label1;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label9;
    private java.awt.TextField textFieldCantidad;
    // End of variables declaration//GEN-END:variables
}
