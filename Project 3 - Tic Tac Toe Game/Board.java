public class Board {

    char [][] TicTacBoard = new char [3][3];

    public Board()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            TicTacBoard[i][j] = ' ';
        }
    }


public void BoardPrint()
{
    System.out.println("Game Board:                Positions:");
    System.out.println(" ");
    
    System.out.print(" " + TicTacBoard[0][0] + " | " + TicTacBoard[0][1] + " | " + TicTacBoard[0][2] + " ");
    System.out.print("                ");
    System.out.println(" 1 | 2 | 3 ");
    
    System.out.println("____________                ____________");

    System.out.print(" " + TicTacBoard[1][0] + " | " + TicTacBoard[1][1] + " | " + TicTacBoard[1][2] + " ");
    System.out.print("                ");
    System.out.println(" 4 | 5 | 6 ");
    
    System.out.println("____________                ____________");

    System.out.print(" " + TicTacBoard[2][0] + " | " + TicTacBoard[2][1] + " | " + TicTacBoard[2][2] + " ");
    System.out.print("                ");
    System.out.println(" 7 | 8 | 9 ");
};

public int CheckWin(char p)
{
    int choice = 0;

    if(TicTacBoard[1][0] == p && TicTacBoard[0][1] == p && TicTacBoard[0][2] == p)
    {
        if(p == 'X')
            choice = 1;
    
        else if(p == 'O')
            choice = 2;
    }

    else if(TicTacBoard[1][0] == p && TicTacBoard[1][1] == p && TicTacBoard[1][2] == p)
    {
        if(p == 'X')
            choice = 1;
    
        else if(p == 'O')
            choice = 2;
    }

    else if(TicTacBoard[2][0] == p && TicTacBoard[2][1] == p && TicTacBoard[2][2] == p)
    {
        if(p == 'X')
            choice = 1;
    
        else if(p == 'O')
            choice = 2;
    }

    else if(TicTacBoard[0][0] == p && TicTacBoard[1][0] == p && TicTacBoard[2][0] == p)
    {
        if(p == 'X')
            choice = 1;
    
        else if(p == 'O')
            choice = 2;
    }

    else if(TicTacBoard[0][1] == p && TicTacBoard[1][1] == p && TicTacBoard[2][1] == p)
    {
        if(p == 'X')
            choice = 1;
    
        else if(p == 'O')
            choice = 2;
    }

    else if(TicTacBoard[0][2] == p && TicTacBoard[1][2] == p && TicTacBoard[2][2] == p)
    {
        if(p == 'X')
            choice = 1;
    
        else if(p == 'O')
            choice = 2;
    }

    else if(TicTacBoard[0][0] == p && TicTacBoard[1][1] == p && TicTacBoard[2][2] == p)
    {
        if(p == 'X')
            choice = 1;
    
        else if(p == 'O')
            choice = 2;
    }

    else if(TicTacBoard[0][2] == p && TicTacBoard[1][1] == p && TicTacBoard[2][0] == p)
    {
        if(p == 'X')
            choice = 1;
    
        else if(p == 'O')
            choice = 2;
    }

    else if(TicTacBoard[0][0] == p && TicTacBoard[0][1] == p && TicTacBoard[0][2] == p)
    {
        if(p == 'X')
            choice = 1;
    
        else if(p == 'O')
            choice = 2;
    }
    else if(TicTacBoard[0][0] != ' ' && TicTacBoard[0][1] != ' ' && TicTacBoard[0][2] != ' ' && TicTacBoard[1][0] != ' '
    		&& TicTacBoard[1][1] != ' ' && TicTacBoard[2][0] != ' ' && TicTacBoard[1][2] != ' ' && TicTacBoard[2][1] != ' ' && TicTacBoard[2][2] != ' ')
    {
    	choice = -1;
    }

    return choice;
};

public boolean AssignTurns(char p, int position)
{
    boolean temp;

    if(position >= 1 && position <= 9)
    {
        temp = true;
        switch(position)
        {
        case 1:
            if(TicTacBoard[0][0] == ' ')
            {
                TicTacBoard[0][0] = p;
            }
            else temp = false;
            break;
        case 2:
            if(TicTacBoard[0][1] == ' ')
            {
                TicTacBoard[0][1] = p;
            }
            else temp = false;
            break;
        case 3:
            if(TicTacBoard[0][2] == ' ')
            {
                TicTacBoard[0][2] = p;
            }
            else temp = false;
            break;
        case 4:
            if(TicTacBoard[1][0] == ' ')
            {
                TicTacBoard[1][0] = p;
            }
            else temp = false;
            break;
        case 5:
            if(TicTacBoard[1][1] == ' ')
            {
                TicTacBoard[1][1] = p;
            }
            else temp = false;
            break;
        case 6:
            if(TicTacBoard[1][2] == ' ')
            {
                TicTacBoard[1][2] = p;
            }
            else temp = false;
            break;
        case 7:
            if(TicTacBoard[2][0] == ' ')
            {
                TicTacBoard[2][0] = p;
            }
            else temp = false;
            break;
        case 8:
            if(TicTacBoard[2][1] == ' ')
            {
                TicTacBoard[2][1] = p;
            }
            else temp = false;
            break;
        case 9:
            if(TicTacBoard[2][2] == ' ')
            {
                TicTacBoard[2][2] = p;
            }
            else temp = false;
            break;
        default:
            temp = false;
        }
    }
    else
        temp = false;
    
        return temp;
    }
};


