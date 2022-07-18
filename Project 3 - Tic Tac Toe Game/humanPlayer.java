import java.util.Scanner;

public class humanPlayer extends Player
{
    public humanPlayer()
    {
        super();
    }

    public humanPlayer(int p)
    {
        super(p);
    }

    public int Play(Board d)
    {
        Scanner q = new Scanner(System.in);
        char playTurn;
        boolean temp2 = true;

        if(PlayNum == 1)
		{
			playTurn = 'X';
		}
		else if(PlayNum == 2)
		{
			playTurn = 'O';
		}
		else
			playTurn = '*';
		
		while(temp2 == true)
		{
			if(d.AssignTurns(playTurn,q.nextInt()))
			{
				temp2 = false;
			}
			else
			{
				System.out.println("Invalid Play!");
				System.out.println("Try Again Please!");
			}
		}
        return 0;
    };
};