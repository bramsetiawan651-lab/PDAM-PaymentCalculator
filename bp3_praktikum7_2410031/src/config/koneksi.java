/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author THINKPAD
 */
public class koneksi {
         private static Connection conn;
   public static Connection getConnection() {
    if(conn==null){
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/bp3_praktikum7_2410031";
            String user = "root";
            String pass = "";
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal" + e);
        }
    }   
       return conn;
   }
}
