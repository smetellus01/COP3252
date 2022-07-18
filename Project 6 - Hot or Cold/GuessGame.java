import javax.swing.JFrame;

public class GuessGame
{

    public static void main(String[] args) 
    {
        GuessFrame guessFrame = new GuessFrame();
        guessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessFrame.setSize( 300, 150 );
        guessFrame.setVisible( true );
    }

}