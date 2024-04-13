/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author fatec-dsm2
 */
public class Conexao {
        
    static final String driver = "com.mysql.jdbc.Driver";
   
    static final String url= "jdbc:mysql://127.0.0.1/learnybd";
    
    static final String usuario="root";
    static final String senha="";
    private Connection conexao;// objeto que faz conexao com o banco
    public Statement statement;// objeto que abre caminho até o banco
    public ResultSet resultset;// objeto que armazena os comandos sql   
    
    public static Connection conecta() {  
        Connection conexao = null; 
  
        try {  
            Class.forName(driver);  
            conexao = DriverManager.getConnection(url,usuario,senha);
            //JOptionPane.showMessageDialog(null,"Conectou com o Banco de Dados");
            
        } catch(ClassNotFoundException Driver){
               JOptionPane.showMessageDialog(null,"Driver nao localizado: "+Driver);
               return conexao;
        }catch(SQLException Fonte) {
                JOptionPane.showMessageDialog(null,"Erro na conexão com a fonte de dados: "+Fonte);
            }
        return conexao;  
    }
    //comentario
     public void desconecta (){
        boolean result = true;
        try
        {
            conexao.close();
            //JOptionPane.showMessageDialog(null,"Banco fechado");
        }
        catch(SQLException fecha)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel fechar o banco de dados"+ fecha);
            result = false;
        }
    }
     
     public void executeSQL(String sql){
//chamada do metodo conecta para abrir a conexão com o db
        conecta();
        try{
    
        statement = conexao.createStatement();

        statement.execute(sql);
        //desconecta();
        }catch(SQLException sqle){
           JOptionPane.showMessageDialog(null, "Driver não encontrado1" + sqle.getMessage());
        }
}
    
    public ResultSet RetornarResultset(String sql){
         ResultSet resultSet = null;
         conecta();
         try{
         statement = conexao.createStatement();
         resultSet = statement.executeQuery(sql);
         resultSet.next();
         }catch (Exception e){
         JOptionPane.showMessageDialog(null, "Erro ao retornar resultset"+e.getMessage());
         }
         return resultSet;
 }
}
