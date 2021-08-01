/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOModels;

import DAO.Connect;
import Models.ClientModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author A D E P T
 */
public class DAOClient {
    
    Connect connect = new Connect();
    ClientModel clientModel = new ClientModel();
    
    public void Salvar(ClientModel mod) {
        connect.Connection();
        
        try {
            
            PreparedStatement pst = connect.connect.prepareStatement("INSERT INTO tb_clients (client_name, client_cpf, client_address, client_address_number, client_phone) VALUES(?,?,?,?,?)");
            pst.setString(1, mod.getClient_name());
            pst.setString(2, mod.getClient_cpf());
            pst.setString(3, mod.getClient_address());
            pst.setString(4, mod.getClient_address_number());
            pst.setString(5, mod.getClient_phone());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar realizar o cadastro do cliente!/nErro:"+ex);
        }
        
        connect.Disconnect();
    }





    public ClientModel searchUser(ClientModel mod) {
        connect.Connection();        
        connect.executaSql("SELECT *FROM tb_clients WHERE client_cpf ='%"+mod.getSearch()+"%'");
        
        try {
                connect.rs.first();
                mod.setClient_name(connect.rs.getString("client_name"));
                mod.setClient_cpf(connect.rs.getString("client_cpf"));
                mod.setClient_address(connect.rs.getString("client_address"));
                mod.setClient_address_number(connect.rs.getString("client_address_number"));
                mod.setClient_phone(connect.rs.getString("client_phone"));
                
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha na busca!/nErro:"+ex);
            }    
        connect.Disconnect();
        return mod;
    }
}
