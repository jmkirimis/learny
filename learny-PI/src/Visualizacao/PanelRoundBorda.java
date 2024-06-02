
package Visualizacao;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class PanelRoundBorda extends JPanel {

    private ImageIcon img;
    private int radius = 0; // Arredondamento dos cantos
    private int borderWidth = 2; // Tamanho da borda
    Color azul = new Color(83, 194, 242);
    Color vermelho = new Color(239,91,106);
    private Color gradientStartColor = vermelho; // Cor de inicio do gradiente
    private Color gradientEndColor = azul; // Cor de fim do gradiente

    public PanelRoundBorda() {
        setOpaque(false);
        img = new ImageIcon();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        repaint();
    }

    public Color getGradientStartColor() {
        return gradientStartColor;
    }

    public void setGradientStartColor(Color gradientStartColor) {
        this.gradientStartColor = gradientStartColor;
        repaint();
    }

    public Color getGradientEndColor() {
        return gradientEndColor;
    }

    public void setGradientEndColor(Color gradientEndColor) {
        this.gradientEndColor = gradientEndColor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int arcWidth = Math.min(width, radius);
        int arcHeight = Math.min(height, radius);

        // Cria uma pintura de gradiente para a borda
        GradientPaint gradient = new GradientPaint(0, 0, gradientStartColor, 0, height, gradientEndColor);

        // Preenche a area arredondada
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(borderWidth / 2.0, borderWidth / 2.0, width - borderWidth, height - borderWidth, arcWidth, arcHeight));

        // Desenha a borda com o gradiente
        g2.setPaint(gradient);
        g2.setStroke(new BasicStroke(borderWidth));
        g2.draw(new RoundRectangle2D.Double(borderWidth / 2.0, borderWidth / 2.0, width - borderWidth, height - borderWidth, arcWidth, arcHeight));

        // Corta para encaixar na area arredondada
        Shape clip = new RoundRectangle2D.Double(borderWidth, borderWidth, width - 2 * borderWidth, height - 2 * borderWidth, arcWidth, arcHeight);
        g2.setClip(clip);

        // Desenha a imagem
        if (img != null && img.getImage() != null) {
            g2.drawImage(img.getImage(), borderWidth, borderWidth, width - 2 * borderWidth, height - 2 * borderWidth, this);
        }

        g2.dispose();
        super.paintComponent(grphcs);
    }

    public void setImg(ImageIcon img) {
        this.img = img;
        repaint();
    }

    public ImageIcon getImg() {
        return this.img;
    }
}