/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Controle.Conexao;
import Modelagem.Aluno;
import Modelagem.NavegacaoFormulario;
import Modelagem.Session;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FOpcoes extends NavegacaoFormulario {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Color pretoComOpacidade = new Color(72, 72, 72, 120);
    Color vermelhoPastel = new Color(239, 91, 106);
    Color azulPastel = new Color(108, 210, 255);

    Color azul = new Color(83, 194, 242);
    Color verde = new Color(128, 210, 91);
    Color vermelho = new Color(239, 91, 106);
    Color amarelo = new Color(255, 179, 0);
    private Aluno alunoLogado;



    public FOpcoes(JFrame telaDeOrigem) {
        super(telaDeOrigem, TelaOrigem.OPCOES);
        initComponents();
        ImageIcon icon = new ImageIcon("src/Imagens/logo-icon.png");
        this.setIconImage(icon.getImage());
        conexao = Conexao.conecta();
        alunoLogado = Session.getInstance().getAlunoLogado();
        
        panel_icon1.setBackground(pretoComOpacidade);
        panel_icon2.setBackground(pretoComOpacidade);
        panel_icon3.setBackground(pretoComOpacidade);

        panel_diaria1.setVisible(false);
        panel_diaria2.setVisible(false);
        panel_diaria3.setVisible(false);
        carregarMissoes();
    }

    private void carregarMissoes() {
        String sql = "select * from missoesDiarias join missoes using(idMissao) where idAluno = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, alunoLogado.getIdAluno());
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

                if (nomeMissao.equals("Atividades 1")) {
                    panelsDiarias[cont].setGradientStartColor(vermelho);
                    panelsDiarias[cont].setGradientEndColor(azul);
                } else if (nomeMissao.equals("Atividades 2")) {
                    panelsDiarias[cont].setGradientStartColor(vermelho);
                    panelsDiarias[cont].setGradientEndColor(azul);
                } else if (nomeMissao.equals("Visual")) {
                    panelsDiarias[cont].setGradientStartColor(azul);
                    panelsDiarias[cont].setGradientEndColor(azul);
                } else if (nomeMissao.equals("Ouvir")) {
                    panelsDiarias[cont].setGradientStartColor(vermelho);
                    panelsDiarias[cont].setGradientEndColor(vermelho);
                } else if (nomeMissao.equals("Numeros")) {
                    panelsDiarias[cont].setGradientStartColor(amarelo);
                    panelsDiarias[cont].setGradientEndColor(amarelo);
                } else if (nomeMissao.equals("Observacao")) {
                    panelsDiarias[cont].setGradientStartColor(verde);
                    panelsDiarias[cont].setGradientEndColor(verde);
                } else if(nomeMissao.equals("Mundo")){
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

    private void abrirNotificacoes() {
        FNotificacao notificacoes = new FNotificacao(this, null);
        notificacoes.setVisible(true);
        this.setVisible(false);
    }
    
    private void abrirRanking() {
        FRanking ranking = new FRanking(this);
        ranking.setVisible(true);
        this.setVisible(false);
    }
    
    private void abrirEstatistica() {
        FEstatistica estatisticas = new FEstatistica(this);
        estatisticas.setVisible(true);
        this.setVisible(false);
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
        panelGradienteHorizontal1 = new Visualizacao.PanelGradiente();
        panelRound1 = new Visualizacao.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelRound3 = new Visualizacao.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelGradiente2 = new Visualizacao.PanelGradiente();
        panel_icon1 = new Visualizacao.PanelSombra();
        jLabel3 = new javax.swing.JLabel();
        panel_icon2 = new Visualizacao.PanelSombra();
        jLabel4 = new javax.swing.JLabel();
        panel_icon3 = new Visualizacao.PanelSombra();
        jLabel5 = new javax.swing.JLabel();
        panelSombra5 = new Visualizacao.PanelSombra();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelSombra6 = new Visualizacao.PanelSombra();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelSombra7 = new Visualizacao.PanelSombra();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panelSombra2 = new Visualizacao.PanelSombra();
        panel_diaria1 = new Visualizacao.PanelRoundBorda();
        lbl_missao1 = new javax.swing.JLabel();
        icon_missao1 = new javax.swing.JLabel();
        panel_diaria3 = new Visualizacao.PanelRoundBorda();
        lbl_missao3 = new javax.swing.JLabel();
        icon_missao3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panel_diaria2 = new Visualizacao.PanelRoundBorda();
        lbl_missao2 = new javax.swing.JLabel();
        icon_missao2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customScrollPane1.setBorder(null);
        customScrollPane1.setPreferredSize(new java.awt.Dimension(485, 834));

        panelGradienteHorizontal1.setGradientEndColor(new java.awt.Color(97, 145, 175));
        panelGradienteHorizontal1.setGradientStartColor(new java.awt.Color(175, 73, 85));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundTopLeft(70);
        panelRound1.setRoundTopRight(70);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Opções");

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

        panelRound3.setBackground(new java.awt.Color(72, 72, 72));
        panelRound3.setRoundBottomLeft(40);
        panelRound3.setRoundBottomRight(40);
        panelRound3.setRoundTopLeft(40);
        panelRound3.setRoundTopRight(40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-pesquisa.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pesquisar fases");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(11, 11, 11))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelGradiente2.setGradientDirection(Visualizacao.PanelGradiente.GradientDirection.DIAGONAL_DOWN);
        panelGradiente2.setGradientEndColor(new java.awt.Color(86, 168, 204));
        panelGradiente2.setGradientStartColor(new java.awt.Color(171, 91, 108));
        panelGradiente2.setRadius(50);
        panelGradiente2.setVerticalProportion(1.2F);

        panel_icon1.setBackground(new java.awt.Color(102, 102, 102));
        panel_icon1.setCornerRadius(100);
        panel_icon1.setPreferredSize(new java.awt.Dimension(50, 50));
        panel_icon1.setShadowOpacity(0.3F);
        panel_icon1.setShadowSize(3);
        panel_icon1.setShadowType(Visualizacao.ShadowType.BOT);
        panel_icon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_icon1MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-notificacao.png"))); // NOI18N
        jLabel3.setToolTipText("");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_icon1Layout = new javax.swing.GroupLayout(panel_icon1);
        panel_icon1.setLayout(panel_icon1Layout);
        panel_icon1Layout.setHorizontalGroup(
            panel_icon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_icon1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panel_icon1Layout.setVerticalGroup(
            panel_icon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_icon1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panel_icon2.setBackground(new java.awt.Color(102, 102, 102));
        panel_icon2.setCornerRadius(100);
        panel_icon2.setPreferredSize(new java.awt.Dimension(50, 50));
        panel_icon2.setShadowOpacity(0.3F);
        panel_icon2.setShadowSize(3);
        panel_icon2.setShadowType(Visualizacao.ShadowType.BOT);
        panel_icon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_icon2MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-sair-branco.png"))); // NOI18N

        javax.swing.GroupLayout panel_icon2Layout = new javax.swing.GroupLayout(panel_icon2);
        panel_icon2.setLayout(panel_icon2Layout);
        panel_icon2Layout.setHorizontalGroup(
            panel_icon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_icon2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panel_icon2Layout.setVerticalGroup(
            panel_icon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_icon2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panel_icon3.setBackground(new java.awt.Color(102, 102, 102));
        panel_icon3.setCornerRadius(100);
        panel_icon3.setPreferredSize(new java.awt.Dimension(50, 50));
        panel_icon3.setShadowOpacity(0.3F);
        panel_icon3.setShadowSize(3);
        panel_icon3.setShadowType(Visualizacao.ShadowType.BOT);
        panel_icon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_icon3MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-rank.png"))); // NOI18N

        javax.swing.GroupLayout panel_icon3Layout = new javax.swing.GroupLayout(panel_icon3);
        panel_icon3.setLayout(panel_icon3Layout);
        panel_icon3Layout.setHorizontalGroup(
            panel_icon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_icon3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panel_icon3Layout.setVerticalGroup(
            panel_icon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_icon3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGradiente2Layout = new javax.swing.GroupLayout(panelGradiente2);
        panelGradiente2.setLayout(panelGradiente2Layout);
        panelGradiente2Layout.setHorizontalGroup(
            panelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradiente2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(panel_icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(panel_icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(panel_icon3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        panelGradiente2Layout.setVerticalGroup(
            panelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradiente2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(panelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_icon1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_icon2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_icon3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        panelSombra5.setBackground(new java.awt.Color(83, 194, 242));
        panelSombra5.setCornerRadius(40);
        panelSombra5.setShadowOpacity(0.3F);
        panelSombra5.setShadowSize(3);
        panelSombra5.setShadowType(Visualizacao.ShadowType.BOT_LEFT);
        panelSombra5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSombra5MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Todos os Mundos");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ver todos os mundos");

        javax.swing.GroupLayout panelSombra5Layout = new javax.swing.GroupLayout(panelSombra5);
        panelSombra5.setLayout(panelSombra5Layout);
        panelSombra5Layout.setHorizontalGroup(
            panelSombra5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra5Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(panelSombra5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        panelSombra5Layout.setVerticalGroup(
            panelSombra5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        panelSombra6.setBackground(new java.awt.Color(128, 210, 91));
        panelSombra6.setCornerRadius(40);
        panelSombra6.setShadowOpacity(0.3F);
        panelSombra6.setShadowSize(3);
        panelSombra6.setShadowType(Visualizacao.ShadowType.BOT_LEFT);
        panelSombra6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSombra6MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Estatísticas e");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Veja o seu progresso");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Medalhas");

        javax.swing.GroupLayout panelSombra6Layout = new javax.swing.GroupLayout(panelSombra6);
        panelSombra6.setLayout(panelSombra6Layout);
        panelSombra6Layout.setHorizontalGroup(
            panelSombra6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra6Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(panelSombra6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        panelSombra6Layout.setVerticalGroup(
            panelSombra6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        panelSombra7.setBackground(new java.awt.Color(255, 179, 0));
        panelSombra7.setCornerRadius(40);
        panelSombra7.setShadowOpacity(0.3F);
        panelSombra7.setShadowSize(3);
        panelSombra7.setShadowType(Visualizacao.ShadowType.BOT_LEFT);
        panelSombra7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSombra7MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Suas Fases");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("fases realizadas recentemente");

        javax.swing.GroupLayout panelSombra7Layout = new javax.swing.GroupLayout(panelSombra7);
        panelSombra7.setLayout(panelSombra7Layout);
        panelSombra7Layout.setHorizontalGroup(
            panelSombra7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra7Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(panelSombra7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        panelSombra7Layout.setVerticalGroup(
            panelSombra7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        panelSombra2.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra2.setCornerRadius(50);

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
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

        javax.swing.GroupLayout panelSombra2Layout = new javax.swing.GroupLayout(panelSombra2);
        panelSombra2.setLayout(panelSombra2Layout);
        panelSombra2Layout.setHorizontalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra2Layout.createSequentialGroup()
                .addGroup(panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSombra2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel_diaria3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel_diaria2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel_diaria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelSombra2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        panelSombra2Layout.setVerticalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(38, 38, 38)
                .addComponent(panel_diaria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panel_diaria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panel_diaria3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1)
                        .addGap(105, 105, 105)
                        .addComponent(jLabel13))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelGradiente2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(panelSombra2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelSombra5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelSombra6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelSombra7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13))
                .addGap(48, 48, 48)
                .addComponent(panelGradiente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(panelSombra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(panelSombra5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(panelSombra6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(panelSombra7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGradienteHorizontal1Layout = new javax.swing.GroupLayout(panelGradienteHorizontal1);
        panelGradienteHorizontal1.setLayout(panelGradienteHorizontal1Layout);
        panelGradienteHorizontal1Layout.setHorizontalGroup(
            panelGradienteHorizontal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGradienteHorizontal1Layout.setVerticalGroup(
            panelGradienteHorizontal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradienteHorizontal1Layout.createSequentialGroup()
                .addGap(0, 103, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        customScrollPane1.setViewportView(panelGradienteHorizontal1);

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
        voltarParaOrigem();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel13MouseExited

    private void panel_icon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_icon1MouseClicked
        abrirNotificacoes();
    }//GEN-LAST:event_panel_icon1MouseClicked

    private void panel_icon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_icon2MouseClicked
        new FLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_panel_icon2MouseClicked

    private void panel_icon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_icon3MouseClicked
        abrirRanking();
    }//GEN-LAST:event_panel_icon3MouseClicked

    private void panelSombra5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSombra5MouseClicked
        new FMundos().setVisible(true);
        dispose();
    }//GEN-LAST:event_panelSombra5MouseClicked

    private void panelSombra6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSombra6MouseClicked
        abrirEstatistica();
    }//GEN-LAST:event_panelSombra6MouseClicked

    private void panelSombra7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSombra7MouseClicked
        new FFasesRecentes(this).setVisible(true);
        dispose();
    }//GEN-LAST:event_panelSombra7MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        abrirNotificacoes();
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(FOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FOpcoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Visualizacao.CustomScrollPane customScrollPane1;
    private javax.swing.JLabel icon_missao1;
    private javax.swing.JLabel icon_missao2;
    private javax.swing.JLabel icon_missao3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl_missao1;
    private javax.swing.JLabel lbl_missao2;
    private javax.swing.JLabel lbl_missao3;
    private Visualizacao.PanelGradiente panelGradiente2;
    private Visualizacao.PanelGradiente panelGradienteHorizontal1;
    private Visualizacao.PanelRound panelRound1;
    private Visualizacao.PanelRound panelRound3;
    private Visualizacao.PanelSombra panelSombra2;
    private Visualizacao.PanelSombra panelSombra5;
    private Visualizacao.PanelSombra panelSombra6;
    private Visualizacao.PanelSombra panelSombra7;
    private Visualizacao.PanelRoundBorda panel_diaria1;
    private Visualizacao.PanelRoundBorda panel_diaria2;
    private Visualizacao.PanelRoundBorda panel_diaria3;
    private Visualizacao.PanelSombra panel_icon1;
    private Visualizacao.PanelSombra panel_icon2;
    private Visualizacao.PanelSombra panel_icon3;
    // End of variables declaration//GEN-END:variables
}
