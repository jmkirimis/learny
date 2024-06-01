/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import Controle.Conexao;
import Visualizacao.AlertaGeral;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author João
 */
public class VerificadorDiarias {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private Aluno alunoLogado;
    private JFrame parentFrame;

    public VerificadorDiarias(JFrame parentFrame) {
        alunoLogado = Session.getInstance().getAlunoLogado();
        conexao = Conexao.conecta();
        this.parentFrame = parentFrame;
    }

    public void verificarDiarias() {
        String sqlFasesConcluidas = "select count(*) as totalFases, tipo from fasesConcluidas join fases using(idFase) where dataConclusao = ? and idAluno = ? group by tipo";
        try (PreparedStatement pstFasesConcluidas = conexao.prepareStatement(sqlFasesConcluidas)) {
            Date dataAtual = Date.valueOf(LocalDate.now());
            pstFasesConcluidas.setDate(1, dataAtual);
            pstFasesConcluidas.setInt(2, alunoLogado.getIdAluno());
            try (ResultSet rsFasesConcluidas = pstFasesConcluidas.executeQuery()) {
                while (rsFasesConcluidas.next()) {
                    int numMissoes = rsFasesConcluidas.getInt("totalFases");
                    String tipoFase = rsFasesConcluidas.getString("tipo");
                    verificarMissao(numMissoes, tipoFase);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void verificarMissao(int numMissoes, String tipoFase) {
        String sqlMissoes = "select * from missoesDiarias join missoes using(idMissao)";
        try (PreparedStatement pstMissoes = conexao.prepareStatement(sqlMissoes); ResultSet rsMissoes = pstMissoes.executeQuery()) {
            while (rsMissoes.next()) {
                int idMissao = rsMissoes.getInt("idMissao");
                String descMissao = rsMissoes.getString("descMissao");

                if (numMissoes == 3 && descMissao.equals("Conclua 3 fases")) {
                    contabilizarPontos();
                    deletar(idMissao);
                } else if (numMissoes == 5 && descMissao.equals("Conclua 5 fases")) {
                    contabilizarPontos();
                    deletar(idMissao);
                } else if (tipoFase.equals("Visual") && descMissao.equals("Conclua a fase visual")) {
                    contabilizarPontos();
                    deletar(idMissao);
                } else if (tipoFase.equals("Observacao") && descMissao.equals("Conclua a fase observacao")) {
                    contabilizarPontos();
                    deletar(idMissao);
                } else if (tipoFase.equals("Ouvir") && descMissao.equals("Conclua a fase de escuta")) {
                    contabilizarPontos();
                    deletar(idMissao);
                } else if (tipoFase.equals("Numeros") && descMissao.equals("Conclua a fase de numeros")) {
                    contabilizarPontos();
                    deletar(idMissao);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void deletar(int idMissao) {
        String sql = "delete from missoesDiarias where idMissao = ?";
        try (PreparedStatement pstDeletar = conexao.prepareStatement(sql)) {
            pstDeletar.setInt(1, idMissao);
            pstDeletar.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void contabilizarPontos() {
        String sql2 = "select count(*) from missoesDiarias";
        try (PreparedStatement pstContabilizar = conexao.prepareStatement(sql2); ResultSet rsContabilizar = pstContabilizar.executeQuery()) {
            if (rsContabilizar.next()) {
                int numDiarias = rsContabilizar.getInt(1);

                int pontos = 0;
                String mensagem = "";

                if (numDiarias == 1) {
                    pontos = 200;
                    mensagem = "Você concluiu sua ultima missão!";
                } else if (numDiarias == 2) {
                    pontos = 150;
                    mensagem = "Você concluiu sua segunda missão!";
                } else if (numDiarias == 3) {
                    pontos = 100;
                    mensagem = "Você concluiu sua primeira missão!";
                }

                if (pontos > 0) {
                    inserirPontos(pontos);
                    ImageIcon icon = new ImageIcon("src/Imagens/icon sair.png");
                    AlertaGeral alert = new AlertaGeral(parentFrame, icon, "Missões Diárias", mensagem);
                    alert.setVisible(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void inserirPontos(int pontos) {
        String sql = "update alunos set pontosTotais = pontosTotais + ? where idAluno = ?";
        try (PreparedStatement pstInserirPontos = conexao.prepareStatement(sql)) {
            pstInserirPontos.setInt(1, pontos);
            pstInserirPontos.setInt(2, alunoLogado.getIdAluno());
            alunoLogado.setPontosTotais(alunoLogado.getPontosTotais() + pontos);
            pstInserirPontos.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
