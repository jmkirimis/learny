/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Controle.Conexao;
import Modelagem.AlunoLogado;
import Modelagem.VerificadorFases;
import Modelagem.WindowManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author João
 */
public class FRegiao extends javax.swing.JFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Color vermelhoPastel = new Color(239,91,106);
    Color azulPastel = new Color(108,210,255);
    AlunoLogado alunlog = new AlunoLogado();
    private int idAlunoLogado = 0;

    public FRegiao() {
        initComponents();
        // Deleta o aluno logado ao sair pelo botão de fechar janela
        WindowManager.register(this);
        panelGradiente.addColor(new ModelColor(vermelhoPastel, 0f), new ModelColor(azulPastel, 1f));
        conexao = Conexao.conecta();
        String sql = "select * from alunoLogado where idAlunoLogado = 1";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                idAlunoLogado = rs.getInt(1);
                double pontos = rs.getDouble(9);
                int fasesConcluidas = rs.getInt(10);
                lbl_pontos.setText(Double.toString(pontos));
                lbl_fases_concluidas.setText(Integer.toString(fasesConcluidas));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        VerificadorFases vfases = new VerificadorFases(conexao);
        String[] estadosFases = vfases.verificarFases(1, idAlunoLogado); // Verifica as fases da região 1
            
        System.out.println("Fase Visual: " + estadosFases[0]);
        System.out.println("Fase Números: " + estadosFases[1]);
        System.out.println("Fase Ouvir: " + estadosFases[2]);
        System.out.println("Fase Observacao: " + estadosFases[3]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradiente = new Visualizacao.PanelGradiente();
        panelRound1 = new Visualizacao.PanelRound();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        menuHamburguer = new javax.swing.JLabel();
        fase4 = new Visualizacao.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        fase5 = new Visualizacao.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        fase3 = new Visualizacao.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        fase2 = new Visualizacao.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        panelRoundBorda1 = new Visualizacao.PanelRoundBorda();
        panelRoundBorda2 = new Visualizacao.PanelRoundBorda();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelRoundBorda3 = new Visualizacao.PanelRoundBorda();
        jLabel8 = new javax.swing.JLabel();
        panelSombra1 = new Visualizacao.PanelSombra();
        lbl_pontos = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        panelSombra2 = new Visualizacao.PanelSombra();
        lbl_fases_concluidas = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelSombra4 = new Visualizacao.PanelSombra();
        lbl_fases_concluidas1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone perfil.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone home.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        menuHamburguer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone menu hamburguer.png"))); // NOI18N
        menuHamburguer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHamburguerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuHamburguerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuHamburguerMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(118, 118, 118)
                .addComponent(menuHamburguer)
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuHamburguer, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        fase4.setBackground(new java.awt.Color(102, 102, 102));
        fase4.setRoundBottomLeft(100);
        fase4.setRoundBottomRight(100);
        fase4.setRoundTopLeft(100);
        fase4.setRoundTopRight(100);
        fase4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fase4MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("03");

        javax.swing.GroupLayout fase4Layout = new javax.swing.GroupLayout(fase4);
        fase4.setLayout(fase4Layout);
        fase4Layout.setHorizontalGroup(
            fase4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fase4Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(34, 34, 34))
        );
        fase4Layout.setVerticalGroup(
            fase4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fase4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        fase5.setBackground(new java.awt.Color(102, 102, 102));
        fase5.setRoundBottomLeft(100);
        fase5.setRoundBottomRight(100);
        fase5.setRoundTopLeft(100);
        fase5.setRoundTopRight(100);
        fase5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fase5MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("04");

        javax.swing.GroupLayout fase5Layout = new javax.swing.GroupLayout(fase5);
        fase5.setLayout(fase5Layout);
        fase5Layout.setHorizontalGroup(
            fase5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fase5Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(34, 34, 34))
        );
        fase5Layout.setVerticalGroup(
            fase5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fase5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        fase3.setBackground(new java.awt.Color(102, 102, 102));
        fase3.setRoundBottomLeft(100);
        fase3.setRoundBottomRight(100);
        fase3.setRoundTopLeft(100);
        fase3.setRoundTopRight(100);
        fase3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fase3MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("02");

        javax.swing.GroupLayout fase3Layout = new javax.swing.GroupLayout(fase3);
        fase3.setLayout(fase3Layout);
        fase3Layout.setHorizontalGroup(
            fase3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fase3Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(34, 34, 34))
        );
        fase3Layout.setVerticalGroup(
            fase3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fase3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel9)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        fase2.setBackground(new java.awt.Color(102, 102, 102));
        fase2.setRoundBottomLeft(100);
        fase2.setRoundBottomRight(100);
        fase2.setRoundTopLeft(100);
        fase2.setRoundTopRight(100);
        fase2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fase2MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("01");

        javax.swing.GroupLayout fase2Layout = new javax.swing.GroupLayout(fase2);
        fase2.setLayout(fase2Layout);
        fase2Layout.setHorizontalGroup(
            fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fase2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(34, 34, 34))
        );
        fase2Layout.setVerticalGroup(
            fase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fase2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel10)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        panelRoundBorda1.setBackground(new java.awt.Color(102, 102, 102));
        panelRoundBorda1.setBorderWidth(5);
        panelRoundBorda1.setRadius(100);

        javax.swing.GroupLayout panelRoundBorda1Layout = new javax.swing.GroupLayout(panelRoundBorda1);
        panelRoundBorda1.setLayout(panelRoundBorda1Layout);
        panelRoundBorda1Layout.setHorizontalGroup(
            panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelRoundBorda1Layout.setVerticalGroup(
            panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelRoundBorda2.setBackground(new java.awt.Color(102, 102, 102));
        panelRoundBorda2.setBorderWidth(6);
        panelRoundBorda2.setImg(new ImageIcon("src/Imagens/natureza.png"));
        panelRoundBorda2.setRadius(50);
        panelRoundBorda2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRoundBorda2MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mundo 01");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Região 01 - Floresta");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon seta.png"))); // NOI18N

        javax.swing.GroupLayout panelRoundBorda2Layout = new javax.swing.GroupLayout(panelRoundBorda2);
        panelRoundBorda2.setLayout(panelRoundBorda2Layout);
        panelRoundBorda2Layout.setHorizontalGroup(
            panelRoundBorda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelRoundBorda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(26, 26, 26))
        );
        panelRoundBorda2Layout.setVerticalGroup(
            panelRoundBorda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelRoundBorda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(panelRoundBorda2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        panelRoundBorda3.setBackground(new java.awt.Color(102, 102, 102));
        panelRoundBorda3.setBorderWidth(5);
        panelRoundBorda3.setRadius(100);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-bandeira.png"))); // NOI18N

        javax.swing.GroupLayout panelRoundBorda3Layout = new javax.swing.GroupLayout(panelRoundBorda3);
        panelRoundBorda3.setLayout(panelRoundBorda3Layout);
        panelRoundBorda3Layout.setHorizontalGroup(
            panelRoundBorda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundBorda3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(23, 23, 23))
        );
        panelRoundBorda3Layout.setVerticalGroup(
            panelRoundBorda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundBorda3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(panelRoundBorda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(panelRoundBorda2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRoundBorda3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(fase5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fase4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(fase3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundBorda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRoundBorda2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(fase5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(271, 271, 271))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(fase4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(fase3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addComponent(fase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(panelRoundBorda3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelSombra1.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra1.setPreferredSize(new java.awt.Dimension(131, 54));
        panelSombra1.setShadowOpacity(0.3F);

        lbl_pontos.setForeground(new java.awt.Color(51, 51, 51));
        lbl_pontos.setText("pontos");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-fogo.png"))); // NOI18N

        javax.swing.GroupLayout panelSombra1Layout = new javax.swing.GroupLayout(panelSombra1);
        panelSombra1.setLayout(panelSombra1Layout);
        panelSombra1Layout.setHorizontalGroup(
            panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra1Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_pontos)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelSombra1Layout.setVerticalGroup(
            panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra1Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(panelSombra1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_pontos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSombra2.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra2.setPreferredSize(new java.awt.Dimension(131, 47));
        panelSombra2.setShadowOpacity(0.3F);

        lbl_fases_concluidas.setForeground(new java.awt.Color(51, 51, 51));
        lbl_fases_concluidas.setText("fases");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-moeda.png"))); // NOI18N

        javax.swing.GroupLayout panelSombra2Layout = new javax.swing.GroupLayout(panelSombra2);
        panelSombra2.setLayout(panelSombra2Layout);
        panelSombra2Layout.setHorizontalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra2Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(lbl_fases_concluidas)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelSombra2Layout.setVerticalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_fases_concluidas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelSombra2Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSombra4.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra4.setPreferredSize(new java.awt.Dimension(131, 47));
        panelSombra4.setShadowOpacity(0.3F);

        lbl_fases_concluidas1.setForeground(new java.awt.Color(51, 51, 51));
        lbl_fases_concluidas1.setText("fases");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-estrela.png"))); // NOI18N

        javax.swing.GroupLayout panelSombra4Layout = new javax.swing.GroupLayout(panelSombra4);
        panelSombra4.setLayout(panelSombra4Layout);
        panelSombra4Layout.setHorizontalGroup(
            panelSombra4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra4Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_fases_concluidas1)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        panelSombra4Layout.setVerticalGroup(
            panelSombra4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelSombra4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_fases_concluidas1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGradienteLayout = new javax.swing.GroupLayout(panelGradiente);
        panelGradiente.setLayout(panelGradienteLayout);
        panelGradienteLayout.setHorizontalGroup(
            panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradienteLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(panelSombra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(panelSombra4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        panelGradienteLayout.setVerticalGroup(
            panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSombra2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(panelSombra4, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6jLabel1MouseClicked
        new FPerfil().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel6jLabel1MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel7MouseExited

    private void menuHamburguerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHamburguerMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuHamburguerMouseEntered

    private void menuHamburguerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHamburguerMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuHamburguerMouseExited

    private void fase5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fase5MouseClicked
        new FFaseObservacao().setVisible(true);
        dispose();
    }//GEN-LAST:event_fase5MouseClicked

    private void fase4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fase4MouseClicked
        new FFaseOuvir().setVisible(true);
        dispose();
    }//GEN-LAST:event_fase4MouseClicked

    private void fase3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fase3MouseClicked
        new FFaseNumeros1().setVisible(true);
        dispose();
    }//GEN-LAST:event_fase3MouseClicked

    private void fase2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fase2MouseClicked
        new FFaseLigar().setVisible(true);
        dispose();
    }//GEN-LAST:event_fase2MouseClicked

    private void menuHamburguerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHamburguerMouseClicked

    }//GEN-LAST:event_menuHamburguerMouseClicked

    private void panelRoundBorda2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRoundBorda2MouseClicked
        new FMundos().setVisible(true);
        dispose();
    }//GEN-LAST:event_panelRoundBorda2MouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRegiao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRegiao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRegiao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRegiao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRegiao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Visualizacao.PanelRound fase2;
    private Visualizacao.PanelRound fase3;
    private Visualizacao.PanelRound fase4;
    private Visualizacao.PanelRound fase5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_fases_concluidas;
    private javax.swing.JLabel lbl_fases_concluidas1;
    private javax.swing.JLabel lbl_pontos;
    private javax.swing.JLabel menuHamburguer;
    private Visualizacao.PanelGradiente panelGradiente;
    private Visualizacao.PanelRound panelRound1;
    private Visualizacao.PanelRoundBorda panelRoundBorda1;
    private Visualizacao.PanelRoundBorda panelRoundBorda2;
    private Visualizacao.PanelRoundBorda panelRoundBorda3;
    private Visualizacao.PanelSombra panelSombra1;
    private Visualizacao.PanelSombra panelSombra2;
    private Visualizacao.PanelSombra panelSombra4;
    // End of variables declaration//GEN-END:variables
}
