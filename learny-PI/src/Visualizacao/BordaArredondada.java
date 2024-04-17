/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

/**
 *
 * @author fatec-dsm2
 */
import java.awt.*;
import javax.swing.border.AbstractBorder;

public class BordaArredondada extends AbstractBorder {
    private final int raio;
    private final Color cor;

    public BordaArredondada(int raio, Color cor) {
        this.raio = raio;
        this.cor = cor;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(cor);

        // Desenhar as bordas arredondadas
        g2d.drawRoundRect(x, y, width - 1, height - 1, raio, raio);
        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(raio, raio, raio, raio);
    }
}
