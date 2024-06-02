/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GradientLabel extends JLabel {
    
    private Color gradientStart = Color.BLUE; // Cor padrão inicial
    private Color gradientEnd = Color.RED;    // Cor padrão final

    // Construtor padrão necessário para utilização em interfaces gráficas
    public GradientLabel() {
        super();
    }

    // Construtor com texto
    public GradientLabel(String text) {
        super(text);
    }

    // Construtor com texto e alinhamento
    public GradientLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    // Construtor com texto, cor de início e fim do gradiente
    public GradientLabel(String text, Color gradientStart, Color gradientEnd) {
        super(text);
        this.gradientStart = gradientStart;
        this.gradientEnd = gradientEnd;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Configurando o gradiente
        GradientPaint gradientPaint = new GradientPaint(0, 0, gradientStart, getWidth(), 0, gradientEnd);
        g2d.setPaint(gradientPaint);

        // Desenhando o texto
        FontMetrics fontMetrics = g2d.getFontMetrics();
        String text = getText();
        Rectangle2D stringBounds = fontMetrics.getStringBounds(text, g2d);
        int x = (getWidth() - (int) stringBounds.getWidth()) / 2;
        int y = (getHeight() - (int) stringBounds.getHeight()) / 2 + fontMetrics.getAscent();

        g2d.drawString(text, x, y);

        // Não chamar o paintComponent original para evitar sobreposição
    }

    // Métodos setters para configurar as cores do gradiente
    public void setGradientStart(Color gradientStart) {
        this.gradientStart = gradientStart;
        repaint(); // Repaint para atualizar a label
    }

    public void setGradientEnd(Color gradientEnd) {
        this.gradientEnd = gradientEnd;
        repaint(); // Repaint para atualizar a label
    }

    public Color getGradientStart() {
        return gradientStart;
    }

    public Color getGradientEnd() {
        return gradientEnd;
    }

}
