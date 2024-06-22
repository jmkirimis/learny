
package Visualizacao;

import Modelagem.Config;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToggleButton extends JComponent {

    private boolean isOn = Config.audioAtivado;
    private static final int PADDING = 6; // Reduzido para ajustar o tamanho
    Color azul = new Color(83, 194, 242);
    Color azulEscuro = new Color(65,126,153);
    Color vermelho = new Color(239,91,106);
    Color vermelhoEscuro = new Color(121,76,90);

    public ToggleButton() {
        this.setPreferredSize(new Dimension(80, 40));
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
            // Desenhar o fundo de gradiente
            GradientPaint gradiente = new GradientPaint(0, 0, vermelho, width, 0, azul);
            g2.setPaint(gradiente);
            g2.fillRoundRect(0, PADDING, width, height, height, height);

            // Desenhar o círculo cinza à direita
            g2.setColor(Color.WHITE);
            g2.fillOval(width - ovalDiameter - PADDING, circleY, ovalDiameter, ovalDiameter);

            // Desenhar o texto "ON"
            g2.setColor(Color.WHITE);
            g2.drawString("ON", 20, getHeight() / 2 + 5);
        } else {
           // Desenhar o fundo de gradiente
            GradientPaint gradiente = new GradientPaint(0, 0, vermelhoEscuro, width, 0, azulEscuro);
            g2.setPaint(gradiente);
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
