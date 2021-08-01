/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOModels;

import DAO.Connect;
import Models.UserModel;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author A D E P T
 */
public class DAOUser {
    
    Connect connect = new Connect();
    UserModel userModel = new UserModel();
    
    public void Salvar(UserModel mod) {
        connect.Connection();
        
        try {
            
            PreparedStatement pst = connect.connect.prepareStatement("insert into tb_users (user_name, user_password) values(?,?)");
            pst.setString(1, mod.getUser_name());
            pst.setString(2, mod.getUser_password());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar realizar o cadastro de usuário!/nErro:"+ex);
        }
        
        connect.Disconnect();
    }
    
    public UserModel searchUser(UserModel mod) {
        connect.Connection();        
        connect.executaSql("SELECT *FROM tb_users WHERE user_name ='%"+mod.getSearch()+"%'");
        
        try {
                connect.rs.first();
                mod.setUser_id(connect.rs.getInt("user_id"));
                mod.setUser_name(connect.rs.getString("user_name"));
                mod.setUser_password(connect.rs.getString("user_password"));
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha na busca!/nErro:"+ex);
            }    
        connect.Disconnect();
        return mod;
    }
}
