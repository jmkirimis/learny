/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PlaceholderPasswordField extends JPasswordField implements FocusListener {
    private String placeholder;
    private boolean showingPlaceholder;
    private Color placeholderColor;

    public PlaceholderPasswordField() {
        this(""); // Construtor padrão com placeholder vazio
    }

    public PlaceholderPasswordField(String placeholder) {
        super(placeholder);
        this.placeholder = placeholder;
        this.showingPlaceholder = true;
        this.placeholderColor = Color.GRAY;
        setForeground(placeholderColor);
        addFocusListener(this);
        updateEchoChar();
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (showingPlaceholder) {
            setText("");
            setForeground(Color.BLACK);
            showingPlaceholder = false;
        }
        updateEchoChar();
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getPassword().length == 0) {
            setForeground(placeholderColor);
            setText(placeholder);
            showingPlaceholder = true;
        }
        updateEchoChar();
    }

    @Override
    public char[] getPassword() {
        return showingPlaceholder ? new char[0] : super.getPassword();
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        if (!hasFocus() && getPassword().length == 0) {
            setForeground(placeholderColor);
            setText(placeholder);
            showingPlaceholder = true;
        }
    }

    public Color getPlaceholderColor() {
        return placeholderColor;
    }

    public void setPlaceholderColor(Color placeholderColor) {
        this.placeholderColor = placeholderColor;
        if (showingPlaceholder) {
            setForeground(placeholderColor);
        }
    }

    private void updateEchoChar() {
        setEchoChar(showingPlaceholder ? (char) 0 : '\u2022');
    }
}