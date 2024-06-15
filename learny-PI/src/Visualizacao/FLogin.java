
package Visualizacao;

import Controle.Conexao;
import Modelagem.Aluno;
import Modelagem.Session;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class FLogin extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Aluno a = new Aluno(null);
    Color preto = new Color(0,0,0,150);

    public FLogin() {
        initComponents();
        conexao = Conexao.conecta();
        ImageIcon icon = new ImageIcon("src/Imagens/logo-icon.png");
        this.setIconImage(icon.getImage());
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
        panelGradiente1 = new Visualizacao.PanelGradiente();
        panelOpac = new Visualizacao.PanelPretoOpac();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_desc_login = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_desc_login2 = new javax.swing.JLabel();
        panelRound1 = new Visualizacao.PanelRound();
        txt_usuario_entrar = new Visualizacao.PlaceholderTextField();
        panelRound2 = new Visualizacao.PanelRound();
        txt_senha_entrar = new Visualizacao.PlaceholderPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customScrollPane1.setBorder(null);
        customScrollPane1.setPreferredSize(new java.awt.Dimension(485, 834));

        panelGradiente1.setGradientDirection(Visualizacao.PanelGradiente.GradientDirection.VERTICAL);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone confirmar.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Não tem uma conta?");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Cadastre-se");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        lbl_desc_login.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_desc_login.setForeground(new java.awt.Color(255, 255, 255));
        lbl_desc_login.setText("Entre na sua conta Learny");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N

        lbl_desc_login2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_desc_login2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_desc_login2.setText("Faça login com suas informações de cadastro");

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(40);
        panelRound1.setRoundBottomRight(40);
        panelRound1.setRoundTopLeft(40);
        panelRound1.setRoundTopRight(40);

        txt_usuario_entrar.setBorder(null);
        txt_usuario_entrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_usuario_entrar.setPlaceholder("Usuário");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txt_usuario_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(txt_usuario_entrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(40);
        panelRound2.setRoundBottomRight(40);
        panelRound2.setRoundTopLeft(40);
        panelRound2.setRoundTopRight(40);

        txt_senha_entrar.setBorder(null);
        txt_senha_entrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_senha_entrar.setPlaceholder("Senha");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txt_senha_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_senha_entrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelOpacLayout = new javax.swing.GroupLayout(panelOpac);
        panelOpac.setLayout(panelOpacLayout);
        panelOpacLayout.setHorizontalGroup(
            panelOpacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpacLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelOpacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOpacLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel3))
                    .addGroup(panelOpacLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelOpacLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelOpacLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel8))
                    .addGroup(panelOpacLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel6)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7))
                    .addGroup(panelOpacLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(lbl_desc_login))
                    .addComponent(lbl_desc_login2))
                .addGap(30, 30, 30))
        );
        panelOpacLayout.setVerticalGroup(
            panelOpacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpacLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lbl_desc_login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_desc_login2)
                .addGap(46, 46, 46)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel8)
                .addGap(43, 43, 43)
                .addGroup(panelOpacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(120, 120, 120))
        );

        javax.swing.GroupLayout panelGradiente1Layout = new javax.swing.GroupLayout(panelGradiente1);
        panelGradiente1.setLayout(panelGradiente1Layout);
        panelGradiente1Layout.setHorizontalGroup(
            panelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOpac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGradiente1Layout.setVerticalGroup(
            panelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOpac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        customScrollPane1.setViewportView(panelGradiente1);

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

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        new FCadastro().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        autenticar();
    }//GEN-LAST:event_jLabel8MouseClicked
    
    private void autenticar() {
        String usuarioLogin = txt_usuario_entrar.getText();
        String senhaLogin = txt_senha_entrar.getText();

        Aluno aluno = autenticarNoBanco(usuarioLogin, senhaLogin);
        if (aluno != null) {
            Session.getInstance().setAlunoLogado(aluno);
            new FMundos().setVisible(true);
            this.dispose();
        } else {
            ImageIcon icon = new ImageIcon("src/Imagens/icon-login-alerta.png");
            AlertaGeral alert = new AlertaGeral(this, icon, "Erro ao Logar", "Usuário e/ou senha inválidos!", 80, 60);
            alert.setVisible(true);
        }
    }
    
    public Aluno autenticarNoBanco(String usuarioLogin, String senhaLogin){
        String sql = "select * from alunos where usuario =? and senha =?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuarioLogin);
            pst.setString(2, senhaLogin);
            rs = pst.executeQuery();
            
            if(rs.next()){
                int idAluno = rs.getInt(1);
                String nome = rs.getString(2);
                String usuario = rs.getString(3);
                String senha = rs.getString(4);
                String email = rs.getString(5);
                String dataNasc = rs.getString(6);
                int idade = rs.getInt(7);
                double pontosTotais = rs.getDouble(8);
                int fasesConcluidas = rs.getInt(9);
                String foto = rs.getString(10);
                String medalha = rs.getString(11);
                String ranque = rs.getString(12);
                return new Aluno(idAluno, nome, usuario, senha, email, dataNasc, idade, pontosTotais, fasesConcluidas, foto, medalha, ranque);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
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
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Visualizacao.CustomScrollPane customScrollPane1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbl_desc_login;
    private javax.swing.JLabel lbl_desc_login2;
    private Visualizacao.PanelGradiente panelGradiente1;
    private Visualizacao.PanelPretoOpac panelOpac;
    private Visualizacao.PanelRound panelRound1;
    private Visualizacao.PanelRound panelRound2;
    private Visualizacao.PlaceholderPasswordField txt_senha_entrar;
    private Visualizacao.PlaceholderTextField txt_usuario_entrar;
    // End of variables declaration//GEN-END:variables
}
