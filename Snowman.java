import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class Snowman
{
	public static void main(String[] args) 
	{
    JFrame window = new JFrame(" Snowman ");

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    WinterPanel tr = new WinterPanel();

    window.add(tr);

    window.setSize(600, 400);
    window.setVisible(true);
	}

}

class WinterPanel extends JPanel
{
    private double md;
    private double hd;
    private double bd;
    private double ed;
    
    private double th;
    private double bcY;
    private double mcY;
    private double hcY;

    private int center;

    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        Random random = new Random();

        th = ((0.75)*getHeight());

        bd = (th) / 2;

        if(bd > getWidth())
        {
            bd = getWidth();
        }

        md = ((bd)*(2.0/3.0));
        hd = (1.0/3.0)*(bd);
        ed = hd*.1;
        
        bcY = getHeight()-(bd/2.0)-(getHeight()*(1.0/8.0));
        mcY = bcY-(bd/2.0)-(md/2.0);
        hcY = mcY-(md/2.0)-(hd/2.0);
        
        center = getWidth()/2;

        // Draw Ovals

        g.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        g.drawOval((int)(center-(bd/2)), (int)(bcY-(bd)/2), (int)(bd), (int)bd); 
        
        // Middle Oval
	   
        g.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
	    g.drawOval((int)(center-(md/2)), (int)(mcY-(md/2)), (int)(md), (int)md);

        // Top Oval

        g.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
	    g.drawOval((int)(center-(hd/2)), (int)(hcY-(hd/2)), (int)(hd), (int)hd);

        // Right Eye

        g.fillOval((int)((center)+(hd/4)-ed), ((int)(hcY-(hd/4))), (int)ed,(int)ed);

        // Left Eye
	    
        g.setColor(new Color(0,0,0));
        g.fillOval((int)((center)-(hd/4)), ((int)(hcY-(hd/4))), (int)ed,(int)ed);

        // Right Arm
	    
        g.drawLine((int)((center)+(md/4)), ((int)(mcY-(md/4))), 
        (int)((center)+(md/4)+md/2) , (int)(mcY-(md/4)-md/3));

        // Left Arm
	    
        g.drawLine((int)((center)-(md/4)), ((int)(mcY-(md/4))), 
        (int)((center)-(md/4)-md/2) , (int)(mcY-(md/4)-md/3));
    }
}
