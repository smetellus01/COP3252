import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class GuessFrame extends JFrame
{
    private static Random random = new Random();
    private int number;
    private int guessNumbers;
    private int distance;

    private JTextField guessInputJTextField;
    private JLabel prompt1JLabel;
    private JLabel prompt2JLabel;
    private JLabel messageJLabel;
    private JButton newGameButton;

    private Color background;

    public GuessFrame()
    {
        super("Guessing Game");    

        guessNumbers = 0;
        background = Color.LIGHT_GRAY;

        prompt1JLabel = new JLabel("I have a number between 1 and 1000. ");
        prompt2JLabel = new JLabel("Gues my number? Enter yout Guess: ");

        guessInputJTextField = new JTextField( 5 );
        guessInputJTextField.addActionListener( new Handler( ) );
        messageJLabel = new JLabel("Guess will be prompted here.");

        newGameButton = new Button("New Game");

        newGameButton.addActionListener
        (
        
    new ActionListener()
    {
        public void actionPerformed( ActionEvent b)
        {
            background = Color.LIGHT_GRAY;
            theGame();
            repaint();
        }
    }

        );

        FlowLayout containerLayout = new FlowLayout();

        compsToExperiment.setLayout(containerLayout);

        compsToExperiment.add(prompt1JLabel);
        compsToExperiment.add(prompt2JLabel);
        compsToExperiment.add(messageJLabel);
        compsToExperiment.add(newGameButton);
        compsToExperiment.add(guessInputJTextField);

        theGame();
    }

    public void theGame()
    {
        number = random.nextInt(1000)+1;
    }

    public void paint( Graphics g )
    {
        super.paint( g );
        getContentPane().setBackground( background );
    }

    public void reaction( int userguess )
    {
        guessNumbers++;
        currentDistance = 1000;

    if(guessNumbers == 1)
    {
        distance =  Math.abs(userguess - number);

        if(userguess > number)
        {
            messageJLabel.setText("Too High. Try a lower number. ");   
        }
        else
        {
            messageJLabel.setText("Too Low. Try a higher number. ");
        }
    }
        else
        {
        
        currentDistance = Math.abs(userguess - number);    
        
        if(userguess > number)
        {
            messageJLabel.setText("Too High. Try a lower number. ");
            
            if(currentDistance <= distance)
                background = Color.RED;
            else
                background = Color.BLUE;
                currentDistance = distance;
        }

        else if (userguess < number)
        {
            messageJLabel.setText("Too Low. Try a higher number. ");
            
            background = ( currentDistance <= distance ) ?
                Color.RED : Color.BLUE;
                currentDistance = distance;
        }
        else
        {
            messageJLabel.setText(" Correct! ");

            if(currentDistance <= distance)
                background = Color.RED;
            else
                background = Color.BLUE;
            
        }

        repaint();
        }
    }


class GuessHandler implements ActionListener
{
    public void actionPerformed( ActionEvent e )
    {
        
    }
    
}
}
