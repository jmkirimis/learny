package Modelagem;

import Controle.Conexao;
import Visualizacao.AlertaGeral;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Aluno {

    private int idAluno;
    private String nome;
    private String usuario;
    private String senha;
    private String email;
    private String dataNasc;
    private int idade;
    private double pontosTotais;
    private int fasesConcluidas;
    private String foto;
    private String medalhaAtiva;
    private String ranque;

    private JFrame parentFrame;
    //importar classe conexao
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Aluno(JFrame parentFrame) {
        this(0, "", "", "", "", "", 0, 0.0, 0, "", "", "");
        this.parentFrame = parentFrame;
    }

    public Aluno(int idAluno, String nome, String usuario, String senha, String email, String dataNasc, int idade, double pontosTotais, int fasesConcluidas, String foto, String medalhaAtiva, String ranque) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.dataNasc = dataNasc;
        this.idade = idade;
        this.pontosTotais = pontosTotais;
        this.fasesConcluidas = fasesConcluidas;
        this.foto = foto;
        this.medalhaAtiva = medalhaAtiva;
        this.ranque = ranque;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getMedalhaAtiva() {
        return medalhaAtiva;
    }

    public void setMedalhaAtiva(String medalhaAtiva) {
        this.medalhaAtiva = medalhaAtiva;
    }

    public String getRanque() {
        return ranque;
    }

    public void setRanque(String ranque) {
        this.ranque = ranque;
    }

    public String cadastrar() {
        conexao = Conexao.conecta();
        String verificaSql = "SELECT COUNT(*) FROM alunos WHERE usuario = ?";
        String insertSql = "INSERT INTO alunos(nome, usuario, senha, email, dataNasc, pontosTotais, fasesConcluidas, foto, medalha, ranque) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Verifica se o usuário já existe
            pst = conexao.prepareStatement(verificaSql);
            pst.setString(1, getUsuario());
            rs = pst.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                ImageIcon icon = new ImageIcon("src/Imagens/icon-erro-cadastro.png");
                AlertaGeral alert = new AlertaGeral(parentFrame, icon, "Erro de Cadastro", "Usuário já cadastrado!", 50, 50);
                alert.setVisible(true);
            } else {
                // Insere os dados do novo aluno
                pst = conexao.prepareStatement(insertSql);
                pst.setString(1, getNome());
                pst.setString(2, getUsuario());
                pst.setString(3, getSenha());
                pst.setString(4, getEmail());
                pst.setString(5, getDataNasc());
                pst.setDouble(6, 0);
                pst.setInt(7, 0);
                pst.setString(8, getFoto());
                pst.setString(9, "");
                pst.setString(10, "");
                int linhasAfetadas = pst.executeUpdate();

                if (linhasAfetadas > 0) {
                    ImageIcon icon = new ImageIcon("src/Imagens/icone confirmar.png");
                    AlertaGeral alert = new AlertaGeral(parentFrame, icon, "Inserir Dados", "Dados cadastrados com sucesso!", 50, 50);
                    alert.setVisible(true);
                } else {
                    ImageIcon icon = new ImageIcon("src/Imagens/icone confirmar.png");
                    AlertaGeral alert = new AlertaGeral(parentFrame, icon, "Inserir Dados", "Nenhum dado foi inserido.", 50, 50);
                    alert.setVisible(true);
                }
                return "ok";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }

    public void alterar() {
        conexao = Conexao.conecta();
        String verificaSql = "SELECT COUNT(*) FROM alunos WHERE usuario = ? AND idAluno != ?";
        String updateSql = "UPDATE alunos SET nome = ?, usuario = ?, senha = ?, email = ?, dataNasc = ?, foto = ? WHERE idAluno = ?";

        try {
            // Verifica se o novo usuário já existe, excluindo o atual aluno que está sendo alterado
            pst = conexao.prepareStatement(verificaSql);
            pst.setString(1, getUsuario());
            pst.setInt(2, getIdAluno());
            rs = pst.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                ImageIcon icon = new ImageIcon("src/Imagens/icon-erro-cadastro.png");
                AlertaGeral alert = new AlertaGeral(parentFrame, icon, "Erro de Alteração", "Usuário já cadastrado!", 50, 50);
                alert.setVisible(true);
            } else {
                // Atualiza os dados do aluno
                pst = conexao.prepareStatement(updateSql);
                pst.setString(1, getNome());
                pst.setString(2, getUsuario());
                pst.setString(3, getSenha());
                pst.setString(4, getEmail());
                pst.setString(5, getDataNasc());
                pst.setString(6, getFoto());
                pst.setInt(7, getIdAluno());

                int linhasAfetadas = pst.executeUpdate();

                if (linhasAfetadas > 0) {
                    ImageIcon icon = new ImageIcon("src/Imagens/icone confirmar.png");
                    AlertaGeral alert = new AlertaGeral(parentFrame, icon, "Alterar Dados", "Dados alterados com sucesso!", 50, 50);
                    alert.setVisible(true);
                } else {
                    ImageIcon icon = new ImageIcon("src/Imagens/icon-confirmar.png");
                    AlertaGeral alert = new AlertaGeral(parentFrame, icon, "Alterar Dados", "Nenhum dado foi alterado.", 50, 50);
                    alert.setVisible(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void salvarMedalha() {
        conexao = Conexao.conecta();
        String sql;
        sql = "update alunos set medalha = ? where idAluno = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, getMedalhaAtiva());
            pst.setInt(2, getIdAluno());

            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
