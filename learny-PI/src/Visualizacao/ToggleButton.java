/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

/**
 *
 * @author João
 */
import Modelagem.Config;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToggleButton extends JComponent {

    private boolean isOn = Config.audioAtivado;
    private static final int PADDING = 6; // Reduzido para ajustar o tamanho
    Color verde = new Color(128,210,91);

    public ToggleButton() {
        this.setPreferredSize(new Dimension(80, 40)); // Ajuste proporcional das dimensões
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isOn = !isOn;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Suavizar a borda dos desenhos
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int height = getHeight() - PADDING * 2;
        int width = getWidth();
        int ovalDiameter = height - PADDING; // Diminuir o diâmetro do círculo
        
        // Calcular a posição vertical do círculo para centralizá-lo
        int circleY = PADDING + (height - ovalDiameter) / 2;

        if (isOn) {
            // Desenhar o fundo verde
            g2.setColor(verde);
            g2.fillRoundRect(0, PADDING, width, height, height, height);

            // Desenhar o círculo cinza à direita
            g2.setColor(Color.WHITE);
            g2.fillOval(width - ovalDiameter - PADDING, circleY, ovalDiameter, ovalDiameter);

            // Desenhar o texto "ON"
            g2.setColor(Color.WHITE);
            g2.drawString("ON", 20, getHeight() / 2 + 5);
        } else {
            // Desenhar o fundo cinza
            g2.setColor(Color.GRAY);
            g2.fillRoundRect(0, PADDING, width, height, height, height);

            // Desenhar o círculo branco à esquerda
            g2.setColor(Color.WHITE);
            g2.fillOval(PADDING, circleY, ovalDiameter, ovalDiameter);

            // Desenhar o texto "OFF"
            g2.setColor(Color.WHITE);
            g2.drawString("OFF", width - 40, getHeight() / 2 + 5);
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
        repaint();
    }
}
