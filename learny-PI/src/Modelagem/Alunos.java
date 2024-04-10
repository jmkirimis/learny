
package Modelagem;

import Controle.Conexao;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Alunos {
    private String nome;
    private String usuario;
    private String senha;
    private String email;
    private String dataNasc;
    
    //importar classe conexao
    Conexao conaluno = new Conexao();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    Calendar c = Calendar.getInstance();

    public Alunos() {
        this("","","","","");
    }

    public Alunos(String nome,String usuario, String senha, String email, String dataNasc) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.dataNasc = dataNasc;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    
    public void cadastrar(){
        String sql;
        sql = "insert into alunos(nome, usuario, senha, email) values"
                + "('" + getNome() + "', '" + getUsuario() + "', '" + getSenha() + "', '" + getEmail() + "')";
        conaluno.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
    }
    
     public String logar() {
         
        String sql = "select * from alunos where usuario = '"+ getUsuario() +"' and senha = '" + getSenha() + "' ";
        rs = conaluno.RetornarResultset(sql);
        try {
            if(rs.next()){
                return "logado";
            }else{
                return "invalido";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Alunos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
     }
    
}
