/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Controle.Conexao;
import Modelagem.Aluno;
import Modelagem.FaseConcluida;
import Modelagem.Session;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author João
 */
public class FFaseLigar extends javax.swing.JFrame {

    /**
     * Creates new form FFase
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private Aluno alunoLogado;
    
    Color azul = new Color(83, 194, 242);
    Color verde = new Color(128,210,91);
    Color vermelho = new Color(239,91,106);
    Color amarelo = new Color(255,179,0);
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
    
    private Timer timer;
    private int seconds = 0;
    private int minutes;
    private int remainingSeconds;
    
    private int acertos;
    private int idAluno;
    
    private boolean linhaVisivelCobra = false;
    private boolean linhaVisivelCavalo = false;
    private boolean linhaVisivelPassaro = false;
    private boolean linhaVisivelMacaco = false;
     
    public FFaseLigar() {  
        initComponents();
        alunoLogado = Session.getInstance().getAlunoLogado();
        conexao = Conexao.conecta();
        if (alunoLogado == null) {
            // Se não houver aluno logado, redirecione para a tela de login
            new FLogin().setVisible(true);
            this.dispose();
            return;
        }
        this.acertos = 0;
        
        idAluno = alunoLogado.getIdAluno();
        
        // Adiciona uma label para desenhar a linha para as cobras
        JLabel lineLabelCobra = new JLabel();
        lineLabelCobra.setBounds(0, 0, panel_cobra.getWidth(), panel_cobra.getHeight());
        panel_cobra.add(lineLabelCobra);
        
        // Adiciona uma label para desenhar a linha para os cavalos
        JLabel lineLabelCavalo = new JLabel();
        lineLabelCavalo.setBounds(0, 0, panel_cavalo.getWidth(), panel_cavalo.getHeight());
        panel_cavalo.add(lineLabelCavalo);
        
        // Adiciona uma label para desenhar a linha para os Passaros
        JLabel lineLabelPassaro = new JLabel();
        lineLabelPassaro.setBounds(0, 0, panel_passaro.getWidth(), panel_passaro.getHeight());
        panel_passaro.add(lineLabelPassaro);
        
        // Adiciona uma label para desenhar a linha para as cobras
        JLabel lineLabelMacaco = new JLabel();
        lineLabelMacaco.setBounds(0, 0, panel_macaco.getWidth(), panel_macaco.getHeight());
        panel_macaco.add(lineLabelMacaco);
        
        // Adiciona um ouvinte de eventos ao rótulo lbl_cobra
        lbl_cobra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!cobraClicada) {
                    // Define o ícone de clique se ainda não foi clicado
                    lbl_cobra.setIcon(iconCobraClick);
                    cobraClicada = true;
                } else {
                    lbl_cobra.setIcon(iconCobra);
                    cobraClicada = false;
                }
                // Desenha a linha
                if (cobraClicada && cobraClicadaDir) {
                    desenharLinha(lbl_cobra, lbl_cobra_dir, panel_cobra, azul);
                    linhaVisivelCobra = true;
                } else {
                    apagarLinha(panel_cobra); // Se não, apague a linha no painel correspondente
                    linhaVisivelCobra = false;
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
                } else {
                    // Define o ícone padrão se já foi clicado
                    lbl_cobra_dir.setIcon(iconCobra);
                    cobraClicadaDir = false;
                }
                // Desenha a linha
                if (cobraClicada && cobraClicadaDir) {
                    desenharLinha(lbl_cobra, lbl_cobra_dir, panel_cobra, azul);
                    linhaVisivelCobra = true;
                } else {
                    apagarLinha(panel_cobra); // Se não, apague a linha no painel correspondente
                    linhaVisivelCobra = false;
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
                } else {
                    // Define o ícone padrão se já foi clicado
                    lbl_cavalo.setIcon(iconCavalo);
                    cavaloClicado = false;
                }
                // Desenha a linha
                if (cavaloClicado && cavaloClicadoDir) {
                    desenharLinha(lbl_cavalo, lbl_cavalo_dir, panel_cavalo, verde);
                    linhaVisivelCavalo = true;
                } else {
                    apagarLinha(panel_cavalo); // Se não, apague a linha no painel correspondente
                    linhaVisivelCavalo = false;
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
                } else {
                    // Define o ícone padrão se já foi clicado
                    lbl_cavalo_dir.setIcon(iconCavalo);
                    cavaloClicadoDir = false;
                }
                // Desenha a linha
                if (cavaloClicado && cavaloClicadoDir) {
                    desenharLinha(lbl_cavalo, lbl_cavalo_dir, panel_cavalo, verde);
                    linhaVisivelCavalo = true;
                } else {
                    apagarLinha(panel_cavalo); // Se não, apague a linha no painel correspondente
                    linhaVisivelCavalo = false;
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
                } else {
                    // Define o ícone padrão se já foi clicado
                    lbl_passaro.setIcon(iconPassaro);
                    passaroClicado = false;
                }
                // Desenha a linha
                if (passaroClicado && passaroClicadoDir) {
                    desenharLinha(lbl_passaro, lbl_passaro_dir, panel_passaro, vermelho);
                    linhaVisivelPassaro = true;
                } else {
                    apagarLinha(panel_passaro); // Se não, apague a linha no painel correspondente
                    linhaVisivelPassaro = false;
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
                } else {
                    // Define o ícone padrão se já foi clicado
                    lbl_passaro_dir.setIcon(iconPassaro);
                    passaroClicadoDir = false;
                }
                // Desenha a linha
                if (passaroClicado && passaroClicadoDir) {
                    desenharLinha(lbl_passaro, lbl_passaro_dir, panel_passaro, vermelho);
                    linhaVisivelPassaro = true;
                } else {
                    apagarLinha(panel_passaro); // Se não, apague a linha no painel correspondente
                    linhaVisivelPassaro = false;
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
                } else {
                    // Define o ícone padrão se já foi clicado
                    lbl_macaco.setIcon(iconMacaco);
                    macacoClicado = false;
                }
                // Desenha a linha
                if (macacoClicado && macacoClicadoDir) {
                    desenharLinha(lbl_macaco, lbl_macaco_dir, panel_macaco, amarelo);
                    linhaVisivelMacaco = true;
                } else {
                    apagarLinha(panel_macaco); // Se não, apague a linha no painel correspondente
                    linhaVisivelMacaco = false;
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
                } else {
                    lbl_macaco_dir.setIcon(iconMacaco);
                    macacoClicadoDir = false;
                }
                // Desenha a linha
                if (macacoClicado && macacoClicadoDir) {
                    desenharLinha(lbl_macaco, lbl_macaco_dir, panel_macaco, amarelo);
                    linhaVisivelMacaco = true;
                } else {
                    apagarLinha(panel_macaco); // Se não, apague a linha no painel correspondente
                    linhaVisivelMacaco = false;
                }
            }
        });
        
        // Configuranod o timer
        timer = new Timer(1000, new ActionListener() {

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
    
    public void desenharLinha(JLabel lbl1, JLabel lbl2, JPanel panel, Color cor){
        int panelCenterX = panel.getWidth() / 2;
        int panelCenterY = panel.getHeight() / 2;

        int startX = lbl1.getX() + lbl1.getWidth() / 2;
        int startY = lbl1.getY() + lbl1.getHeight() / 2;
        int endX = lbl2.getX() + lbl2.getWidth() / 2;
        int endY = lbl2.getY() + lbl2.getHeight() / 2;

        // Calcular o deslocamento necessário para centralizar a linha
        int offsetX = panelCenterX - (startX + endX) / 2;
        int offsetY = panelCenterY - (startY + endY) / 2;

        startX += offsetX;
        startY += offsetY;
        endX += offsetX;
        endY += offsetY;

        // Obtenha o objeto Graphics2D
        Graphics2D g2 = (Graphics2D) panel.getGraphics();

        // Defina a cor e a espessura da linha com bordas arredondadas
        g2.setColor(cor); // Defina a cor da linha
        g2.setStroke(new BasicStroke(5));// Defina a espessura da linha e bordas arredondadas

        // Desenhe a linha
        g2.drawLine(startX, startY, endX, endY);
    }
    
    public void apagarLinha(JPanel panel) {
        panel.repaint();
    }
    
    public void resetarIcone(){
    
    }
    
    public void verificarAcertos() {
        if(linhaVisivelCobra){
            acertos++;
        }
        if(linhaVisivelCavalo){
            acertos++;
        }
        if(linhaVisivelPassaro){
            acertos++;
        }
        if(linhaVisivelMacaco){
            acertos++;
        }
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
        lbl_cavalo = new javax.swing.JLabel();
        lbl_passaro = new javax.swing.JLabel();
        lbl_macaco = new javax.swing.JLabel();
        lbl_cavalo_dir = new javax.swing.JLabel();
        lbl_passaro_dir = new javax.swing.JLabel();
        lbl_macaco_dir = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panel_cobra = new javax.swing.JPanel();
        lbl_cobra_dir = new javax.swing.JLabel();
        lbl_cobra = new javax.swing.JLabel();
        panel_cavalo = new javax.swing.JPanel();
        panel_passaro = new javax.swing.JPanel();
        panel_macaco = new javax.swing.JPanel();

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
                .addGap(77, 77, 77)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel1.setText("Connect");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon voltar.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        lbl_cavalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cavalo.png"))); // NOI18N

        lbl_passaro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/passaro.png"))); // NOI18N

        lbl_macaco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/macaco.png"))); // NOI18N

        lbl_cavalo_dir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cavalo.png"))); // NOI18N

        lbl_passaro_dir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/passaro.png"))); // NOI18N

        lbl_macaco_dir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/macaco.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-confirmar.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 255));
        jLabel6.setText("Watch and");

        panel_cobra.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_cobraLayout = new javax.swing.GroupLayout(panel_cobra);
        panel_cobra.setLayout(panel_cobraLayout);
        panel_cobraLayout.setHorizontalGroup(
            panel_cobraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        panel_cobraLayout.setVerticalGroup(
            panel_cobraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        lbl_cobra_dir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cobra.png"))); // NOI18N

        lbl_cobra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cobra.png"))); // NOI18N

        panel_cavalo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_cavaloLayout = new javax.swing.GroupLayout(panel_cavalo);
        panel_cavalo.setLayout(panel_cavaloLayout);
        panel_cavaloLayout.setHorizontalGroup(
            panel_cavaloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        panel_cavaloLayout.setVerticalGroup(
            panel_cavaloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        panel_passaro.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_passaroLayout = new javax.swing.GroupLayout(panel_passaro);
        panel_passaro.setLayout(panel_passaroLayout);
        panel_passaroLayout.setHorizontalGroup(
            panel_passaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        panel_passaroLayout.setVerticalGroup(
            panel_passaroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        panel_macaco.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_macacoLayout = new javax.swing.GroupLayout(panel_macaco);
        panel_macaco.setLayout(panel_macacoLayout);
        panel_macacoLayout.setHorizontalGroup(
            panel_macacoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        panel_macacoLayout.setVerticalGroup(
            panel_macacoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))))
                    .addComponent(panelSombra2, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_passaro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel_passaro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_cavalo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel_cavalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_cavalo_dir)
                                    .addComponent(lbl_passaro_dir))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_macaco)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel_macaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_macaco_dir))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_cobra)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel_cobra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_cobra_dir)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelSombra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_cobra_dir)
                    .addComponent(panel_cobra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cobra))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_cavalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cavalo)
                    .addComponent(lbl_cavalo_dir))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_passaro)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbl_passaro_dir)
                        .addComponent(panel_passaro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_macaco)
                    .addComponent(panel_macaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_macaco_dir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(39, 39, 39))
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
        new FRegiao().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    FaseConcluida fase = new FaseConcluida();
    
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        
        verificarAcertos();
        double porcAcerto;
        porcAcerto = ((double)acertos/4)*100;
        
        double pontos;
        pontos = ((double) porcAcerto * 0.7) + ((int) seconds * 0.3);
        
        fase.setIdFase(1);
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
            pst.setString(3, "Voce concluiu a fase visual!");
            pst.setString(4, "icon-trofeu.png");
            pst.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
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
            java.util.logging.Logger.getLogger(FFaseLigar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FFaseLigar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FFaseLigar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FFaseLigar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FFaseLigar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JPanel panel_cavalo;
    private javax.swing.JPanel panel_cobra;
    private javax.swing.JPanel panel_macaco;
    private javax.swing.JPanel panel_passaro;
    // End of variables declaration//GEN-END:variables
}
