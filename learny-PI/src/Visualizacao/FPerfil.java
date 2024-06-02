
package Visualizacao;

import Controle.Conexao;
import Modelagem.Aluno;
import Modelagem.Config;
import Modelagem.NavegacaoFormulario;
import Modelagem.Session;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;

public class FPerfil extends NavegacaoFormulario {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private Aluno alunoLogado;

    public FPerfil(JFrame telaDeOrigem) {
        super(telaDeOrigem, TelaOrigem.PERFIL);
        initComponents();
        alunoLogado = Session.getInstance().getAlunoLogado();
        String nome = alunoLogado.getNome();
        double pontos = alunoLogado.getPontosTotais();
        int nivel = (int) (pontos / 100);
        double progressoNivel = pontos % 100;
        String foto = alunoLogado.getFoto();
        barra_nivel.setValue((int) progressoNivel);
        lbl_nome_perfil.setText(nome);
        lbl_anos.setText(Integer.toString(nivel));
        panel_foto_perfil.setImagem("src/Imagens/" + foto);
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

        panelScrollGeral = new Visualizacao.CustomScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panelSombra1 = new Visualizacao.PanelSombra();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        panelSombra2 = new Visualizacao.PanelSombra();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_nome_perfil = new javax.swing.JLabel();
        panelSombra6 = new Visualizacao.PanelSombra();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_idade_perfil = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelSombra3 = new Visualizacao.PanelSombra();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_anos = new javax.swing.JLabel();
        panelSombra7 = new Visualizacao.PanelSombra();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        panel_foto_perfil = new Visualizacao.PanelRoundPerfil();
        panelRoundBorda1 = new Visualizacao.PanelRoundBorda();
        barra_nivel = new Visualizacao.ProgressBar();
        panelSombra4 = new Visualizacao.PanelSombra();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelSombra8 = new Visualizacao.PanelSombra();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        toggleButton1 = new Visualizacao.ToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        toggleButton2 = new Visualizacao.ToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelScrollGeral.setBorder(null);
        panelScrollGeral.setPreferredSize(new java.awt.Dimension(485, 834));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelSombra1.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra1.setCornerRadius(70);
        panelSombra1.setPreferredSize(new java.awt.Dimension(406, 90));
        panelSombra1.setShadowOpacity(0.2F);
        panelSombra1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSombra1MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Estatísticas");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon estatisticas.png"))); // NOI18N

        javax.swing.GroupLayout panelSombra1Layout = new javax.swing.GroupLayout(panelSombra1);
        panelSombra1.setLayout(panelSombra1Layout);
        panelSombra1Layout.setHorizontalGroup(
            panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSombra1Layout.setVerticalGroup(
            panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelSombra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(panelSombra1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel19)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelSombra2.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra2.setCornerRadius(70);
        panelSombra2.setPreferredSize(new java.awt.Dimension(406, 90));
        panelSombra2.setShadowOpacity(0.2F);
        panelSombra2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSombra2MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon google.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Ranking");

        javax.swing.GroupLayout panelSombra2Layout = new javax.swing.GroupLayout(panelSombra2);
        panelSombra2.setLayout(panelSombra2Layout);
        panelSombra2Layout.setHorizontalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSombra2Layout.setVerticalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        lbl_nome_perfil.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_nome_perfil.setForeground(new java.awt.Color(83, 194, 242));
        lbl_nome_perfil.setText("Nome");

        panelSombra6.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra6.setCornerRadius(70);
        panelSombra6.setPreferredSize(new java.awt.Dimension(152, 72));
        panelSombra6.setShadowOpacity(0.2F);
        panelSombra6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSombra6MouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon sair.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Sair");

        javax.swing.GroupLayout panelSombra6Layout = new javax.swing.GroupLayout(panelSombra6);
        panelSombra6.setLayout(panelSombra6Layout);
        panelSombra6Layout.setHorizontalGroup(
            panelSombra6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra6Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(0, 39, Short.MAX_VALUE))
        );
        panelSombra6Layout.setVerticalGroup(
            panelSombra6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14))
            .addGroup(panelSombra6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_idade_perfil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_idade_perfil.setForeground(new java.awt.Color(102, 102, 102));
        lbl_idade_perfil.setText("Lvl.");

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

        panelSombra3.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra3.setCornerRadius(70);
        panelSombra3.setPreferredSize(new java.awt.Dimension(406, 90));
        panelSombra3.setShadowOpacity(0.2F);
        panelSombra3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSombra3MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Notificações");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon sino.png"))); // NOI18N

        javax.swing.GroupLayout panelSombra3Layout = new javax.swing.GroupLayout(panelSombra3);
        panelSombra3.setLayout(panelSombra3Layout);
        panelSombra3Layout.setHorizontalGroup(
            panelSombra3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSombra3Layout.setVerticalGroup(
            panelSombra3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(panelSombra3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSombra3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(20, 20, 20))))
        );

        lbl_anos.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbl_anos.setForeground(new java.awt.Color(102, 102, 102));
        lbl_anos.setText("Nível");

        panelSombra7.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra7.setCornerRadius(70);
        panelSombra7.setPreferredSize(new java.awt.Dimension(188, 75));
        panelSombra7.setShadowOpacity(0.2F);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon contato.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Contato");

        javax.swing.GroupLayout panelSombra7Layout = new javax.swing.GroupLayout(panelSombra7);
        panelSombra7.setLayout(panelSombra7Layout);
        panelSombra7Layout.setHorizontalGroup(
            panelSombra7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra7Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        panelSombra7Layout.setVerticalGroup(
            panelSombra7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelSombra7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_foto_perfil.setBackground(new java.awt.Color(255, 255, 255));
        panel_foto_perfil.setPreferredSize(new java.awt.Dimension(150, 140));
        panel_foto_perfil.setRoundBottomLeft(50);
        panel_foto_perfil.setRoundBottomRight(50);
        panel_foto_perfil.setRoundTopLeft(50);
        panel_foto_perfil.setRoundTopRight(50);

        javax.swing.GroupLayout panel_foto_perfilLayout = new javax.swing.GroupLayout(panel_foto_perfil);
        panel_foto_perfil.setLayout(panel_foto_perfilLayout);
        panel_foto_perfilLayout.setHorizontalGroup(
            panel_foto_perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        panel_foto_perfilLayout.setVerticalGroup(
            panel_foto_perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        panelRoundBorda1.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundBorda1.setBorderWidth(3);
        panelRoundBorda1.setPreferredSize(new java.awt.Dimension(406, 45));
        panelRoundBorda1.setRadius(50);

        barra_nivel.setBorder(null);
        barra_nivel.setValue(300);
        barra_nivel.setColorString(new java.awt.Color(255, 255, 255));
        barra_nivel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelRoundBorda1Layout = new javax.swing.GroupLayout(panelRoundBorda1);
        panelRoundBorda1.setLayout(panelRoundBorda1Layout);
        panelRoundBorda1Layout.setHorizontalGroup(
            panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundBorda1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(barra_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelRoundBorda1Layout.setVerticalGroup(
            panelRoundBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundBorda1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(barra_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        panelSombra4.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra4.setCornerRadius(70);
        panelSombra4.setPreferredSize(new java.awt.Dimension(406, 90));
        panelSombra4.setShadowOpacity(0.2F);
        panelSombra4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSombra4MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Editar perfil");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon lapis.png"))); // NOI18N

        javax.swing.GroupLayout panelSombra4Layout = new javax.swing.GroupLayout(panelSombra4);
        panelSombra4.setLayout(panelSombra4Layout);
        panelSombra4Layout.setHorizontalGroup(
            panelSombra4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSombra4Layout.setVerticalGroup(
            panelSombra4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSombra4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelSombra4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        panelSombra8.setBackground(new java.awt.Color(255, 255, 255));
        panelSombra8.setCornerRadius(70);
        panelSombra8.setShadowOpacity(0.2F);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Acessibilidade");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Ativar áudio");

        toggleButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        toggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toggleButton1MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-acessibilidade.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Mudar Cores");

        toggleButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelSombra8Layout = new javax.swing.GroupLayout(panelSombra8);
        panelSombra8.setLayout(panelSombra8Layout);
        panelSombra8Layout.setHorizontalGroup(
            panelSombra8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra8Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panelSombra8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSombra8Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelSombra8Layout.createSequentialGroup()
                        .addGroup(panelSombra8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSombra8Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(toggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelSombra8Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(toggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54))))
        );
        panelSombra8Layout.setVerticalGroup(
            panelSombra8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelSombra8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(panelSombra8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSombra8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSombra8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSombra8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelRoundBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelSombra1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelSombra2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelSombra3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelSombra4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelSombra8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel_foto_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addComponent(jLabel13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nome_perfil)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_idade_perfil)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_anos)))))))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSombra6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelSombra7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(10, 10, 10)
                        .addComponent(lbl_nome_perfil)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_idade_perfil)
                            .addComponent(lbl_anos)))
                    .addComponent(panel_foto_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelRoundBorda1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(panelSombra8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelSombra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelSombra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelSombra4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSombra6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelSombra7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        panelScrollGeral.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelScrollGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelScrollGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void panelSombra1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSombra1MouseClicked
        abrirEstatistica();
    }//GEN-LAST:event_panelSombra1MouseClicked

    private void panelSombra2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSombra2MouseClicked
        abrirRanking();
    }//GEN-LAST:event_panelSombra2MouseClicked

    private void panelSombra3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSombra3MouseClicked
        abrirNotificacoes();
    }//GEN-LAST:event_panelSombra3MouseClicked

    private void panelSombra4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSombra4MouseClicked
        new FEditarPerfil(this).setVisible(true);
        dispose();
    }//GEN-LAST:event_panelSombra4MouseClicked

    private void panelSombra6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSombra6MouseClicked
        new FLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_panelSombra6MouseClicked

    private void toggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toggleButton1MouseClicked
        Config.audioAtivado = !Config.audioAtivado;
    }//GEN-LAST:event_toggleButton1MouseClicked

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
            java.util.logging.Logger.getLogger(FPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Visualizacao.ProgressBar barra_nivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_anos;
    private javax.swing.JLabel lbl_idade_perfil;
    private javax.swing.JLabel lbl_nome_perfil;
    private Visualizacao.PanelRoundBorda panelRoundBorda1;
    private Visualizacao.CustomScrollPane panelScrollGeral;
    private Visualizacao.PanelSombra panelSombra1;
    private Visualizacao.PanelSombra panelSombra2;
    private Visualizacao.PanelSombra panelSombra3;
    private Visualizacao.PanelSombra panelSombra4;
    private Visualizacao.PanelSombra panelSombra6;
    private Visualizacao.PanelSombra panelSombra7;
    private Visualizacao.PanelSombra panelSombra8;
    private Visualizacao.PanelRoundPerfil panel_foto_perfil;
    private Visualizacao.ToggleButton toggleButton1;
    private Visualizacao.ToggleButton toggleButton2;
    // End of variables declaration//GEN-END:variables
}
