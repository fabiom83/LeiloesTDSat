/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    conectaDAO conectaDAO = new conectaDAO();
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    String sql;
    
    public void cadastrarProduto (ProdutosDTO produto) {
        
        conn = conectaDAO.connectDB();
        sql = "INSERT INTO produtos (nome, valor, status) VALUES (?,?,?)";
        try {
            conn = new conectaDAO().connectDB();
            prep = conn.prepareStatement(sql);
            prep.setString(1, produto.getNome().toUpperCase());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            prep.executeUpdate();
            conectaDAO.desconectar();
            
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar. Verifique se os Dados de Acesso ao BD " + ex.getMessage());
            conectaDAO.desconectar();
        
        }
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

