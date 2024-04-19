
package Modelagem;

import Controle.Conexao;
import java.sql.*;
import javax.swing.JOptionPane;

public class AlunoLogado {
    private int idAlunoLogado;
    private int idAluno;
    private String nome;
    private String usuario;
    private String senha;
    private String email;
    private String dataNasc;
    private int idade;
    private double pontosTotais;
    private int fasesConcluidas;
    
    //importar classe conexao
    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public AlunoLogado() {
        this(0,0,"","","","","",0,0.0,0);
    }

    public AlunoLogado(int idAlunoLogado, int idAluno, String nome, String usuario, String senha, String email, String dataNasc, int idade, double pontosTotais, int fasesConcluidas) {
        this.idAlunoLogado = idAlunoLogado;
        this.idAluno = idAluno;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.dataNasc = dataNasc;
        this.idade = idade;
        this.pontosTotais = pontosTotais;
        this.fasesConcluidas = fasesConcluidas;
        
    }

    public int getIdAlunoLogado() {
        return idAlunoLogado;
    }

    public void setIdAlunoLogado(int idAlunoLogado) {
        this.idAlunoLogado = idAlunoLogado;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
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

    public double getPontosTotais() {
        return pontosTotais;
    }

    public void setPontosTotais(double pontosTotais) {
        this.pontosTotais = pontosTotais;
    }

    public int getFasesConcluidas() {
        return fasesConcluidas;
    }

    public void setFasesConcluidas(int fasesConcluidas) {
        this.fasesConcluidas = fasesConcluidas;
    }
    
    public void cadastrarLogin(){
        conexao = Conexao.conecta();
        String sql;
        sql = "insert into alunoLogado(idAlunoLogado, idAluno, nome, usuario, senha, email, dataNasc, idade, pontosTotais, fasesConcluidas) values"
                + "(?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, 1);
            pst.setInt(2, getIdAluno());
            pst.setString(3, getNome());
            pst.setString(4, getUsuario());
            pst.setString(5, getSenha());
            pst.setString(6, getEmail());
            pst.setString(7, getDataNasc());
            pst.setInt(8, getIdade());
            pst.setDouble(9, getPontosTotais());
            pst.setInt(10, getFasesConcluidas());
            pst.executeUpdate();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void fecharLogin(){
        try {
            conexao = Conexao.conecta();
            String sql;
            sql = "delete from alunoLogado where idAlunoLogado = ?";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, 1);
            pst.executeUpdate();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
