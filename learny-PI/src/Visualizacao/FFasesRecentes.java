
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

public class FFasesRecentes extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private Map<Integer, PanelSombra> fasesMap; // Mapa para armazenar os painéis de fases
    private Aluno alunoLogado;
    private int idAluno;

    Color azul = new Color(83, 194, 242);
    Color verde = new Color(128, 210, 91);
    Color vermelho = new Color(239, 91, 106);
    Color amarelo = new Color(255, 179, 0);
    private FOpcoes telaDeOpcoes;

    public FFasesRecentes(FOpcoes telaDeOpcoes) {
        this.telaDeOpcoes = telaDeOpcoes;
        initComponents();
        conexao = Conexao.conecta();
        alunoLogado = Session.getInstance().getAlunoLogado();
        // Inicializa a estrutura de dados
        fasesMap = new HashMap<>();
        idAluno = alunoLogado.getIdAluno();
        painelFases.setLayout(new BoxLayout(painelFases, BoxLayout.Y_AXIS));

        carregarFases(); // Carregar as fases concluídas
        Dimension fixedSize = new Dimension(0, 100); // Tamanho desejado quando vazio
        if (painelFases.getComponentCount() == 0) {
            painelFases.setPreferredSize(fixedSize);
        } else {
            painelFases.setPreferredSize(null);
        }
        painelFases.revalidate();
    }

    private void carregarFases() {
        String sql = "select fc.idFaseConcluida, f.tipo "
                + "from fasesConcluidas fc "
                + "join fases f on fc.idFase = f.idFase "
                + "where fc.idAluno = ? and dataConclusao = ?";

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

                ajustarAlturaPaineis();

                // Armazena o painel no mapa com o ID da fase concluída
                fasesMap.put(idFaseConcluida, (PanelSombra) painelFase);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void ajustarAlturaPaineis() {
        // Obtem a altura adicional desejada
        int alturaAdicional = 65;
        // Obtem os tamanhos preferidos atuais dos outros painéis
        Dimension tamanhoRound = panelRoundRecentes.getPreferredSize();
        Dimension tamanhoGeral = panelGeral.getPreferredSize();
        // Adiciona a altura adicional aos tamanhos preferidos
        tamanhoRound.height += alturaAdicional;
        tamanhoGeral.height += alturaAdicional;
        // Define os novos tamanhos preferidos dos outros painéis
        panelRoundRecentes.setPreferredSize(tamanhoRound);
        panelGeral.setPreferredSize(tamanhoGeral);
        // Revalida os painéis para que as mudanças tenham efeito
        panelRoundRecentes.revalidate();
        panelGeral.revalidate();
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
        ImageIcon icon = new ImageIcon("src/Imagens/" + caminhoIcone);
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
                painel.setBackground(Color.GRAY);
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
        panelGeral = new javax.swing.JPanel();
        panelRoundRecentes = new Visualizacao.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        painelFases = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customScrollPane1.setBorder(null);
        customScrollPane1.setPreferredSize(new java.awt.Dimension(485, 834));

        panelGeral.setBackground(new java.awt.Color(72, 72, 72));
        panelGeral.setPreferredSize(new java.awt.Dimension(475, 834));

        panelRoundRecentes.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundRecentes.setRoundTopLeft(60);
        panelRoundRecentes.setRoundTopRight(60);

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

        javax.swing.GroupLayout panelRoundRecentesLayout = new javax.swing.GroupLayout(panelRoundRecentes);
        panelRoundRecentes.setLayout(panelRoundRecentesLayout);
        panelRoundRecentesLayout.setHorizontalGroup(
            panelRoundRecentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundRecentesLayout.createSequentialGroup()
                .addGroup(panelRoundRecentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundRecentesLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel1)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel13))
                    .addGroup(panelRoundRecentesLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(painelFases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(57, 57, 57))
        );
        panelRoundRecentesLayout.setVerticalGroup(
            panelRoundRecentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundRecentesLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelRoundRecentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13))
                .addGap(55, 55, 55)
                .addComponent(painelFases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(460, 460, 460))
        );

        javax.swing.GroupLayout panelGeralLayout = new javax.swing.GroupLayout(panelGeral);
        panelGeral.setLayout(panelGeralLayout);
        panelGeralLayout.setHorizontalGroup(
            panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundRecentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGeralLayout.setVerticalGroup(
            panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeralLayout.createSequentialGroup()
                .addGap(0, 145, Short.MAX_VALUE)
                .addComponent(panelRoundRecentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        customScrollPane1.setViewportView(panelGeral);

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
    private javax.swing.JPanel painelFases;
    private javax.swing.JPanel panelGeral;
    private Visualizacao.PanelRound panelRoundRecentes;
    // End of variables declaration//GEN-END:variables
}
