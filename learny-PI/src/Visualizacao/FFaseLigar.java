package Visualizacao;

import Controle.Conexao;
import Modelagem.Aluno;
import Modelagem.Config;
import Modelagem.FaseConcluida;
import Modelagem.Session;
import java.awt.BasicStroke;
import java.awt.Color;
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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
    Color verde = new Color(128, 210, 91);
    Color vermelho = new Color(239, 91, 106);
    Color amarelo = new Color(255, 179, 0);
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
    //icone dica
    Icon iconDicaAtivada = new ImageIcon("src/Imagens/icon-dica-ativada.png");
    Icon iconDicaDesativada = new ImageIcon("src/Imagens/icon-dica-desativada.png");

    private boolean cobraClicada = false;
    private boolean cobraClicadaDir = false;
    private boolean cavaloClicado = false;
    private boolean cavaloClicadoDir = false;
    private boolean passaroClicado = false;
    private boolean passaroClicadoDir = false;
    private boolean macacoClicado = false;
    private boolean macacoClicadoDir = false;
    private boolean dicaClicada = false;

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
        ImageIcon icon = new ImageIcon("src/Imagens/logo-icon.png");
        this.setIconImage(icon.getImage());
        alunoLogado = Session.getInstance().getAlunoLogado();
        conexao = Conexao.conecta();
        this.acertos = 0;

        idAluno = alunoLogado.getIdAluno();
        linha_bonus.setColor(Color.white);

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
                    apagarLinha(panel_cobra);
                    linhaVisivelCobra = false;
                }
                tocarAudio("src/audios/snake.wav");
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
                    apagarLinha(panel_cobra);
                    linhaVisivelCobra = false;
                }
                tocarAudio("src/audios/snake.wav");
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
                    apagarLinha(panel_cavalo);
                    linhaVisivelCavalo = false;
                }
                tocarAudio("src/audios/horse.wav");
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
                    apagarLinha(panel_cavalo);
                    linhaVisivelCavalo = false;
                }
                tocarAudio("src/audios/horse.wav");
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
                    apagarLinha(panel_passaro);
                    linhaVisivelPassaro = false;
                }
                tocarAudio("src/audios/bird.wav");
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
                    apagarLinha(panel_passaro);
                    linhaVisivelPassaro = false;
                }
                tocarAudio("src/audios/bird.wav");
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
                    apagarLinha(panel_macaco);
                    linhaVisivelMacaco = false;
                }
                tocarAudio("src/audios/monkey.wav");
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
                    apagarLinha(panel_macaco);
                    linhaVisivelMacaco = false;
                }
                tocarAudio("src/audios/monkey.wav");
            }
        });

        // Configurando o timer
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                minutes = seconds / 60;
                remainingSeconds = seconds % 60;
            }
        });

        timer.start(); // Iniciar o timer

    }

    public void tocarAudio(String caminhoDoArquivo) {
        if (!Config.audioAtivado) {
            return;
        }
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(caminhoDoArquivo));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void desenharLinha(JLabel lbl1, JLabel lbl2, JPanel panel, Color cor) {
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

    public void resetarIcone() {

    }

    public void verificarAcertos() {
        if (linhaVisivelCobra) {
            acertos++;
        }
        if (linhaVisivelCavalo) {
            acertos++;
        }
        if (linhaVisivelPassaro) {
            acertos++;
        }
        if (linhaVisivelMacaco) {
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

        panelScrollGeral = new Visualizacao.CustomScrollPane();
        jPanel4 = new javax.swing.JPanel();
        lbl_cobra = new javax.swing.JLabel();
        lbl_cavalo = new javax.swing.JLabel();
        panel_cavalo = new javax.swing.JPanel();
        lbl_passaro = new javax.swing.JLabel();
        panel_passaro = new javax.swing.JPanel();
        lbl_macaco = new javax.swing.JLabel();
        panel_macaco = new javax.swing.JPanel();
        linha_bonus = new Visualizacao.CustomSeparator();
        lbl_cavalo_dir = new javax.swing.JLabel();
        lbl_passaro_dir = new javax.swing.JLabel();
        panelSombra1 = new Visualizacao.PanelSombra();
        jLabel5 = new javax.swing.JLabel();
        lbl_macaco_dir = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelSombra2 = new Visualizacao.PanelSombra();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panel_cobra = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_cobra_dir = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_dica = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelScrollGeral.setBorder(null);
        panelScrollGeral.setPreferredSize(new java.awt.Dimension(485, 834));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(475, 834));

        lbl_cobra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cobra.png"))); // NOI18N

        lbl_cavalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cavalo.png"))); // NOI18N

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

        lbl_passaro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/passaro.png"))); // NOI18N

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

        lbl_macaco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/macaco.png"))); // NOI18N

        panel_macaco.setBackground(new java.awt.Color(255, 255, 255));

        linha_bonus.setColor(new java.awt.Color(255, 255, 255));
        linha_bonus.setThickness(5);

        javax.swing.GroupLayout panel_macacoLayout = new javax.swing.GroupLayout(panel_macaco);
        panel_macaco.setLayout(panel_macacoLayout);
        panel_macacoLayout.setHorizontalGroup(
            panel_macacoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(linha_bonus, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        );
        panel_macacoLayout.setVerticalGroup(
            panel_macacoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_macacoLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(linha_bonus, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        lbl_cavalo_dir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cavalo.png"))); // NOI18N

        lbl_passaro_dir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/passaro.png"))); // NOI18N

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

        lbl_macaco_dir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/macaco.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-confirmar3.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

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
                .addGap(83, 83, 83))
        );
        panelSombra2Layout.setVerticalGroup(
            panelSombra2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombra2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(26, Short.MAX_VALUE))
        );

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setText("Connect");

        lbl_cobra_dir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cobra.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon voltar.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        btn_dica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-dica-desativada.png"))); // NOI18N
        btn_dica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dicaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbl_passaro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel_passaro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbl_cavalo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel_cavalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_cavalo_dir)
                            .addComponent(lbl_passaro_dir)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_cobra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_cobra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_cobra_dir))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelSombra2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(39, 39, 39)
                                    .addComponent(jLabel2)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_macaco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_macaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_macaco_dir)))
                .addGap(40, 40, 40))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(btn_dica, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(panelSombra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelSombra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_cobra_dir)
                    .addComponent(panel_cobra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cobra))
                .addGap(55, 55, 55)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_cavalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cavalo)
                    .addComponent(lbl_cavalo_dir))
                .addGap(55, 55, 55)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_passaro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_passaro)
                    .addComponent(lbl_passaro_dir))
                .addGap(55, 55, 55)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_macaco)
                        .addComponent(lbl_macaco_dir))
                    .addComponent(panel_macaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_dica, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        panelScrollGeral.setViewportView(jPanel4);

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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new FRegiao().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    FaseConcluida fase = new FaseConcluida();

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

        verificarAcertos();
        double porcAcerto;
        porcAcerto = ((double) acertos / 4) * 100;

        double pontos;
        pontos = ((double) porcAcerto) - ((int) seconds * 0.4);
        String medalha = alunoLogado.getMedalhaAtiva();
        if (medalha.equals("Iniciando!")) {
            pontos = pontos + 50;
        } else if (medalha.equals("A todo vapor!")) {
            pontos = pontos * 2;
        }

        fase.setIdFase(1);
        fase.setIdAluno(idAluno);
        fase.setPontos(pontos);
        fase.setTempoConclusao(minutes, remainingSeconds);
        fase.setPorcAcertos(porcAcerto);
        fase.cadastrar();
        inserirNotificacao();
        new FFaseConcluida().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btn_dicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dicaMouseClicked
        if (!dicaClicada) {
            String medalha = alunoLogado.getMedalhaAtiva();
            if (medalha.equals("Mundo Concluido!")) {
                // Define o ícone de clique se ainda não foi clicado
                btn_dica.setIcon(iconDicaAtivada);
                lbl_macaco.setIcon(iconMacacoClick);
                lbl_macaco.removeMouseListener(lbl_macaco.getMouseListeners()[0]);
                lbl_macaco_dir.setIcon(iconMacacoClick);
                lbl_macaco_dir.removeMouseListener(lbl_macaco_dir.getMouseListeners()[0]);
                linha_bonus.setColor(amarelo);
                acertos++;
            }
            else{
                ImageIcon icon = new ImageIcon("src/Imagens/icon-dica-alerta.png");
                AlertaGeral alert = new AlertaGeral(this, icon, "Dica Indisponível", "Ative ou consiga a medalha de mundo concluido para liberar", 50, 50);
                alert.setVisible(true);
            }
            dicaClicada = true;
        } else {
            String medalha = alunoLogado.getMedalhaAtiva();
            if (medalha.equals("Mundo Concluido!")) {
                // Redefine o ícone e restaura os estados anteriores
                btn_dica.setIcon(iconDicaDesativada);
                lbl_macaco.setIcon(iconMacaco); // Substitua pelo ícone original
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
                            apagarLinha(panel_macaco);
                            linhaVisivelMacaco = false;
                        }
                        tocarAudio("src/audios/monkey.wav");
                    }
                });
                lbl_macaco_dir.setIcon(iconMacaco); // Substitua pelo ícone original
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
                            apagarLinha(panel_macaco);
                            linhaVisivelMacaco = false;
                        }
                        tocarAudio("src/audios/monkey.wav");
                    }
                });
                linha_bonus.setColor(Color.WHITE); // Substitua pela cor original
                acertos--; // ou outra lógica se precisar
            }
            dicaClicada = false;
        }
    }//GEN-LAST:event_btn_dicaMouseClicked

    private void inserirNotificacao() {
        String sql;
        sql = "insert into notificacoes(idAluno, notificacao, descNotificacao, iconNotificacao) values"
                + "(?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, alunoLogado.getIdAluno());
            pst.setString(2, "Fase Concluida");
            pst.setString(3, "Voce concluiu a fase visual!");
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
    private javax.swing.JLabel btn_dica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_cavalo;
    private javax.swing.JLabel lbl_cavalo_dir;
    private javax.swing.JLabel lbl_cobra;
    private javax.swing.JLabel lbl_cobra_dir;
    private javax.swing.JLabel lbl_macaco;
    private javax.swing.JLabel lbl_macaco_dir;
    private javax.swing.JLabel lbl_passaro;
    private javax.swing.JLabel lbl_passaro_dir;
    private Visualizacao.CustomSeparator linha_bonus;
    private Visualizacao.CustomScrollPane panelScrollGeral;
    private Visualizacao.PanelSombra panelSombra1;
    private Visualizacao.PanelSombra panelSombra2;
    private javax.swing.JPanel panel_cavalo;
    private javax.swing.JPanel panel_cobra;
    private javax.swing.JPanel panel_macaco;
    private javax.swing.JPanel panel_passaro;
    // End of variables declaration//GEN-END:variables
}
