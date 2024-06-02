package Visualizacao;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelGradiente extends JPanel {

    public enum GradientDirection {
        HORIZONTAL, VERTICAL, DIAGONAL_DOWN, DIAGONAL_UP
    }

    private int radius = 0; // Arredondamento dos cantos
    private GradientDirection gradientDirection = GradientDirection.HORIZONTAL;
    private float verticalProportion = 0.5f; // Proporção para o gradiente vertical
    Color azulPastel = new Color(108, 210, 255);
    Color vermelhoPastel = new Color(239, 91, 106);
    private Color gradientStartColor = vermelhoPastel; // Cor de inicio do gradiente
    private Color gradientEndColor = azulPastel; // Cor de fim do gradiente

    public PanelGradiente() {
        setOpaque(false);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public GradientDirection getGradientDirection() {
        return gradientDirection;
    }

    public void setGradientDirection(GradientDirection gradientDirection) {
        this.gradientDirection = gradientDirection;
        repaint();
    }

    public float getVerticalProportion() {
        return verticalProportion;
    }

    public void setVerticalProportion(float verticalProportion) {
        this.verticalProportion = verticalProportion;
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int arcWidth = Math.min(width, radius);
        int arcHeight = Math.min(height, radius);

        // Determina a direção do gradiente
        GradientPaint gradient;
        switch (gradientDirection) {
            case VERTICAL:
                gradient = new GradientPaint(0, 0, gradientStartColor, 0, height, gradientEndColor);
                break;
            case DIAGONAL_DOWN:
                gradient = new GradientPaint(0, height * (1 - verticalProportion), gradientStartColor, width, height * verticalProportion, gradientEndColor);
                break;
            case DIAGONAL_UP:
                gradient = new GradientPaint(0, height * verticalProportion, gradientStartColor, width, height * (1 - verticalProportion), gradientEndColor);
                break;
            case HORIZONTAL:
            default:
                gradient = new GradientPaint(0, 0, gradientStartColor, width, 0, gradientEndColor);
                break;
        }

        // Preenche a área arredondada
        g2.setPaint(gradient);
        g2.fill(new RoundRectangle2D.Double(0, 0, width, height, arcWidth, arcHeight));

        g2.dispose();
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
