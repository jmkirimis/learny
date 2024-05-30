/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Controle.Conexao;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author João
 */
public class FMissoesDiarias extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    Color azul = new Color(83, 194, 242);
    Color verde = new Color(128,210,91);
    Color vermelho = new Color(239,91,106);
    Color amarelo = new Color(255,179,0);
    
    public FMissoesDiarias() {
        setUndecorated(true);
        initComponents();
        conexao = Conexao.conecta();
        setBackground(new Color(0, 0, 0, 0));
        Color transparente = new Color(0,0,0,0);
        panelGeral.setBackground(transparente);
        panel_diaria1.setVisible(false);
        panel_diaria2.setVisible(false);
        panel_diaria3.setVisible(false);
        carregarMissoes();
        
        // Adiciona o MouseListener para detectar cliques fora do JFrame
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!getBounds().contains(e.getPoint())) {
                    dispose(); // Fecha o JFrame
                }
            }
        });

        // Adiciona o MouseListener ao content pane para propagar eventos de clique
        getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Ignora cliques dentro do painel
                e.consume();
            }
        });

        // Adiciona o MouseListener ao frame para detectar cliques fora do painel
        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent event) {
                if (event instanceof MouseEvent) {
                    MouseEvent me = (MouseEvent) event;
                    if (me.getID() == MouseEvent.MOUSE_CLICKED) {
                        if (!FMissoesDiarias.this.getBounds().contains(me.getLocationOnScreen())) {
                            dispose(); // Fecha o JFrame
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);
    }
    
    private void carregarMissoes() {
        String sql = "select * from missoesDiarias join missoes using(idMissao)";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            // Lista de labels para fácil acesso no loop
            JLabel[] lblsMissoes = {lbl_missao1, lbl_missao2, lbl_missao3};
            JLabel[] lblsIcons = {icon_missao1, icon_missao2, icon_missao3};
            PanelRoundBorda[] panelsDiarias = {panel_diaria1, panel_diaria2, panel_diaria3};
            int cont = 0;
            while (rs.next()) {
                String nomeMissao = rs.getString("nomeMissao");
                String descMissao = rs.getString("descMissao");
                String iconMissao = rs.getString("iconMissao");
                panelsDiarias[cont].setVisible(true);
                
                if(nomeMissao.equals("Atividades 1")){
                    panelsDiarias[cont].setGradientStartColor(vermelho);
                    panelsDiarias[cont].setGradientEndColor(azul);
                } else if(nomeMissao.equals("Atividades 2")){
                    panelsDiarias[cont].setGradientStartColor(vermelho);
                    panelsDiarias[cont].setGradientEndColor(azul);
                } else if(nomeMissao.equals("Visual")){
                    panelsDiarias[cont].setGradientStartColor(azul);
                    panelsDiarias[cont].setGradientEndColor(azul);
                } else if(nomeMissao.equals("Ouvir")){
                    panelsDiarias[cont].setGradientStartColor(vermelho);
                    panelsDiarias[cont].setGradientEndColor(vermelho);
                } else if(nomeMissao.equals("Numeros")){
                    panelsDiarias[cont].setGradientStartColor(amarelo);
                    panelsDiarias[cont].setGradientEndColor(amarelo);
                } else if(nomeMissao.equals("Observacao")){
                    panelsDiarias[cont].setGradientStartColor(verde);
                    panelsDiarias[cont].setGradientEndColor(verde);
                }
                lblsMissoes[cont].setText(descMissao);
                ImageIcon icon = new ImageIcon("src/Imagens/" + iconMissao);
                lblsIcons[cont].setIcon(icon);
                cont++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeral = new javax.swing.JPanel();
        panelRoundBorda1 = new Visualizacao.PanelRoundBorda();
        panel_diaria3 = new Visualizacao.PanelRoundBorda();
        lbl_missao3 = new javax.swing.JLabel();
        icon_missao3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panel_diaria2 = new Visualizacao.PanelRoundBorda();
        lbl_missao2 = new javax.swing.JLabel();
        icon_missao2 = new javax.swing.JLabel();
        panel_diaria1 = new Visualizacao.PanelRoundBorda();
        lbl_missao1 = new javax.swing.JLabel();
        icon_missao1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGeral.setBackground(new java.awt.Color(255, 255, 255));

        panelRoundBorda1.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBorda1.setBorderWidth(5);
        panelRoundBorda1.setRadius(50);

        panel_diaria3.setBackground(new java.awt.Color(255, 255, 255));
        panel_diaria3.setBorderWidth(5);
        panel_diaria3.setGradientEndColor(new java.awt.Color(128, 210, 91));
        panel_diaria3.setGradientStartColor(new java.awt.Color(128, 210, 91));
        panel_diaria3.setRadius(50);

        lbl_missao3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_missao3.setForeground(new java.awt.Color(72, 72, 72));

        icon_missao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-diaria-mundo.png"))); // NOI18N

        javax.swing.GroupLayout panel_diaria3Layout = new javax.swing.GroupLayout(panel_diaria3);
        panel_diaria3.setLayout(panel_diaria3Layout);
        panel_diaria3Layout.setHorizontalGroup(
            panel_diaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_diaria3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl_missao3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(icon_missao3)
                .addGap(16, 16, 16))
        );
        panel_diaria3Layout.setVerticalGroup(
            panel_diaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_diaria3Layout.createSequentialGroup()
                .addGroup(panel_diaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_diaria3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbl_missao3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_diaria3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(icon_missao3)))
                .addGap(21, 21, 21))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Missões Diarias");

        panel_diaria2.setBackground(new java.awt.Color(255, 255, 255));
        panel_diaria2.setBorderWidth(5);
        panel_diaria2.setGradientStartColor(new java.awt.Color(83, 194, 242));
        panel_diaria2.setRadius(50);

        lbl_missao2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_missao2.setForeground(new java.awt.Color(72, 72, 72));

        icon_missao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-diaria-visualizar.png"))); // NOI18N

        javax.swing.GroupLayout panel_diaria2Layout = new javax.swing.GroupLayout(panel_diaria2);
        panel_diaria2.setLayout(panel_diaria2Layout);
        panel_diaria2Layout.setHorizontalGroup(
            panel_diaria2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_diaria2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl_missao2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(icon_missao2)
                .addGap(16, 16, 16))
        );
        panel_diaria2Layout.setVerticalGroup(
            panel_diaria2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_diaria2Layout.createSequentialGroup()
                .addGroup(panel_diaria2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_diaria2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbl_missao2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_diaria2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(icon_missao2)))
                .addGap(21, 21, 21))
        );

        panel_diaria1.setBackground(new java.awt.Color(255, 255, 255));
        panel_diaria1.setBorderWidth(5);
        panel_diaria1.setRadius(50);

        lbl_missao1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_missao1.setForeground(new java.awt.Color(72, 72, 72));

        icon_missao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-diaria-fases.png"))); // NOI18N

        javax.swing.GroupLayout panel_diaria1Layout = new javax.swing.GroupLayout(panel_diaria1);
        panel_diaria1.setLayout(panel_diaria1Layout);
        panel_diaria1Layout.setHorizontalGroup(
            panel_diaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_diaria1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl_missao1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(icon_missao1)
                .addGap(16, 16, 16))
        );
        panel_diaria1Layout.setVerticalGroup(
            panel_diaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_diaria1Layout.createSequentialGroup()
                .addGroup(panel_diaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_diaria1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbl_missao1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_diaria1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(icon_missao1)))
                .addGap(21, 21, 21))
        );

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon voltar.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRoundBorda1Layout = new javax.swing.GroupLayout(panelRoundBorda1);
        panelRoundBorda1.setLayout(panelRoundBorda1Layout);
        panelRoundBorda1Layout.setHorizontalGroup(
            panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundBorda1Layout.createSequentialGroup()
                        .addGroup(panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panel_diaria3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel_diaria2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel_diaria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRoundBorda1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel7)))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundBorda1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(27, 27, 27))))
        );
        panelRoundBorda1Layout.setVerticalGroup(
            panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundBorda1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(38, 38, 38)
                .addComponent(panel_diaria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panel_diaria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panel_diaria3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout panelGeralLayout = new javax.swing.GroupLayout(panelGeral);
        panelGeral.setLayout(panelGeralLayout);
        panelGeralLayout.setHorizontalGroup(
            panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGeralLayout.setVerticalGroup(
            panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(FMissoesDiarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMissoesDiarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMissoesDiarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMissoesDiarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FMissoesDiarias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon_missao1;
    private javax.swing.JLabel icon_missao2;
    private javax.swing.JLabel icon_missao3;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbl_missao1;
    private javax.swing.JLabel lbl_missao2;
    private javax.swing.JLabel lbl_missao3;
    private javax.swing.JPanel panelGeral;
    private Visualizacao.PanelRoundBorda panelRoundBorda1;
    private Visualizacao.PanelRoundBorda panel_diaria1;
    private Visualizacao.PanelRoundBorda panel_diaria2;
    private Visualizacao.PanelRoundBorda panel_diaria3;
    // End of variables declaration//GEN-END:variables
}
