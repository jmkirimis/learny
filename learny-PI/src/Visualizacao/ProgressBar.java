
package Visualizacao;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class ProgressBar extends JProgressBar {

    private Color colorString = new Color(200, 200, 200);
    Color azul = new Color(83, 194, 242);
    Color vermelho = new Color(239, 91, 106);

    public ProgressBar() {
        setStringPainted(true);
        setPreferredSize(new Dimension(100, 15));
        setBackground(new Color(255, 255, 255));
        setForeground(new Color(69, 124, 235));
        setUI(new RoundedProgressBarUI());

        // Definir o intervalo personalizado de 0 a 300
        setMinimum(0);
    }

    public Color getColorString() {
        return colorString;
    }

    public void setColorString(Color colorString) {
        this.colorString = colorString;
    }

    @Override
    public String getString() {
        // Retornar o valor atual com o prefixo "exp: "
        return "exp: " + getValue() + " / " + getMaximum();
    }

    class RoundedProgressBarUI extends BasicProgressBarUI {

        @Override
        protected void paintIndeterminate(Graphics g, JComponent c) {
            // Pintura customizada para o estado indeterminado, se necessário
            super.paintIndeterminate(g, c);
        }

        @Override
        protected void paintDeterminate(Graphics g, JComponent c) {
            Graphics2D g2d = (Graphics2D) g.create();

            // Antialiasing para gráficos mais suaves
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Desenhar a barra de progresso
            int width = c.getWidth();
            int height = c.getHeight();
            int arc = height; // Ajustar o arco para controlar o arredondamento
            Insets insets = progressBar.getInsets();
            int barRectWidth = width - (insets.left + insets.right);
            int barRectHeight = height - (insets.top + insets.bottom);
            int amountFull = getAmountFull(insets, barRectWidth, barRectHeight);

            // Criar o gradiente de pintura
            Color startColor = vermelho;
            Color endColor = azul;
            GradientPaint gradientPaint = new GradientPaint(0, 0, startColor, 0, height, endColor);

            // Preencher a barra de progresso com gradiente
            g2d.setPaint(gradientPaint);
            g2d.fillRoundRect(insets.left, insets.top, amountFull, barRectHeight, arc, arc);

            // Desenhar o texto na barra de progresso
            if (progressBar.isStringPainted()) {
                paintString(g2d, insets.left, insets.top, barRectWidth, barRectHeight, amountFull, insets);
            }

            g2d.dispose();
        }

        @Override
        protected void paintString(Graphics g, int x, int y, int width, int height, int amountFull, Insets b) {
            if (!(g instanceof Graphics2D)) {
                return;
            }

            Graphics2D g2d = (Graphics2D) g;
            String progressString = progressBar.getString();
            g2d.setFont(progressBar.getFont());

            // Definir a cor da string
            g2d.setColor(getColorString());

            // Calcular a posição da string com espaçamento adicional
            int stringWidth = g2d.getFontMetrics().stringWidth(progressString);
            int stringHeight = g2d.getFontMetrics().getAscent();
            int stringX = b.left + 15; // Aumentar a margem esquerda para 15 pixels
            int stringY = (height - stringHeight) / 2 + stringHeight;

            // Desenhar a string no canto esquerdo com mais espaçamento
            g2d.drawString(progressString, stringX, stringY);
        }
    }
}
