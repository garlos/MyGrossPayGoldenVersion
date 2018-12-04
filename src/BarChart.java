import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BarChart extends JPanel {
    private double[] value;


    public BarChart(double[] val) {
        value = val;
    }

    public BarChart() {

    }

    public void barChartGenerator(double grossPay, double[][] dSet, int i) {

        JFrame frame = new JFrame();
        frame.setSize(30, 147);

        Color myWhite = new Color(255, 255, 255); // Real white Color
//        frame.setBackground(myWhite);

        double[] value = new double[6];

        /*normalize DataSet to Percentage before drawing Bar chart*/
        value[0] = 100;     // to adjust first bar to 100

        value[1] = NormalizeToPercentage.normalize(dSet[i][0] * 34, 0, 100, 0, 100);
        value[2] = NormalizeToPercentage.normalize(dSet[i][1], 150, 200, 0, 100);
        value[3] = NormalizeToPercentage.normalize(dSet[i][2], 0, 50, 0, 100);
        value[4] = NormalizeToPercentage.normalize(dSet[i][3], 70, 90, 0, 100);

        value[5] = 100;     // to adjust last bar to 100

        frame.getContentPane().add(new BarChart(value));
        WindowListener winListener = new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        };
        frame.addWindowListener(winListener);

        frame.setVisible(true);

        /*save BarChart as Image*/
        saveImage(frame, grossPay);

        frame.setVisible(false);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (value == null || value.length == 0)
            return;
        double minValue = 0;
        double maxValue = 0;
        for (double aValue : value) {
            if (minValue > aValue)
                minValue = aValue;
            if (maxValue < aValue)
                maxValue = aValue;
        }
        Dimension dim = getSize();
        int clientWidth = dim.width;
        int clientHeight = dim.height;
        int barWidth = (clientWidth / value.length);
        int top = 0;
        int bottom = 0;
        if (maxValue == minValue)
            return;
        double scale = (clientHeight) / (maxValue - minValue);
//        graphics.setFont(labelFont);


        Color myBlack = new Color(0, 0, 0); // Real Black Color

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


            graphics.setColor(myBlack);
            graphics.fillRect(valueP, valueQ, barWidth, height);
            graphics.setColor(myBlack);
            graphics.drawRect(valueP, valueQ, barWidth, height);
        }
    }


    public void saveImage(JFrame frame, double grossPay) {
        Dimension size = frame.getSize();
        BufferedImage image = (BufferedImage) frame.createImage(size.width, size.height);
        Graphics g = image.getGraphics();
        frame.paint(g);
        g.dispose();
        try {
            double gross = Math.round(grossPay * 100) / 100.0;
            ImageIO.write(image, "jpg", new File("./img/" + gross + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
