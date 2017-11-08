/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.fmy.spk.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Femmy
 */
public class DBConn {
    
    private Connection conn;
    
    public Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil load Drivernya");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("gagal load Drivernya " + ex);
        }
        
        try {
            String url = "jdbc:mysql://localhost:3306/sisgaji";//nama database yang akan dibuat
            conn = DriverManager.getConnection(url);
            System.out.println("Berhasil Konek ke database");
        } catch (SQLException ex){
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Konek ke database");
            JOptionPane.showMessageDialog(null, "Gagal Koneksi","Peringatan",
                    JOptionPane.WARNING_MESSAGE);
        }
        return conn;
    }
    
}
