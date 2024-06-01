/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Controle.Conexao;
import Modelagem.Aluno;
import Modelagem.Config;
import Modelagem.FaseConcluida;
import Modelagem.Session;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author fatec-dsm2
 */
public class FFaseOuvir extends javax.swing.JFrame {

    /**
     * Creates new form FFaseOuvir
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    FaseConcluida fase = new FaseConcluida();
    
    private Timer timer;
    private int seconds = 0;
    private int minutes;
    private int remainingSeconds;
    private String acerto = "";
    
    private Aluno alunoLogado;
    private int idAluno;
    
    public FFaseOuvir() {
        initComponents();
        conexao = Conexao.conecta();
        alunoLogado = Session.getInstance().getAlunoLogado();
        if (alunoLogado == null) {
            // Se não houver aluno logado, redirecione para a tela de login
            new FLogin().setVisible(true);
            this.dispose();
            return;
        }
        
        idAluno = alunoLogado.getIdAluno();
        
        lbl_tocar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toca o áudio
                tocarAudio("src/audios/red.wav");
            }
        });
        
        String medalha = alunoLogado.getMedalhaAtiva();
        System.out.println(medalha);
        if(medalha.equals("Mundo Concluido!")){
            panel_heard.setVisible(false);
        }
        
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                minutes = seconds / 60;
                remainingSeconds = seconds % 60;
            
                System.out.println("O JFrame está aberto há " + minutes + " minutos e " + remainingSeconds + " segundos.");
            }
        });
        
        timer.start();
    }
    
    public void dispose() {
        super.dispose();
        if (timer != null) {
            timer.stop();
        }
    }
    
    public void tocarAudio(String caminhoDoArquivo) {
        if (!Config.audioAtivado) {
            return;
        }
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(caminhoDoArquivo));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
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

        customScrollPane1 = new Visualizacao.CustomScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panelSombra1 = new Visualizacao.PanelSombra();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelSombra3 = new Visualizacao.PanelSombra();
        jLabel6 = new javax.swing.JLabel();
        panelSombra2 = new Visualizacao.PanelSombra();
        lbl_tocar = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel_red = new Visualizacao.PanelRound();
        lbl_red = new javax.swing.JLabel();
        panel_head = new Visualizacao.PanelRound();
        lbl_head = new javax.swing.JLabel();
        panel_read = new Visualizacao.PanelRound();
        lbl_read = new javax.swing.JLabel();
        panel_heard = new Visualizacao.PanelRound();
        lbl_heard = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customScrollPane1.setBorder(null);
        customScrollPane1.setPreferredSize(new java.awt.Dimension(485, 834));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(475, 834));

        panelSombra1.setBackground(new java.awt.Color(102, 102, 102));
        panelSombra1.setPreferredSize(new java.awt.Dimension(120, 110));
        panelSombra1.setShadowOpacity(0.3F);
        panelSombra1.setShadowSize(3);
        panelSombra1.setShadowType(Visualizacao.ShadowType.BOT_RIGHT);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone fala.png"))); // NOI18N

        javax.swing.GroupLayout panelSombra1Layout = new javax.swing.GroupLayout(panelSombra1);
        panelSombra1.setLayout(panelSombra1Layout);
        panelSombra1Layout.setHorizontalGroup(
            panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelSombra1Layout.setVerticalGroup(
            panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("Listen and");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon voltar.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-confirmar.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        panelSombra3.setBackground(new java.awt.Color(255, 51, 51));
        panelSombra3.setShadowOpacity(0.3F);
        panelSombra3.setShadowSize(4);
        panelSombra3.setShadowType(Visualizacao.ShadowType.BOT_RIGHT);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Que cor é essa?");

        panelSombra2.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra2.setCornerRadius(70);
        panelSombra2.setPreferredSize(new java.awt.Dimension(373, 77));

        lbl_tocar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone audio.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Selecione o que ouvir");

        javax.swing.GroupLayout panelSombra2Layout = new javax.swing.GroupLayout(panelSombra2);
        panelSombra2.setLayout(panelSombra2Layout);
        panelSombra2Layout.setHorizontalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra2Layout.createSequentialGroup()
                .addComponent(lbl_tocar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(0, 46, Short.MAX_VALUE))
        );
        panelSombra2Layout.setVerticalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_tocar))
            .addGroup(panelSombra2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelSombra3Layout = new javax.swing.GroupLayout(panelSombra3);
        panelSombra3.setLayout(panelSombra3Layout);
        panelSombra3Layout.setHorizontalGroup(
            panelSombra3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(92, 92, 92))
            .addGroup(panelSombra3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(panelSombra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );
        panelSombra3Layout.setVerticalGroup(
            panelSombra3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel6)
                .addGap(41, 41, 41)
                .addComponent(panelSombra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("choose");

        panel_red.setRoundBottomLeft(50);
        panel_red.setRoundBottomRight(50);
        panel_red.setRoundTopLeft(50);
        panel_red.setRoundTopRight(50);
        panel_red.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_redMouseClicked(evt);
            }
        });

        lbl_red.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lbl_red.setForeground(new java.awt.Color(102, 102, 102));
        lbl_red.setText("RED");

        javax.swing.GroupLayout panel_redLayout = new javax.swing.GroupLayout(panel_red);
        panel_red.setLayout(panel_redLayout);
        panel_redLayout.setHorizontalGroup(
            panel_redLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_redLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(lbl_red)
                .addGap(55, 55, 55))
        );
        panel_redLayout.setVerticalGroup(
            panel_redLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_redLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_red)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panel_head.setRoundBottomLeft(50);
        panel_head.setRoundBottomRight(50);
        panel_head.setRoundTopLeft(50);
        panel_head.setRoundTopRight(50);
        panel_head.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_headMouseClicked(evt);
            }
        });

        lbl_head.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lbl_head.setForeground(new java.awt.Color(102, 102, 102));
        lbl_head.setText("HEAD");

        javax.swing.GroupLayout panel_headLayout = new javax.swing.GroupLayout(panel_head);
        panel_head.setLayout(panel_headLayout);
        panel_headLayout.setHorizontalGroup(
            panel_headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_headLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(lbl_head)
                .addGap(47, 47, 47))
        );
        panel_headLayout.setVerticalGroup(
            panel_headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_headLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_head)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panel_read.setRoundBottomLeft(50);
        panel_read.setRoundBottomRight(50);
        panel_read.setRoundTopLeft(50);
        panel_read.setRoundTopRight(50);
        panel_read.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_readMouseClicked(evt);
            }
        });

        lbl_read.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lbl_read.setForeground(new java.awt.Color(102, 102, 102));
        lbl_read.setText("READ");

        javax.swing.GroupLayout panel_readLayout = new javax.swing.GroupLayout(panel_read);
        panel_read.setLayout(panel_readLayout);
        panel_readLayout.setHorizontalGroup(
            panel_readLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_readLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(lbl_read)
                .addGap(48, 48, 48))
        );
        panel_readLayout.setVerticalGroup(
            panel_readLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_readLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_read)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panel_heard.setPreferredSize(new java.awt.Dimension(161, 73));
        panel_heard.setRoundBottomLeft(50);
        panel_heard.setRoundBottomRight(50);
        panel_heard.setRoundTopLeft(50);
        panel_heard.setRoundTopRight(50);
        panel_heard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_heardMouseClicked(evt);
            }
        });

        lbl_heard.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lbl_heard.setForeground(new java.awt.Color(102, 102, 102));
        lbl_heard.setText("HEARD");

        javax.swing.GroupLayout panel_heardLayout = new javax.swing.GroupLayout(panel_heard);
        panel_heard.setLayout(panel_heardLayout);
        panel_heardLayout.setHorizontalGroup(
            panel_heardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_heardLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lbl_heard)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panel_heardLayout.setVerticalGroup(
            panel_heardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_heardLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_heard)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(60, 60, 60)
                                    .addComponent(jLabel2))
                                .addComponent(jLabel3)))
                        .addComponent(panelSombra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(182, 182, 182)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panel_red, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_read, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_heard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_head, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(29, 29, 29)
                .addComponent(panelSombra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_red, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_head, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_heard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_read, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(jLabel4)
                .addGap(38, 38, 38))
        );

        customScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new FRegiao().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        double porcAcerto, pontos;
        porcAcerto = 0;
        pontos = 0;
        if(acerto.equals("ok")){
            porcAcerto = 100;
            pontos = 100;
        } else{
            porcAcerto = 0;
            pontos = 0;
        }
        String medalha = alunoLogado.getMedalhaAtiva();
        if(medalha.equals("Iniciando!")){
            pontos = pontos + 50;
        } else if(medalha.equals("A todo vapor!")){
            pontos = pontos * 2;
        }
        fase.setIdFase(3);
        fase.setIdAluno(idAluno);
        fase.setPontos(pontos);
        fase.setTempoConclusao(minutes,remainingSeconds);
        fase.setPorcAcertos(porcAcerto);
        fase.cadastrar();
        inserirNotificacao();
        new FFaseConcluida().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void inserirNotificacao(){
        String sql;
        sql = "insert into notificacoes(idAluno, notificacao, descNotificacao, iconNotificacao) values"
                + "(?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, alunoLogado.getIdAluno());
            pst.setString(2, "Fase Concluida");
            pst.setString(3, "Voce concluiu a fase de escuta!");
            pst.setString(4, "icon-medalha-notificacao.png");
            pst.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void panel_redMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_redMouseClicked
        acerto = "ok";
        panel_red.setBackground(new Color(153,153,153));
        lbl_red.setForeground(new Color(255, 255, 255));
        panel_head.setBackground(new Color(240,240,240));
        lbl_head.setForeground(new Color(102, 102, 102));
        panel_read.setBackground(new Color(240,240,240));
        lbl_read.setForeground(new Color(102, 102, 102));
        panel_heard.setBackground(new Color(240,240,240));
        lbl_heard.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_panel_redMouseClicked

    private void panel_headMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_headMouseClicked
        panel_red.setBackground(new Color(240,240,240));
        lbl_red.setForeground(new Color(102, 102, 102));
        panel_head.setBackground(new Color(153,153,153));
        lbl_head.setForeground(new Color(255, 255, 255));
        panel_read.setBackground(new Color(240,240,240));
        lbl_read.setForeground(new Color(102, 102, 102));
        panel_heard.setBackground(new Color(240,240,240));
        lbl_heard.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_panel_headMouseClicked

    private void panel_readMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_readMouseClicked
        panel_red.setBackground(new Color(240,240,240));
        lbl_red.setForeground(new Color(102, 102, 102));
        panel_head.setBackground(new Color(240,240,240));
        lbl_head.setForeground(new Color(102, 102, 102));
        panel_read.setBackground(new Color(153,153,153));
        lbl_read.setForeground(new Color(255, 255, 255));
        panel_heard.setBackground(new Color(240,240,240));
        lbl_heard.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_panel_readMouseClicked

    private void panel_heardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_heardMouseClicked
        panel_red.setBackground(new Color(240,240,240));
        lbl_red.setForeground(new Color(102, 102, 102));
        panel_head.setBackground(new Color(240,240,240));
        lbl_head.setForeground(new Color(102, 102, 102));
        panel_read.setBackground(new Color(240,240,240));
        lbl_read.setForeground(new Color(102, 102, 102));
        panel_heard.setBackground(new Color(153,153,153));
        lbl_heard.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_panel_heardMouseClicked

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
            java.util.logging.Logger.getLogger(FFaseOuvir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FFaseOuvir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FFaseOuvir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FFaseOuvir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FFaseOuvir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Visualizacao.CustomScrollPane customScrollPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_head;
    private javax.swing.JLabel lbl_heard;
    private javax.swing.JLabel lbl_read;
    private javax.swing.JLabel lbl_red;
    private javax.swing.JLabel lbl_tocar;
    private Visualizacao.PanelSombra panelSombra1;
    private Visualizacao.PanelSombra panelSombra2;
    private Visualizacao.PanelSombra panelSombra3;
    private Visualizacao.PanelRound panel_head;
    private Visualizacao.PanelRound panel_heard;
    private Visualizacao.PanelRound panel_read;
    private Visualizacao.PanelRound panel_red;
    // End of variables declaration//GEN-END:variables
}
