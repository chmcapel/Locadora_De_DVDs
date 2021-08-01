/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOModels;

import DAO.Connect;
import Models.RentModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author A D E P T
 */
public class DAORent {
    
    Connect connect = new Connect();
    RentModel rentModel = new RentModel();
    
    public void Salvar(RentModel mod) {
        connect.Connection();
        
        try {
            
            PreparedStatement pst = connect.connect.prepareStatement("INSERT INTO tb_rents(client_name, product_name, rent_date, rent_delivery_date) VALUES(?,?,?,?)");
            pst.setString(1, mod.getClient_name());
            pst.setString(2, mod.getProduct_name());
            pst.setString(3, mod.getRent_date());
            pst.setString(4, mod.getRent_delivery_date());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Locação realizada com sucesso!");
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar realizar o cadastro de produto!/nErro:"+ex);
        }
        
        connect.Disconnect();
    }
    
    public void Delete(RentModel mod) {
        connect.Connection();
        
        try {
            PreparedStatement pst = connect.connect.prepareStatement("DELETE FROM tb_rents WHERE product_name=?");
            pst.setString(1, mod.getProduct_name());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Devolução realizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a devolução!/nErro: "+ex);
        }
    }
    
    public RentModel searchUser(RentModel mod) {
        connect.Connection();        
        connect.executaSql("SELECT *FROM tb_rents WHERE rent_id ='%"+mod.getSearch()+"%'");
        
        try {
                connect.rs.first();
                mod.setRent_id(connect.rs.getInt("rent_id"));
                mod.setClient_name(connect.rs.getString("client_name"));
                mod.setProduct_name(connect.rs.getString("product_name"));
                mod.setRent_date(connect.rs.getString("rent_date"));
                mod.setRent_delivery_date(connect.rs.getString("rent_delivery_date"));                
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha na busca!/nErro:"+ex);
            }    
        connect.Disconnect();
        return mod;
    }
    
}
