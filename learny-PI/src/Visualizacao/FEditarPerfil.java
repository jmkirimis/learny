
package Visualizacao;

import Controle.Conexao;
import Modelagem.Aluno;
import Modelagem.Session;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;

public class FEditarPerfil extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private Aluno alunoLogado;
    private String foto;
    private int idAluno;

    private FPerfil telaDePerfil;

    public FEditarPerfil(FPerfil telaDePerfil) {
        this.telaDePerfil = telaDePerfil;
        initComponents();
        ImageIcon icon = new ImageIcon("src/Imagens/logo-icon.png");
        this.setIconImage(icon.getImage());
        alunoLogado = Session.getInstance().getAlunoLogado();
        String dataNasc = alunoLogado.getDataNasc();
        foto = alunoLogado.getFoto();

        txt_nome.setText(alunoLogado.getNome());
        txt_usuario.setText(alunoLogado.getUsuario());
        txt_senha.setText(alunoLogado.getSenha());
        txt_email.setText(alunoLogado.getEmail());
        panel_foto_editar.setImagem("src/Imagens/" + foto);

        // Formato original da data recebida
        SimpleDateFormat sdfOriginal = new SimpleDateFormat("yyyy-MM-dd");
        // Formato desejado para exibição
        SimpleDateFormat sdfFormatada = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Converte a string para um objeto Date usando o formato original
            Date dataOriginal = sdfOriginal.parse(dataNasc);
            // Converte o objeto Date de volta para uma string no formato desejado
            String dataFormatada = sdfFormatada.format(dataOriginal);
            // Define a string formatada no JTextField
            txt_dataNasc.setText(dataFormatada);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    Aluno a = new Aluno(this);

    // Método para retornar à tela de perfil
    public void voltarParaPerfil() {
        if (telaDePerfil != null) {
            telaDePerfil.setVisible(true);
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
        panelGradiente = new Visualizacao.PanelGradiente();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel_foto_editar = new Visualizacao.PanelRoundPerfil();
        panelRound1 = new Visualizacao.PanelRound();
        jLabel8 = new javax.swing.JLabel();
        panelRound2 = new Visualizacao.PanelRound();
        txt_usuario = new javax.swing.JTextField();
        panelRound7 = new Visualizacao.PanelRound();
        txt_senha = new javax.swing.JPasswordField();
        panelRound8 = new Visualizacao.PanelRound();
        txt_nome = new javax.swing.JTextField();
        panelRound9 = new Visualizacao.PanelRound();
        txt_email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        panelRound6 = new Visualizacao.PanelRound();
        txt_dataNasc = new Visualizacao.TextData();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        customScrollPane1.setBorder(null);
        customScrollPane1.setPreferredSize(new java.awt.Dimension(485, 834));

        panelGradiente.setBackground(new java.awt.Color(204, 204, 204));
        panelGradiente.setGradientDirection(Visualizacao.PanelGradiente.GradientDirection.VERTICAL);
        panelGradiente.setGradientEndColor(new java.awt.Color(74, 133, 162));
        panelGradiente.setGradientStartColor(new java.awt.Color(153, 62, 72));
        panelGradiente.setPreferredSize(new java.awt.Dimension(475, 834));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Editar Perfil");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone confirmar.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        panel_foto_editar.setBackground(new java.awt.Color(255, 255, 255));
        panel_foto_editar.setPreferredSize(new java.awt.Dimension(160, 160));

        javax.swing.GroupLayout panel_foto_editarLayout = new javax.swing.GroupLayout(panel_foto_editar);
        panel_foto_editar.setLayout(panel_foto_editarLayout);
        panel_foto_editarLayout.setHorizontalGroup(
            panel_foto_editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        panel_foto_editarLayout.setVerticalGroup(
            panel_foto_editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setPreferredSize(new java.awt.Dimension(160, 40));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);
        panelRound1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound1MouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lapis_pequeno.png"))); // NOI18N

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(40);
        panelRound2.setRoundBottomRight(40);
        panelRound2.setRoundTopLeft(40);
        panelRound2.setRoundTopRight(40);

        txt_usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(72, 72, 72));
        txt_usuario.setBorder(null);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRound7.setBackground(new java.awt.Color(255, 255, 255));
        panelRound7.setRoundBottomLeft(40);
        panelRound7.setRoundBottomRight(40);
        panelRound7.setRoundTopLeft(40);
        panelRound7.setRoundTopRight(40);

        txt_senha.setBorder(null);

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_senha, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRound8.setBackground(new java.awt.Color(255, 255, 255));
        panelRound8.setRoundBottomLeft(40);
        panelRound8.setRoundBottomRight(40);
        panelRound8.setRoundTopLeft(40);
        panelRound8.setRoundTopRight(40);

        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nome.setForeground(new java.awt.Color(72, 72, 72));
        txt_nome.setBorder(null);

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRound9.setBackground(new java.awt.Color(255, 255, 255));
        panelRound9.setRoundBottomLeft(40);
        panelRound9.setRoundBottomRight(40);
        panelRound9.setRoundTopLeft(40);
        panelRound9.setRoundTopRight(40);

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_email.setForeground(new java.awt.Color(72, 72, 72));
        txt_email.setBorder(null);

        javax.swing.GroupLayout panelRound9Layout = new javax.swing.GroupLayout(panelRound9);
        panelRound9.setLayout(panelRound9Layout);
        panelRound9Layout.setHorizontalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelRound9Layout.setVerticalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icone-voltar-branco.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        panelRound6.setBackground(new java.awt.Color(255, 255, 255));
        panelRound6.setRoundBottomLeft(40);
        panelRound6.setRoundBottomRight(40);
        panelRound6.setRoundTopLeft(40);
        panelRound6.setRoundTopRight(40);

        txt_dataNasc.setBorder(null);
        txt_dataNasc.setForeground(new java.awt.Color(72, 72, 72));
        txt_dataNasc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txt_dataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_dataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelGradienteLayout = new javax.swing.GroupLayout(panelGradiente);
        panelGradiente.setLayout(panelGradienteLayout);
        panelGradienteLayout.setHorizontalGroup(
            panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradienteLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGradienteLayout.createSequentialGroup()
                        .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel9))
                    .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelGradienteLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(panel_foto_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelGradienteLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(75, 75, 75)
                            .addComponent(jLabel2))
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelGradienteLayout.setVerticalGroup(
            panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradienteLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGradienteLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2))
                .addGap(45, 45, 45)
                .addGroup(panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_foto_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(panelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(panelGradienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        customScrollPane1.setViewportView(panelGradiente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(customScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        a.setIdAluno(alunoLogado.getIdAluno());
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
            a.alterar();
            new FLogin().setVisible(true);
            dispose();
        } catch (ParseException e) {
            // Tratamento de erro de formatação de data
            JOptionPane.showMessageDialog(null, "Erro ao formatar a data: " + e.getMessage());
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void panelRound1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound1MouseClicked
        JnaFileChooser ch = new JnaFileChooser();
        boolean action = ch.showOpenDialog(this);
        if (action) {
            File selectedFile = ch.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // Diretório de destino
            String destinationDirectory = "src/Imagens/";

            try {
                // Caminhos dos arquivos
                Path sourcePath = Paths.get(filePath);
                Path destinationPath = Paths.get(destinationDirectory + selectedFile.getName());

                // Verifica se o arquivo já existe no diretório de destino
                if (Files.exists(destinationPath)) {
                    // Se o arquivo já existe, apenas carrega a foto existente
                    panel_foto_editar.setImagem(destinationPath.toString());
                    foto = selectedFile.getName();
                } else {
                    // Copia o arquivo para o diretório de destino
                    Files.copy(sourcePath, destinationPath);
                    // Exibe a imagem selecionada no painel
                    panel_foto_editar.setImagem(destinationPath.toString());
                    foto = selectedFile.getName();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao copiar o arquivo para o pacote do projeto: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_panelRound1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        voltarParaPerfil();
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(FEditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FEditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FEditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FEditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FEditarPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Visualizacao.CustomScrollPane customScrollPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private Visualizacao.PanelGradiente panelGradiente;
    private Visualizacao.PanelRound panelRound1;
    private Visualizacao.PanelRound panelRound2;
    private Visualizacao.PanelRound panelRound6;
    private Visualizacao.PanelRound panelRound7;
    private Visualizacao.PanelRound panelRound8;
    private Visualizacao.PanelRound panelRound9;
    private Visualizacao.PanelRoundPerfil panel_foto_editar;
    private Visualizacao.TextData txt_dataNasc;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
