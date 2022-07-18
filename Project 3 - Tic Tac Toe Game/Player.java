public abstract class Player
{
    int PlayNum;

    public Player()
    {
        PlayNum = -1;
    }

    public Player(int p)
    {
        PlayNum = p;
    }

    public int accessorPlayNum()
    {
        return PlayNum;
    }

    public abstract int Play(Board d);

    public char playTurn()
    {

        char turn;

        if(PlayNum == 1)
            turn = 'X';
        else if(PlayNum == 2)
            turn = 'O';
        else
            turn = '*';
        
            return turn;
    }
}