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
import Modelagem.VerificadorDiarias;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author fatec-dsm2
 */
public class FNotificacao extends javax.swing.JFrame {

    /**
     * Creates new form FNotificacao
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    VerificadorDiarias verifDiaria = new VerificadorDiarias(null);

    private Map<Integer, PanelSombra> notificacoesMap; // Mapa para armazenar os painéis de notificação
    private Aluno alunoLogado;
    private int idAluno;
    
    Color azul = new Color(83, 194, 242);
    Color verde = new Color(128,210,91);
    Color vermelho = new Color(239,91,106);
    Color amarelo = new Color(255,179,0);
    
    private NavegacaoFormulario telaDeOrigem;
    private JFrame parentFrame;

    public FNotificacao(NavegacaoFormulario telaDeOrigem, JFrame parentFrame) {
        this.telaDeOrigem = telaDeOrigem;
        this.parentFrame = parentFrame;
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
        notificacoesMap = new HashMap<>();
        idAluno = alunoLogado.getIdAluno();
        painelNotificacoes.setLayout(new BoxLayout(painelNotificacoes, BoxLayout.Y_AXIS));
        panel_diaria1.setVisible(false);
        panel_diaria2.setVisible(false);
        panel_diaria3.setVisible(false);
        carregarNotificacoes();
        carregarMissoes();
        Dimension fixedSize = new Dimension(0, 100); // Tamanho desejado quando vazio
        if (painelNotificacoes.getComponentCount() == 0) {
            painelNotificacoes.setPreferredSize(fixedSize);
        }
        painelNotificacoes.revalidate();

        int maxId = getUltimoIdNotificacao(); // Obtenha o último ID de notificação
        int idNotificacao = 0; // O ID da notificação que você deseja buscar

        // Obtenha o painel correspondente
        while (idNotificacao <= maxId) {
            PanelSombra painel = getPainelNotificacao(idNotificacao);

            String sql = "select * from notificacoes where idNotificacao = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, idNotificacao);
                rs = pst.executeQuery();
                // muda as cores conforme o tipo da notificação
                if (rs.next()) {
                    String descNotificacao = rs.getString(4);
                    if (descNotificacao != null && descNotificacao.contains("visual")) {
                        painel.setBackground(azul);
                    } else if (descNotificacao != null && descNotificacao.contains("numeros")) {
                        painel.setBackground(amarelo);
                    } else if (descNotificacao != null && descNotificacao.contains("observacao")) {
                        painel.setBackground(verde);
                    } else if (descNotificacao != null && descNotificacao.contains("escuta")) {
                        painel.setBackground(vermelho);
                    }
                }
            } catch (Exception ex) {
                //JOptionPane.showMessageDialog(null, ex);
            }

            if (painel != null) {
                // Adiciona um MouseListener ao painel
                int finalIdNotificacao = idNotificacao; // variável final para uso no listener
                painel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        // Aqui você pode adicionar o código que deseja executar ao clicar no painel
                        String sql = "select * from notificacoes where idNotificacao = ?";
                        try {
                            pst = conexao.prepareStatement(sql);
                            pst.setInt(1, finalIdNotificacao);
                            rs = pst.executeQuery();

                            if (rs.next()) {
                                String nomeNotificacao = rs.getString("notificacao");
                                String descNotificacao = rs.getString(4);
                                if(nomeNotificacao.equals("Fase Concluida")){
                                    ImageIcon icon = new ImageIcon("src/Imagens/icon-fase-alerta.png");
                                    AlertaGeral alert = new AlertaGeral(parentFrame, icon, nomeNotificacao, descNotificacao, 50, 50);
                                    alert.setVisible(true);
                                } else if(nomeNotificacao.equals("Conquista Desbloqueada")){
                                    ImageIcon icon = new ImageIcon("src/Imagens/icon-conquista-alerta.png");
                                    AlertaGeral alert = new AlertaGeral(parentFrame, icon, nomeNotificacao, descNotificacao, 50, 50);
                                    alert.setVisible(true);
                                }
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }

                        String sql2 = "delete from notificacoes where idNotificacao = ?";
                        try {
                            pst = conexao.prepareStatement(sql2);
                            pst.setInt(1, finalIdNotificacao);

                            int rowsAffected = pst.executeUpdate();
                            System.out.println("Linhas afetadas: " + rowsAffected);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }
            idNotificacao++;
        }
    }

    private void carregarNotificacoes() {
        String sql = "select * from notificacoes where idAluno = ?"; // Ajuste a consulta conforme necessário

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idAluno);
            rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String descricao = rs.getString("notificacao");
                String caminhoIcone = rs.getString("iconNotificacao");

                JPanel painelNotificacao = criarPainelNotificacao(descricao, caminhoIcone);
                painelNotificacoes.add(painelNotificacao);

                painelNotificacoes.add(Box.createRigidArea(new Dimension(0, 15)));

                painelNotificacoes.add(painelNotificacao);
                
                ajustarAlturaPaineis();

                // Armazena o painel no mapa com o ID da notificação
                notificacoesMap.put(id, (PanelSombra) painelNotificacao);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void ajustarAlturaPaineis() {
        // Obtenha a altura adicional desejada
        int alturaAdicional = 65; // Altere conforme necessário
        // Obtenha os tamanhos preferidos atuais dos outros painéis
        Dimension tamanhoRound = panelRoundNotificacoes.getPreferredSize();
        Dimension tamanhoSombra = panelSombraNotificacoes.getPreferredSize();
        Dimension tamanhoGeral = panelGeral.getPreferredSize();
        // Adicione a altura adicional aos tamanhos preferidos
        tamanhoRound.height += alturaAdicional;
        tamanhoSombra.height += alturaAdicional;
        tamanhoGeral.height += alturaAdicional;
        // Defina os novos tamanhos preferidos dos outros painéis
        panelRoundNotificacoes.setPreferredSize(tamanhoRound);
        panelSombraNotificacoes.setPreferredSize(tamanhoSombra);
        panelGeral.setPreferredSize(tamanhoGeral);
        // Revalide os painéis para que as mudanças tenham efeito
        panelRoundNotificacoes.revalidate();
        panelSombraNotificacoes.revalidate();
        panelGeral.revalidate();
    }

    private JPanel criarPainelNotificacao(String descricao, String caminhoIcone) {
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

        JLabel lblDescricao = new JLabel(descricao);
        lblDescricao.setFont(new Font("Arial", Font.BOLD, 16));
        lblDescricao.setForeground(Color.WHITE);

        painel.add(lblIcone, BorderLayout.WEST);
        painel.add(lblDescricao, BorderLayout.CENTER);

        // Ajuste o estilo do painel conforme necessário (cores, bordas, etc.)
        Color verde = new Color(0, 204, 51);
        painel.setBackground(verde); // Exemplo de cor de fundo

        return painel;
    }

    public PanelSombra getPainelNotificacao(int id) {
        return notificacoesMap.get(id);
    }

    private int getUltimoIdNotificacao() {
        String sql = "select max(idNotificacao) as max_id from notificacoes";
        int maxId = -1;
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt("max_id");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return maxId;
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
                
                if(nomeMissao.equals("Atividades 1")){
                    panelsDiarias[cont].setGradientStartColor(vermelho);
                    panelsDiarias[cont].setGradientEndColor(azul);
                } else if(nomeMissao.equals("Atividades 2")){
                    panelsDiarias[cont].setGradientStartColor(vermelho);
                    panelsDiarias[cont].setGradientEndColor(azul);
                } else if(nomeMissao.equals("Visual")){
                    panelsDiarias[cont].setGradientStartColor(azul);
                    panelsDiarias[cont].setGradientEndColor(azul);
                } else if(nomeMissao.equals("Ouvir")){
                    panelsDiarias[cont].setGradientStartColor(vermelho);
                    panelsDiarias[cont].setGradientEndColor(vermelho);
                } else if(nomeMissao.equals("Numeros")){
                    panelsDiarias[cont].setGradientStartColor(amarelo);
                    panelsDiarias[cont].setGradientEndColor(amarelo);
                } else if(nomeMissao.equals("Observacao")){
                    panelsDiarias[cont].setGradientStartColor(verde);
                    panelsDiarias[cont].setGradientEndColor(verde);
                }else if(nomeMissao.equals("Mundo")){
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
    
    // Método para retornar à tela de origem
    private void voltarParaOrigem() {
        if (telaDeOrigem != null) {
            telaDeOrigem.setVisible(true);
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
        panelRoundNotificacoes = new Visualizacao.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelSombraNotificacoes = new Visualizacao.PanelSombra();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        customSeparator1 = new Visualizacao.CustomSeparator();
        jLabel6 = new javax.swing.JLabel();
        panel_diaria3 = new Visualizacao.PanelRoundBorda();
        lbl_missao3 = new javax.swing.JLabel();
        icon_missao3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        painelNotificacoes = new javax.swing.JPanel();
        panel_diaria2 = new Visualizacao.PanelRoundBorda();
        lbl_missao2 = new javax.swing.JLabel();
        icon_missao2 = new javax.swing.JLabel();
        panel_diaria1 = new Visualizacao.PanelRoundBorda();
        lbl_missao1 = new javax.swing.JLabel();
        icon_missao1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customScrollPane1.setBorder(null);
        customScrollPane1.setPreferredSize(new java.awt.Dimension(485, 834));

        panelGeral.setBackground(new java.awt.Color(72, 72, 72));
        panelGeral.setPreferredSize(new java.awt.Dimension(475, 1243));

        panelRoundNotificacoes.setBackground(new java.awt.Color(255, 255, 255));
        panelRoundNotificacoes.setRoundTopLeft(60);
        panelRoundNotificacoes.setRoundTopRight(60);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(72, 72, 72));
        jLabel1.setText("Notificações");

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

        panelSombraNotificacoes.setBackground(new java.awt.Color(255, 255, 255));
        panelSombraNotificacoes.setShadowOpacity(0.3F);
        panelSombraNotificacoes.setShadowSize(4);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(72, 72, 72));
        jLabel2.setText("Conta Criada !!");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(72, 72, 72));
        jLabel3.setText("Conta Kastle criada com");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(72, 72, 72));
        jLabel4.setText("sucesso, aproveite o");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(72, 72, 72));
        jLabel5.setText("aplicativo Learny");

        customSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        customSeparator1.setColor(new java.awt.Color(72, 72, 72));
        customSeparator1.setThickness(5);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Novos");

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Missões Diarias");

        painelNotificacoes.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout painelNotificacoesLayout = new javax.swing.GroupLayout(painelNotificacoes);
        painelNotificacoes.setLayout(painelNotificacoesLayout);
        painelNotificacoesLayout.setHorizontalGroup(
            painelNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
        painelNotificacoesLayout.setVerticalGroup(
            painelNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout panelSombraNotificacoesLayout = new javax.swing.GroupLayout(panelSombraNotificacoes);
        panelSombraNotificacoes.setLayout(panelSombraNotificacoesLayout);
        panelSombraNotificacoesLayout.setHorizontalGroup(
            panelSombraNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombraNotificacoesLayout.createSequentialGroup()
                .addGroup(panelSombraNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSombraNotificacoesLayout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel6))
                    .addGroup(panelSombraNotificacoesLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(panelSombraNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSombraNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panel_diaria3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel_diaria2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel_diaria1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelSombraNotificacoesLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel7))
                            .addGroup(panelSombraNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(customSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                                .addComponent(painelNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(39, 39, 39))
        );
        panelSombraNotificacoesLayout.setVerticalGroup(
            panelSombraNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSombraNotificacoesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(32, 32, 32)
                .addComponent(customSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(painelNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel7)
                .addGap(38, 38, 38)
                .addComponent(panel_diaria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panel_diaria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panel_diaria3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout panelRoundNotificacoesLayout = new javax.swing.GroupLayout(panelRoundNotificacoes);
        panelRoundNotificacoes.setLayout(panelRoundNotificacoesLayout);
        panelRoundNotificacoesLayout.setHorizontalGroup(
            panelRoundNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundNotificacoesLayout.createSequentialGroup()
                .addGroup(panelRoundNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundNotificacoesLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel13))
                    .addGroup(panelRoundNotificacoesLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(panelSombraNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        panelRoundNotificacoesLayout.setVerticalGroup(
            panelRoundNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundNotificacoesLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelRoundNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addComponent(panelSombraNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout panelGeralLayout = new javax.swing.GroupLayout(panelGeral);
        panelGeral.setLayout(panelGeralLayout);
        panelGeralLayout.setHorizontalGroup(
            panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGeralLayout.setVerticalGroup(
            panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeralLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(panelRoundNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        voltarParaOrigem();
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
            java.util.logging.Logger.getLogger(FNotificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FNotificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FNotificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FNotificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FNotificacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Visualizacao.CustomScrollPane customScrollPane1;
    private Visualizacao.CustomSeparator customSeparator1;
    private javax.swing.JLabel icon_missao1;
    private javax.swing.JLabel icon_missao2;
    private javax.swing.JLabel icon_missao3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbl_missao1;
    private javax.swing.JLabel lbl_missao2;
    private javax.swing.JLabel lbl_missao3;
    private javax.swing.JPanel painelNotificacoes;
    private javax.swing.JPanel panelGeral;
    private Visualizacao.PanelRound panelRoundNotificacoes;
    private Visualizacao.PanelSombra panelSombraNotificacoes;
    private Visualizacao.PanelRoundBorda panel_diaria1;
    private Visualizacao.PanelRoundBorda panel_diaria2;
    private Visualizacao.PanelRoundBorda panel_diaria3;
    // End of variables declaration//GEN-END:variables
}
