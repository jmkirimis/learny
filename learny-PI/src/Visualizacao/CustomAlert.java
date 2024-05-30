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

public class CustomAlert extends JDialog {
    Color cinza = new Color(102, 102, 102);
    public CustomAlert(Frame parent) {
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
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço acima do ícone
        mainPanel.add(iconLabel);

        // Adicionando título
        JLabel titleLabel = new JLabel("Data Saving Failure");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre ícone e título
        mainPanel.add(titleLabel);

        // Adicionando descrição
        JLabel descriptionLabel = new JLabel("<html><div style='text-align: center;'>Oops! We encountered an issue while attempting to save your data. Please try again later or contact support for assistance. Apologies for any inconvenience caused.</div></html>");
        descriptionLabel.setForeground(Color.LIGHT_GRAY);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaço entre título e descrição
        mainPanel.add(descriptionLabel);

        add(mainPanel, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(cinza);
        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");
        
        // Adicionando ações aos botões
        yesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Yes button clicked");
                // Ação para o botão Yes
                dispose();
            }
        });
        
        noButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("No button clicked");
                // Ação para o botão No
                dispose();
            }
        });

        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setSize(400, 250);
        setLocationRelativeTo(parent);
    }
}
