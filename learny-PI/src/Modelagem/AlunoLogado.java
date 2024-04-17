
package Modelagem;

import Controle.Conexao;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class AlunoLogado {
    private String nome;
    private String usuario;
    private String senha;
    private String email;
    private String dataNasc;
    private int idade;
    
    //importar classe conexao
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public AlunoLogado() {
        this("","","","","",0);
    }

    public AlunoLogado(String nome,String usuario, String senha, String email, String dataNasc, int idade) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.dataNasc = dataNasc;
        this.idade = idade;
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
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
   
    public void cadastrar(){
        conexao = Conexao.conecta();
        String sql;
        sql = "insert into alunoLogado(nome, usuario, senha, email, dataNasc, idade) values"
                + "(?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, getNome());
            pst.setString(2, getUsuario());
            pst.setString(3, getSenha());
            pst.setString(4, getEmail());
            pst.setString(5, getDataNasc());
            pst.setInt(6, getIdade());
            pst.executeUpdate();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
