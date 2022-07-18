import java.util.Random;

public class computerPlayer extends Player
{
    public computerPlayer()
    {
        super();
    }

    public computerPlayer(int p)
    {
        super(p);
    }

    public int Play(Board d)
    {
        char playTurn;
        int pos = -1;

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
    

    pos = FindWin(d, playTurn);

    if(pos != -1)
    {
        d.AssignTurns(playTurn, pos);
        return pos;
    }

    char oppBlock;

    if(playTurn == 'X')
    {
        oppBlock = 'O';
    }
    else if(playTurn == 'O')
    {
        oppBlock = 'X';
    }
    else          
        oppBlock = '*';
    
    pos = FindWin(d, oppBlock);

    if(pos != -1)
    {
        d.AssignTurns(playTurn, pos);
        return pos;
    }

    if(d.TicTacBoard[1][1] == ' ')
    {
        pos = 5;
        d.AssignTurns(playTurn, pos);  
        return pos;  
    }

    pos = -1;
    while(pos == -1)
    {
        Random rand = new Random();
        int First = rand.nextInt(3);
        int Second = rand.nextInt(3);

        if(d.TicTacBoard[First][Second] == ' ')
        {
            if(First == 0 && Second == 1)
                pos = 2;
            if(First == 0 && Second == 0)
                pos = 1;
            if(First == 1 && Second == 0)
                pos = 4;
            if(First == 0 && Second == 2)
                pos = 3;
            if(First == 1 && Second == 2)
                pos = 6;
            if(First == 1 && Second == 1)
                pos = 5;
            if(First == 2 && Second == 1)
                pos = 8;
            if(First == 2 && Second == 2)
                pos = 9;
            if(First == 2 && Second == 0)
                pos = 7;
        }
    
    }
    d.AssignTurns(playTurn, pos);
    return pos;
    
    };

private int FindWin(Board d, char playTurn)
{
    int pos = -1;

    // Horizontal

    if(d.TicTacBoard[0][1] == playTurn && d.TicTacBoard[0][2] == playTurn && d.TicTacBoard[0][0] == ' ')
    {
        pos = 1;
    }
    else if(d.TicTacBoard[0][1] == playTurn && d.TicTacBoard[0][2] == playTurn && d.TicTacBoard[0][1] == ' ')
    {
        pos = 2;
    }
    else if(d.TicTacBoard[0][0] == playTurn && d.TicTacBoard[0][1] == playTurn && d.TicTacBoard[0][2] == ' ')
    {
        pos = 3;
    }
    else if(d.TicTacBoard[1][1] == playTurn && d.TicTacBoard[1][2] == playTurn && d.TicTacBoard[1][0] == ' ')
    {
        pos = 4;
    }
    else if(d.TicTacBoard[1][0] == playTurn && d.TicTacBoard[1][2] == playTurn && d.TicTacBoard[1][1] == ' ')
    {
        pos = 5;
    }
    else if(d.TicTacBoard[1][0] == playTurn && d.TicTacBoard[1][1] == playTurn && d.TicTacBoard[1][2] == ' ')
    {
        pos = 6;
    }
    else if(d.TicTacBoard[2][1] == playTurn && d.TicTacBoard[2][2] == playTurn && d.TicTacBoard[2][0] == ' ')
    {
        pos = 7;
    }
    else if(d.TicTacBoard[2][0] == playTurn && d.TicTacBoard[2][2] == playTurn && d.TicTacBoard[2][1] == ' ')
    {
        pos = 8;
    }
    else if(d.TicTacBoard[2][0] == playTurn && d.TicTacBoard[2][1] == playTurn && d.TicTacBoard[2][2] == ' ')
    {
        pos = 9;
    }

    // Verticals

    else if(d.TicTacBoard[1][1] == playTurn && d.TicTacBoard[2][1] == playTurn && d.TicTacBoard[0][1] == ' ')
    {
        pos = 2;
    }
    else if(d.TicTacBoard[0][1] == playTurn && d.TicTacBoard[2][1] == playTurn && d.TicTacBoard[1][1] == ' ')
    {
        pos = 5;
    }
    else if(d.TicTacBoard[0][1] == playTurn && d.TicTacBoard[1][1] == playTurn && d.TicTacBoard[2][1] == ' ')
    {
        pos = 8;
    }
    else if(d.TicTacBoard[1][0] == playTurn && d.TicTacBoard[2][0] == playTurn && d.TicTacBoard[0][0] == ' ')
    {
        pos = 1;
    }
    else if(d.TicTacBoard[2][0] == playTurn && d.TicTacBoard[0][0] == playTurn && d.TicTacBoard[1][0] == ' ')
    {
        pos = 4;
    }
    else if(d.TicTacBoard[0][0] == playTurn && d.TicTacBoard[1][0] == playTurn && d.TicTacBoard[2][0] == ' ')
    {
        pos = 7;
    }
    else if(d.TicTacBoard[1][2] == playTurn && d.TicTacBoard[2][2] == playTurn && d.TicTacBoard[0][2] == ' ')
    {
        pos = 3;
    }
    else if(d.TicTacBoard[0][2] == playTurn && d.TicTacBoard[1][2] == playTurn && d.TicTacBoard[2][2] == ' ')
    {
        pos = 9;
    }
    else if(d.TicTacBoard[0][2] == playTurn && d.TicTacBoard[2][2] == playTurn && d.TicTacBoard[1][2] == ' ')
    {
        pos = 6;
    }

    // Diagonals
    else if(d.TicTacBoard[0][2] == playTurn && d.TicTacBoard[1][1] == playTurn && d.TicTacBoard[2][0] == ' ')
    {
        pos = 7;
    }
    else if(d.TicTacBoard[2][0] == playTurn && d.TicTacBoard[0][2] == playTurn && d.TicTacBoard[1][1] == ' ')
    {
        pos = 5;
    }
    else if(d.TicTacBoard[2][0] == playTurn && d.TicTacBoard[1][1] == playTurn && d.TicTacBoard[0][2] == ' ')
    {
        pos = 3;
    }
    else if(d.TicTacBoard[1][1] == playTurn && d.TicTacBoard[2][2] == playTurn && d.TicTacBoard[0][0] == ' ')
    {
        pos = 1;
    }
    else if(d.TicTacBoard[0][0] == playTurn && d.TicTacBoard[1][1] == playTurn && d.TicTacBoard[2][2] == ' ')
    {
        pos = 9;
    }
    else if(d.TicTacBoard[0][0] == playTurn && d.TicTacBoard[2][2] == playTurn && d.TicTacBoard[1][1] == ' ')
    {
        pos = 5;
    }
    else
    {
        pos = -1;
    }

    return pos;
    }

}


