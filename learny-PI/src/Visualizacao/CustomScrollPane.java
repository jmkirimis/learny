
package Visualizacao;

import javax.swing.*;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollPane extends JScrollPane {

    public CustomScrollPane() {
        super();
        customizeScrollbarUI();
    }

    public CustomScrollPane(Component view) {
        super(view);
        customizeScrollbarUI();
    }

    private void customizeScrollbarUI() {
        JScrollBar verticalScrollBar = getVerticalScrollBar();
        JScrollBar horizontalScrollBar = getHorizontalScrollBar();

        // Define a aparência do scrollbar vertical
        verticalScrollBar.setUI(new WindowsLikeScrollBarUI());

        // Define a aparência do scrollbar horizontal
        horizontalScrollBar.setUI(new WindowsLikeScrollBarUI());
    }

    private static class WindowsLikeScrollBarUI extends BasicScrollBarUI {
        private final Dimension thumbSize = new Dimension(10, 0);

        @Override
        protected void configureScrollBarColors() {
            thumbColor = new Color(190, 190, 190); // Cor do thumb
            trackColor = new Color(240, 240, 240); // Cor do track
        }

        @Override
        protected void installDefaults() {
            super.installDefaults();
            scrollBarWidth = 10; // Largura do scrollbar
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }

        protected Dimension getThumbSize() {
            return thumbSize;
        }
    }
}