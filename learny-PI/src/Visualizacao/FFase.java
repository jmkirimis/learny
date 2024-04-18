/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Controle.Conexao;
import Modelagem.FaseConcluida;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author João
 */
public class FFase extends javax.swing.JFrame {

    /**
     * Creates new form FFase
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    Color minhaNovaCor = new Color(83, 194, 242);
    //icone cobra
    Icon iconCobraClick = new ImageIcon("src/Imagens/cobra-click.png");
    Icon iconCobra = new ImageIcon("src/Imagens/cobra.png");
    //icone cavalo
    Icon iconCavaloClick = new ImageIcon("src/Imagens/cavalo-click.png");
    Icon iconCavalo = new ImageIcon("src/Imagens/cavalo.png");
    //icone passaro
    Icon iconPassaroClick = new ImageIcon("src/Imagens/passaro-click.png");
    Icon iconPassaro = new ImageIcon("src/Imagens/passaro.png");
    //icone macaco
    Icon iconMacacoClick = new ImageIcon("src/Imagens/macaco-click.png");
    Icon iconMacaco = new ImageIcon("src/Imagens/macaco.png");
    
    private boolean cobraClicada = false;
    private boolean cobraClicadaDir = false;
    private boolean cavaloClicado = false;
    private boolean cavaloClicadoDir = false;
    private boolean passaroClicado = false;
    private boolean passaroClicadoDir = false;
    private boolean macacoClicado = false;
    private boolean macacoClicadoDir = false;
    
    private String cobraAcerto;
    private String cavaloAcerto;
    private String passaroAcerto;
    private String macacoAcerto;
    
    private Timer timer;
    private int minutes;
    private int remainingSeconds;
    
    private int acertos;
    private int idAluno;
     
    public FFase() {
        this.cobraAcerto = "";
        this.cavaloAcerto = "";
        this.passaroAcerto = "";
        this.macacoAcerto = "";
        
        this.acertos = 0;
        
        initComponents();
        
        //faz a conexao com o banco
        conexao = Conexao.conecta();
        
        //pega o id do aluno
        String sql = "select * from alunoLogado where idAluno = 1";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                int idAluno = Integer.parseInt(rs.getString(1));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        // Adiciona um ouvinte de eventos ao rótulo lbl_cobra
        lbl_cobra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!cobraClicada) {
                    // Define o ícone de clique se ainda não foi clicado
                    lbl_cobra.setIcon(iconCobraClick);
                    cobraClicada = true;
                    if (cobraClicadaDir) {
                        cobraAcerto = "ok";
                        //JOptionPane.showMessageDialog(null, "Relação estabelecida entre os cliques!");
                    } else{
                        cobraAcerto = "erro";
                    }
                } else {
                    // Define o ícone padrão se já foi clicado
                    cobraAcerto = "erro";
                    lbl_cobra.setIcon(iconCobra);
                    cobraClicada = false;
                }
            }
        });
        lbl_cobra_dir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!cobraClicadaDir) {
                    // Define o ícone de clique se ainda não foi clicado
                    lbl_cobra_dir.setIcon(iconCobraClick);
                    cobraClicadaDir = true;
                    if (cobraClicada) {
                        cobraAcerto = "ok";
                        //JOptionPane.showMessageDialog(null, "Relação estabelecida entre os cliques!");
                    } else{
                        cobraAcerto = "erro";
                    }
                } else {
                    // Define o ícone padrão se já foi clicado
                    cobraAcerto = "erro";
                    lbl_cobra_dir.setIcon(iconCobra);
                    cobraClicadaDir = false;
                }
            }
        });
        lbl_cavalo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!cavaloClicado) {
                    // Define o ícone de clique se ainda não foi clicado
                    lbl_cavalo.setIcon(iconCavaloClick);
                    cavaloClicado = true;
                    if (cavaloClicadoDir) {
                        cavaloAcerto = "ok";
                        //JOptionPane.showMessageDialog(null, "Relação estabelecida entre os cliques!");
                    } else{
                        cavaloAcerto = "erro";
                    }
                } else {
                    // Define o ícone padrão se já foi clicado
                    cavaloAcerto = "erro";
                    lbl_cavalo.setIcon(iconCavalo);
                    cavaloClicado = false;
                }
            }
        });
        lbl_cavalo_dir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!cavaloClicadoDir) {
                    // Define o ícone de clique se ainda não foi clicado
                    lbl_cavalo_dir.setIcon(iconCavaloClick);
                    cavaloClicadoDir = true;
                    if (cavaloClicado) {
                        cavaloAcerto = "ok";
                        //JOptionPane.showMessageDialog(null, "Relação estabelecida entre os cliques!");
                    } else{
                        cavaloAcerto = "erro";
                    }
                } else {
                    // Define o ícone padrão se já foi clicado
                    cavaloAcerto = "erro";
                    lbl_cavalo_dir.setIcon(iconCavalo);
                    cavaloClicadoDir = false;
                }
            }
        });
        lbl_passaro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!passaroClicado) {
                    // Define o ícone de clique se ainda não foi clicado
                    lbl_passaro.setIcon(iconPassaroClick);
                    passaroClicado = true;
                    if (passaroClicadoDir) {
                        passaroAcerto = "ok";
                        //JOptionPane.showMessageDialog(null, "Relação estabelecida entre os cliques!");
                    } else{
                        passaroAcerto = "erro";
                    }
                } else {
                    // Define o ícone padrão se já foi clicado
                    passaroAcerto = "erro";
                    lbl_passaro.setIcon(iconPassaro);
                    passaroClicado = false;
                }
            }
        });
        lbl_passaro_dir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!passaroClicadoDir) {
                    // Define o ícone de clique se ainda não foi clicado
                    lbl_passaro_dir.setIcon(iconPassaroClick);
                    passaroClicadoDir = true;
                    if (passaroClicado) {
                        passaroAcerto = "ok";
                        //JOptionPane.showMessageDialog(null, "Relação estabelecida entre os cliques!");
                    } else{
                        passaroAcerto = "erro";
                    }
                } else {
                    // Define o ícone padrão se já foi clicado
                    passaroAcerto = "erro";
                    lbl_passaro_dir.setIcon(iconPassaro);
                    passaroClicadoDir = false;
                }
            }
        });
        lbl_macaco.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!macacoClicado) {
                    // Define o ícone de clique se ainda não foi clicado
                    lbl_macaco.setIcon(iconMacacoClick);
                    macacoClicado = true;
                    if (macacoClicadoDir) {
                        macacoAcerto = "ok";
                        //JOptionPane.showMessageDialog(null, "Relação estabelecida entre os cliques!");
                    } else{
                        macacoAcerto = "erro";
                    }
                } else {
                    // Define o ícone padrão se já foi clicado
                    macacoAcerto = "erro";
                    lbl_macaco.setIcon(iconMacaco);
                    macacoClicado = false;
                }
            }
        });
        lbl_macaco_dir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!macacoClicadoDir) {
                    // Define o ícone de clique se ainda não foi clicado
                    lbl_macaco_dir.setIcon(iconMacacoClick);
                    macacoClicadoDir = true;
                    if (macacoClicado) {
                        macacoAcerto = "ok";
                        //JOptionPane.showMessageDialog(null, "Relação estabelecida entre os cliques!");
                    } else{
                        macacoAcerto = "erro";
                    }
                } else {
                    // Define o ícone padrão se já foi clicado
                    macacoAcerto = "erro";
                    lbl_macaco_dir.setIcon(iconMacaco);
                    macacoClicadoDir = false;
                }
            }
        });
        
        timer = new Timer(1000, new ActionListener() {
            private int seconds = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                minutes = seconds / 60;
                remainingSeconds = seconds % 60;
            
                System.out.println("O JFrame está aberto há " + minutes + " minutos e " + remainingSeconds + " segundos.");
            }
        });
        
        timer.start(); // Iniciar o timer
    }

    public void dispose() {
        super.dispose();
        if (timer != null) {
            timer.stop();
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

        jPanel1 = new javax.swing.JPanel();
        panelSombra1 = new Visualizacao.PanelSombra();
        jLabel5 = new javax.swing.JLabel();
        panelSombra2 = new Visualizacao.PanelSombra();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_cobra = new javax.swing.JLabel();
        lbl_cavalo = new javax.swing.JLabel();
        lbl_passaro = new javax.swing.JLabel();
        lbl_macaco = new javax.swing.JLabel();
        lbl_cobra_dir = new javax.swing.JLabel();
        lbl_cavalo_dir = new javax.swing.JLabel();
        lbl_passaro_dir = new javax.swing.JLabel();
        lbl_macaco_dir = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelSombra1.setBackground(new java.awt.Color(102, 102, 102));
        panelSombra1.setPreferredSize(new java.awt.Dimension(120, 110));
        panelSombra1.setShadowOpacity(0.3F);
        panelSombra1.setShadowSize(3);
        panelSombra1.setShadowType(Visualizacao.ShadowType.BOT_RIGHT);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/olho.png"))); // NOI18N

        javax.swing.GroupLayout panelSombra1Layout = new javax.swing.GroupLayout(panelSombra1);
        panelSombra1.setLayout(panelSombra1Layout);
        panelSombra1Layout.setHorizontalGroup(
            panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelSombra1Layout.setVerticalGroup(
            panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        panelSombra2.setBackground(new java.awt.Color(102, 102, 102));
        panelSombra2.setPreferredSize(new java.awt.Dimension(365, 79));
        panelSombra2.setShadowOpacity(0.3F);
        panelSombra2.setShadowSize(3);
        panelSombra2.setShadowType(Visualizacao.ShadowType.BOT_RIGHT);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ligue os animais");

        javax.swing.GroupLayout panelSombra2Layout = new javax.swing.GroupLayout(panelSombra2);
        panelSombra2.setLayout(panelSombra2Layout);
        panelSombra2Layout.setHorizontalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel3)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        panelSombra2Layout.setVerticalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setText("Visual");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon voltar.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        lbl_cobra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cobra.png"))); // NOI18N

        lbl_cavalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cavalo.png"))); // NOI18N

        lbl_passaro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/passaro.png"))); // NOI18N

        lbl_macaco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/macaco.png"))); // NOI18N

        lbl_cobra_dir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cobra.png"))); // NOI18N

        lbl_cavalo_dir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cavalo.png"))); // NOI18N

        lbl_passaro_dir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/passaro.png"))); // NOI18N

        lbl_macaco_dir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/macaco.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-confirmar.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_macaco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_macaco_dir))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_passaro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_passaro_dir))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_cavalo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_cavalo_dir))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_cobra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_cobra_dir))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addComponent(panelSombra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel4)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(lbl_cobra_dir)
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_cavalo)
                            .addComponent(lbl_cavalo_dir))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_passaro)
                            .addComponent(lbl_passaro_dir))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_macaco_dir)
                            .addComponent(lbl_macaco)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelSombra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(lbl_cobra)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new FMundos().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    FaseConcluida fase = new FaseConcluida();
    
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        if(cobraAcerto == "ok"){
            acertos++;
        }
        if(cavaloAcerto == "ok"){
            acertos++;
        }
        if(passaroAcerto == "ok"){
            acertos++;
        }
        if(macacoAcerto == "ok"){
            acertos++;
        }
        
        double porcAcerto;
        porcAcerto = ((double)acertos/4)*100;
        
        fase.setIdFase(1);
        fase.setIdAluno(idAluno);
        fase.setPontos(100);
        fase.setTempoConclusao(minutes,remainingSeconds);
        fase.setPorcAcertos(porcAcerto);
        fase.cadastrar();
        new FFaseConcluida().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(FFase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FFase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FFase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FFase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FFase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_cavalo;
    private javax.swing.JLabel lbl_cavalo_dir;
    private javax.swing.JLabel lbl_cobra;
    private javax.swing.JLabel lbl_cobra_dir;
    private javax.swing.JLabel lbl_macaco;
    private javax.swing.JLabel lbl_macaco_dir;
    private javax.swing.JLabel lbl_passaro;
    private javax.swing.JLabel lbl_passaro_dir;
    private Visualizacao.PanelSombra panelSombra1;
    private Visualizacao.PanelSombra panelSombra2;
    // End of variables declaration//GEN-END:variables
}
