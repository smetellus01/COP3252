import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.Random;
import java.awt.event.*;

public class ScreenSaver
{
    public static void main(String[] args) 
    {
        JFrame window = new JFrame("Screen Saver");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SSPanel ssp = new SSPanel();

        window.add(ssp);

        window.setSize(800, 600);
        window.setVisible(true);
    }
}

    class SSPanel extends JPanel implements ActionListener
    {
        protected int delay = 1000;
        protected Timer timer;

        private int x = 0;
        private int y = 0;

        private int vDiameter = 0;
        private int hDiameter = 0;

        public void actionPerformed(ActionEvent s)
        {
            repaint();
        }

        public SSPanel()
        {
            timer = new Timer(delay, this);
            timer.start();
        }

        public void paintComponent( Graphics g )
        {
            super.paintComponent( g );

            Random random = new Random();

            Graphics2D tri = (Graphics2D) g;

            tri.setStroke(new BasicStroke(random.nextInt(10)+1));
            g.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
            y = (random.nextInt(getHeight()));
            x = (random.nextInt(getWidth()));

            hDiameter = random.nextInt(getWidth()-x);
            vDiameter = random.nextInt(getHeight()-y);

            g.drawOval(x, y, hDiameter, vDiameter);

        }

    }

