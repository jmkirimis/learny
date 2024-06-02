
package Visualizacao;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;

public class CustomSeparator extends JSeparator {
    private int thickness;
    private Color color;
    private boolean dashed;

    public CustomSeparator(int orientation, int thickness, Color color, boolean dashed) {
        super(orientation);
        this.thickness = thickness;
        this.color = color;
        this.dashed = dashed;
        setCustomBorder();
    }

    public CustomSeparator() {
        this(SwingConstants.HORIZONTAL, 1, Color.BLACK, false);
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
        setCustomBorder();
        repaint();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setCustomBorder();
        repaint();
    }

    public boolean isDashed() {
        return dashed;
    }

    public void setDashed(boolean dashed) {
        this.dashed = dashed;
        setCustomBorder();
        repaint();
    }

    private void setCustomBorder() {
        setBorder(new SeparatorBorder());
    }

    private class SeparatorBorder extends AbstractBorder {
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(color);
            if (dashed) {
                float[] dashPattern = { 10, 10 };
                g2d.setStroke(new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dashPattern, 0));
            } else {
                g2d.setStroke(new BasicStroke(thickness));
            }

            if (getOrientation() == SwingConstants.HORIZONTAL) {
                g2d.drawLine(x, y + thickness / 2, x + width, y + thickness / 2);
            } else {
                g2d.drawLine(x + thickness / 2, y, x + thickness / 2, y + height);
            }
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(thickness, thickness, thickness, thickness);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.right = insets.top = insets.bottom = thickness;
            return insets;
        }
    }

    @Override
    public void updateUI() {
        super.updateUI();
        setCustomBorder();
    }
}