package Visualizacao;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PanelRoundPerfil extends JPanel {

    private BufferedImage image;

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    private int roundTopLeft = 50;
    private int roundTopRight = 50;
    private int roundBottomLeft = 50;
    private int roundBottomRight = 50;

    public PanelRoundPerfil() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(createRoundTopLeft());
        if (roundTopRight > 0) {
            area.intersect(new Area(createRoundTopRight()));
        }
        if (roundBottomLeft > 0) {
            area.intersect(new Area(createRoundBottomLeft()));
        }
        if (roundBottomRight > 0) {
            area.intersect(new Area(createRoundBottomRight()));
        }
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);

        if (image != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            double scaleX = (double) panelWidth / image.getWidth();
            double scaleY = (double) panelHeight / image.getHeight();
            double scale = Math.min(scaleX, scaleY);

            int newWidth = (int) (image.getWidth() * scale);
            int newHeight = (int) (image.getHeight() * scale);

            int x = (panelWidth - newWidth) / 2;
            int y = (panelHeight - newHeight) / 2;

            BufferedImage roundedImage = getRoundedImage(image, newWidth, newHeight, roundTopLeft, roundTopRight, roundBottomLeft, roundBottomRight);
            grphcs.drawImage(roundedImage, x, y, this);
        } else {
            ImageIcon defaultImage = new ImageIcon("src/Imagens/camera.png");
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            int imageWidth = defaultImage.getIconWidth();
            int imageHeight = defaultImage.getIconHeight();

            int x = (panelWidth - imageWidth) / 2;
            int y = (panelHeight - imageHeight) / 2;

            grphcs.drawImage(defaultImage.getImage(), x, y, this);
        }
    }

    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private BufferedImage getRoundedImage(BufferedImage image, int width, int height, int roundTL, int roundTR, int roundBL, int roundBR) {
        BufferedImage rounded = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = rounded.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setClip(createRoundShape(width, height, roundTL, roundTR, roundBL, roundBR));
        g2.drawImage(image, 0, 0, width, height, null);
        g2.dispose();
        return rounded;
    }

    private Shape createRoundShape(int width, int height, int roundTL, int roundTR, int roundBL, int roundBR) {
        int topLeftArc = Math.min(roundTL, Math.min(width, height));
        int topRightArc = Math.min(roundTR, Math.min(width, height));
        int bottomLeftArc = Math.min(roundBL, Math.min(width, height));
        int bottomRightArc = Math.min(roundBR, Math.min(width, height));
        return new RoundRectangle2D.Double(0, 0, width, height, topLeftArc, topLeftArc);
    }

    public void setImagem(String path) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(path));

            int width = originalImage.getWidth();
            int height = originalImage.getHeight();
            int newDim = Math.min(width, height);
            int x = (width - newDim) / 2;
            int y = (height - newDim) / 2;
            image = originalImage.getSubimage(x, y, newDim, newDim);

            repaint();
        } catch (IOException e) {
            
        }
    }
}
