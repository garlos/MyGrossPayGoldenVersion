import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BarChart extends JPanel {
    private double[] value;
    private String[] languages;


    public BarChart(double[] val, String[] lang) {
        languages = lang;
        value = val;
    }


    public BarChart() {

    }


    public void drawBarChart() {
        JFrame frame = new JFrame();
        frame.setSize(100, 100);
        double[] value = new double[4];
        value[0] = 99;
        value[1] = 88;
        value[2] = 20;
        value[3] = 80;

        frame.getContentPane().add(new BarChart(value, languages));

        WindowListener winListener = new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        };
        frame.addWindowListener(winListener);
        frame.setVisible(true);

        saveImage(frame);      // save BarChart as Image
    }


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (value == null || value.length == 0)
            return;
        double minValue = 0;
        double maxValue = 0;
        for (int i = 0; i < value.length; i++) {
            if (minValue > value[i])
                minValue = value[i];
            if (maxValue < value[i])
                maxValue = value[i];
        }
        Dimension dim = getSize();
        int clientWidth = dim.width;
        int clientHeight = dim.height;
        int barWidth = clientWidth / value.length;
        Font titleFont = new Font("Book Antiqua", Font.BOLD, 15);
        FontMetrics titleFontMetrics = graphics.getFontMetrics(titleFont);
        Font labelFont = new Font("Book Antiqua", Font.PLAIN, 10);
        FontMetrics labelFontMetrics = graphics.getFontMetrics(labelFont);
        graphics.setFont(titleFont);
        int top = titleFontMetrics.getHeight();
        int bottom = labelFontMetrics.getHeight();
        if (maxValue == minValue)
            return;
        double scale = (clientHeight - top - bottom) / (maxValue - minValue);
        graphics.setFont(labelFont);

        for (int j = 0; j < value.length; j++) {
            int valueP = j * barWidth + 1;
            int valueQ = top;
            int height = (int) (value[j] * scale);
            if (value[j] >= 0)
                valueQ += (int) ((maxValue - value[j]) * scale);
            else {
                valueQ += (int) (maxValue * scale);
                height = -height;
            }

            graphics.setColor(Color.black);
            graphics.fillRect(valueP, valueQ, barWidth, height);
            graphics.setColor(Color.white);
            graphics.drawRect(valueP, valueQ, barWidth, height);
        }
    }


    public void saveImage(JFrame frame) {
        Dimension size = frame.getSize();
        BufferedImage image = (BufferedImage) frame.createImage(size.width, size.height);
        Graphics g = image.getGraphics();
        frame.paint(g);
        g.dispose();
        try {
            ImageIO.write(image, "jpg", new File("BarChart.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
