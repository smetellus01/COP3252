import java.io.IOException;

public class TicTacToe 
{
	public static void main(String[] args) throws IOException
	{
		if(args.length == 0)
		{
			int winner = 0;
			Board d = new Board();
			humanPlayer p1 = new humanPlayer(1);
			humanPlayer p2 = new humanPlayer(2);

			while(winner == 0)
			{
				d.BoardPrint();
				System.out.println("Player 1, please enter a move (1-9): ");
				p1.Play(d);
				winner = d.CheckWin(p1.playTurn());
				if(winner != 0)
					break;
				d.BoardPrint();
				System.out.println("Player 2, please enter a move (1-9): ");
				p2.Play(d);
				winner = d.CheckWin(p2.playTurn());
			}

			d.BoardPrint();
			if(winner == 1)
				System.out.println("Player 1 Wins! Game Ended");
			else if (winner == 2)
				System.out.println("Player 2 Wins! Game Ended");
			else
				System.out.println("Game Over! We have a Draw!");
		}
		
		else if (args.length == 1)
		{
			if(!args[0].equals("-c"))
			{
				System.out.println("Usage: java TicTacToe [-c [1|2] [-a]]");
				return;
			}

			int winner = 0;
			Board d = new Board();
			computerPlayer p1 = new computerPlayer(1);
			computerPlayer p2 = new computerPlayer(2);

			while(winner == 0)
			{
				d.BoardPrint();
				System.out.println("Player 1 (Computer) will choose a position" + p1.Play(d));
				p1.Play(d);
				winner = d.CheckWin(p1.playTurn());
				if(winner != 0)
					break;
				d.BoardPrint();
				System.out.println("Player 2 (Computer) will choose a position" + p2.Play(d));
				p2.Play(d);
				winner = d.CheckWin(p2.playTurn());
			}

			d.BoardPrint();
			if(winner == 1)
				System.out.println("Player 1 Wins! Game Ended");
			else if (winner == 2)
				System.out.println("Player 2 Wins! Game Ended");
			else
				System.out.println("Game Over! We have a Draw!");
		}

		else if(args.length == 2)
		{
			int winner = 0;
			Board d = new Board();
			humanPlayer p1 = null;
			computerPlayer p2 = null;

			if(args[1].equals("1") && args[0].equals("c"))
			{
				p1 = new humanPlayer(2);
				p2 = new computerPlayer(1);

				while(winner == 0)
				{
					d.BoardPrint();
					System.out.println("Player 1 (Computer) will choose a position" + p2.Play(d));
					p1.Play(d);
					winner = d.CheckWin(p2.playTurn());
					if(winner != 0)
						break;
					d.BoardPrint();
					System.out.println("Player 2, enter a move (1-9): ");
					p1.Play(d);
					winner = d.CheckWin(p1.playTurn());
				}
			}
			else if(args[1].equals("2") && args[0].equals("-c"))
			{
				p1 = new humanPlayer(1);
				p2 = new computerPlayer(2);

				while(winner == 0)
				{
					d.BoardPrint();
					System.out.println("Player 1, enter a move (1-9): ");
					p1.Play(d);
					winner = d.CheckWin(p1.playTurn());
					if(winner != 0)
						break;
					d.BoardPrint();
					System.out.println("Player 1 (Computer) will choose a position" + p2.Play(d));
					winner = d.CheckWin(p2.playTurn());
				}
			}
			else
			{
				System.out.println("Usage:  java TicTacToe [-c [1|2] [-a]]");
				return;
			}

			d.BoardPrint();
			if(winner == 1)
			{
				System.out.println("Player One Wins the Game!");
			}
			else if(winner == 2)
			{
				System.out.println("Player Two Wins the Game!");
			}
			else 
			{
				System.out.println("Game over! It's a Draw!");
			}
		}
    
	}

}