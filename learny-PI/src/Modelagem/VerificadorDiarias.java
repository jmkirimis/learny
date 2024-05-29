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
import javax.swing.JPanel;

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

    public String verificar() {
        String sql = "select count(*), tipo from fasesConcluidas join fases using(idFase) where dataConclusao = ? and idAluno = ?";
        try {
            pst = conexao.prepareStatement(sql);
            Date dataAtual = Date.valueOf(LocalDate.now());
            pst.setDate(1, dataAtual);
            pst.setInt(2, alunoLogado.getIdAluno());
            rs = pst.executeQuery();

            if (rs.next()) {
                int numMissoes = rs.getInt(1);
                if (numMissoes == 3 || numMissoes == 5) {
                    String sqlMissoes = "select * from missoesDiarias join missoes using(idMissao)";
                    pst = conexao.prepareStatement(sqlMissoes);
                    rs = pst.executeQuery();

                    while (rs.next()) {
                        int idMissao = rs.getInt("idMissao");
                        String descMissao = rs.getString("descMissao");

                        deletar(idMissao);

                        // Verifica o tipo de missão e esconde o painel correspondente
                        if (descMissao.equals("Conclua 3 fases")) {
                            return "ok";
                        } else if (descMissao.equals("Conclua 5 fases")) {
                            return "ok";
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return "";
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

}
