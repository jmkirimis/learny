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

public class TextData extends JTextField {
    private boolean isFormatting;

    public TextData() {
        super();
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!isFormatting) {
                    formatText();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!isFormatting) {
                    formatText();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!isFormatting) {
                    formatText();
                }
            }
        });
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
