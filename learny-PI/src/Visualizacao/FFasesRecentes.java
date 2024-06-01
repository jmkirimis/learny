/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Controle.Conexao;
import Modelagem.Aluno;
import Modelagem.Session;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author fatec-dsm2
 */
public class FFasesRecentes extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private Map<Integer, PanelSombra> fasesMap; // Mapa para armazenar os painéis de fases
    private Aluno alunoLogado;
    private int idAluno;
    
    Color azul = new Color(83, 194, 242);
    Color verde = new Color(128,210,91);
    Color vermelho = new Color(239,91,106);
    Color amarelo = new Color(255,179,0);
    private FOpcoes telaDeOpcoes;

    public FFasesRecentes(FOpcoes telaDeOpcoes) {
        this.telaDeOpcoes = telaDeOpcoes;
        initComponents();
        conexao = Conexao.conecta();
        alunoLogado = Session.getInstance().getAlunoLogado();
        if (alunoLogado == null) {
            // Se não houver aluno logado, redirecione para a tela de login
            new FLogin().setVisible(true);
            this.dispose();
            return;
        }
        // Inicialize a estrutura de dados
        fasesMap = new HashMap<>();
        idAluno = alunoLogado.getIdAluno();
        painelFases.setLayout(new BoxLayout(painelFases, BoxLayout.Y_AXIS));

        carregarFases(); // Carregar as fases concluídas
    }

    private void carregarFases() {
        String sql = "select fc.idFaseConcluida, f.tipo " +
                     "from fasesConcluidas fc " +
                     "join fases f on fc.idFase = f.idFase " +
                     "where fc.idAluno = ? and dataConclusao = ?";

        try {
            LocalDate currentDate = LocalDate.now();
            Date sqlDate = Date.valueOf(currentDate);
            
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idAluno);
            pst.setDate(2, sqlDate);
            rs = pst.executeQuery();

            while (rs.next()) {
                int idFaseConcluida = rs.getInt("idFaseConcluida");
                String tipo = rs.getString("tipo");
                String caminhoIcone = "icon-medalha-notificacao.png";

                JPanel painelFase = criarPainelFase(tipo, caminhoIcone);

                painelFases.add(Box.createRigidArea(new Dimension(0, 15)));
                painelFases.add(painelFase);

                // Armazena o painel no mapa com o ID da fase concluída
                fasesMap.put(idFaseConcluida, (PanelSombra) painelFase);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private JPanel criarPainelFase(String tipo, String caminhoIcone) {
        PanelSombra painel = new PanelSombra();
        painel.setShadowType(ShadowType.BOT_RIGHT);
        painel.setShadowSize(3);
        painel.setShadowOpacity(0.3f);
        painel.setLayout(new BorderLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painel.setBackground(Color.WHITE);

        JLabel lblIcone = new JLabel();
        ImageIcon icon = new ImageIcon("src/Imagens/" + caminhoIcone); // Ajuste o caminho conforme necessário
        lblIcone.setIcon(icon);
        lblIcone.setPreferredSize(new Dimension(50, 50));

        JLabel lblTipo = new JLabel(tipo);
        lblTipo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTipo.setForeground(Color.WHITE);

        painel.add(lblIcone, BorderLayout.WEST);
        painel.add(lblTipo, BorderLayout.CENTER);

        // Ajuste a cor do painel conforme o tipo da fase
        switch (tipo.toLowerCase()) {
            case "visual":
                painel.setBackground(azul);
                break;
            case "numeros":
                painel.setBackground(amarelo);
                break;
            case "ouvir":
                painel.setBackground(vermelho);
                break;
            case "observacao":
                painel.setBackground(verde);
                break;
            default:
                painel.setBackground(Color.GRAY); // Cor padrão para tipos desconhecidos
                break;
        }
        
        return painel;
    }

    public PanelSombra getPainelFase(int idFaseConcluida) {
        return fasesMap.get(idFaseConcluida);
    }
    
    // Método para retornar à tela de opções
    public void voltarParaOpcoes() {
        if (telaDeOpcoes != null) {
            telaDeOpcoes.setVisible(true);
            this.dispose();
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
        panelRound1 = new Visualizacao.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        painelFases = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customScrollPane1.setBorder(null);
        customScrollPane1.setPreferredSize(new java.awt.Dimension(485, 834));

        jPanel1.setBackground(new java.awt.Color(72, 72, 72));
        jPanel1.setPreferredSize(new java.awt.Dimension(475, 834));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundTopLeft(60);
        panelRound1.setRoundTopRight(60);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Fases Recentes");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon voltar.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        painelFases.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout painelFasesLayout = new javax.swing.GroupLayout(painelFases);
        painelFases.setLayout(painelFasesLayout);
        painelFasesLayout.setHorizontalGroup(
            painelFasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelFasesLayout.setVerticalGroup(
            painelFasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(painelFases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13))
                .addGap(55, 55, 55)
                .addComponent(painelFases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(456, 456, 456))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        voltarParaOpcoes();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel13MouseExited

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
            java.util.logging.Logger.getLogger(FFasesRecentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FFasesRecentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FFasesRecentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FFasesRecentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FFasesRecentes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Visualizacao.CustomScrollPane customScrollPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painelFases;
    private Visualizacao.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
