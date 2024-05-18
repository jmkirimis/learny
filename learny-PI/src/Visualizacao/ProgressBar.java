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
    Color vermelho = new Color(239,91,106);

    public ProgressBar() {
        setStringPainted(true);
        setPreferredSize(new Dimension(100, 15));
        setBackground(new Color(255, 255, 255));
        setForeground(new Color(69, 124, 235));
        setUI(new RoundedProgressBarUI());
    }

    public Color getColorString() {
        return colorString;
    }

    public void setColorString(Color colorString) {
        this.colorString = colorString;
    }

    class RoundedProgressBarUI extends BasicProgressBarUI {

        @Override
        protected void paintIndeterminate(Graphics g, JComponent c) {
            // Custom painting for indeterminate state if needed
            super.paintIndeterminate(g, c);
        }

        @Override
        protected void paintDeterminate(Graphics g, JComponent c) {
            Graphics2D g2d = (Graphics2D) g.create();

            // Antialiasing for smoother graphics
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw progress bar
            int width = c.getWidth();
            int height = c.getHeight();
            int arc = height; // Adjust the arc to control the roundness
            Insets insets = progressBar.getInsets();
            int barRectWidth = width - (insets.left + insets.right);
            int barRectHeight = height - (insets.top + insets.bottom);
            int amountFull = getAmountFull(insets, barRectWidth, barRectHeight);

            // Create gradient paint
            Color startColor = azul;
            Color endColor = vermelho;
            GradientPaint gradientPaint = new GradientPaint(0, 0, startColor, width, 0, endColor);

            // Fill progress bar with gradient
            g2d.setPaint(gradientPaint);
            g2d.fillRoundRect(insets.left, insets.top, amountFull, barRectHeight, arc, arc);

            // Draw the text on progress bar
            if (progressBar.isStringPainted()) {
                paintString(g2d, insets.left, insets.top, barRectWidth, barRectHeight, amountFull, insets);
            }

            g2d.dispose();
        }

        @Override
        protected void paintString(Graphics grphcs, int i, int i1, int i2, int i3, int i4, Insets insets) {
            grphcs.setColor(getColorString());
            super.paintString(grphcs, i, i1, i2, i3, i4, insets);
        }
    }
}
