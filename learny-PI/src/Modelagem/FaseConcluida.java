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
import java.sql.Time;
import java.time.LocalTime;
import javax.swing.JOptionPane;
/**
 *
 * @author fatec-dsm2
 */
public class FaseConcluida {
    private int idFase;
    private int idAluno;
    private double pontos;
    private LocalTime tempoConclusao;
    private double porcAcertos;
    
    //importar classe conexao
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public FaseConcluida() {
        this(0, 0, 0.0, 0, 0, 0.0);
    }

    
    public FaseConcluida(int idFase, int idAluno, double pontos, int minutos, int segundos, double porcAcertos) {
        this.idFase = idFase;
        this.idAluno = idAluno;
        this.pontos = pontos;
        this.tempoConclusao = LocalTime.of(0, minutos, segundos);
        this.porcAcertos = porcAcertos;
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    public int getMinutos() {
        return tempoConclusao.getMinute();
    }

    // Método getter para segundos
    public int getSegundos() {
        return tempoConclusao.getSecond();
    }
    
    public LocalTime getTempoConclusao() {
        return tempoConclusao;
    }
    
    
    public void setTempoConclusao(int minutos, int segundos) {
        this.tempoConclusao = LocalTime.of(0, minutos, segundos);
    }

    public double getPorcAcertos() {
        return porcAcertos;
    }

    public void setPorcAcertos(double porcAcertos) {
        this.porcAcertos = porcAcertos;
    }
    
    public void cadastrar(){
        conexao = Conexao.conecta();
        String sql;
        sql = "insert into fasesConcluidas(idFase, idAluno, pontos, tempoConclusao, porcentagemAcertos) values"
                + "(?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, getIdFase());
            pst.setInt(2, getIdAluno());
            pst.setDouble(3, getPontos());
            
            // Convertendo LocalTime para java.sql.Time
            LocalTime localTime = getTempoConclusao();
            Time time = Time.valueOf(localTime);

            pst.setTime(4, time); // Usando o java.sql.Time convertido
            pst.setDouble(5, getPorcAcertos());
            pst.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace(); // Isso imprimirá o stack trace completo do erro
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar: " + e.getMessage());
        }
    }
    
    
}
