
package Modelagem;

import Controle.Conexao;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Alunos {
    private int idAluno;
    private String nome;
    private String usuario;
    private String senha;
    private String email;
    private String dataNasc;
    private String foto;
    
    //importar classe conexao
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    Calendar c = Calendar.getInstance();

    public Alunos() {
        this(0,"","","","","","");
    }

    public Alunos(int idAluno, String nome,String usuario, String senha, String email, String dataNasc, String foto) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.dataNasc = dataNasc;
        this.foto = foto;
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
    
    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
   
    public void cadastrar(){
        conexao = Conexao.conecta();
        String sql;
        sql = "insert into alunos(nome, usuario, senha, email, dataNasc, pontosTotais, fasesConcluidas, foto) values"
                + "(?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, getNome());
            pst.setString(2, getUsuario());
            pst.setString(3, getSenha());
            pst.setString(4, getEmail());
            pst.setString(5, getDataNasc());
            pst.setDouble(6, 0);
            pst.setInt(7, 0);
            pst.setString(8, getFoto());
            int linhasAfetadas = pst.executeUpdate();
            
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum dado foi inserido.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void alterar(){
        conexao = Conexao.conecta();
        String sql;
        sql = "update alunos set nome = ?, usuario = ?, senha = ?, email = ?, dataNasc = ? where idAluno = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, getNome());
            pst.setString(2, getUsuario());
            pst.setString(3, getSenha());
            pst.setString(4, getEmail());
            pst.setString(5, getDataNasc());
            pst.setInt(6, getIdAluno());
            int linhasAfetadas = pst.executeUpdate();
            
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum dado foi inserido.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
}
