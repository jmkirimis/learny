package Visualizacao;

import Controle.Conexao;
import Modelagem.Aluno;
import Modelagem.FaseConcluida;
import Modelagem.Session;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class FFaseNumeros2 extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    FaseConcluida fase = new FaseConcluida();

    private Aluno alunoLogado;
    private Timer timer;
    private int minutes;
    private int remainingSeconds;
    private int idAluno;
    private int acertos2;
    private int seconds2;
    private boolean dicaClicada = false;

    //icone dica
    Icon iconDicaAtivada = new ImageIcon("src/Imagens/icon-dica-ativada.png");
    Icon iconDicaDesativada = new ImageIcon("src/Imagens/icon-dica-desativada.png");

    public FFaseNumeros2(int acertos, int seconds) {
        initComponents();
        ImageIcon icon = new ImageIcon("src/Imagens/logo-icon.png");
        this.setIconImage(icon.getImage());
        conexao = Conexao.conecta();
        alunoLogado = Session.getInstance().getAlunoLogado();
        this.acertos2 = acertos;
        this.seconds2 = seconds;

        idAluno = alunoLogado.getIdAluno();

        // Adiciona o MouseListener ao panel_heard
        panel_num3.addMouseListener(panel_num3MouseListener);
        
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds2++;
                minutes = seconds2 / 60;
                remainingSeconds = seconds2 % 60;
            }
        });

        timer.start();
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
        panelSombra2 = new Visualizacao.PanelSombra();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelSombra3 = new Visualizacao.PanelSombra();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelSombra4 = new Visualizacao.PanelSombra();
        jLabel6 = new javax.swing.JLabel();
        panel_num1 = new Visualizacao.PanelSombra();
        jLabel8 = new javax.swing.JLabel();
        panelSombra6 = new Visualizacao.PanelSombra();
        jLabel9 = new javax.swing.JLabel();
        panel_num3 = new Visualizacao.PanelSombra();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_dica = new javax.swing.JLabel();

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
        jLabel3.setText("Some os números");

        javax.swing.GroupLayout panelSombra2Layout = new javax.swing.GroupLayout(panelSombra2);
        panelSombra2.setLayout(panelSombra2Layout);
        panelSombra2Layout.setHorizontalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        panelSombra2Layout.setVerticalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Numbers");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon voltar.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        panelSombra3.setBackground(new java.awt.Color(255, 204, 0));
        panelSombra3.setPreferredSize(new java.awt.Dimension(104, 104));
        panelSombra3.setShadowOpacity(0.3F);
        panelSombra3.setShadowSize(3);
        panelSombra3.setShadowType(Visualizacao.ShadowType.BOT_RIGHT);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("7");

        javax.swing.GroupLayout panelSombra3Layout = new javax.swing.GroupLayout(panelSombra3);
        panelSombra3.setLayout(panelSombra3Layout);
        panelSombra3Layout.setHorizontalGroup(
            panelSombra3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel7)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panelSombra3Layout.setVerticalGroup(
            panelSombra3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-soma.png"))); // NOI18N

        panelSombra4.setBackground(new java.awt.Color(255, 204, 0));
        panelSombra4.setPreferredSize(new java.awt.Dimension(104, 104));
        panelSombra4.setShadowOpacity(0.3F);
        panelSombra4.setShadowSize(3);
        panelSombra4.setShadowType(Visualizacao.ShadowType.BOT_RIGHT);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("6");

        javax.swing.GroupLayout panelSombra4Layout = new javax.swing.GroupLayout(panelSombra4);
        panelSombra4.setLayout(panelSombra4Layout);
        panelSombra4Layout.setHorizontalGroup(
            panelSombra4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelSombra4Layout.setVerticalGroup(
            panelSombra4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        panel_num1.setBackground(new java.awt.Color(255, 102, 102));
        panel_num1.setPreferredSize(new java.awt.Dimension(104, 104));
        panel_num1.setShadowOpacity(0.3F);
        panel_num1.setShadowSize(3);
        panel_num1.setShadowType(Visualizacao.ShadowType.BOT_RIGHT);
        panel_num1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_num1MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("18");

        javax.swing.GroupLayout panel_num1Layout = new javax.swing.GroupLayout(panel_num1);
        panel_num1.setLayout(panel_num1Layout);
        panel_num1Layout.setHorizontalGroup(
            panel_num1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_num1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addGap(21, 21, 21))
        );
        panel_num1Layout.setVerticalGroup(
            panel_num1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_num1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addGap(24, 24, 24))
        );

        panelSombra6.setBackground(new java.awt.Color(51, 204, 255));
        panelSombra6.setPreferredSize(new java.awt.Dimension(104, 104));
        panelSombra6.setShadowOpacity(0.3F);
        panelSombra6.setShadowSize(3);
        panelSombra6.setShadowType(Visualizacao.ShadowType.BOT_RIGHT);
        panelSombra6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSombra6MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("13");

        javax.swing.GroupLayout panelSombra6Layout = new javax.swing.GroupLayout(panelSombra6);
        panelSombra6.setLayout(panelSombra6Layout);
        panelSombra6Layout.setHorizontalGroup(
            panelSombra6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addGap(21, 21, 21))
        );
        panelSombra6Layout.setVerticalGroup(
            panelSombra6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addGap(25, 25, 25))
        );

        panel_num3.setBackground(new java.awt.Color(0, 204, 51));
        panel_num3.setPreferredSize(new java.awt.Dimension(104, 104));
        panel_num3.setShadowOpacity(0.3F);
        panel_num3.setShadowSize(3);
        panel_num3.setShadowType(Visualizacao.ShadowType.BOT_RIGHT);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("20");

        javax.swing.GroupLayout panel_num3Layout = new javax.swing.GroupLayout(panel_num3);
        panel_num3.setLayout(panel_num3Layout);
        panel_num3Layout.setHorizontalGroup(
            panel_num3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_num3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addGap(22, 22, 22))
        );
        panel_num3Layout.setVerticalGroup(
            panel_num3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_num3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addGap(24, 24, 24))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Escolha o resultado");

        btn_dica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-dica-desativada.png"))); // NOI18N
        btn_dica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dicaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2))
                    .addComponent(panelSombra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panelSombra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(panelSombra4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel_num1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(panelSombra6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(panel_num3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_dica, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)))
                .addComponent(panelSombra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSombra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4))
                    .addComponent(panelSombra4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(btn_dica, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_num1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelSombra6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_num3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(customScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new FRegiao().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void panel_num1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_num1MouseClicked
        ImageIcon icon = new ImageIcon("src/Imagens/icon-numeros-alerta.png");
        AlertaGeral alert = new AlertaGeral(FFaseNumeros2.this, icon, "Fase Números", "Que pena.. A resposta era 13", 25, 25);
        alert.setVisible(true);
        calcularPontos();
    }//GEN-LAST:event_panel_num1MouseClicked

    private void panelSombra6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSombra6MouseClicked
        acertos2++;
        ImageIcon icon = new ImageIcon("src/Imagens/icon-numeros-alerta.png");
        AlertaGeral alert = new AlertaGeral(FFaseNumeros2.this, icon, "Fase Números", "Muito Bem!", 25, 25);
        alert.setVisible(true);
        calcularPontos();
    }//GEN-LAST:event_panelSombra6MouseClicked

    private MouseListener panel_num3MouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent evt) {
            ImageIcon icon = new ImageIcon("src/Imagens/icon-numeros-alerta.png");
            AlertaGeral alert = new AlertaGeral(FFaseNumeros2.this, icon, "Fase Números", "Que pena.. A resposta era 13", 25, 25);
            alert.setVisible(true);
            calcularPontos();
        }
    };

    private void btn_dicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dicaMouseClicked
        if (!dicaClicada) {
            String medalha = alunoLogado.getMedalhaAtiva();
            if (medalha.equals("Mundo Concluido!")) {
                // Define o ícone de clique se ainda não foi clicado
                btn_dica.setIcon(iconDicaAtivada);
                panel_num3.setBackground(new Color(210, 210, 210));
                panel_num3.setShadowColor(Color.white);
                panel_num3.setShadowSize(1);
                panel_num3.setShadowType(ShadowType.CENTER);
                panel_num3.removeMouseListener(panel_num3MouseListener);
            } else {
                ImageIcon icon = new ImageIcon("src/Imagens/icon-dica-alerta.png");
                AlertaGeral alert = new AlertaGeral(this, icon, "Dica Indisponível", "Ative ou consiga a medalha de mundo concluido para liberar", 50, 50);
                alert.setVisible(true);
            }
            dicaClicada = true;
        } else {
            btn_dica.setIcon(iconDicaDesativada);
            panel_num3.setBackground(new Color(0, 204, 51));
            panel_num3.setShadowColor(new Color(0, 0, 0));
            panel_num3.setShadowSize(3);
            panel_num3.setShadowType(ShadowType.BOT_RIGHT);
            // Adiciona o MouseListener ao panel_heard
            panel_num3.addMouseListener(panel_num3MouseListener);
            dicaClicada = false;
        }
    }//GEN-LAST:event_btn_dicaMouseClicked

    private void calcularPontos() {
        double porcAcerto;
        porcAcerto = ((double) acertos2 / 2) * 100;

        double pontos;
        pontos = ((double) porcAcerto * 0.7) + ((int) seconds2 * 0.3);
        String medalha = alunoLogado.getMedalhaAtiva();
        if (medalha.equals("Iniciando!")) {
            pontos = pontos + 50;
        } else if (medalha.equals("A todo vapor!")) {
            pontos = pontos * 2;
        }

        fase.setIdFase(2);
        fase.setIdAluno(idAluno);
        fase.setPontos(pontos);
        fase.setTempoConclusao(minutes, remainingSeconds);
        fase.setPorcAcertos(porcAcerto);
        fase.cadastrar();
        timer.stop();
        inserirNotificacao();
        new FFaseConcluida().setVisible(true);
        dispose();
    }

    private void inserirNotificacao() {
        String sql;
        sql = "insert into notificacoes(idAluno, notificacao, descNotificacao, iconNotificacao) values"
                + "(?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, alunoLogado.getIdAluno());
            pst.setString(2, "Fase Concluida");
            pst.setString(3, "Voce concluiu a fase de numeros!");
            pst.setString(4, "icon-medalha-notificacao.png");
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
            java.util.logging.Logger.getLogger(FFaseNumeros2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FFaseNumeros2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FFaseNumeros2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FFaseNumeros2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FFaseNumeros2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_dica;
    private Visualizacao.CustomScrollPane customScrollPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private Visualizacao.PanelSombra panelSombra1;
    private Visualizacao.PanelSombra panelSombra2;
    private Visualizacao.PanelSombra panelSombra3;
    private Visualizacao.PanelSombra panelSombra4;
    private Visualizacao.PanelSombra panelSombra6;
    private Visualizacao.PanelSombra panel_num1;
    private Visualizacao.PanelSombra panel_num3;
    // End of variables declaration//GEN-END:variables
}
