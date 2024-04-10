/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import java.awt.Color;

/**
 *
 * @author João
 */
public class ModelColor {
    private Color color;
    private float position;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getPosition() {
        return position;
    }

    public void setPosition(float position) {
        this.position = position;
    }

    public ModelColor() {
    }

    public ModelColor(Color color, float position) {
        this.color = color;
        this.position = position;
    }
    
    
}
