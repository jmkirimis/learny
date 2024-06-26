/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PlaceholderData extends JTextField implements FocusListener {
    private String placeholder;
    private boolean showingPlaceholder;
    private Color cinza = new Color(72, 72, 72);
    private boolean isFormatting;

    public PlaceholderData() {
        this(""); // Construtor padrão com placeholder vazio
    }

    public PlaceholderData(String placeholder) {
        super(placeholder);
        this.placeholder = placeholder;
        this.showingPlaceholder = true;
        setForeground(Color.GRAY);
        setText(placeholder);
        addFocusListener(this);
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!isFormatting && !showingPlaceholder) {
                    formatText();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!isFormatting && !showingPlaceholder) {
                    formatText();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!isFormatting && !showingPlaceholder) {
                    formatText();
                }
            }
        });
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (showingPlaceholder) {
            setText("");
            setForeground(cinza);
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

    private void formatText() {
        isFormatting = true;
        String text = super.getText().replace("/", "");
        if (text.length() > 8) {
            text = text.substring(0, 8);
        }
        StringBuilder formattedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i == 2 || i == 4) {
                formattedText.append('/');
            }
            formattedText.append(text.charAt(i));
        }
        SwingUtilities.invokeLater(() -> {
            setText(formattedText.toString());
            setCaretPosition(formattedText.length());
            isFormatting = false;
        });
    }

}