package Visualizacao;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.util.ArrayList;
import java.util.List;

public class PanelGradiente extends javax.swing.JPanel {

    Color vermelhoPastel = new Color(239,91,106);
    Color azulPastel = new Color(108,210,255);
    
    public PanelGradiente() {
        initComponents();
        //set false to make background panel as transpatent
        setOpaque(false);
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
        int width = getWidth();
        int height = getHeight();

        Graphics2D g2 = (Graphics2D) grphcs;

        // Define as cores e as posições para o gradiente
        Color color1 = azulPastel;
        Color color2 = vermelhoPastel;
        GradientPaint gp = new GradientPaint(0, height, color1, 0, 0, color2);

        g2.setPaint(gp);
        g2.fillRect(0, 0, width, height);

        super.paintComponent(grphcs);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
