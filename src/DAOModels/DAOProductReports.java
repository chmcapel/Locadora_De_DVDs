/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOModels;

import DAO.Connect;
import Models.ProductModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author A D E P T
 */
public class DAOProductReports {
    
    Connect connect = new Connect();
    ProductModel productModel = new ProductModel();
    
    
   public void Salvar(ProductModel mod) {
        connect.Connection();
        
        try {
            
            PreparedStatement pst = connect.connect.prepareStatement("INSERT INTO tb_products(product_name, product_gender, product_synopsis) VALUES(?,?,?)");
            pst.setString(1, mod.getProduct_name());
            pst.setString(2, mod.getProduct_gender());
            pst.setString(3, mod.getProduct_synopsis());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar realizar o cadastro de produto!/nErro:"+ex);
        }
        
        connect.Disconnect();
    }
    
    public ProductModel searchUser(ProductModel mod) {
        connect.Connection();        
        connect.executaSql("SELECT *FROM tb_products WHERE product_name ='%"+mod.getSearch()+"%'");
        
        try {
                connect.rs.first();
                mod.setProduct_id(connect.rs.getInt("product_id"));
                mod.setProduct_name(connect.rs.getString("product_name"));
                mod.setProduct_gender(connect.rs.getString("product_gender"));
                mod.setProduct_synopsis(connect.rs.getString("product_synopsis"));                
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha na busca!/nErro:"+ex);
            }    
        connect.Disconnect();
        return mod;
    } 
}
