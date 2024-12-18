/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facturacionpf;

/**
 *
 * @author seily
 */


import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import javax.swing.JOptionPane;


public class ConeccionP {
    static Connection conectar = null;
     public static Connection getconexion()
     {                  
       //String url = "jdbc:jtds:sqlserver://BYRONRODRIG210F;instance=SQLEXPRESS;DatabaseName=Test";
       String url = "jdbc:jtds:sqlserver://DESKTOP-86HURG3;instance=SQLEXPRESS;DatabaseName=FacturacionBodega";
       try {
           
          Class.forName("net.sourceforge.jtds.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           JOptionPane.showMessageDialog(null,"error de conexion, verificar driver" + e.getMessage(),
                   "Error al conectar", JOptionPane.ERROR_MESSAGE);
       }
       try {
           conectar = DriverManager.getConnection(url,"sa","seilysql03");
       } catch(SQLException e){
           JOptionPane.showMessageDialog(null,"error al conectar con DB" + e.getMessage(),
                   "Error al conectar 01", JOptionPane.ERROR_MESSAGE);
       }
       return conectar;
     }
}
