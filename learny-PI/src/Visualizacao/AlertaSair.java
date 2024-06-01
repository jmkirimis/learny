/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlertaSair extends JDialog {
    Color cinza = new Color(102, 102, 102);
    Color cinzaClaro = new Color(153, 153, 153);
    Color verde = new Color(128,210,91);
    Color vermelho = new Color(239,91,106);
    
    public AlertaSair(Frame parent) {
        super(parent, "Custom Alert", true);
        
        // Remove a decoração da janela
        setUndecorated(true);
        
        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(cinza);
        
        // Adicionando ícone
        JLabel iconLabel = new JLabel();
        ImageIcon icon = new ImageIcon("src/Imagens/icon sair.png"); // Coloque o caminho do ícone aqui
        iconLabel.setIcon(icon);
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15))); // Espaço acima do ícone
        mainPanel.add(iconLabel);

        // Adicionando título
        JLabel titleLabel = new JLabel("Encerrar Sessão");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15))); // Espaço entre ícone e título
        mainPanel.add(titleLabel);

        // Adicionando descrição
        JLabel descriptionLabel = new JLabel("Você deseja mesmo sair?");
        descriptionLabel.setForeground(Color.LIGHT_GRAY);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15))); // Espaço entre título e descrição
        mainPanel.add(descriptionLabel);
        
        // Adicionando espaço entre a descrição e os botões
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15))); // Espaço adicional

        add(mainPanel, BorderLayout.CENTER);

        // Painel de botões personalizados com sombra
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(cinza);
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 0)); // Layout para dois botões com espaço entre eles

        // Definindo margens (espaçamento entre os botões e as bordas laterais do painel)
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15)); // Top, Left, Bottom, Right

        // Botão "Sim" com sombra
        PanelRound yesPanel = new PanelRound();
        yesPanel.setBackground(vermelho); // Ajuste a cor de fundo conforme necessário
        yesPanel.setRoundTopLeft(40);
        yesPanel.setRoundTopRight(40);
        yesPanel.setRoundBottomLeft(40);
        yesPanel.setRoundBottomRight(40);
        yesPanel.setLayout(new BorderLayout());
        yesPanel.setPreferredSize(new Dimension(100, 40)); // Definindo tamanho preferido
        JLabel yesLabel = new JLabel("Sim", JLabel.CENTER);
        yesLabel.setForeground(Color.WHITE);
        yesLabel.setFont(new Font("Arial", Font.BOLD, 14));
        yesPanel.add(yesLabel, BorderLayout.CENTER);
        yesPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Yes button clicked");
                // Ação para o botão Yes
                dispose();
            }
        });

        // Botão "Não" com sombra
        PanelRound noPanel = new PanelRound();
        noPanel.setBackground(cinzaClaro); // Ajuste a cor de fundo conforme necessário
        noPanel.setRoundTopLeft(40);
        noPanel.setRoundTopRight(40);
        noPanel.setRoundBottomLeft(40);
        noPanel.setRoundBottomRight(40);
        noPanel.setLayout(new BorderLayout());
        noPanel.setPreferredSize(new Dimension(100, 40)); // Definindo tamanho preferido
        JLabel noLabel = new JLabel("Não", JLabel.CENTER);
        noLabel.setForeground(Color.WHITE);
        noLabel.setFont(new Font("Arial", Font.BOLD, 14));
        noPanel.add(noLabel, BorderLayout.CENTER);
        noPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("No button clicked");
                // Ação para o botão No
                dispose();
            }
        });

        buttonPanel.add(yesPanel);
        buttonPanel.add(noPanel);

        add(buttonPanel, BorderLayout.SOUTH);

        pack(); // Ajusta o tamanho do diálogo com base nos componentes
        setLocationRelativeTo(parent);
    }
}