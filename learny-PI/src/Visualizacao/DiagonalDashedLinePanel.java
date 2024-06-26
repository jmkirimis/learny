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
import java.awt.geom.Line2D;

public class DiagonalDashedLinePanel extends JPanel {

    public static final int DIRECTION_DESCENDING = 0;
    public static final int DIRECTION_ASCENDING = 1;
    public static final int DIRECTION_HORIZONTAL = 2;
    public static final int DIRECTION_VERTICAL = 3;

    private float[] dashPattern;
    private float strokeWidth;
    private Color lineColor;
    private int direction;

    public DiagonalDashedLinePanel() {
        this(new float[]{10, 10}, 2.0f, Color.BLACK, DIRECTION_DESCENDING);
    }

    public DiagonalDashedLinePanel(float[] dashPattern, float strokeWidth, Color lineColor, int direction) {
        this.dashPattern = dashPattern;
        this.strokeWidth = strokeWidth;
        this.lineColor = lineColor;
        this.direction = direction;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Define o stroke (espessura e padrão da linha tracejada)
        g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f));

        // Define a cor da linha
        g2d.setColor(lineColor);

        int width = getWidth();
        int height = getHeight();

        // Calcular os pontos finais da linha
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        switch (direction) {
            case DIRECTION_DESCENDING:
                x1 = 0;
                y1 = 0;
                x2 = width;
                y2 = height;
                break;
            case DIRECTION_ASCENDING:
                x1 = 0;
                y1 = height;
                x2 = width;
                y2 = 0;
                break;
            case DIRECTION_HORIZONTAL:
                x1 = 0;
                y1 = height / 2;
                x2 = width;
                y2 = height / 2;
                break;
            case DIRECTION_VERTICAL:
                x1 = width / 2;
                y1 = 0;
                x2 = width / 2;
                y2 = height;
                break;
        }

        g2d.draw(new Line2D.Float(x1, y1, x2, y2));
    }

    // Getters e setters
    public float[] getDashPattern() {
        return dashPattern;
    }

    public void setDashPattern(float[] dashPattern) {
        this.dashPattern = dashPattern;
        repaint();
    }

    public float getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
        repaint();
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
        repaint();
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
        repaint();
    }
}