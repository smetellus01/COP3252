import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class Triangles
{
    public static void main(String[] args) 
    {
        JFrame window = new JFrame("Triangles");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel tr = new Panel();

        window.add(tr);

        window.setSize(500, 500);
        window.setVisible(true);
    }

}

class Panel extends JPanel
{
    private int width;
    private int height;

    private int d1;
    private int y1;

    private int d2;
    private int y2;

    private int d3; 
    private int y3;



public void paintComponent ( Graphics g )
{
    super.paintComponent( g ); // superclass paintComponent
    Random random = new Random();

    width = getWidth();
    height = getHeight();

    for(int i = 0; i < 6; i++)
    {
        Graphics2D tri = (Graphics2D) g;

        GeneralPath triangle = new GeneralPath();

        d1 = random.nextInt(width);
        y1 = random.nextInt(height);

        d2 = random.nextInt(width);
        y2 = random.nextInt(height);

        d3 = random.nextInt(width);
        y3 = random.nextInt(height);

        triangle.moveTo(d1, y1);
        triangle.lineTo(d2, y2);
        triangle.lineTo(d3, y3);

        triangle.closePath();

        tri.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

        tri.fill(triangle);

    }
}

}