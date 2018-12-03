import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class TimerTime extends JPanel implements ActionListener
{
    private JLabel timeLabel;
    private int count = 0;

    public TimerTime()
    {
        timeLabel = new JLabel( new Date().toString() );
        add( timeLabel );

        Timer timer = new Timer(1000, this);
        timer.setInitialDelay(1);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //System.out.println(e.getSource());
        timeLabel.setText( new Date().toString() );
//      timeLabel.setText( String.valueOf(System.currentTimeMillis() ) );
        count++;
        System.out.println(count);

        if (count == 10)
        {
            Timer timer = (Timer)e.getSource();
            timer.stop();
        }
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("TimerTime");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new TimerTime() );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }


}