/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PlaceholderTextField extends JTextField implements FocusListener {
    private String placeholder;
    private boolean showingPlaceholder;

    public PlaceholderTextField() {
        this(""); // Construtor padrão com placeholder vazio
    }

    public PlaceholderTextField(String placeholder) {
        super(placeholder);
        this.placeholder = placeholder;
        this.showingPlaceholder = true;
        setForeground(Color.GRAY);
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (showingPlaceholder) {
            setText("");
            setForeground(Color.BLACK);
            showingPlaceholder = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().isEmpty()) {
            setForeground(Color.GRAY);
            setText(placeholder);
            showingPlaceholder = true;
        }
    }

    @Override
    public String getText() {
        return showingPlaceholder ? "" : super.getText();
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        if (!hasFocus() && getText().isEmpty()) {
            setForeground(Color.GRAY);
            setText(placeholder);
            showingPlaceholder = true;
        }
    }
}