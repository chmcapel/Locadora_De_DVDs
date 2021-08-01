/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;


/**
 *
 * @author A D E P T
 */
public class Connect {
    
    public Statement stm; //responsavel por pesquisas.
    public ResultSet rs;  // responsavel por guardar as pesquisas.
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5432/APS_Locadora_De_DVDs";
    private String user = "postgres";
    private String password = "Adeptzera@";
    public Connection connect;  // responsavel pela conexão.
    
    
    public void Connection(){        // responsavel por realizar a conexão com o bd.
        try {            
            System.setProperty("jdbc.Drivers", driver);
            connect = DriverManager.getConnection(url, user, password);
//            JOptionPane.showMessageDialog(null, "Successfully connected.");                    
        } catch (SQLException ex) {            
//            JOptionPane.showMessageDialog(null, "Connection fail.\n"+ex);            
        }
    }
        
    public void Disconnect(){     // responsavel para desconectar do bd.
   
        try {
            connect.close();
//            JOptionPane.showMessageDialog(null, "Disconnected.");
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Connection fail.\n"+ex.getMessage());
        }            
    }

    public void executaSql(String sql) {
        
            
        try {
            stm = connect.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
        
        }
    }
}