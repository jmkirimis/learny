
package Visualizacao;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class AlertaGeral extends JDialog {
    Color cinza = new Color(120, 120, 120);
    Color cinza2 = new Color(190, 190, 190);
    Color cinzaClaro = new Color(240, 240, 240);
    Color verde = new Color(128,210,91);
    Color vermelho = new Color(239,91,106);
    
    private JLabel iconLabel;
    private JLabel titleLabel;
    private JLabel descriptionLabel;

    public AlertaGeral(Frame parent, ImageIcon icon, String title, String description, int espTopBot, int espRightLeft) {
        super(parent, "Custom Alert", true);
        
        // Remove a decoração da janela
        setUndecorated(true);
        
        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(cinza);
        mainPanel.setBorder(new EmptyBorder(espTopBot, espRightLeft, 20, espRightLeft)); // Define espaçamento entre o texto e as laterais do painel
        
        // Adicionando ícone
        iconLabel = new JLabel();
        iconLabel.setIcon(icon);
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15))); // Espaço acima do ícone
        mainPanel.add(iconLabel);

        // Adicionando título
        titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Espaço entre ícone e título
        mainPanel.add(titleLabel);

        // Adicionando descrição
        descriptionLabel = new JLabel("<html><div style='text-align: center; width: 250px;'>" + description + "</div></html>");
        descriptionLabel.setForeground(cinzaClaro);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15))); // Espaço entre título e descrição
        mainPanel.add(descriptionLabel);
        
        // Adicionando espaço entre a descrição e os botões
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15))); // Espaço adicional

        add(mainPanel, BorderLayout.CENTER);

        // Painel de botões personalizados com sombra
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(cinza);
        buttonPanel.setLayout(new GridLayout(1, 1, 10, 0)); // Layout para um botão

        // Definindo margens (espaçamento entre os botões e as bordas laterais do painel)
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, espRightLeft, espTopBot, espRightLeft)); // Top, Left, Bottom, Right

        // Botão "OK" com sombra
        PanelSombra okPanel = new PanelSombra();
        okPanel.setBackground(cinza2); // cor de fundo
        okPanel.setCornerRadius(30);
        okPanel.setShadowSize(3);
        okPanel.setShadowOpacity(0.3f);
        okPanel.setLayout(new BorderLayout());
        okPanel.setPreferredSize(new Dimension(100, 50)); // Definindo tamanho preferido
        JLabel okLabel = new JLabel("OK", JLabel.CENTER);
        okLabel.setForeground(Color.WHITE);
        okLabel.setFont(new Font("Arial", Font.BOLD, 16));
        okPanel.add(okLabel, BorderLayout.CENTER);
        okPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Ação para o botão OK
                dispose();
            }
        });

        buttonPanel.add(okPanel);

        add(buttonPanel, BorderLayout.SOUTH);

        pack(); // Ajusta o tamanho do diálogo com base nos componentes
        setLocationRelativeTo(parent);
    }
}