/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

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
        String sql = "select count(*) from fasesConcluidas where dataConclusao = ?";
        try {
            pst = conexao.prepareStatement(sql);
            Date dataAtual = Date.valueOf(LocalDate.now());
            pst.setDate(1, dataAtual);
            rs = pst.executeQuery();

            if (rs.next()) {
                int numMissoes = rs.getInt(1);
                if(numMissoes == 3){
                    String sql2 = "select * from missoesDiarias join missoes using(idMissao)";
                        try {
                            pst = conexao.prepareStatement(sql2);
                            rs = pst.executeQuery();

                            while (rs.next()) {
                                int idMissao = rs.getInt("idMissao");
                                String descMissao = rs.getString("descMissao");
                                if(descMissao.equals("Conclua 3 fases")) {
                                    String sql3 = "delete from missoesDiarias where idMissao = ?";
                                    try {
                                        pst = conexao.prepareStatement(sql3);
                                        pst.setInt(1, idMissao);

                                        int rowsAffected = pst.executeUpdate();
                                        System.out.println("Linhas afetadas: " + rowsAffected);
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }
                }
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }
}
