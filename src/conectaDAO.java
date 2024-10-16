
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    Connection conn = null;
    
    public Connection connectDB(){
               
        try {
        
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11?user=root&password=1234");
            System.out.println("Conectado");
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();
            System.out.println("Conexão Encerrada com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Desconectar!");
        }
    }
    
}


