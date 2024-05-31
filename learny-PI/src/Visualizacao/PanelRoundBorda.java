
package Visualizacao;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class PanelRoundBorda extends JPanel {

    private ImageIcon img;
    private int radius = 0; // Radius of the corners
    private int borderWidth = 2; // Width of the border
    Color azul = new Color(83, 194, 242);
    Color vermelho = new Color(239,91,106);
    private Color gradientStartColor = vermelho; // Start color of the gradient
    private Color gradientEndColor = azul; // End color of the gradient

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

        // Create a gradient paint for the border
        GradientPaint gradient = new GradientPaint(0, 0, gradientStartColor, 0, height, gradientEndColor);

        // Fill the rounded area
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(borderWidth / 2.0, borderWidth / 2.0, width - borderWidth, height - borderWidth, arcWidth, arcHeight));

        // Draw the gradient border
        g2.setPaint(gradient);
        g2.setStroke(new BasicStroke(borderWidth));
        g2.draw(new RoundRectangle2D.Double(borderWidth / 2.0, borderWidth / 2.0, width - borderWidth, height - borderWidth, arcWidth, arcHeight));

        // Clip to the rounded area
        Shape clip = new RoundRectangle2D.Double(borderWidth, borderWidth, width - 2 * borderWidth, height - 2 * borderWidth, arcWidth, arcHeight);
        g2.setClip(clip);

        // Draw the image
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