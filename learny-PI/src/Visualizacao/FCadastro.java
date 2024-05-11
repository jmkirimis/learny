/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Modelagem.Alunos;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import jnafilechooser.api.JnaFileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author fatec-dsm2
 */
public class FCadastro extends javax.swing.JFrame {

    Color vermelhoPastel = new Color(239,91,106);
    Color azulPastel = new Color(108,210,255);
    private String foto = "";
    
    public FCadastro() {
        initComponents();
        panelGradiente.addColor(new ModelColor(vermelhoPastel, 0f), new ModelColor(azulPastel, 1f));
        panel_foto_cadastro.setImagem("src/imagens/camera.png");
    }
    Alunos a = new Alunos();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradiente = new Visualizacao.PanelGradiente();
        panelPretoOpac1 = new Visualizacao.PanelPretoOpac();
        jLabel4 = new javax.swing.JLabel();
        btn_cadastrar = new javax.swing.JButton();
        txt_nome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_dataNasc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        lblEntrar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panel_foto_cadastro = new Visualizacao.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        panelGradiente.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");

        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Data de Nascimento");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nome");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Já possui uma conta?");

        lblEntrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEntrar.setForeground(new java.awt.Color(102, 153, 255));
        lblEntrar.setText("Entre aqui");
        lblEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEntrarMouseClicked(evt);
            }
        });

        jButton1.setText("selecionar foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro");

        panel_foto_cadastro.setBackground(new java.awt.Color(255, 255, 255));
        panel_foto_cadastro.setPreferredSize(new java.awt.Dimension(150, 140));
        panel_foto_cadastro.setRoundBottomLeft(30);
        panel_foto_cadastro.setRoundBottomRight(30);
        panel_foto_cadastro.setRoundTopLeft(30);
        panel_foto_cadastro.setRoundTopRight(30);

        javax.swing.GroupLayout panel_foto_cadastroLayout = new javax.swing.GroupLayout(panel_foto_cadastro);
        panel_foto_cadastro.setLayout(panel_foto_cadastroLayout);
        panel_foto_cadastroLayout.setHorizontalGroup(
            panel_foto_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        panel_foto_cadastroLayout.setVerticalGroup(
            panel_foto_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuário");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha");

        javax.swing.GroupLayout panelPretoOpac1Layout = new javax.swing.GroupLayout(panelPretoOpac1);
        panelPretoOpac1.setLayout(panelPretoOpac1Layout);
        panelPretoOpac1Layout.setHorizontalGroup(
            panelPretoOpac1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPretoOpac1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelPretoOpac1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPretoOpac1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelPretoOpac1Layout.createSequentialGroup()
                        .addGroup(panelPretoOpac1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPretoOpac1Layout.createSequentialGroup()
                                .addGroup(panelPretoOpac1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panel_foto_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(panelPretoOpac1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_nome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_usuario)
                                    .addComponent(txt_senha)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))
                            .addComponent(txt_email, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_dataNasc))
                        .addGap(30, 30, 30))
                    .addGroup(panelPretoOpac1Layout.createSequentialGroup()
                        .addGroup(panelPretoOpac1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(panelPretoOpac1Layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jLabel1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelPretoOpac1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(panelPretoOpac1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPretoOpac1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPretoOpac1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEntrar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelPretoOpac1Layout.setVerticalGroup(
            panelPretoOpac1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPretoOpac1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addGroup(panelPretoOpac1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPretoOpac1Layout.createSequentialGroup()
                        .addComponent(panel_foto_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPretoOpac1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(9, 9, 9)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(panelPretoOpac1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblEntrar))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGradienteLayout = new javax.swing.GroupLayout(panelGradiente);
        panelGradiente.setLayout(panelGradienteLayout);
        panelGradienteLayout.setHorizontalGroup(
            panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPretoOpac1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelGradienteLayout.setVerticalGroup(
            panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPretoOpac1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        a.setNome(txt_nome.getText());
        a.setUsuario(txt_usuario.getText());
        a.setSenha(txt_senha.getText());
        a.setEmail(txt_email.getText());
        a.setFoto(foto);
        String dataNasc = txt_dataNasc.getText();
        SimpleDateFormat sdfFormatada = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfOriginal = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Convertendo a string da data para o formato original
            Date dataOriginal = sdfFormatada.parse(dataNasc);
    
            String dataNascBanco = sdfOriginal.format(dataOriginal);
    
            a.setDataNasc(dataNascBanco);
            a.cadastrar();
            new FLogin().setVisible(true);
            dispose();
        } catch (ParseException e) {
            // Tratamento de erro de formatação de data
            JOptionPane.showMessageDialog(null, "Erro ao formatar a data: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_cadastrarActionPerformed

    private void lblEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEntrarMouseClicked
        new FLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_lblEntrarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JnaFileChooser ch = new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if(action){
            File selectedFile = ch.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // Diretório de destino para onde você quer copiar o arquivo
            String destinationDirectory = "src/Imagens/";

            try {
                // Copia o arquivo para o diretório de destino
                Path sourcePath = Paths.get(filePath);
                Path destinationPath = Paths.get(destinationDirectory + selectedFile.getName());
                Files.copy(sourcePath, destinationPath);
                // Exibe a imagem selecionada no painel
                panel_foto_cadastro.setImagem("src/Imagens/" + selectedFile.getName());
                foto = selectedFile.getName();
                JOptionPane.showMessageDialog(this, "Arquivo copiado com sucesso para o pacote do projeto.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao copiar o arquivo para o pacote do projeto: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblEntrar;
    private Visualizacao.PanelGradiente panelGradiente;
    private Visualizacao.PanelPretoOpac panelPretoOpac1;
    private Visualizacao.PanelRound panel_foto_cadastro;
    private javax.swing.JTextField txt_dataNasc;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
