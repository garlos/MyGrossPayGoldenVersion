import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BarChart extends JPanel {
    private double[] value;
    private String[] languages;
    private String title;

    public BarChart(double[] val, String[] lang, String t) {
        languages = lang;
        value = val;
        title = t;
    }

    public BarChart() {

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
        int titleWidth = titleFontMetrics.stringWidth(title);
        int q = titleFontMetrics.getAscent();
        int p = (clientWidth - titleWidth) / 2;
        graphics.setFont(titleFont);
        graphics.drawString(title, p, q);
        int top = titleFontMetrics.getHeight();
        int bottom = labelFontMetrics.getHeight();
        if (maxValue == minValue)
            return;
        double scale = (clientHeight - top - bottom) / (maxValue - minValue);
        q = clientHeight - labelFontMetrics.getDescent();
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

            graphics.setColor(Color.blue);
            graphics.fillRect(valueP, valueQ, barWidth , height);
            graphics.setColor(Color.black);
            graphics.drawRect(valueP, valueQ, barWidth , height);
            int labelWidth = labelFontMetrics.stringWidth(languages[j]);
            p = j * barWidth + (barWidth - labelWidth) / 2;
            graphics.drawString(languages[j], p, q);
        }
    }

    public void drawBarChart() {
        JFrame frame = new JFrame();
        frame.setSize(350, 300);
        double[] value = new double[4];
        String[] languages = new String[4];
        value[0] = 1.9;
        languages[0] = "StaffType";

        value[1] = 2;
        languages[1] = "WorkHours";

        value[2] = 5;
        languages[2] = "ExHours";

        value[3] = 4;
        languages[3] = "Quality";

//        value[4] = 5;
//        languages[4] = "Java";
        frame.getContentPane().add(new BarChart(value, languages, "Programming Languages"));

        WindowListener winListener = new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        };
        frame.addWindowListener(winListener);
        frame.setVisible(true);
    }
}
