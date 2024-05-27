/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import Controle.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author João
 */
public class VerificadorFases {
    private Connection conexao;
    private Aluno alunoLogado;
    
    public VerificadorFases(Connection conexao) {
        this.conexao = conexao;
        alunoLogado = Session.getInstance().getAlunoLogado();
    }
    
    public String verificarFase(int idRegiao, String tipoFase, int idAlunoLogado) {
        String estadoFase = "not completed";
        String sql = "SELECT a.nome, f.tipo AS faseTipo FROM fasesConcluidas fc " +
                     "JOIN fases f ON fc.idFase = f.idFase " +
                     "JOIN regioes r ON f.idRegiao = r.idRegiao " +
                     "JOIN alunos a ON fc.idAluno = a.idAluno " +
                     "WHERE r.idRegiao = ? AND f.tipo = ? AND a.idAluno = ?;";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idRegiao);
            pst.setString(2, tipoFase);
            pst.setInt(3, alunoLogado.getIdAluno());
            rs = pst.executeQuery();
            if (rs.next()) {
                estadoFase = "ok";
                if (!verificarConquista(idAlunoLogado, "Iniciando!")) {
                    inserirConquista(idAlunoLogado, "Iniciando!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return estadoFase;
    }

    public String[] verificarFases(int idRegiao, int idAlunoLogado) {
        String[] estadosFases = new String[4];
        estadosFases[0] = verificarFase(idRegiao, "Visual", idAlunoLogado);
        estadosFases[1] = verificarFase(idRegiao, "Números", idAlunoLogado);
        estadosFases[2] = verificarFase(idRegiao, "Ouvir", idAlunoLogado);
        estadosFases[3] = verificarFase(idRegiao, "Observacao", idAlunoLogado);

        // Verificar se todas as fases foram concluídas com sucesso
        boolean todasFasesConcluidas = true;
        for (String estado : estadosFases) {
            if (!"ok".equals(estado)) {
                todasFasesConcluidas = false;
                break;
            }
        }

        // Verificar se a conquista "A todo vapor!" já foi concedida
        boolean conquistaJaConcedida = verificarConquista(idAlunoLogado, "A todo vapor!");

        // Se todas as fases estiverem concluídas e a conquista ainda não foi concedida, conceda a conquista
        if (todasFasesConcluidas && !conquistaJaConcedida) {
            inserirConquista(idAlunoLogado, "A todo vapor!"); // Nome da conquista a ser inserida
        }

        return estadosFases;
    }

    private void inserirConquista(int idAluno, String nomeConquista) {
        String sqlConquista = "INSERT INTO alunosXconquistas (idConquista, idAluno) " +
                              "SELECT c.idConquista, ? FROM conquistas c " +
                              "WHERE c.nomeConquista = ?;";
        PreparedStatement pst = null;
        try {
            pst = conexao.prepareStatement(sqlConquista);
            pst.setInt(1, idAluno);
            pst.setString(2, nomeConquista);
            inserirNotificacao(nomeConquista);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private boolean verificarConquista(int idAluno, String nomeConquista) {
        String sql = "SELECT COUNT(*) FROM alunosXconquistas axc " +
                     "JOIN conquistas c ON axc.idConquista = c.idConquista " +
                     "WHERE axc.idAluno = ? AND c.nomeConquista = ?;";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idAluno);
            pst.setString(2, nomeConquista);
            rs = pst.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return false;
    }
    
     private void inserirNotificacao(String nomeConquista){
        String sql = "insert into notificacoes(idAluno, notificacao, descNotificacao, iconNotificacao) values"
                + "(?,?,?,?)";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, alunoLogado.getIdAluno());
            pst.setString(2, "Conquista Desbloqueada");
            pst.setString(3, "Voce desbolqueou a conquista " + nomeConquista);
            pst.setString(4, "icon-trofeu.png");
            pst.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
