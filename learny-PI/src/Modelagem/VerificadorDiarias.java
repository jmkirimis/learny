/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import Controle.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
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

    public VerificadorDiarias() {
        alunoLogado = Session.getInstance().getAlunoLogado();
        conexao = Conexao.conecta();
    }

    public void verificarDiarias() {
        String sql = "select count(*), tipo from fasesConcluidas join fases using(idFase) where dataConclusao = ? and idAluno = ?";
        try {
            pst = conexao.prepareStatement(sql);
            Date dataAtual = Date.valueOf(LocalDate.now());
            pst.setDate(1, dataAtual);
            pst.setInt(2, alunoLogado.getIdAluno());
            rs = pst.executeQuery();

            if (rs.next()) {
                int numMissoes = rs.getInt(1);
                String tipoFase = rs.getString(2);

                String sqlMissoes = "select * from missoesDiarias join missoes using(idMissao)";
                try {
                    pst = conexao.prepareStatement(sqlMissoes);
                    rs = pst.executeQuery();

                    while (rs.next()) {
                        int idMissao = rs.getInt("idMissao");
                        String descMissao = rs.getString("descMissao");

                        // Verifica o tipo de missão e esconde o painel correspondente
                        if (numMissoes == 3 && descMissao.equals("Conclua 3 fases")) {
                            contabilizarPontos();
                            deletar(idMissao);
                        } else if (numMissoes == 5 && descMissao.equals("Conclua 5 fases")) {
                            contabilizarPontos();
                            deletar(idMissao);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        String sql2 = "select tipo from fasesConcluidas fc join fases using(idFase) where fc.dataConclusao = ? and fc.idAluno = ?";
        try {
            pst = conexao.prepareStatement(sql2);
            Date dataAtual = Date.valueOf(LocalDate.now());
            pst.setDate(1, dataAtual);
            System.out.println(alunoLogado.getIdAluno());
            pst.setInt(2, alunoLogado.getIdAluno());
            rs = pst.executeQuery();

            while (rs.next()) {
                String tipoFase = rs.getString(1);

                String sqlMissoes = "select * from missoesDiarias join missoes using(idMissao)";
                try {
                    pst = conexao.prepareStatement(sqlMissoes);
                    rs = pst.executeQuery();

                    while (rs.next()) {
                        int idMissao = rs.getInt("idMissao");
                        String descMissao = rs.getString("descMissao");

                        if (tipoFase.equals("Visual") && idMissao == 4) {
                            contabilizarPontos();
                            deletar(4);
                        } else if (tipoFase.equals("Observacao") && idMissao == 3) {
                            contabilizarPontos();
                            deletar(3);
                        } else if (tipoFase.equals("Ouvir") && idMissao == 5) {
                            contabilizarPontos();
                            deletar(5);
                        } else if (tipoFase.equals("Numeros") && idMissao == 6) {
                            contabilizarPontos();
                            deletar(6);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void deletar(int idMissao) {
        String sql = "delete from missoesDiarias where idMissao = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idMissao);

            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void contabilizarPontos(){
        String sql2 = "select count(*) from missoesDiarias";
        try {
            pst = conexao.prepareStatement(sql2);
            rs = pst.executeQuery();

            while (rs.next()) {
                int numDiarias = rs.getInt(1);

                if (numDiarias == 1) {
                    JOptionPane.showMessageDialog(null,"Você terminou sua última missão diária! +200pts");
                    inserirPontos(200);
                } else if (numDiarias == 2) {
                    JOptionPane.showMessageDialog(null,"Você terminou sua segunda missão diária! +150pts");
                    inserirPontos(150);
                } else if (numDiarias == 3) {
                    JOptionPane.showMessageDialog(null,"Você terminou sua primeira missão diária! +100pts");
                    inserirPontos(100);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void inserirPontos(int pontos){
        String sql = "update alunos set pontosTotais = pontosTotais + ? where idAluno = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, pontos);
            pst.setInt(2, alunoLogado.getIdAluno());
            alunoLogado.setPontosTotais(alunoLogado.getPontosTotais()+pontos);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // Isso imprimirá o stack trace completo do erro
        }
    }

}
