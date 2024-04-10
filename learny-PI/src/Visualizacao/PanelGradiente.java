package Visualizacao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.util.ArrayList;
import java.util.List;

public class PanelGradiente extends javax.swing.JPanel {

    public PanelGradiente() {
        initComponents();
        //set false to make background panel as transpatent
        setOpaque(false);
        colors = new ArrayList<>();
    }
    private List<ModelColor> colors;
    public void addColor(ModelColor... color){
        for(ModelColor c:color){
            colors.add(c);
        }
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
        if(!colors.isEmpty()){
            int width = getWidth();
            int height = getHeight();
            Graphics2D g2 = (Graphics2D) grphcs;
            Color color[] = new Color[colors.size()];
            float position[] = new float[colors.size()];
            for(int i=0; i<colors.size(); i++){
                color[i] = colors.get(i).getColor();
                position[i] = colors.get(i).getPosition();
            }
            int sx = 0; // comeco x
            int sy = 0; // comeco y
            int ex = 0; // fim x
            int ey = height; // fim y
            LinearGradientPaint g = new LinearGradientPaint(sx, sy, ex, ey, position, color);
            g2.setPaint(g);
            g2.fillRect(0, 0, width, height);
        }
        super.paintComponent(grphcs);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
